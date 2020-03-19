/*
 * Copyright (c) 2020 RenegadeMaster Inc. - All Right Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * The contents of this file are proprietary and confidential.
 * Written by Ciaran Bent <ciaran.bent@protonmail.ch>, March 2020
 */

package com.k00221230.fyp.hwms

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.amplify.generated.graphql.CreateSearchQueryRequestMutation
import com.amazonaws.amplify.generated.graphql.GetSearchResultStringQuery
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import type.CreateSearchQueryRequestInput
import java.util.Date
import javax.annotation.Nonnull
import kotlin.random.Random


/**
 * The AppSyncClient Class.
 *
 * This Class is used to communicate with the AWS backend for HWMS.
 */
public object AppSyncClient : AppCompatActivity() {
    @Volatile
    private lateinit var client: AWSAppSyncClient

    private val rand: Random = Random(Date().time)

    // Use this to store the Request ID.  This is needed to check for results
    private var reqId: String = String()
    private var resultString: String = String()

    /**
     * Format and send a Search Request to the DynamoDB Requests Table.
     */
    @Synchronized
    fun sendClientRequest(context: Context?, item: String, prediction: Boolean = false): String {
        println(
            "Attempting to send:" +
                    "\nPrediction: " + prediction +
                    "\nItem: " + item
        )

        client = AppSyncClientFactory.getInstance(context!!)!!

        reqId = generateId()
        val createSearchQueryRequestInput = CreateSearchQueryRequestInput.builder()
            .id(reqId)
            .prediction(prediction)
            .item(item)
            .build()

        client.mutate(
            CreateSearchQueryRequestMutation.builder()
                .input(createSearchQueryRequestInput).build()
        )?.enqueue(mutationCallback)

        println("Ran mutation")

        return reqId
    }

    /**
     * Retrieve and format the result of the Web-Crawl from the DynamoDB Response Table.
     */
    @Synchronized
    fun retrieveSearchResults(context: Context?, reqId: String): List<List<String>> {
        println(
            "Attempting to retrieve request with:" +
                    "\nID: " + reqId
        )

        // Comment the following line out to disable DB connection
        client = AppSyncClientFactory.getInstance(context!!)!!

        // ToDo: Try to offload this to a Thread so as not to hang the UI Thread
        do {
            Thread.sleep(500)

            client.query(
                GetSearchResultStringQuery.builder()
                    .id(reqId)
                    .build()
            ).responseFetcher(AppSyncResponseFetchers.CACHE_AND_NETWORK)
                .enqueue(queryCallback)
        } while (resultString.isNullOrBlank() || resultString == "null")

        val stringToReturn: String = cleanResponseString(resultString)
        var workingString: List<List<String>>

        workingString = stringToLists(stringToReturn)

        // Convert the Response into something usable before returning it
        return workingString
    }

    /**
     * Callback function for communicating with the DynamoDB API using the AppSync API.
     */
    private val mutationCallback =
        object : GraphQLCall.Callback<CreateSearchQueryRequestMutation.Data>() {
            override fun onResponse(response: Response<CreateSearchQueryRequestMutation.Data>) {
                Log.i("Success", "Added Entry to DB")
            }

            override fun onFailure(e: ApolloException) {
                Log.e("ERROR: Failed to add entry to DB", e.toString())
            }
        }

    /**
     * Callback function for communicating with the DynamoDB API using the AppSync API.
     */
    private val queryCallback: GraphQLCall.Callback<GetSearchResultStringQuery.Data> =
        object : GraphQLCall.Callback<GetSearchResultStringQuery.Data>() {
            override fun onResponse(@Nonnull response: Response<GetSearchResultStringQuery.Data>) {
                Log.i("Results", response.data()?.searchResultString.toString())
                resultString = response.data()?.searchResultString.toString()
            }

            override fun onFailure(@Nonnull e: ApolloException) {
                Log.e("ERROR: Could not get item from DB", e.toString())
            }
        }

    /**
     * Clean the result String by removing the unnecessary parts, and converting it to a List-like
     * structure.
     */
    private fun cleanResponseString(dirtyString: String): String {
        var workingString: String = dirtyString
        println("CleanResponseString Stage 00: \n$workingString")

        // Remove the start and end bits of the String
        workingString = workingString.substringAfter('=')
        println("CleanResponseString Stage 01: \n$workingString")

        workingString = workingString.substringBeforeLast(", c")
        println("CleanResponseString Stage 02: \n$workingString\n")

        return workingString
    }

    /**
     * Convert a String known to contain THREE lists of items into a List<List<String>> structure.
     */
    private fun stringToLists(s: String): List<List<String>> {
        var workingString: String = String()
        var workingList: List<String> = ArrayList<String>()
        var workingLists: ArrayList<ArrayList<String>> = ArrayList<ArrayList<String>>()

        // Isolate the different lists
        println("StringToLists Stage 00: \n$workingString")

        workingString = s.substringAfter('[')
        println("StringToLists Stage 01: \n$workingString")

        workingString = s.substringBeforeLast(']')
        println("StringToLists Stage 02: \n$workingString")

        workingList = stringToList(workingString, "], [")
        println("StringToLists Stage 03: \n$workingString")

        println("List State 01:\n$workingList")
        println("\tList PT 00: Len: ${workingList[0].count()}\n${workingList[0]}")
        println("\tList PT 01: Len: ${workingList[1].count()}\n${workingList[1]}")
        println("\tList PT 02: Len: ${workingList[2].count()}\n${workingList[2]}")

        workingLists.add(
            workingList[0].split(
                "(?<![gzk0KWBU])(?<=[a-zA-Z0-9.])[,][\\s](?![a-hj-z468])"
                    .toRegex()
            ) as ArrayList<String>
        )
        workingLists.add(workingList[1].split("[,][\\s]".toRegex()) as ArrayList<String>)
        workingLists.add(workingList[2].split("[,][\\s]".toRegex()) as ArrayList<String>)

        println("List State 02:\n$workingList")
        println("\tList PT 00: Len: ${workingLists[0].count()}\n${workingLists[0]}")
        println("\tList PT 01: Len: ${workingLists[1].count()}\n${workingLists[1]}")
        println("\tList PT 02: Len: ${workingLists[2].count()}\n${workingLists[2]}")

        return workingLists
    }

    /**
     * Convert a String known to contain a single list of items into a List<String> structure.
     */
    private fun stringToList(s: String, delims: String): List<String> {
        var workingList: MutableList<String> = ArrayList<String>(0)

        println("StringToList Stage 00: \n$s")

        workingList = s.split(delims) as MutableList<String>
        println("StringToList Stage 01: \n$workingList")

        workingList[0] = workingList[0].substringAfter("[[")
        println("StringToList Stage 02: \n$workingList")

        return workingList
    }

    /**
     * Generate an ID that can be used to identify the request that this Client sends to the DB.
     * This ID is then used to retrieve the results of the Current and Predicted price data.
     */
    private fun generateId(): String {
        var id: Long = Date().time

        // ToDo: Find a better way to generate a random ID
        id += rand.nextLong(1, 85132547)

        return id.toString()
    }

    /**
     * Measure the time in Milliseconds taken to execute any function.
     * Made inline as this may need to be called many times under certain circumstances.
     */
    inline fun <T> measureTimeMillis(
        loggingFunction: (Long) -> Unit,
        function: () -> T
    ): T {

        val startTime = System.currentTimeMillis()
        val result: T = function.invoke()
        loggingFunction.invoke(System.currentTimeMillis() - startTime)

        return result
    }
}

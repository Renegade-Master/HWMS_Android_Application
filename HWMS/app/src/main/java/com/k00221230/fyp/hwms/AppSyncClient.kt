package com.k00221230.fyp.hwms

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.amplify.generated.graphql.CreateSearchQueryRequestMutation
import com.amazonaws.amplify.generated.graphql.GetSearchQueryResponseQuery
import com.amazonaws.amplify.generated.graphql.GetSearchResultStringQuery
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import type.CreateSearchQueryRequestInput
import java.util.*
import kotlin.random.Random


/**
 * The AppSyncClient Class.
 *
 * This Class is used to communicate with the AWS backend for HWMS.
 */
object AppSyncClient : AppCompatActivity() {
    @Volatile
    private lateinit var client: AWSAppSyncClient

    private val rand: Random = Random(Date().time)

    // Use this to store the Request ID.  This is needed to check for results
    private var id: String = String()

    @Synchronized
    fun sendClientRequest(context: Context?, item: String, prediction: Boolean = false) {
        println(
            "Attempting to send:" +
                    "\nPrediction: " + prediction +
                    "\nItem: " + item
        )

        // Comment the following line out to disable DB connection
        client = AppSyncClientFactory.getInstance(context!!)!!

        id = generateId()
        val createSearchQueryRequestInput = CreateSearchQueryRequestInput.builder()
            .id(id)
            .prediction(prediction)
            .item(item)
            .build()

        client.mutate(
            CreateSearchQueryRequestMutation.builder()
                .input(createSearchQueryRequestInput).build()
        )?.enqueue(mutationCallback)

        println("Ran mutation")
    }

    @Synchronized
    fun retrieveSearchResults(context: Context?, reqId: String) {
        println(
            "Attempting to retrieve request with:" +
                    "\n ID: " + reqId
        )

        // Comment the following line out to disable DB connection
        client = AppSyncClientFactory.getInstance(context!!)!!

        val getSearchQueryResponseInput = GetSearchQueryResponseQuery.builder()
            .id(reqId)
            .build()

        client.query(
            GetSearchResultStringQuery.builder()
                .id(reqId)
                .build()
        )?.enqueue(queryCallBack)

        println("Ran query")
    }

    private val mutationCallback =
        object : GraphQLCall.Callback<CreateSearchQueryRequestMutation.Data>() {
            override fun onResponse(response: Response<CreateSearchQueryRequestMutation.Data>) {
                Log.i("Success", "Added Entry")
                println("Added entry")
            }

            override fun onFailure(e: ApolloException) {
                Log.e("Error", e.toString())
                println("Failed to add entry")
            }
        }

    private val queryCallBack =
        object : GraphQLCall.Callback<GetSearchResultStringQuery.Data>() {
            override fun onResponse(response: Response<GetSearchResultStringQuery.Data>) {
                Log.i("Success", "Retrieved Entry")
                println("Retrieved entry")
            }

            override fun onFailure(e: ApolloException) {
                Log.e("Error", e.toString())
                println("Failed to retrieve entry")
            }
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
}

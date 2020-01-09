package com.k00221230.fyp.hwms

import android.app.usage.UsageEvents
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.amplify.generated.graphql.CreateSearchQueryRequestMutation
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import type.CreateSearchQueryRequestInput

object AppSyncClient: AppCompatActivity() {
    @Volatile
    private lateinit var client: AWSAppSyncClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Synchronized
    fun SendClientRequest(void: Float) {
        AppSyncClientFactory
    }

    @Synchronized
    fun runMutation(context: Context?) {
        client = AppSyncClientFactory.getInstance(context!!)!!

        if(client != null) {
            println("Created AppSync Client")
            println(client.toString())
        } else {
            println("AppSync Client is null for some reason")
        }

        val createSearchQueryRequestInput = CreateSearchQueryRequestInput.builder()
            .id("000_test")
            .prediction(false)
            .item("testItem")
            .build()

        client?.mutate(
            CreateSearchQueryRequestMutation.builder()
                .input(createSearchQueryRequestInput).build())?.enqueue(mutationCallback)

        println("Ran mutation")
    }

    private val mutationCallback = object: GraphQLCall.Callback<CreateSearchQueryRequestMutation.Data>() {
        override fun onResponse(response: Response<CreateSearchQueryRequestMutation.Data>) {
            Log.i("Results", "Added Todo")
            println("Added entry")
        }

        override fun onFailure(e: ApolloException) {
            Log.e("Error", e.toString())
            println("Failed to add entry")
        }
    }
}

/*

    fun runMutation() {
        if(mAWSAppSyncClient != null) {
            println("Created AppSync Client")
            println(mAWSAppSyncClient.toString())
        } else {
            println("AppSync Client is null for some reason")
        }

        val createSearchQueryRequestInput = CreateSearchQueryRequestInput.builder()
            .id("000_test")
            .prediction(false)
            .item("testItem")
            .build()

        mAWSAppSyncClient?.mutate(
            CreateSearchQueryRequestMutation.builder()
                .input(createSearchQueryRequestInput).build())?.enqueue(mutationCallback)

        println("Ran mutation")
    }

    private val mutationCallback = object: GraphQLCall.Callback<CreateSearchQueryRequestMutation.Data>() {
        override fun onResponse(response: Response<CreateSearchQueryRequestMutation.Data>) {
            Log.i("Results", "Added Todo")
            println("Added entry")
        }

        override fun onFailure(e: ApolloException) {
            Log.e("Error", e.toString())
            println("Failed to add entry")
        }
    }

 */
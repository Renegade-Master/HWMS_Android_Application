package com.k00221230.fyp.hwms

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.amplify.generated.graphql.CreateSearchQueryRequestMutation
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import type.CreateSearchQueryRequestInput
import java.util.Date
import kotlin.random.Random

object AppSyncClient: AppCompatActivity() {
    @Volatile
    private lateinit var client: AWSAppSyncClient

    private val rand: Random = Random(Date().time)

    @Synchronized
    fun SendClientRequest(context: Context?, item: String, prediction: Boolean = false) {
        println("Attempting to send:" +
                "\nPrediction: " + prediction +
                "\nItem: " + item)

        // Comment the following line out to disable DB connection
        client = AppSyncClientFactory.getInstance(context!!)!!

        val createSearchQueryRequestInput = CreateSearchQueryRequestInput.builder()
            .id(generateId())
            .prediction(prediction)
            .item(item)
            .build()

        client.mutate(
            CreateSearchQueryRequestMutation.builder()
                .input(createSearchQueryRequestInput).build())?.enqueue(mutationCallback)

        println("Ran mutation")
    }

    private val mutationCallback = object: GraphQLCall.Callback<CreateSearchQueryRequestMutation.Data>() {
        override fun onResponse(response: Response<CreateSearchQueryRequestMutation.Data>) {
            Log.i("Success", "Added Entry")
            println("Added entry")
        }

        override fun onFailure(e: ApolloException) {
            Log.e("Error", e.toString())
            println("Failed to add entry")
        }
    }

    private fun generateId(): String {
        var id: Long = Date().time

        id += rand.nextLong(1,85132547)

        return id.toString()
    }
}

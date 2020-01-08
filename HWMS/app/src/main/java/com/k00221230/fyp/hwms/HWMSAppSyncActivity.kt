package com.k00221230.fyp.hwms

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.amazonaws.amplify.generated.graphql.CreateSearchQueryRequestMutation
import com.amazonaws.mobile.config.AWSConfiguration
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient
import com.apollographql.apollo.GraphQLCall
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.api.Response
import type.CreateSearchQueryRequestInput

class HWMSAppSyncActivity: AppCompatActivity() {
    private lateinit var mAWSAppSyncClient: AWSAppSyncClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        mAWSAppSyncClient = AWSAppSyncClient.builder()
            .context(applicationContext)
            .awsConfiguration(AWSConfiguration(applicationContext))
            .build()
    }

    fun runMutation() {
        val createSearchQueryRequestInput = CreateSearchQueryRequestInput.builder()
            .id("000_test")
            .prediction(false)
            .item("testItem")
            .build()

        mAWSAppSyncClient.mutate(
            CreateSearchQueryRequestMutation.builder()
                .input(createSearchQueryRequestInput).build())
            .enqueue(mutationCallback)
    }

    private val mutationCallback = object: GraphQLCall.Callback<CreateSearchQueryRequestMutation.Data>() {
        override fun onResponse(response: Response<CreateSearchQueryRequestMutation.Data>) {
            Log.i("Results", "Added Todo")
        }

        override fun onFailure(e: ApolloException) {
            Log.e("Error", e.toString())
        }
    }
}

package com.k00221230.fyp.hwms

import android.content.Context

import com.amazonaws.mobile.config.AWSConfiguration
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient

object AppSyncClientFactory {
    @Volatile
    private var client: AWSAppSyncClient? = null

    @Synchronized
    fun getInstance(context: Context): AWSAppSyncClient? {
        if (client == null) {
            val awsConfig = AWSConfiguration(context)

            client = AWSAppSyncClient.builder()
                .context(context)
                .awsConfiguration(awsConfig)
                .build()
        }
        return client
    }
}

package com.k00221230.fyp.hwms

import android.content.Context
import com.amazonaws.mobile.config.AWSConfiguration
import com.amazonaws.mobileconnectors.appsync.AWSAppSyncClient

/**
 * Factory function to generate one-time-only AppSync Clients for use elsewhere in other functions.
 */
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

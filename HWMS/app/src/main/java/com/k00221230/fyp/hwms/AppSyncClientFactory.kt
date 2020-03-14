/*
 * Copyright (c) 2020 RenegadeMaster Inc. - All Right Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * The contents of this file are proprietary and confidential.
 * Written by Ciaran Bent <ciaran.bent@protonmail.ch>, March 2020
 */

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

    /**
     * The Factory function for the AppSync Client.
     * Returns a temporary instance of the AppSync Client for communicating with other AWS entities.
     */
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

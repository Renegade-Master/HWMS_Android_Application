/*
 * Copyright (c) 2020 RenegadeMaster Inc. - All Right Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * The contents of this file are proprietary and confidential.
 * Written by Ciaran Bent <ciaran.bent@protonmail.ch>, March 2020
 */

package com.k00221230.fyp.hwms.ui.searchhistory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchHistoryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text
}
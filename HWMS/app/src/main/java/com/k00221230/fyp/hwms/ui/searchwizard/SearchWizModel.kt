package com.k00221230.fyp.hwms.ui.searchwizard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchWizModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to the Search Generation Wizard"
    }
    val text: LiveData<String> = _text
}
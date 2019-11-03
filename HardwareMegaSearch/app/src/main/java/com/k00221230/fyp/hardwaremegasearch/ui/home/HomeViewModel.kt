package com.k00221230.fyp.hardwaremegasearch.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Save money on your next upgrade!\n\nPress the button below to start a new search."
    }
    val text: LiveData<String> = _text
}
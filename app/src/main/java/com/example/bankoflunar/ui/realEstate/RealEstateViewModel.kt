package com.example.bankoflunar.ui.realEstate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RealEstateViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is realEstate Fragment"
    }
    val text: LiveData<String> = _text
}
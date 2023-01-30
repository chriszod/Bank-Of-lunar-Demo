package com.example.bankoflunar.ui.investing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InvestingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is investing Fragment"
    }
    val text: LiveData<String> = _text
}
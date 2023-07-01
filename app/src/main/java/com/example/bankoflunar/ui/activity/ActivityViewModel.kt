package com.example.bankoflunar.ui.activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bankoflunar.data.model.Deposit
import com.example.bankoflunar.data.repository.DepositRepository
import com.example.bankoflunar.ui.extension.injectable

class ActivityViewModel() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is activity Fragment"
    }
    val text: LiveData<String> = _text

}
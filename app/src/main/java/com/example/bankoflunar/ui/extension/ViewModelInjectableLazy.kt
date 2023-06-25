package com.example.bankoflunar.ui.extension

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import com.example.bankoflunar.BolApplication
import com.example.bankoflunar.Injectable

@MainThread
public inline fun <reified I : Injectable> AndroidViewModel.injectable(): Lazy<I> = object : Lazy<I> {
    private var cached: I? = null

    override val value: I
        get() {
            val injectable = cached
            return if (injectable == null) {
                val app = getApplication<BolApplication>()
                app.getInjectable(I::class).also {
                    cached = it
                }
            } else {
                injectable
            }
        }

    override fun isInitialized(): Boolean = cached != null
}
package com.example.bankoflunar.ui.extension

import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import com.example.bankoflunar.BolApplication
import com.example.bankoflunar.Injectable

@MainThread
public inline fun <reified I : Injectable> Fragment.injectable(): Lazy<I> = object : Lazy<I> {
    private var cached: I? = null

    override val value: I
        get() {
            val injectable = cached
            return if (injectable == null) {
                val app = requireActivity().application as BolApplication
                app.getInjectable(I::class).also {
                    cached = it
                }
            } else {
                injectable
            }
        }

    override fun isInitialized(): Boolean = cached != null
}
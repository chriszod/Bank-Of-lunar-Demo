package com.example.bankoflunar.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentCardButtonDialogBinding

class CardButtonDialogFragment : DialogFragment() {
    private var _binding: FragmentCardButtonDialogBinding? = null
    val binding get()  = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardButtonDialogBinding.inflate(inflater, container, false)
        return binding.root
    }



}
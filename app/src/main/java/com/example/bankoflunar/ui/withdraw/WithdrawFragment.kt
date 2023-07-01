package com.example.bankoflunar.ui.withdraw

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentActivityBinding
import com.example.bankoflunar.databinding.FragmentWithdrawBinding
import com.example.bankoflunar.ui.activity.ActivityViewModel

class WithdrawFragment : Fragment() {

    private var _binding: FragmentWithdrawBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val withdrawViewModel =
            ViewModelProvider(this).get(WithdrawViewModel::class.java)

        _binding = FragmentWithdrawBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
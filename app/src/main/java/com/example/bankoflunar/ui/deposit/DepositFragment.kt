package com.example.bankoflunar.ui.deposit

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentActivityBinding
import com.example.bankoflunar.databinding.FragmentDepositBinding
import com.example.bankoflunar.ui.activity.ActivityViewModel

class DepositFragment : Fragment() {

    private var _binding: FragmentDepositBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val depositViewModel =
            ViewModelProvider(this).get(DepositViewModel::class.java)

        _binding = FragmentDepositBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
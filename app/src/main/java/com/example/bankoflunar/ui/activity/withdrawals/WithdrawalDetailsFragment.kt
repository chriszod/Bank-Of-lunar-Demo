package com.example.bankoflunar.ui.activity.withdrawals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentWithdrawalDetailsBinding
import com.example.bankoflunar.ui.withdraw.model.WithdrawalGenerator

class WithdrawalDetailsFragment : Fragment() {
    private var _binding: FragmentWithdrawalDetailsBinding? = null
    val binding get()  = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentWithdrawalDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = WithdrawalGenerator.getWithdrawalData(100)
        recyclerView = binding.recyclerView
        recyclerView.adapter = WithdrawalDetailsAdapter(
            dataSet = data,
            goToWithdrawalDetails = { gotoWithdrawalDetails() },
        )
    }

    private fun gotoWithdrawalDetails() {
        findNavController().navigate(R.id.action_withdrawalDetailsFragment_to_withdrawalDetailsMoreInfoFragment)
    }


}
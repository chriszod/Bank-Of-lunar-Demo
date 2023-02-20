package com.example.bankoflunar.ui.activity.investments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentInvestmentDetailsBinding
import com.example.bankoflunar.ui.investing.model.InvestmentGenerator

class InvestmentDetailsFragment : Fragment() {
    private var _binding: FragmentInvestmentDetailsBinding? = null
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
        _binding = FragmentInvestmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = InvestmentGenerator.getInvestmentData(100)
        recyclerView = binding.recyclerView
        recyclerView.adapter = InvestmentDetailsAdapter(
            dataSet = data,
            goToInvestmentDetails = { gotoInvestmentDetails() },
        )
    }

    private fun gotoInvestmentDetails() {
        findNavController().navigate(R.id.action_investmentDetailsFragment_to_investmentDetailsMoreInfoFragment)
    }

}
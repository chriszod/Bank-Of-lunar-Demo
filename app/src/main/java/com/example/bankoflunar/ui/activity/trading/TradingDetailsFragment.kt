package com.example.bankoflunar.ui.activity.trading

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentTradingDetailsBinding
import com.example.bankoflunar.ui.trading.model.TradingGenerator


class TradingDetailsFragment : Fragment() {
    private var _binding: FragmentTradingDetailsBinding? = null
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
        _binding = FragmentTradingDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = TradingGenerator.getTradingData(100)
        recyclerView = binding.recyclerView
        recyclerView.adapter = TradingDetailsAdapter(
            dataSet = data,
            goToTradingDetails = { gotoTradingDetails() },
        )
    }

    private fun gotoTradingDetails() {
        findNavController().navigate(R.id.action_tradingDetailsFragment_to_tradingDetailsMoreInfoFragment)
    }

}
package com.example.bankoflunar.ui.trading

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentInvestingBinding
import com.example.bankoflunar.databinding.FragmentTradingBinding
import com.example.bankoflunar.ui.investing.InvestingViewModel

class TradingFragment : Fragment() {

    private var _binding: FragmentTradingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tradingViewModel =
            ViewModelProvider(this).get(TradingViewModel::class.java)

        _binding = FragmentTradingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTrading
        tradingViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
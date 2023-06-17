package com.example.bankoflunar.ui.trading

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentInvestingBinding
import com.example.bankoflunar.databinding.FragmentTradingBinding
import com.example.bankoflunar.ui.investing.InvestingViewModel

class TradingFragment : Fragment() {

    private var _binding: FragmentTradingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tradingViewModel =
            ViewModelProvider(this).get(TradingViewModel::class.java)

        _binding = FragmentTradingBinding.inflate(inflater, container, false)
        _binding?.goToStockCFDs = gotoStockCFDs
        _binding?.goToForexTrading = gotoForexTrading
        _binding?.goToCommodities = gotoCommodities
        _binding?.goToEquityIndices = gotoEquityIndices
        _binding?.goToPreciousMetals = gotoPreciousMetals
        _binding?.goToEnergies = gotoEnergies
        _binding?.goToShares = gotoShares
        _binding?.goToNFP = gotoNFP
        return binding.root
    }

    private val gotoStockCFDs = Runnable{
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment)
    }

    private val gotoForexTrading = Runnable{
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment)
    }

    private val gotoCommodities = Runnable{
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment)
    }

    private val gotoEquityIndices = Runnable{
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment)
    }

    private val gotoPreciousMetals = Runnable{
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment)
    }

    private val gotoEnergies = Runnable{
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment)
    }

    private val gotoShares = Runnable{
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment)
    }

    private val gotoNFP = Runnable{
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
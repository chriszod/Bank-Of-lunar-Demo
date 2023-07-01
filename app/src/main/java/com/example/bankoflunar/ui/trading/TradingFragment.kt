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
        val bundle = Bundle().apply {
            putInt("item", 1)
        }
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment, bundle)
    }

    private val gotoForexTrading = Runnable{
        val bundle = Bundle().apply {
            putInt("item", 2)
        }
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment, bundle)
    }

    private val gotoCommodities = Runnable{
        val bundle = Bundle().apply {
            putInt("item", 3)
        }
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment, bundle)
    }

    private val gotoEquityIndices = Runnable{
        val bundle = Bundle().apply {
            putInt("item", 4)
        }
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment, bundle)
    }

    private val gotoPreciousMetals = Runnable{
        val bundle = Bundle().apply {
            putInt("item", 5)
        }
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment, bundle)
    }

    private val gotoEnergies = Runnable{
        val bundle = Bundle().apply {
            putInt("item", 6)
        }
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment, bundle)
    }

    private val gotoShares = Runnable{
        val bundle = Bundle().apply {
            putInt("item", 7)
        }
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment, bundle)
    }

    private val gotoNFP = Runnable{
        val bundle = Bundle().apply {
            putInt("item", 8)
        }
        findNavController().navigate(R.id.action_nav_trading_to_cardRecyclerViewFragment, bundle)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
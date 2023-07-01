package com.example.bankoflunar.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentActivityBinding

class ActivityFragment : Fragment() {

    private var _binding: FragmentActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val activityViewModel =
            ViewModelProvider(this).get(ActivityViewModel::class.java)

        _binding = FragmentActivityBinding.inflate(inflater, container, false)
        _binding?.goToDeposit = gotoDeposit
        _binding?.goToWithdrawal = gotoWithdrawal
        _binding?.goToInvestment = gotoInvestment
        _binding?.goToInternalTransfer = gotoInternalTransfer
        _binding?.goToTrading = gotoTrading
        return  binding.root
    }

    private val gotoDeposit = Runnable {
        val bundle = Bundle().apply {
            putInt("item", 1)
        }

        findNavController().navigate(R.id.action_nav_activity_to_activityRecyclerViewFragment, bundle)
    }

    private val gotoWithdrawal = Runnable {
        val bundle = Bundle().apply {
            putInt("item", 2)
        }
        findNavController().navigate(R.id.action_nav_activity_to_activityRecyclerViewFragment, bundle)
    }

    private val gotoInvestment = Runnable {
        findNavController().navigate(R.id.action_nav_activity_to_activityRecyclerViewFragment)
    }

    private val gotoTrading = Runnable {
        findNavController().navigate(R.id.action_nav_activity_to_activityRecyclerViewFragment)
    }

    private val gotoInternalTransfer = Runnable {
        findNavController().navigate(R.id.action_nav_activity_to_activityRecyclerViewFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

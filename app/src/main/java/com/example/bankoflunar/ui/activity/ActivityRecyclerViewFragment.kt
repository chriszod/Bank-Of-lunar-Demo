package com.example.bankoflunar.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.data.repository.DepositRepository
import com.example.bankoflunar.data.repository.WithdrawalRepository
import com.example.bankoflunar.databinding.FragmentActivityRecyclerViewBinding
import com.example.bankoflunar.ui.activity.model.TransactionModel
import com.example.bankoflunar.ui.activity.model.toTransactionModel
import com.example.bankoflunar.ui.extension.injectable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityRecyclerViewFragment : Fragment() {
    private var _binding: FragmentActivityRecyclerViewBinding? = null
    val binding get() = _binding!!
    private val depositRepository: DepositRepository by injectable()
    private val withdrawalRepository: WithdrawalRepository by injectable()
    private var item: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getInt("item") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentActivityRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.Main) {
            val dataSet: List<TransactionModel> = when (item) {
                1 -> depositRepository.getDeposits().map { it.toTransactionModel() }
                2 -> withdrawalRepository.getWithdrawals().map { it.toTransactionModel() }
                else -> emptyList()
            }
            binding.recyclerView.adapter =
                ActivityAdapter(dataSet = dataSet, gotoDetails = gotoDetails)
        }
    }

    private val gotoDetails = Runnable {
        findNavController().navigate(R.id.action_activityRecyclerViewFragment_to_activityDetailsFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
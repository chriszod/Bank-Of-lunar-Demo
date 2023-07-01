package com.example.bankoflunar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.bankoflunar.data.repository.ForexTradingRepository
import com.example.bankoflunar.data.repository.InvestingRepository
import com.example.bankoflunar.data.repository.StockCFDsRepository
import com.example.bankoflunar.databinding.FragmentCardRecyclerViewBinding
import com.example.bankoflunar.ui.activity.model.toTransactionModel
import com.example.bankoflunar.ui.extension.injectable
import com.example.bankoflunar.ui.model.CardModel
import com.example.bankoflunar.ui.model.toCardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CardRecyclerViewFragment : Fragment() {
    private var _binding: FragmentCardRecyclerViewBinding? = null
    val binding get()  = _binding!!
    private val stockCFDsRepository: StockCFDsRepository by injectable()
    private val forexTradingRepository: ForexTradingRepository by injectable()
    private var item: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        item = arguments?.getInt("item") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCardRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.Main) {
            val dataSet: List<CardModel> = when (item) {
                1 -> stockCFDsRepository.getStockCFDs().map { it.toCardModel() }
                2 -> forexTradingRepository.getForexTrading().map { it.toCardModel() }
                else -> emptyList()
                }
            binding.recyclerView.adapter =
                CardAdapter(dataSet = dataSet, gotoDialog = gotoDialog)
        }
    }

    private val gotoDialog = Runnable {
        CardButtonDialogFragment().show(childFragmentManager, TAG)
    }

    companion object {
        const val TAG = "PurchaseConfirmationDialog"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
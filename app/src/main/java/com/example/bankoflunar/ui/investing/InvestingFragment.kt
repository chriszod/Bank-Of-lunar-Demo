package com.example.bankoflunar.ui.investing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.bankoflunar.data.repository.InvestingRepository
import com.example.bankoflunar.databinding.FragmentInvestingBinding
import com.example.bankoflunar.ui.CardAdapter
import com.example.bankoflunar.ui.CardButtonDialogFragment
import com.example.bankoflunar.ui.extension.injectable
import com.example.bankoflunar.ui.model.CardModel
import com.example.bankoflunar.ui.model.toCardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InvestingFragment : Fragment() {

    private var _binding: FragmentInvestingBinding? = null
    val binding get()  = _binding!!
    private val investingRepository: InvestingRepository by injectable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInvestingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.Main) {
            val dataSet: List<CardModel> =
                investingRepository.getInvesting().map { it.toCardModel()
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
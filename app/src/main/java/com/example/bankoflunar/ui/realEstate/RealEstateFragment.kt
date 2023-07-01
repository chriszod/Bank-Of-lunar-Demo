package com.example.bankoflunar.ui.realEstate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.bankoflunar.data.repository.RealEstateRepository
import com.example.bankoflunar.databinding.FragmentRealEstateBinding
import com.example.bankoflunar.ui.CardAdapter
import com.example.bankoflunar.ui.CardButtonDialogFragment
import com.example.bankoflunar.ui.extension.injectable
import com.example.bankoflunar.ui.model.CardModel
import com.example.bankoflunar.ui.model.toCardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RealEstateFragment : Fragment() {

    private var _binding: FragmentRealEstateBinding? = null
    private val binding get() = _binding!!
    private val realEstateRepository: RealEstateRepository by injectable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRealEstateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.Main) {
            val dataSet: List<CardModel> =
                realEstateRepository.getRealEstate().map { it.toCardModel()
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
package com.example.bankoflunar.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentCardRecyclerViewBinding
import com.example.bankoflunar.ui.model.CardsGenerator


class CardRecyclerViewFragment : Fragment() {
    private var _binding: FragmentCardRecyclerViewBinding? = null
    val binding get()  = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        val data = CardsGenerator.getCardData(3)
        recyclerView = binding.recyclerView
        recyclerView.adapter = CardAdapter(dataSet = data, gotoDialog = gotoDialog)
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
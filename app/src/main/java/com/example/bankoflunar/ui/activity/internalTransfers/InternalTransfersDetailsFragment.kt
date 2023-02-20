package com.example.bankoflunar.ui.activity.internalTransfers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentInternalTransfersDetailsBinding
import com.example.bankoflunar.ui.transfer.model.InternalTransferGenerator

class InternalTransfersDetailsFragment : Fragment() {
    private var _binding: FragmentInternalTransfersDetailsBinding? = null
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
        _binding = FragmentInternalTransfersDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = InternalTransferGenerator.getInternalTransfersData(100)
        recyclerView = binding.recyclerView
        recyclerView.adapter = InternalTransfersDetailsAdapter(
            dataSet = data,
            goToInternalTransfersDetails = { gotoInternalTransfersDetails() },
        )
    }

    private fun gotoInternalTransfersDetails() {
        findNavController().navigate(R.id.action_internalTransfersDetailsFragment_to_internalTransfersDetailsMoreInfoFragment)
    }

}
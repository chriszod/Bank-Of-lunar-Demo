package com.example.bankoflunar.ui.activity.deposit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentDepositDetailsBinding
import com.example.bankoflunar.ui.deposit.model.Generator


class DepositDetailsFragment : Fragment() {
    private var _binding: FragmentDepositDetailsBinding? = null
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
        _binding = FragmentDepositDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = Generator.getDepositData(100)
        recyclerView = binding.recyclerView
        recyclerView.adapter = DepositDetailsAdapter(
            dataSet = data,
            gotoDepositDetails = { gotoDepositDetails() },
        )
    }

    private fun gotoDepositDetails() {
        findNavController().navigate(R.id.action_depositDetailsFragment_to_activityDepositDetailsFragment)
    }
}
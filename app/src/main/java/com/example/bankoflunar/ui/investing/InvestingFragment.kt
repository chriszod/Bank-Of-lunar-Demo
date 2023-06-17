package com.example.bankoflunar.ui.investing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentInvestingBinding
import com.example.bankoflunar.ui.CardAdapter
import com.example.bankoflunar.ui.CardButtonDialogFragment
import com.example.bankoflunar.ui.CardRecyclerViewFragment
import com.example.bankoflunar.ui.model.CardsGenerator

class InvestingFragment : Fragment() {

    private var _binding: FragmentInvestingBinding? = null
    val binding get()  = _binding!!
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        val investingViewModel =
            ViewModelProvider(this).get(InvestingViewModel::class.java)

        _binding = FragmentInvestingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = CardsGenerator.getCardData(3)
        recyclerView = binding.recyclerView
        recyclerView.adapter = CardAdapter(dataSet = data, gotoDialog = gotoDialog)
    }

    private val gotoDialog = Runnable {
        CardButtonDialogFragment().show(childFragmentManager, CardRecyclerViewFragment.TAG)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
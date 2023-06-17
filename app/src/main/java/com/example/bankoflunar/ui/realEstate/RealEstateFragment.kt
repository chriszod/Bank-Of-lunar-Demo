package com.example.bankoflunar.ui.realEstate

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentRealEstateBinding
import com.example.bankoflunar.ui.CardAdapter
import com.example.bankoflunar.ui.CardButtonDialogFragment
import com.example.bankoflunar.ui.CardRecyclerViewFragment
import com.example.bankoflunar.ui.model.CardsGenerator

class RealEstateFragment : Fragment() {

    private var _binding: FragmentRealEstateBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val realEstateViewModel =
            ViewModelProvider(this).get(RealEstateViewModel::class.java)

        _binding = FragmentRealEstateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = CardsGenerator.getCardData(1)
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
package com.example.bankoflunar.ui.realEstate

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentActivityBinding
import com.example.bankoflunar.databinding.FragmentRealEstateBinding
import com.example.bankoflunar.ui.activity.ActivityViewModel

class RealEstateFragment : Fragment() {

    private var _binding: FragmentRealEstateBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val realEstateViewModel =
            ViewModelProvider(this).get(RealEstateViewModel::class.java)

        _binding = FragmentRealEstateBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
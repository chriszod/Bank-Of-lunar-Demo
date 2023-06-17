package com.example.bankoflunar.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.R
import com.example.bankoflunar.databinding.FragmentActivityRecyclerViewBinding
import com.example.bankoflunar.ui.activity.model.ActivityGenerator

class ActivityRecyclerViewFragment : Fragment() {
    private var _binding: FragmentActivityRecyclerViewBinding? = null
    val binding get()  = _binding!!
    private lateinit var recyclerView: RecyclerView


   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        val data = ActivityGenerator.getActivityData(100)
        recyclerView = binding.recyclerView
        recyclerView.adapter = ActivityAdapter(dataSet = data, gotoDetails = gotoDetails)
    }

    private val gotoDetails = Runnable {
        findNavController().navigate(R.id.action_activityRecyclerViewFragment_to_activityDetailsFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
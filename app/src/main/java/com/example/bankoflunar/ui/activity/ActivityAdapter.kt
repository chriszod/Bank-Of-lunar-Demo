package com.example.bankoflunar.ui.activity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.databinding.ListActivityBinding
import com.example.bankoflunar.ui.activity.model.TransactionModel

class ActivityAdapter(
    private val dataSet: List<TransactionModel>,
    private val gotoDetails: Runnable,
) : RecyclerView.Adapter<ActivityAdapter.ActivityAdapterViewHolder>() {

    inner class ActivityAdapterViewHolder(
        private val binding: ListActivityBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transactionModel: TransactionModel) {
            binding.activity = transactionModel
            binding.goToDetails = gotoDetails
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityAdapterViewHolder {
        val binding = ListActivityBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ActivityAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: ActivityAdapterViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}
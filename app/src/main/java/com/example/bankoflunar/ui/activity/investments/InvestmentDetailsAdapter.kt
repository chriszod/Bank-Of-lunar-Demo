package com.example.bankoflunar.ui.activity.investments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.databinding.ListActivityInvestmentsBinding
import com.example.bankoflunar.ui.investing.model.Investment

class InvestmentDetailsAdapter (
    private val dataSet : List<Investment>,
    private val goToInvestmentDetails: () -> Unit,
): RecyclerView.Adapter<InvestmentDetailsAdapter.InvestmentDetailsViewHolder>() {

    class InvestmentDetailsViewHolder(
        private val binding: ListActivityInvestmentsBinding,
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(investment: Investment) {
            binding.investment = investment
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvestmentDetailsViewHolder {
        val binding = ListActivityInvestmentsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        binding.seeInvestmentDetails = Runnable { goToInvestmentDetails() }

        return InvestmentDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: InvestmentDetailsViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}
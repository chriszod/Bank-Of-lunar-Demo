package com.example.bankoflunar.ui.activity.deposit


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.databinding.ListActivityDepositBinding
import com.example.bankoflunar.ui.deposit.model.Deposit

class DepositDetailsAdapter (
    private val dataSet : List<Deposit>,
    private val gotoDepositDetails: () -> Unit,
) : RecyclerView.Adapter<DepositDetailsAdapter.DepositDetailsViewHolder>() {

    class DepositDetailsViewHolder(
        private val binding: ListActivityDepositBinding,
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(deposit: Deposit) {
            binding.deposit = deposit
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepositDetailsViewHolder {
        val binding = ListActivityDepositBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        binding.seeDepositDetails = Runnable { gotoDepositDetails() }

        return DepositDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: DepositDetailsViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}
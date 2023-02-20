package com.example.bankoflunar.ui.activity.withdrawals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.databinding.ListActivityWithdrawalBinding
import com.example.bankoflunar.ui.withdraw.model.Withdrawal

class WithdrawalDetailsAdapter (
    private val dataSet : List<Withdrawal>,
    private val goToWithdrawalDetails: () -> Unit,
): RecyclerView.Adapter<WithdrawalDetailsAdapter.WithdrawalDetailsViewHolder>() {

    class WithdrawalDetailsViewHolder(
        private val binding: ListActivityWithdrawalBinding,
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(withdrawal: Withdrawal) {
            binding.withdrawal = withdrawal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WithdrawalDetailsViewHolder {
        val binding = ListActivityWithdrawalBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        binding.seeWithdrawalDetails = Runnable { goToWithdrawalDetails() }

        return WithdrawalDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: WithdrawalDetailsViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}
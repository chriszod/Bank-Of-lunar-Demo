package com.example.bankoflunar.ui.activity.internalTransfers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.databinding.ListActivityInternalTransfersBinding
import com.example.bankoflunar.ui.transfer.model.InternalTransfer

class InternalTransfersDetailsAdapter (
    private val dataSet : List<InternalTransfer>,
    private val goToInternalTransfersDetails: () -> Unit,
): RecyclerView.Adapter<InternalTransfersDetailsAdapter.InternalTransfersDetailsViewHolder>() {

    class InternalTransfersDetailsViewHolder(
        private val binding: ListActivityInternalTransfersBinding,
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(internalTransfer: InternalTransfer) {
            binding.internalTransfer = internalTransfer
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InternalTransfersDetailsViewHolder {
        val binding = ListActivityInternalTransfersBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        binding.seeInternalTransferDetails = Runnable { goToInternalTransfersDetails() }

        return InternalTransfersDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: InternalTransfersDetailsViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}
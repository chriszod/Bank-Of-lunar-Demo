package com.example.bankoflunar.ui.activity.trading

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.databinding.ListActivityTradingBinding
import com.example.bankoflunar.ui.trading.model.Trading


class TradingDetailsAdapter (
    private val dataSet: List<Trading>,
    private val goToTradingDetails : () -> Unit,
) : RecyclerView.Adapter<TradingDetailsAdapter.TradingDetailsViewHolder>() {

    class TradingDetailsViewHolder(
        private val binding: ListActivityTradingBinding,
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(trading: Trading) {
            binding.trading = trading
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TradingDetailsViewHolder {
        val binding = ListActivityTradingBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        binding.seeTradingDetails = Runnable { goToTradingDetails() }

        return TradingDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: TradingDetailsViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}
package com.example.bankoflunar.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bankoflunar.databinding.ListCardsBinding
import com.example.bankoflunar.ui.model.Cards

class CardAdapter(private val dataSet: List<Cards>,
                  private val gotoDialog: Runnable,
): RecyclerView.Adapter<CardAdapter.CardAdapterHolder>() {
    inner class CardAdapterHolder(
        private val binding: ListCardsBinding,
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(card: Cards){
            binding.card = card
            binding.gotoDialog = gotoDialog
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapterHolder {
        val binding = ListCardsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CardAdapterHolder(binding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: CardAdapterHolder, position: Int) {
        holder.bind(dataSet[position])
    }
}
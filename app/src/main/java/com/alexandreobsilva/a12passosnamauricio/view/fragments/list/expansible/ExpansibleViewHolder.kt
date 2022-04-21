package com.alexandreobsilva.a12passosnamauricio.view.fragments.list.expansible

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alexandreobsilva.a12passosnamauricio.R
import com.alexandreobsilva.a12passosnamauricio.databinding.ItemViewExpansibleBinding

class ExpansibleViewHolder(
    private val binding: ItemViewExpansibleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        item: ExpansibleItem,
        isExpanded: Boolean,
        onClickExpand: () -> Unit
    ) {
        binding.run {
            title.text = item.title
            description.text = item.description
            if (isExpanded) {
                description.visibility = View.VISIBLE
                expandIndicator.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
            } else {
                description.visibility = View.GONE
                expandIndicator.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
            }
            root.setOnClickListener { onClickExpand() }
        }
    }
}
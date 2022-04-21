package com.alexandreobsilva.a12passosnamauricio.view.fragments.list.expansible

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.alexandreobsilva.a12passosnamauricio.databinding.ItemViewExpansibleBinding

class ExpansibleAdapter : ListAdapter<ExpansibleItem, ExpansibleViewHolder>(
    ExpansibleDiffCallback()
) {
    private val expandedPositions = mutableSetOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpansibleViewHolder {
        return ItemViewExpansibleBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
            .let { ExpansibleViewHolder(it) }
    }

    override fun onBindViewHolder(holder: ExpansibleViewHolder, position: Int) =
        holder.bind(
            item = getItem(position),
            isExpanded = expandedPositions.contains(position),
            onClickExpand = { toggleExpanded(position) }
        )

    private fun toggleExpanded(position: Int) {
        expandedPositions.run {
            if (contains(position)) {
                remove(position)
            } else {
                add(position)
            }
        }
        notifyItemChanged(position)
    }

    class ExpansibleDiffCallback : DiffUtil.ItemCallback<ExpansibleItem>() {

        override fun areItemsTheSame(
            oldItem: ExpansibleItem,
            newItem: ExpansibleItem
        ): Boolean =
            oldItem.title == newItem.title

        override fun areContentsTheSame(
            oldItem: ExpansibleItem,
            newItem: ExpansibleItem
        ): Boolean =
            oldItem.title == newItem.title &&
                    oldItem.description == newItem.description
    }
}
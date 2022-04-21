package com.alexandreobsilva.a12passosnamauricio.view.fragments.list.expansible

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.alexandreobsilva.a12passosnamauricio.databinding.FragmentExpansibleListBinding

class ExpansibleListFragment : Fragment() {

    private var _binding: FragmentExpansibleListBinding? = null
    private val binding: FragmentExpansibleListBinding get() = _binding!!

    private val items: List<ExpansibleItem>?
        get() = arguments
            ?.getParcelableArrayList<ExpansibleItem>(ARGUMENT_ITEMS)
            ?.toList()
            ?: listOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentExpansibleListBinding
            .inflate(inflater, container, false)
            .also { _binding = it }
            .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setItemsList()
    }

    private fun setItemsList() {
        items?.takeIf { it.isNotEmpty() }?.let { nonEmptyItems ->
            binding.recycler.run {
                adapter = ExpansibleAdapter().apply { submitList(nonEmptyItems) }
                addItemDecoration(DividerItemDecoration(context, VERTICAL))
            }
        }
    }

    companion object {

        private const val ARGUMENT_ITEMS = "ARGUMENT_ITEMS"

        fun newInstance(items: List<ExpansibleItem>) =
            ExpansibleListFragment().apply {
                arguments = bundleOf(
                    ARGUMENT_ITEMS to ArrayList(items)
                )
            }
    }
}

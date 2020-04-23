package com.alexandreobsilva.a12passosnamauricio.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.alexandreobsilva.a12passosnamauricio.R

/**
 * A simple [Fragment] subclass.
 */
class RecyclerDiarioFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val minhaView = inflater.inflate(R.layout.fragment_recycler_diario, container, false)



        return minhaView
    }

}

/*
 * Copyright (c) 2020 RenegadeMaster Inc. - All Right Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * The contents of this file are proprietary and confidential.
 * Written by Ciaran Bent <ciaran.bent@protonmail.ch>, March 2020
 */

package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i5.g5XXX

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.k00221230.fyp.hwms.R
import com.k00221230.fyp.hwms.ui.searchwizard.SearchWizViewModel

class SearchWizCpuIntelI55000Fragment : Fragment() {

    private val args: SearchWizCpuIntelI55000FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI55000ViewModel: SearchWizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel_i5_5000, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textview_searchwiz_selectcomponent).text =
            getString(R.string.hello_searchwiz_component, args.myArg)

        view.findViewById<Button>(R.id.button_searchwiz_next).setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.radiogrp_searchwiz_selector)
            val selectionId = radioGroup.checkedRadioButtonId
            val selection = radioGroup.findViewById<RadioButton>(selectionId)

            when (selection.tag) {
                "4130" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 4130", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
            }

            /*Snackbar.make(view, "Selected Intel Core i5 " + selection.tag, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show()*/

            val sbTerm: StringBuilder = StringBuilder()
            sbTerm
                .append("CPU ")
                .append("Intel ")
                .append("i5 ")
                .append(selection.tag)

            val term: String = sbTerm.toString()
            // AppSyncClient.sendClientRequest(context, term)

            val action = SearchWizCpuIntelI55000FragmentDirections
                .actionSearchWizCpuIntelI55000FragmentToSearchWizResultsFragment(term)
            NavHostFragment.findNavController(this@SearchWizCpuIntelI55000Fragment)
                .navigate(action)
        }
    }
}

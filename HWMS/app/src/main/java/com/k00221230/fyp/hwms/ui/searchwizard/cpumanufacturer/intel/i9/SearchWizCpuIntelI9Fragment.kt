package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i9

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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar

import com.k00221230.fyp.hwms.R
import com.k00221230.fyp.hwms.ui.searchwizard.SearchWizViewModel

class SearchWizCpuIntelI9Fragment : Fragment() {

    private val args: SearchWizCpuIntelI9FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI9ViewModel: SearchWizViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel_i9, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textview_searchwiz_selectcomponent).text =
                getString(R.string.hello_searchwiz_cpu_intel_generation, args.myArg)

        view.findViewById<Button>(R.id.button_searchwiz_next).setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.radiogrp_searchwiz_selector)
            val selectionId = radioGroup.checkedRadioButtonId
            val selection = radioGroup.findViewById<RadioButton>(selectionId)

            when(selection.tag) {
                "9000" -> {
                    /*Snackbar.make(view, "Selected 9XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI9FragmentDirections
                        .actionSearchWizCpuIntelI9FragmentToSearchWizCpuIntelI99000Fragment("From search step CPU_INTEL_I9")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI9Fragment)
                        .navigate(action)
                }
            }
        }
    }
}

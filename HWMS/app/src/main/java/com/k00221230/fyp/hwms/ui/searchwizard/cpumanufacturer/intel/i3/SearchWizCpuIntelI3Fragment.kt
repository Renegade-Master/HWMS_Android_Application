package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i3

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
import com.google.android.material.snackbar.Snackbar

import com.k00221230.fyp.hwms.R
import com.k00221230.fyp.hwms.ui.searchwizard.SearchWizViewModel

class SearchWizCpuIntelI3Fragment : Fragment() {

    private val args: SearchWizCpuIntelI3FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI3ViewModel: SearchWizViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel_i3, container, false)
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
                "4000" -> {
                    /*Snackbar.make(view, "Selected 4XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI3FragmentDirections
                        .actionSearchWizCpuIntelI3FragmentToSearchWizCpuIntelI34000Fragment("From search step CPU_INTEL_I3")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI3Fragment)
                        .navigate(action)
                }
                "6000" -> {
                    /*Snackbar.make(view, "Selected 6XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI3FragmentDirections
                        .actionSearchWizCpuIntelI3FragmentToSearchWizCpuIntelI36000Fragment("From search step CPU_INTEL_I3")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI3Fragment)
                        .navigate(action)
                }
                "7000" -> {
                    /*Snackbar.make(view, "Selected 7XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI3FragmentDirections
                        .actionSearchWizCpuIntelI3FragmentToSearchWizCpuIntelI37000Fragment("From search step CPU_INTEL_I3")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI3Fragment)
                        .navigate(action)
                }
                "8000" -> {
                    /*Snackbar.make(view, "Selected 8XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI3FragmentDirections
                        .actionSearchWizCpuIntelI3FragmentToSearchWizCpuIntelI38000Fragment("From search step CPU_INTEL_I3")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI3Fragment)
                        .navigate(action)
                }
                "9000" -> {
                    /*Snackbar.make(view, "Selected 9XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI3FragmentDirections
                        .actionSearchWizCpuIntelI3FragmentToSearchWizCpuIntelI39000Fragment("From search step CPU_INTEL_I3")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI3Fragment)
                        .navigate(action)
                }
            }
        }
    }
}

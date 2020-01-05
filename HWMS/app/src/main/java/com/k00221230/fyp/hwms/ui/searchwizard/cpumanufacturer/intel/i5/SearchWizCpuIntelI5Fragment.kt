package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i5

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
import com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.SearchWizCpuManufacturerFragmentDirections
import com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.SearchWizCpuManuIntelFragmentArgs
import com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.SearchWizCpuManuIntelFragmentDirections
import com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i3.SearchWizCpuIntelI3FragmentArgs
import com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i3.SearchWizCpuIntelI3FragmentDirections

class SearchWizCpuIntelI5Fragment : Fragment() {

    private val args: SearchWizCpuIntelI3FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI5ViewModel: SearchWizViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_componentselect, container, false)
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
                    Snackbar.make(view, "Selected 4XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "5000" -> {
                    Snackbar.make(view, "Selected 5XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "6000" -> {
                    Snackbar.make(view, "Selected 6XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "7000" -> {
                    Snackbar.make(view, "Selected 7XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "8000" -> {
                    Snackbar.make(view, "Selected 8XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "9000" -> {
                    Snackbar.make(view, "Selected 9XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "10000" -> {
                    Snackbar.make(view, "Selected 10XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
            }
            findNavController().navigate(R.id.action_SearchWizCpuManuIntelFragment_to_SearchWizHomeFragment)
        }
    }
}

package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer

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
import com.k00221230.fyp.hwms.ui.searchwizard.SearchWizComponentSelectFragmentDirections
import com.k00221230.fyp.hwms.ui.searchwizard.SearchWizViewModel

class SearchWizCpuManufacturerFragment : Fragment() {

    private val args: SearchWizCpuManufacturerFragmentArgs by navArgs()

    private lateinit var SearchWizCpuViewModel: SearchWizViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpumanufacturer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textview_searchwiz_selectcomponent).text =
                getString(R.string.hello_searchwiz_cpu_manufacturer, args.myArg)

        view.findViewById<Button>(R.id.button_searchwiz_next).setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.radiogrp_searchwiz_selector)
            val selectionId = radioGroup.checkedRadioButtonId
            val selection = radioGroup.findViewById<RadioButton>(selectionId)

            when(selection.tag) {
                "AMD" -> {
                    Snackbar.make(view, "Selected AMD", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                    val action = SearchWizCpuManufacturerFragmentDirections
                        .actionSearchWizCpuManufacturerFragmentToSearchWizCpuManuAmdFragment("From search step CPU_MANUFACTURER")
                    NavHostFragment.findNavController(this@SearchWizCpuManufacturerFragment)
                        .navigate(action)
                }
                "INTEL" -> {
                    Snackbar.make(view, "Selected Intel", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                    val action = SearchWizCpuManufacturerFragmentDirections
                        .actionSearchWizCpuManufacturerFragmentToSearchWizCpuManuIntelFragment("From search step CPU_MANUFACTURER")
                    NavHostFragment.findNavController(this@SearchWizCpuManufacturerFragment)
                        .navigate(action)
                }
            }

            //findNavController().navigate(R.id.action_SearchWizCpuManufacturerFragment_to_SearchWizHomeFragment)
        }
    }
}

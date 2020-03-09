package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel

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

class SearchWizCpuManuIntelFragment : Fragment() {

    private val args: SearchWizCpuManuIntelFragmentArgs by navArgs()

    private lateinit var SearchWizCpuManuIntelViewModel: SearchWizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textview_searchwiz_selectcomponent).text =
            getString(R.string.hello_searchwiz_cpu_intel_tier, args.myArg)

        view.findViewById<Button>(R.id.button_searchwiz_next).setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.radiogrp_searchwiz_selector)
            val selectionId = radioGroup.checkedRadioButtonId
            val selection = radioGroup.findViewById<RadioButton>(selectionId)

            when (selection.tag) {
                "I3" -> {
                    /*Snackbar.make(view, "Selected i3", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuManuIntelFragmentDirections
                        .actionSearchWizCpuManuIntelFragmentToSearchWizCpuIntelI3Fragment("From search step CPU_INTEL")
                    NavHostFragment.findNavController(this@SearchWizCpuManuIntelFragment)
                        .navigate(action)
                }
                "I5" -> {
                    /*Snackbar.make(view, "Selected i5", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuManuIntelFragmentDirections
                        .actionSearchWizCpuManuIntelFragmentToSearchWizCpuIntelI5Fragment("From search step CPU_INTEL")
                    NavHostFragment.findNavController(this@SearchWizCpuManuIntelFragment)
                        .navigate(action)
                }
                "I7" -> {
                    /*Snackbar.make(view, "Selected i7", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuManuIntelFragmentDirections
                        .actionSearchWizCpuManuIntelFragmentToSearchWizCpuIntelI7Fragment("From search step CPU_INTEL")
                    NavHostFragment.findNavController(this@SearchWizCpuManuIntelFragment)
                        .navigate(action)
                }
                "I9" -> {
                    /*Snackbar.make(view, "Selected i9", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuManuIntelFragmentDirections
                        .actionSearchWizCpuManuIntelFragmentToSearchWizCpuIntelI9Fragment("From search step CPU_INTEL")
                    NavHostFragment.findNavController(this@SearchWizCpuManuIntelFragment)
                        .navigate(action)
                }
            }
        }
    }
}

package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i7.g8XXX

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

class SearchWizCpuIntelI78000Fragment : Fragment() {

    private val args: SearchWizCpuIntelI78000FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI78000ViewModel: SearchWizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel_i7_8000, container, false)
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
                "5820K" -> {
                    /*Snackbar.make(view, "Selected Intel Core i7 5820K", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "5930K" -> {
                    /*Snackbar.make(view, "Selected Intel Core i7 5930K", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "5960X" -> {
                    /*Snackbar.make(view, "Selected Intel Core i7 5960X", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
            }

            val sbTerm: StringBuilder = StringBuilder()
            sbTerm
                .append("CPU ")
                .append("Intel ")
                .append("i7 ")
                .append(selection.tag)

            val term: String = sbTerm.toString()
            // AppSyncClient.sendClientRequest(context, term)

            val action = SearchWizCpuIntelI78000FragmentDirections
                .actionSearchWizCpuIntelI78000FragmentToSearchWizResultsFragment(term)
            NavHostFragment.findNavController(this@SearchWizCpuIntelI78000Fragment)
                .navigate(action)
        }
    }
}

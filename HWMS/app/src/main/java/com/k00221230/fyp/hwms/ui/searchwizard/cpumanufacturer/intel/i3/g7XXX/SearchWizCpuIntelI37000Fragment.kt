package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i3.g7XXX

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
import com.k00221230.fyp.hwms.AppSyncClient

import com.k00221230.fyp.hwms.R
import com.k00221230.fyp.hwms.ui.searchwizard.SearchWizViewModel

class SearchWizCpuIntelI37000Fragment : Fragment() {

    private val args: SearchWizCpuIntelI37000FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI37000ViewModel: SearchWizViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel_i3_7000, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textview_searchwiz_selectcomponent).text =
                getString(R.string.hello_searchwiz_component, args.myArg)

        view.findViewById<Button>(R.id.button_searchwiz_next).setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.radiogrp_searchwiz_selector)
            val selectionId = radioGroup.checkedRadioButtonId
            val selection = radioGroup.findViewById<RadioButton>(selectionId)

            when(selection.tag) {
                "7100" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 7100", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "7100T" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 7100T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "7101E" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 7101E", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "7101TE" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 7101TE", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "7300" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 7300", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "7300T" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 7300T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "7320" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 7320", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "7350K" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 7350K", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
            }

            /*Snackbar.make(view, "Selected Intel Core i3 " + selection.tag, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show()*/

            val sbTerm: StringBuilder = StringBuilder()
            sbTerm
                .append("CPU ")
                .append("Intel ")
                .append("i3 ")
                .append(selection.tag)

            val term: String = sbTerm.toString()
            // AppSyncClient.sendClientRequest(context, term)

            val action = SearchWizCpuIntelI37000FragmentDirections
                .actionSearchWizCpuIntelI37000FragmentToSearchWizResultsFragment(term)
            NavHostFragment.findNavController(this@SearchWizCpuIntelI37000Fragment)
                .navigate(action)
        }
    }
}

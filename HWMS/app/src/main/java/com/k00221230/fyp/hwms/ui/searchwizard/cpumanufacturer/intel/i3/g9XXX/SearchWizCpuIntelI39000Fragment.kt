package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i3.g9XXX

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.k00221230.fyp.hwms.AppSyncClient

import com.k00221230.fyp.hwms.R
import com.k00221230.fyp.hwms.ui.searchwizard.SearchWizViewModel

class SearchWizCpuIntelI39000Fragment : Fragment() {

    private val args: SearchWizCpuIntelI39000FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI39000ViewModel: SearchWizViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel_i3_9000, container, false)
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
                "9100" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 9100", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "9100F" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 9100F", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "9100T" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 9100T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "9300" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 9300", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "9300T" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 9300T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "9320" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 9320", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "9350K" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 9350K", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "9350KF" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 9350KF", Snackbar.LENGTH_SHORT)
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
            AppSyncClient.SendClientRequest(context, term)

            //findNavController().navigate(R.id.action_SearchWizCpuManuIntelFragment_to_SearchWizHomeFragment)
        }
    }
}

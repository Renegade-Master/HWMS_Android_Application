package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i3.g6XXX

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

class SearchWizCpuIntelI36000Fragment : Fragment() {

    private val args: SearchWizCpuIntelI36000FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI36000ViewModel: SearchWizViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel_i3_6000, container, false)
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
                "6098P" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 6098P", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "6100" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 6100", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "6100T" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 6100T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "6300" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 6300", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "6300T" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 6300T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
                "6320" -> {
                    /*Snackbar.make(view, "Selected Intel Core i3 6320", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/
                }
            }

            Snackbar.make(view, "Selected Intel Core i3 " + selection.tag, Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show()

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

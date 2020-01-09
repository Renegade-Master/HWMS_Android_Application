package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i3.g4XXX

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

class SearchWizCpuIntelI34000Fragment : Fragment() {

    private val args: SearchWizCpuIntelI34000FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI34000ViewModel: SearchWizViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel_i3_4000, container, false)
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
                "4130" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4130", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4130T" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4130T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4150" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4150", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4150T" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4150T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4160" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4160", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4160T" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4160T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4170" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4170", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4170T" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4170T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4330" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4330", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4330T" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4330T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4340" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4340", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4350" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4350", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4350T" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4350T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4360" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4360", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4360T" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4360T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4370" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4370", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "4370T" -> {
                    Snackbar.make(view, "Selected Intel Core i3 4370T", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
            }

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

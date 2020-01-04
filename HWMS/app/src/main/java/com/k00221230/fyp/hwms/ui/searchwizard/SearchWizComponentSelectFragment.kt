package com.k00221230.fyp.hwms.ui.searchwizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.core.view.get

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.k00221230.fyp.hwms.R

class SearchWizComponentSelectFragment : Fragment() {

    private val args: SearchWizComponentSelectFragmentArgs by navArgs()

    private lateinit var searchWizComponentSelectViewModel: SearchWizViewModel

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
                getString(R.string.hello_searchwiz_component, args.myArg)

        view.findViewById<Button>(R.id.button_searchwiz_next).setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.radiogrp_searchwiz_selector)
            val selectionId = radioGroup.checkedRadioButtonId
            val selection = radioGroup.findViewById<RadioButton>(selectionId).tag

            when(selection) {
                "CASE" -> println("Selected Case")
                "CPU" -> println("Selected CPU")
                "GPU" -> println("Selected GPU")
                "MEMORY" -> println("Selected Memory/RAM")
                "MOTHERBOARD" -> println("Selected Motherboard")
                "POWERSUPPLY" -> println("Selected Power Supply")
                "STORAGE" -> println("Selected Storage")
            }

            findNavController().navigate(R.id.action_SearchWizComponentSelectFragment_to_SearchWizHomeFragment)
        }
    }
}

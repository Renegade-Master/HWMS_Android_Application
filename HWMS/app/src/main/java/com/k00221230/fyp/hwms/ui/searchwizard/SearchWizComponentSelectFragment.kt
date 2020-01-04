package com.k00221230.fyp.hwms.ui.searchwizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar

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
            val selection = radioGroup.findViewById<RadioButton>(selectionId)

            when(selection.tag) {
                "CASE" -> {
                    Snackbar.make(view, "Selected Case", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "CPU" -> {
                    Snackbar.make(view, "Selected CPU", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                    val action = SearchWizComponentSelectFragmentDirections
                        .actionSearchWizComponentSelectFragmentToSearchWizComponentSelectCpuFragment("From search step COMPONENT_SELECT")
                    NavHostFragment.findNavController(this@SearchWizComponentSelectFragment)
                        .navigate(action)

                }
                "GPU" ->{
                    Snackbar.make(view, "Selected GPU", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "MEMORY" ->{
                    Snackbar.make(view, "Selected Memory/RAM", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "MOTHERBOARD" ->{
                    Snackbar.make(view, "Selected Motherboard", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "POWERSUPPLY" ->{
                    Snackbar.make(view, "Selected Power Supply", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
                "STORAGE" ->{
                    Snackbar.make(view, "Selected Storage", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()
                }
            }

            //findNavController().navigate(R.id.action_SearchWizComponentSelectFragment_to_SearchWizHomeFragment)
        }
    }
}

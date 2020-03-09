package com.k00221230.fyp.hwms.ui.searchwizard.cpumanufacturer.intel.i7

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

class SearchWizCpuIntelI7Fragment : Fragment() {

    private val args: SearchWizCpuIntelI7FragmentArgs by navArgs()

    private lateinit var SearchWizCpuIntelI7ViewModel: SearchWizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_cpu_intel_i7, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textview_searchwiz_selectcomponent).text =
            getString(R.string.hello_searchwiz_cpu_intel_generation, args.myArg)

        view.findViewById<Button>(R.id.button_searchwiz_next).setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.radiogrp_searchwiz_selector)
            val selectionId = radioGroup.checkedRadioButtonId
            val selection = radioGroup.findViewById<RadioButton>(selectionId)

            when (selection.tag) {
                "4000" -> {
                    /*Snackbar.make(view, "Selected 4XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI7FragmentDirections
                        .actionSearchWizCpuIntelI7FragmentToSearchWizCpuIntelI74000Fragment("From search step CPU_INTEL_I7")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI7Fragment)
                        .navigate(action)
                }
                "5000" -> {
                    /*Snackbar.make(view, "Selected 5XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI7FragmentDirections
                        .actionSearchWizCpuIntelI7FragmentToSearchWizCpuIntelI75000Fragment("From search step CPU_INTEL_I7")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI7Fragment)
                        .navigate(action)
                }
                "6000" -> {
                    /*Snackbar.make(view, "Selected 6XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI7FragmentDirections
                        .actionSearchWizCpuIntelI7FragmentToSearchWizCpuIntelI76000Fragment("From search step CPU_INTEL_I7")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI7Fragment)
                        .navigate(action)
                }
                "7000" -> {
                    /*Snackbar.make(view, "Selected 7XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI7FragmentDirections
                        .actionSearchWizCpuIntelI7FragmentToSearchWizCpuIntelI77000Fragment("From search step CPU_INTEL_I7")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI7Fragment)
                        .navigate(action)
                }
                "8000" -> {
                    /*Snackbar.make(view, "Selected 8XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI7FragmentDirections
                        .actionSearchWizCpuIntelI7FragmentToSearchWizCpuIntelI78000Fragment("From search step CPU_INTEL_I7")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI7Fragment)
                        .navigate(action)
                }
                "9000" -> {
                    /*Snackbar.make(view, "Selected 9XXX", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show()*/

                    val action = SearchWizCpuIntelI7FragmentDirections
                        .actionSearchWizCpuIntelI7FragmentToSearchWizCpuIntelI79000Fragment("From search step CPU_INTEL_I7")
                    NavHostFragment.findNavController(this@SearchWizCpuIntelI7Fragment)
                        .navigate(action)
                }
            }
        }
    }
}

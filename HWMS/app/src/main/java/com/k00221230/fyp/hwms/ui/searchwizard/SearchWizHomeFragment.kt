package com.k00221230.fyp.hwms.ui.searchwizard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs

import com.k00221230.fyp.hwms.R

class SearchWizHomeFragment : Fragment() {

    private val args: SearchWizHomeFragmentArgs by navArgs()

    private lateinit var searchWizHomeViewModel: SearchWizViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textview_searchwiz_selectcomponent).text =
                getString(R.string.hello_searchwiz_home, args.myArg)

        view.findViewById<Button>(R.id.button_searchwiz_next).setOnClickListener {
            val action = SearchWizHomeFragmentDirections
                .actionSearchWizHomeFragmentToSearchWizComponentSelectFragment("From search step COMPONENT_SELECT")
            NavHostFragment.findNavController(this@SearchWizHomeFragment)
                .navigate(action)
        }
    }
}

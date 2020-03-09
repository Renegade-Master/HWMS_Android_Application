package com.k00221230.fyp.hwms.ui.searchhistory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.k00221230.fyp.hwms.R

class SearchHistoryFragment : Fragment() {

    private lateinit var searchHistoryViewModel: SearchHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchHistoryViewModel =
            ViewModelProviders.of(this).get(SearchHistoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_searchhistory, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        searchHistoryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}

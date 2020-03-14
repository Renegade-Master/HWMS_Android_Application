/*
 * Copyright (c) 2020 RenegadeMaster Inc. - All Right Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * The contents of this file are proprietary and confidential.
 * Written by Ciaran Bent <ciaran.bent@protonmail.ch>, March 2020
 */

package com.k00221230.fyp.hwms.ui.searchwizard


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.k00221230.fyp.hwms.AppSyncClient
import com.k00221230.fyp.hwms.AppSyncClient.measureTimeMillis
import com.k00221230.fyp.hwms.R

class SearchWizResultsFragment : Fragment() {

    private val searchTermArgs: SearchWizResultsFragmentArgs by navArgs()

    private lateinit var SearchWizResultsViewModel: SearchWizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Send a request to the Database
        val searchTerm: String = searchTermArgs.searchTerm

        // Comment this line to disable DB Connection safely
        val reqId: String =
            AppSyncClient.sendClientRequest(context, searchTerm)

        view.findViewById<TextView>(R.id.textview_searchwiz_results).text =
            getString(R.string.menu_searchwiz_results)

        // The TableLayout for the results
        val tableLayout = view.findViewById<TableLayout>(R.id.searchwiz_results_tablelayout)
        var response: List<List<String>> = ArrayList<List<String>>()

        measureTimeMillis({ time ->
            Log.i(
                "ExecutionTime",
                "Retrieving Data took $time milliseconds"
            )
        }) {
            // ToDo: Wait for a reply to come back
            response =
                AppSyncClient.retrieveSearchResults(context, reqId)
        }
        println("Result Page Response: \n$response")

        // ToDo: Populate the table with the results
        var nextItem: TableRow
        var itemName: TextView
        var itemPrice: TextView
        var itemLink: Button
        val dataRowLayout: TableRow.LayoutParams = TableRow.LayoutParams()

        dataRowLayout.weight = 1.0f

        // This for loop generates a new TableRow for every item returned by the call to the
        // 'retrieveSearchResults' function.
        for (i in 0 until response[1].count()) {
            nextItem = TableRow(context)
            nextItem.weightSum = 3.0f

            itemName = TextView(context)
            itemPrice = TextView(context)
            itemLink = Button(context)

            itemName.layoutParams = dataRowLayout
            itemPrice.layoutParams = dataRowLayout
            itemLink.layoutParams = dataRowLayout

            itemName.text =
                if (response[0][i].count() < 25) response[0][i] else response[0][i].substring(0, 25)
            itemPrice.text = response[1][i]
            itemLink.text = "Go"
            itemLink.setOnClickListener {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(response[2][i])
                startActivity(openURL)
            }

            nextItem.addView(itemName)
            nextItem.addView(itemPrice)
            nextItem.addView(itemLink)

            tableLayout.addView(nextItem)
        }

        // ToDo: Navigate to the purchase page if the user presses the LinkButton
    }
}

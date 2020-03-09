package com.k00221230.fyp.hwms.ui.searchwizard


import android.os.Bundle
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
        AppSyncClient.sendClientRequest(context, searchTerm)

        view.findViewById<TextView>(R.id.textview_searchwiz_results).text =
            getString(R.string.menu_searchwiz_results)

        // The TableLayout for the results
        val tableLayout = view.findViewById<TableLayout>(R.id.searchwiz_results_tablelayout)

        // ToDo: Wait for a reply to come back

        // ToDo: Populate the table with the results
        var nextItem: TableRow
        var itemName: TextView
        var itemPrice: TextView
        var itemLink: Button
        val dataRowLayout : TableRow.LayoutParams = TableRow.LayoutParams()

        dataRowLayout.weight = 1.0f

        for (i in 1..20) {
            nextItem = TableRow(context)
            nextItem.weightSum = 3.0f

            itemName = TextView(context)
            itemPrice = TextView(context)
            itemLink = Button(context)

            itemName.layoutParams = dataRowLayout
            itemPrice.layoutParams = dataRowLayout
            itemLink.layoutParams = dataRowLayout

            itemName.text = "New Item $i"
            itemPrice.text = "€123.45"
            itemLink.text = "GoToItem"

            nextItem.addView(itemName)
            nextItem.addView(itemPrice)
            nextItem.addView(itemLink)

            tableLayout.addView(nextItem)
        }

        // ToDo: Navigate to the purchase page if the user presses the LinkButton
    }
}

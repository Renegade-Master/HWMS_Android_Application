package com.k00221230.fyp.hwms.ui.searchwizard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.k00221230.fyp.hwms.AppSyncClient
import com.k00221230.fyp.hwms.R

class SearchWizResultsFragment : Fragment() {

    private val searchTermArgs: SearchWizResultsFragmentArgs by navArgs()

    private lateinit var searchWizResultsViewModel: SearchWizViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_searchwiz_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Send a request to the Database
        val searchTerm: String = searchTermArgs.searchTerm
        AppSyncClient.sendClientRequest(context, searchTerm)

        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.textview_searchwiz_results).text =
            getString(R.string.menu_searchwiz_results)

        // The TableLayout for the results
        val tableLayout = view.findViewById<TableLayout>(R.id.searchwiz_results_tablelayout)

        // ToDo: Wait for a reply to come back

        // ToDo: Populate the table with the results
        //val nextItem: TableRow = TableRow

        // ToDo: Navigate to the purchase page if the user presses the LinkButton
    }
}

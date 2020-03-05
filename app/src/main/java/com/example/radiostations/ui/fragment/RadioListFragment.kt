package com.example.radiostations.ui.fragment

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import androidx.core.view.isEmpty
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.radiostations.R
import com.example.radiostations.adapter.RadioAdapter
import com.example.radiostations.databinding.FragmentRadioListBinding
import com.example.radiostations.model.BaseModel
import com.example.radiostations.ui.activity.MainActivity
import com.example.radiostations.utils.*
import com.example.radiostations.utils.Constants.DIALOG_BAD_RESPONSE_TITLE
import com.example.radiostations.utils.Constants.DIALOG_INVALID_INPUT_MESSAGE
import com.example.radiostations.utils.Constants.DIALOG_INVALID_INPUT_TITLE
import com.example.radiostations.utils.Constants.DIALOG_SEARCH_EMPTY_RESULT_MESSAGE
import com.example.radiostations.utils.Constants.DIALOG_SEARCH_EMPTY_RESULT_TITLE
import com.example.radiostations.utils.Constants.DIALOG_SEARCH_MESSAGE
import com.example.radiostations.utils.Constants.DIALOG_SEARCH_TITLE
import com.example.radiostations.utils.Constants.DIALOG_SERVER_ERROR_MESSAGE
import com.example.radiostations.utils.Constants.DIALOG_SERVER_ERROR_TITLE
import com.example.radiostations.utils.Constants.NO_INTERNET_CONNECTION
import com.example.radiostations.viewmodel.RadioViewModel
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class RadioListFragment : DaggerFragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var radioAdapter: RadioAdapter

    private lateinit var radioViewModel: RadioViewModel
    private lateinit var radioListBinding: FragmentRadioListBinding
    private var flagSearch = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        actionBarSettings()
        radioListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_radio_list, container, false)
        return radioListBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = radioListBinding.recyclerview
        progressBar = radioListBinding.progressBar
        radioViewModel =
            ViewModelProviders.of(activity!!, viewModelFactory).get(RadioViewModel::class.java)
        radioViewModel.getRadios().observe(viewLifecycleOwner, Observer(::handleResponse))

        createRadioAdapter()
        checkInternetConnection()
    }

    private fun handleResponse(apiResponse: ApiResponse) {

        when (apiResponse.status) {

            Status.LOADING -> {
                progressBar.visibility = VISIBLE
            }

            Status.SUCCESS -> {
                progressBar.visibility = INVISIBLE
                doOnSuccessResponse(apiResponse.data)
            }

            Status.ERROR -> {
                progressBar.visibility = INVISIBLE
                val error = apiResponse.error?.message
                showAlertInfo(Constants.DIALOG_SERVER_ERROR_TITLE, "$DIALOG_SERVER_ERROR_MESSAGE$error")
            }

        }

    }

    private fun doOnSuccessResponse(response: BaseModel?) {
        if (response != null) {
            if(response.items.isEmpty())
                reloadDataFromServer()
            else
              radioAdapter.setListRadios(response)
        } else {
            showAlertInfo(DIALOG_BAD_RESPONSE_TITLE, DIALOG_INVALID_INPUT_MESSAGE)
        }
    }

    private fun reloadDataFromServer(){
        if(flagSearch)
            showAlertInfo(DIALOG_SEARCH_EMPTY_RESULT_TITLE, DIALOG_SEARCH_EMPTY_RESULT_MESSAGE)
        radioViewModel.callRadioRx()

    }

    private fun createRadioAdapter() {

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = radioAdapter
    }

    private fun actionBarSettings() {
        (activity as MainActivity).getSupportActionBar()?.setTitle(
            Constants.ACTION_BAR_MAIN
        )
        (activity as MainActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(false)
    }

    private fun checkInternetConnection() {

        if (NetworkConnection.hasConnection(activity!!.applicationContext))
            radioViewModel.callRadioRx()
        else {
            ToastMessages.showToast(NO_INTERNET_CONNECTION, activity!!)
        }
    }

    private fun checkValidInput(query: String?) {

        if(CheckInput.isAlpha(query)){

            flagSearch = true
            radioViewModel.callRadioByCityRx(query)

        }
        else{

           if(CheckInput.canBeCoordinate(query)){
               val coordinates: List<String> = query!!.split(",").map { it -> it.trim() }
               flagSearch = true
               radioViewModel.callRadioByCcoordinatesRx(coordinates[0].toFloatOrNull(), coordinates[1].toFloatOrNull())
           }
            else
               showAlertInfo(DIALOG_INVALID_INPUT_TITLE, DIALOG_INVALID_INPUT_MESSAGE)

        }

    }

    private fun showAlertInfo(title: String,message: String) {

        Dialogs.createAlertDialog(requireContext(),title, message)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
        val manager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView

        searchView.setSearchableInfo(manager.getSearchableInfo(activity!!.componentName))
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("", false)
                searchItem.collapseActionView()
                checkValidInput(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_info -> {
                showAlertInfo(DIALOG_SEARCH_TITLE, DIALOG_SEARCH_MESSAGE)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

}

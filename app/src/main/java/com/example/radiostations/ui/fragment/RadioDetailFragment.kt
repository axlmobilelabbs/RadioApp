package com.example.radiostations.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.radiostations.R
import com.example.radiostations.databinding.FragmentRadioDetailBinding
import com.example.radiostations.ui.activity.MainActivity
import com.example.radiostations.utils.Constants
import com.example.radiostations.utils.Constants.BAND_KEY
import com.example.radiostations.utils.Constants.FREQUENCY_KEY
import com.example.radiostations.utils.Constants.MARKET_CITY_KEY
import com.example.radiostations.utils.Constants.NAME_KEY
import com.example.radiostations.utils.Constants.TAGLINE_KEY


class RadioDetailFragment : Fragment() {


    private lateinit var radioDetailBinding: FragmentRadioDetailBinding
    private var name: String? = ""
    private var frequency: String? = ""
    private var marketCity: String? = ""
    private var band: String? = ""
    private var tagLine: String? = ""


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        name = arguments?.getString(NAME_KEY)
        frequency = arguments?.getString(FREQUENCY_KEY)
        marketCity = arguments?.getString(MARKET_CITY_KEY)
        band = arguments?.getString(BAND_KEY)
        tagLine = arguments?.getString(TAGLINE_KEY)
        setDataOnView()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        radioDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_radio_detail, container, false)
        actionBarSettings()
        return radioDetailBinding.root
    }

    private fun setDataOnView() {

        radioDetailBinding.apply {

            radioDetailBinding.tvName.text = name
            radioDetailBinding.tvFrequency.text = frequency
            radioDetailBinding.tvCity.text = marketCity
            radioDetailBinding.tvBand.text = band
            radioDetailBinding.tvTagline.text = tagLine
        }
    }

    private fun actionBarSettings(){
        (activity as MainActivity).getSupportActionBar()?.setTitle(
            Constants.ACTION_BAR_DETAIL
        )
        (activity as MainActivity).getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
    }
}

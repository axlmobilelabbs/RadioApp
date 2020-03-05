package com.example.radiostations.utils

object Constants {

    const val BASE_URL: String = "https://station.api.npr.org/"
    const val AUTHORIZATION_HEADER = "Authorization: Bearer cbc821f94cf15dd594fedd9da479299006a75560d4f5ee290d2d3e3e434b7a4abf2f44fdde14cdae"

    const val NO_INTERNET_CONNECTION: String = "There is not access to network, check yor connection and try again later"
    const val SERVER_ERROR_RESPONSE: String = "Server response: "
    const val ONLY_LETTERS_ALLOWED: String = "Inputs other than letters are not allowed, try again "

    const val LOGO_KEY = "logo"
    const val NAME_KEY = "name"
    const val FREQUENCY_KEY = "frequency"
    const val MARKET_CITY_KEY = "marketCity"
    const val BAND_KEY = "band"
    const val TAGLINE_KEY = "tagline"


    const val ACTION_BAR_MAIN = "Radio Stations"
    const val ACTION_BAR_DETAIL = "Detail"

    const val DIALOG_OK = "OK"
    const val DIALOG_SEARCH_TITLE = "Search by city or coordinates"
    const val DIALOG_INVALID_INPUT_TITLE = "Invalid input"
    const val DIALOG_INVALID_INPUT_MESSAGE = "We ca not perform the research with your entry, try again"
    const val DIALOG_SEARCH_MESSAGE = "Search stations in a city by typing the name of the city e.g Dallas. You can search by typing the coordinates as well " +
            "e.g 32.784144,-96.7981297"
    const val DIALOG_SERVER_ERROR_TITLE = "Server Error"
    const val DIALOG_SERVER_ERROR_MESSAGE = "The server responded with the error "
    const val DIALOG_BAD_RESPONSE_MESSAGE: String = "Something went wrong while we was trying to get your data, try gain later "
    const val DIALOG_BAD_RESPONSE_TITLE: String = "Parsing error "
    const val DIALOG_SEARCH_EMPTY_RESULT_TITLE = "No radios found"
    const val DIALOG_SEARCH_EMPTY_RESULT_MESSAGE = "We could not found any radio with your entry, try again"
}
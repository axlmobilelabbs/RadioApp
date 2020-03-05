package com.example.radiostations.repository

import com.example.radiostations.endpoint.ApiCallInterface
import com.example.radiostations.model.BaseModel


import io.reactivex.Observable


class Repository(private val apiCallInterface: ApiCallInterface) {

    fun getRadios(): Observable<BaseModel> {
        return apiCallInterface.getRadios()
    }

    fun getRadiosByCity(city:String?): Observable<BaseModel> {
        return apiCallInterface.getRadiosByCity(city)
    }

    fun getRadiosByCoordinates(lat:Float?, lon:Float?): Observable<BaseModel> {
        return apiCallInterface.getRadiosByCoordinates(lat, lon)
    }

}

package com.example.radiostations.endpoint

import com.example.radiostations.model.BaseModel
import com.example.radiostations.utils.Constants.AUTHORIZATION_HEADER
import io.reactivex.Observable
import retrofit2.http.*
import retrofit2.http.GET


interface ApiCallInterface {


    @Headers(
        AUTHORIZATION_HEADER
    )
    @GET("/v3/stations")
    fun getRadios(): Observable<BaseModel>

    @Headers(
        AUTHORIZATION_HEADER
    )
    @GET("/v3/stations")
    fun getRadiosByCity(@Query("city")city: String?): Observable<BaseModel>

    @Headers(
        AUTHORIZATION_HEADER
    )
    @GET("/v3/stations")
    fun getRadiosByCoordinates(@Query("lat")lat:Float?,@Query("lon") lon:Float?): Observable<BaseModel>



}

package com.example.radiostations.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.radiostations.repository.Repository
import com.example.radiostations.utils.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class RadioViewModel(private val repository: Repository) : ViewModel() {

    private val disposables = CompositeDisposable()
    private val responseLiveData = MutableLiveData<ApiResponse>()


    fun getRadios(): MutableLiveData<ApiResponse> {
        return responseLiveData
    }

    fun callRadioRx() {

        disposables.add(repository.getRadios()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { d -> responseLiveData.setValue(ApiResponse.loading()) }
            .subscribe(
                { result -> responseLiveData.setValue(ApiResponse.success(result)) },
                { throwable -> responseLiveData.setValue(ApiResponse.error(throwable)) }
            ))

    }

    fun callRadioByCityRx(city:String?) {

        disposables.add(repository.getRadiosByCity(city)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { d -> responseLiveData.setValue(ApiResponse.loading()) }
            .subscribe(
                { result -> responseLiveData.setValue(ApiResponse.success(result)) },
                { throwable -> responseLiveData.setValue(ApiResponse.error(throwable)) }
            ))

    }

    fun callRadioByCcoordinatesRx(lat:Float?, lon:Float?) {

        disposables.add(repository.getRadiosByCoordinates(lat,lon)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { d -> responseLiveData.setValue(ApiResponse.loading()) }
            .subscribe(
                { result -> responseLiveData.setValue(ApiResponse.success(result)) },
                { throwable -> responseLiveData.setValue(ApiResponse.error(throwable)) }
            ))

    }

    override fun onCleared() {
        disposables.clear()
    }
}

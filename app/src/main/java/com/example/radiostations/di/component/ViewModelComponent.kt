package com.example.radiostations.di.component

import com.example.radiostations.di.module.ViewModelModule
import com.example.radiostations.viewmodel.RadioViewModel

import dagger.Component

@Component( modules = [ViewModelModule::class])
interface ViewModelComponent {

    fun inject( mainViewModel: RadioViewModel)

}


package com.example.radiostations.di.module


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.radiostations.viewmodel.RadioViewModel
import com.example.radiostations.factory.ViewModelFactory
import com.example.radiostations.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey( RadioViewModel::class )
    abstract fun mainViewModel( mainViewModel: RadioViewModel ): ViewModel

    @Binds
    abstract fun viewModelFactory( factory: ViewModelFactory):
            ViewModelProvider.Factory

}
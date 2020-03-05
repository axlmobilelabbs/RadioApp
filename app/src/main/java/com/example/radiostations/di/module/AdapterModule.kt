package com.example.radiostations.di.module

import com.example.radiostations.adapter.RadioAdapter
import dagger.Module
import dagger.Provides

@Module
class AdapterModule {

    @Provides
    internal fun provideRadioAdapter(): RadioAdapter {
        return RadioAdapter()
    }



}
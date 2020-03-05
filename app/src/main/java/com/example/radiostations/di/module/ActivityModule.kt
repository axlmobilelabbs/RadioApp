package com.example.radiostations.di.module

import com.example.radiostations.adapter.RadioAdapter
import com.example.radiostations.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [FragmentModule::class, AdapterModule::class])
    abstract fun contributeMainActivity(): MainActivity
    abstract fun contributeRadioAdapter(): RadioAdapter
}
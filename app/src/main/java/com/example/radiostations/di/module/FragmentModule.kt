package com.example.radiostations.di.module

import com.example.radiostations.ui.fragment.RadioDetailFragment
import com.example.radiostations.ui.fragment.RadioListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    internal abstract fun provideRadioListFragment(): RadioListFragment

    @ContributesAndroidInjector
    internal abstract fun provideRadioDetailFragment(): RadioDetailFragment


}
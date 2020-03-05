package com.example.radiostations.di.component

import com.example.radiostations.MyApplication
import com.example.radiostations.di.module.ActivityModule
import com.example.radiostations.di.module.MainModule

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityModule::class, MainModule::class])
interface AppComponent{
    fun inject(myApplication: MyApplication)
}
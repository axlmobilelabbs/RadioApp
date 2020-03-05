package com.example.radiostations.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val applicationContext: Context) {

    @Provides fun provideApplicationContext(): Context = applicationContext
}
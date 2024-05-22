 package com.example.ze

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class VerseVault : Application() {
    companion object {
        lateinit var instance: VerseVault private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
package com.example.ze.fragmentfactory


import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
fun interface VVFragmentFactoryEntryPoint {
    fun getFragmentFactory(): VVFragmentFactory
}
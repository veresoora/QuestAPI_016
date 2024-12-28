package com.nadia.pertemuan10

import android.app.Application
import com.nadia.pertemuan10.di.AppContainer
import com.nadia.pertemuan10.di.MahasiswaContainer

class MahasiswaApplications:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=MahasiswaContainer()
    }
}
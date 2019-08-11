package com.zabochen.fugaapp

import android.app.Application
import com.zabochen.fugaapp.di.*

class MainApp : Application() {

    companion object {
        private lateinit var appComponent: AppComponent
        fun appComponent() = appComponent

    }

    override fun onCreate() {
        super.onCreate()
        setDagger()
    }

    private fun setDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
    }
}
package lolka.example.PsyPath.App

import android.app.Application

import lolka.example.PsyPath.di.AppComponent
import lolka.example.PsyPath.di.AppModule
import lolka.example.PsyPath.di.DaggerAppComponent


class App:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = lolka.example.PsyPath.di.DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()

    }

}
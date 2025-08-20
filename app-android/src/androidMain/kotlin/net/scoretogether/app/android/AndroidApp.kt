package net.scoretogether.app.android

import android.app.Application
import net.scoretogether.shared.di.initKoin
import org.koin.dsl.module

private val platformModule = module { }

class AndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(platformModule)
    }
}

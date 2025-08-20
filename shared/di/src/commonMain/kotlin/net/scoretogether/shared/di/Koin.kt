package net.scoretogether.shared.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Koin modules for shared code.
 */
val networkModule = module { }
val dbModule = module { }
val repositoryModule = module { }
val useCaseModule = module { }

/**
 * Initialize Koin with shared modules and [platformModules].
 */
fun initKoin(vararg platformModules: Module) =
    startKoin {
        modules(
            networkModule,
            dbModule,
            repositoryModule,
            useCaseModule,
            *platformModules,
        )
    }

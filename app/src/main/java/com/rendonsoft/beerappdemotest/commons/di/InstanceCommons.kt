package com.rendonsoft.beerappdemotest.commons.di

import androidx.room.Room
import com.rendonsoft.beerappdemotest.commons.database.database.AppDataBase
import com.rendonsoft.beerappdemotest.commons.network.Network
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val instanceCommons = module {

    single {
        Network()
    }

    single {
        Room.databaseBuilder(
                androidContext(), AppDataBase::class.java, "DATABASE_BEERS"//THIS NAME WOULD BE WITHIN CONSTANTS FILE
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build().beerDao()
    }
}
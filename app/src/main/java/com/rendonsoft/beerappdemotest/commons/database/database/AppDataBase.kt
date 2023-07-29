package com.rendonsoft.beerappdemotest.commons.database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rendonsoft.beerappdemotest.commons.database.dao.BeerDao
import com.rendonsoft.beerappdemotest.commons.database.models.BeerDto

/**
 * AppDataBase
 */
@Database(entities = [BeerDto::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun beerDao(): BeerDao
}
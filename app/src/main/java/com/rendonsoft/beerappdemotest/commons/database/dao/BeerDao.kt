package com.rendonsoft.beerappdemotest.commons.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.rendonsoft.beerappdemotest.commons.database.models.BeerDto

/**
 * BeerDao
 */
@Dao
interface BeerDao {
    @Query("SELECT * FROM Beer WHERE page IN (:page)")
    fun getBeersByPage(page : Int): List<BeerDto>

    @Query("SELECT * FROM Beer WHERE id IN (:id)")
    fun getBeersById(id: Int): BeerDto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBeer(vararg users: BeerDto)

    @Query("DELETE FROM Beer")
    fun deleteBeers()
}
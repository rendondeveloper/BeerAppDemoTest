package com.rendonsoft.beerappdemotest.commons.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * BeerDto
 */
@Entity(tableName = "Beer")
data class BeerDto(
        @PrimaryKey()
        @ColumnInfo val id: Int,
        @ColumnInfo val page: Int,
        @ColumnInfo val name: String,
        @ColumnInfo val tagline: String,
        @ColumnInfo val first_brewed: String,
        @ColumnInfo val description: String,
        @ColumnInfo val image_url: String,
        @ColumnInfo val brewers_tips: String,
        @ColumnInfo val contributed_by: String,
        @ColumnInfo val attenuation_level: Int
)

package com.rendonsoft.beerappdemotest.feature.home.data.mapper

import com.rendonsoft.beerappdemotest.commons.database.models.BeerDto
import com.rendonsoft.beerappdemotest.commons.model.mapper.Mapper
import com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.config.response.Beer

class BeerToBeerDtoMapper : Mapper<Beer, BeerDto> {

    override fun map(input: Beer): BeerDto {
        return BeerDto(
                id = input.id,
                page = input.page ?: 0,
                image_url = input.image_url ?: "",
                name = input.name ?: "",
                tagline = input.tagline ?: "",
                first_brewed = input.first_brewed ?: "",
                attenuation_level = input.attenuation_level ?: 0,
                brewers_tips = input.brewers_tips ?: "",
                description = input.description ?: "",
                contributed_by = input.contributed_by ?: "",
        )
    }
}

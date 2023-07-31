package com.rendonsoft.beerappdemotest.feature.detail.framework.implementation.data.dataSource.mapper

import com.rendonsoft.beerappdemotest.commons.database.models.BeerDto
import com.rendonsoft.beerappdemotest.commons.model.mapper.Mapper
import com.rendonsoft.beerappdemotest.feature.detail.domain.BeerDetailModel

class BeerDtoToBeerDetailModelMapper : Mapper<BeerDto, BeerDetailModel> {

    override fun map(input: BeerDto): BeerDetailModel {
        return BeerDetailModel(
                id = input.id,
                imageUrl = input.image_url,
                name = input.name,
                description = input.description,
                tagLine = input.tagline,
                firstBrewed = input.first_brewed,
                contributedBy = input.contributed_by,
                attenuationLevel = input.attenuation_level,
        )
    }
}

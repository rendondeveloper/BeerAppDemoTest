package com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.dataSource.local.mapper

import com.rendonsoft.beerappdemotest.commons.database.models.BeerDto
import com.rendonsoft.beerappdemotest.commons.model.mapper.Mapper
import com.rendonsoft.beerappdemotest.feature.home.domain.model.BeerModel

class BeerDtoToBeerModelMapper : Mapper<BeerDto, BeerModel> {

    override fun map(input: BeerDto): BeerModel {
        return BeerModel(
                id = input.id,
                imageUrl = input.image_url,
                name = input.name,
                tagLine = input.tagline,
                firstBrewed = input.first_brewed,
                contributedBy = input.contributed_by,
        )
    }
}

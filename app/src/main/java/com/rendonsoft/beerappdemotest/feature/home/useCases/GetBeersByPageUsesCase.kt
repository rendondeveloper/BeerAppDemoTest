package com.rendonsoft.beerappdemotest.feature.home.useCasesimport com.rendonsoft.beerappdemotest.feature.home.data.HomeBeerRepositoryimport com.rendonsoft.beerappdemotest.feature.home.domain.model.BeerModelclass GetBeersByPageUsesCase(        private val homeBeerRepository: HomeBeerRepository) {    suspend operator fun invoke(page: Int) : List<BeerModel> {        return homeBeerRepository.getBeerByPage(page)    }}
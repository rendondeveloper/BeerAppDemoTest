package com.rendonsoft.beerappdemotest.feature.detail.framework.di

import androidx.lifecycle.createSavedStateHandle
import com.rendonsoft.beerappdemotest.feature.detail.data.DetailBeerRepository
import com.rendonsoft.beerappdemotest.feature.detail.data.dataSource.DetailBeerDataSource
import com.rendonsoft.beerappdemotest.feature.detail.framework.implementation.data.dataSource.DetailBeerLocalDataSourceImpl
import com.rendonsoft.beerappdemotest.feature.detail.framework.implementation.data.dataSource.mapper.BeerDtoToBeerDetailModelMapper
import com.rendonsoft.beerappdemotest.feature.detail.framework.presentation.viewModel.DetailViewModel
import com.rendonsoft.beerappdemotest.feature.detail.usesCase.GetBeerByIdUsesCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailModule = module {

    factory {
        BeerDtoToBeerDetailModelMapper()
    }

    factory <DetailBeerDataSource> {
        DetailBeerLocalDataSourceImpl(get(), get())
    }

    factory {
        DetailBeerRepository(get())
    }

    factory {
        GetBeerByIdUsesCase(get())
    }

    viewModel {
        DetailViewModel(get() , get())
    }
}
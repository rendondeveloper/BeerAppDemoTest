package com.rendonsoft.beerappdemotest.feature.home.framework.di

import com.rendonsoft.beerappdemotest.feature.home.data.HomeBeerRepository
import com.rendonsoft.beerappdemotest.feature.home.data.dataSource.HomeBeerLocalDataSource
import com.rendonsoft.beerappdemotest.feature.home.data.dataSource.HomeBeerRemoteDataSource
import com.rendonsoft.beerappdemotest.feature.home.data.mapper.BeerToBeerDtoMapper
import com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.dataSource.local.HomeBeerLocalDataSourceImpl
import com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.dataSource.local.mapper.BeerDtoToBeerModelMapper
import com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.dataSource.remote.HomeBeerRemoteDataSourceImpl
import com.rendonsoft.beerappdemotest.feature.home.framework.presentation.viewModel.HomeViewModel
import com.rendonsoft.beerappdemotest.feature.home.useCases.GetBeersByPageUsesCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {

    factory {
        BeerDtoToBeerModelMapper()
    }

    factory<HomeBeerLocalDataSource> {
        HomeBeerLocalDataSourceImpl(
                get(),
                get(),
        )
    }

    factory<HomeBeerRemoteDataSource> {
        HomeBeerRemoteDataSourceImpl(
                get(),
        )
    }

    factory {
        BeerToBeerDtoMapper()
    }

    factory {
        HomeBeerRepository(get(), get(), get())
    }

    factory {
        GetBeersByPageUsesCase(get())
    }

    viewModel {
        HomeViewModel(get())
    }
}
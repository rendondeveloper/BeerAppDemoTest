package com.rendonsoft.beerappdemotest.feature.home.dataimport androidx.paging.PagingSourceimport androidx.paging.PagingStateimport com.rendonsoft.beerappdemotest.feature.home.data.dataSource.HomeBeerLocalDataSourceimport com.rendonsoft.beerappdemotest.feature.home.data.dataSource.HomeBeerRemoteDataSourceimport com.rendonsoft.beerappdemotest.feature.home.data.mapper.BeerToBeerDtoMapperimport com.rendonsoft.beerappdemotest.feature.home.domain.model.BeerModelclass HomeBeerRepository(        private val homeBeerLocalDataSource: HomeBeerLocalDataSource,        private val homeBeerRemoteDataSource: HomeBeerRemoteDataSource,        private val beerToBeerDtoMapper: BeerToBeerDtoMapper) : PagingSource<Int, BeerModel>(){    override fun getRefreshKey(state: PagingState<Int, BeerModel>): Int? {        return state.anchorPosition?.let { anchorPosition ->            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)                    ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)        }    }    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BeerModel> {        return try {            val page = params.key ?: 1            val pageSize = params.loadSize            val beersLocal = homeBeerLocalDataSource.getBeersByPage(page)            val listBeers = beersLocal.ifEmpty {                val beers = homeBeerRemoteDataSource.getBeerByPage(page, pageSize)                val list = beers.map { beerToBeerDtoMapper.map(it) }.toTypedArray()                homeBeerLocalDataSource.saveBeers(beers = list)                homeBeerLocalDataSource.getBeersByPage(page)            }            LoadResult.Page(                    data = listBeers,                    prevKey = if (page == 1) null else page.minus(1),                    nextKey = if (listBeers.isEmpty()) null else page.plus(1),            )        } catch (e: Exception) {            LoadResult.Error(e)        }    }}
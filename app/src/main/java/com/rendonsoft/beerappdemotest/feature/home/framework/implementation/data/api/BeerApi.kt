package com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.apiimport com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.config.response.Beerimport com.rendonsoft.beerappdemotest.feature.home.framework.implementation.data.config.response.BeerResponseimport kotlinx.coroutines.Deferredimport retrofit2.Responseimport retrofit2.http.GETimport retrofit2.http.Queryinterface BeerApi {    @GET("beers")    fun getBeersAsync(@Query("page") page_number: Int): Deferred<Response<ArrayList<Beer>>>}
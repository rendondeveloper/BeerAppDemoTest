package com.rendonsoft.beerappdemotest.feature.home.framework.presentation.page.modelimport androidx.annotation.StringResimport com.rendonsoft.beerappdemotest.feature.home.domain.model.BeerModelsealed interface HomeUiState {    data class Empty(@StringRes val title: Int, @StringRes val message: Int, val showPullToRefresh: Boolean = false): HomeUiState    object Loading: HomeUiState    object LoadingPage: HomeUiState    data class Data(val beers: List<BeerModel>): HomeUiState}
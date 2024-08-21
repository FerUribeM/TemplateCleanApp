package com.ferbajoo.templetecleanapp.presentation.discover

import androidx.lifecycle.viewModelScope
import com.ferbajoo.templetecleanapp.domain.usecase.LoadNewsUseCase
import com.ferbajoo.templetecleanapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
internal class DiscoverViewModel @Inject constructor(
    private val loadNewsUseCase: LoadNewsUseCase
) : BaseViewModel<DiscoverViewState>() {

    override val _viewData = MutableStateFlow(DiscoverViewState.Idle)

    init {
        loadNews()
    }

    private fun loadNews(filter: String = "global") {
        viewModelScope.launch {
            _viewData.value = DiscoverViewState.Loading
            loadNewsUseCase.invoke(filter = filter)
                .collect { result ->
                    result.error?.let {

                    }
                    result.success?.let { news ->
                        _viewData.value = viewData.value.copy(
                            news = news
                        )
                    }
                }
        }
    }

    fun filterByCategory(filter: String) {
        loadNews(filter)
    }

}
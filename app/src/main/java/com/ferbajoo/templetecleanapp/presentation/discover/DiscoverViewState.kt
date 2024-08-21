package com.ferbajoo.templetecleanapp.presentation.discover

import com.ferbajoo.templetecleanapp.data.model.NewsModel
import com.ferbajoo.templetecleanapp.presentation.base.ViewState

internal data class DiscoverViewState(
    val news: NewsModel = NewsModel(),
) : ViewState {
    companion object {
        val Loading = DiscoverViewState()
        val Idle = DiscoverViewState()
    }
}
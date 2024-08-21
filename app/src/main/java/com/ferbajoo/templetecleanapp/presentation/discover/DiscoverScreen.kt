package com.ferbajoo.templetecleanapp.presentation.discover

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.ferbajoo.templetecleanapp.presentation.components.NewsCard
import com.ferbajoo.templetecleanapp.presentation.discover.components.FilterCategoriesNews
import com.ferbajoo.templetecleanapp.presentation.discover.components.HeaderDiscoverNews
import com.ferbajoo.templetecleanapp.presentation.discover.components.SearchBarDiscoverNews
import com.ferbajoo.templetecleanapp.presentation.theme.TemplateCleanAppTheme
import kotlinx.serialization.Serializable

@Serializable
object Discover

@Composable
fun DiscoverScreen(navController: NavHostController) {
    TemplateCleanAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DiscoverContent(navController)
        }
    }
}

@Composable
internal fun DiscoverContent(
    navController: NavHostController,
    viewModel: DiscoverViewModel = hiltViewModel()
) {
    Scaffold {
        BodyDiscover(viewModel, navController, modifier = Modifier.padding(it))
    }
}

@Composable
internal fun BodyDiscover(
    viewModel: DiscoverViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val state by viewModel.viewData.collectAsStateWithLifecycle()
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            HeaderDiscoverNews()
        }
        item {
            Spacer(modifier = Modifier.size(10.dp))
            SearchBarDiscoverNews()
            Spacer(modifier = Modifier.size(20.dp))
        }
        item {
            FilterCategoriesNews { category ->
                viewModel.filterByCategory(category)
            }
            Spacer(modifier = Modifier.size(20.dp))
        }
        items(state.news.articles) { itemNews ->
            NewsCard(itemNews)
        }
    }
}

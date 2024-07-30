package com.ferbajoo.templetecleanapp.presentation.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ferbajoo.templetecleanapp.R
import com.ferbajoo.templetecleanapp.presentation.components.NewsCard
import com.ferbajoo.templetecleanapp.presentation.discover.Discover
import com.ferbajoo.templetecleanapp.presentation.news.components.BreakingNewsHorizontalPager
import com.ferbajoo.templetecleanapp.presentation.news.components.HeaderSection
import com.ferbajoo.templetecleanapp.presentation.theme.TemplateCleanAppTheme
import kotlinx.serialization.Serializable

@Serializable
object Home

@Composable
fun HomeScreen(navBackStackEntry: NavController) {
    TemplateCleanAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            NewsContent(navBackStackEntry)
        }
    }
}

@Composable
internal fun NewsContent(navController: NavController, viewModel: NewsViewModel = hiltViewModel()) {
    val state by viewModel.viewData.collectAsStateWithLifecycle()
    BodyScreen(state = state, navController)
}

@Composable
private fun BodyScreen(state: NewsViewState, navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HomeToolbar()
        },
    ) { paddingValues ->
        if (state == NewsViewState.Loading) Loader() else LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(15.dp)
        ) {
            item {
                HeaderSection("Breaking News")
                Spacer(modifier = Modifier.height(15.dp))
                if (state.breakingNews.articles.isNotEmpty()) {
                    BreakingNewsHorizontalPager(state.breakingNews.articles)
                }
                Spacer(modifier = Modifier.height(15.dp))
                HeaderSection("Recommendation", "View all") {
                    navController.navigate(Discover)
                }
            }
            if (state.recommendationNews.isNotEmpty()) {
                items(state.recommendationNews) {
                    NewsCard(it)
                }
            }
        }

    }
}

@Composable
fun Loader() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading_animation))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
    ) {
        LottieAnimation(
            composition = composition,
            progress = progress,
        )
        Text(
            text = stringResource(R.string.loading),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onTertiary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeToolbar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background),
        title = { Text(text = "") },
        navigationIcon = {
            IconButton(
                onClick = { },
                colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)
            ) {
                Icon(Icons.Default.Menu, contentDescription = null)
            }
        },
        actions = {
            IconButton(
                onClick = { },
                colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)
            ) {
                Icon(Icons.Default.Search, contentDescription = null)
            }
            IconButton(
                onClick = { },
                colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)
            ) {
                Icon(Icons.Default.Notifications, contentDescription = null)
            }
        })
}

@Preview
@Composable
fun HomeToolbarPreview() {
    HomeToolbar()
}


/*
Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            if (state.isLoading) {
                Text(
                    text = "Se esta cargando la info",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            if (state.error.isNullOrEmpty().not()) {
                Text(
                    text = "Error al cargar la información ${state.error}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            LazyColumn {
                items(state.news.articles.toList()) {
                    Text(
                        text = it.title ?: "",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
 */
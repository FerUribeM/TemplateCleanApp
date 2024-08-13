package com.ferbajoo.templetecleanapp.presentation.news.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.presentation.components.ImageBlackLayer
import com.ferbajoo.templetecleanapp.utils.openLink
import com.ferbajoo.templetecleanapp.utils.toFormatDate

@Composable
fun BreakingNewsHorizontalPager(articles: List<ArticleModel>) {
    val pagerState = rememberPagerState(pageCount = { articles.size })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 40.dp),
        pageSpacing = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) { page ->
        Card {
            Box {
                ImageBlackLayer(url = articles[page].urlToImage)
                BreakingNewsCardContent(articles[page])
            }
        }
    }
    LaunchedEffect(Unit) {
        pagerState.scrollToPage(articles.size / 2)
    }
}

@Composable
fun BreakingNewsCardContent(articleModel: ArticleModel) {
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .clickable {
            context.openLink(articleModel.url)
        }
        .padding(10.dp)) {
        Spacer(
            modifier = Modifier.weight(1f)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = articleModel.author.orEmpty(),
                color = MaterialTheme.colorScheme.onPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(width = 5.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(15.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Check,
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier.padding(2.dp)
                )
            }
            Spacer(modifier = Modifier.width(width = 5.dp))
            Text(
                text = "•",
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(horizontal = 3.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(width = 5.dp))
            Text(
                text = articleModel.publishedAt.toFormatDate().orEmpty(),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Spacer(modifier = Modifier.height(height = 5.dp))
        Text(
            text = articleModel.title,
            color = MaterialTheme.colorScheme.onPrimary,
            maxLines = 2,
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
    }
}

package com.ferbajoo.templetecleanapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ferbajoo.templetecleanapp.data.model.ArticleModel
import com.ferbajoo.templetecleanapp.utils.openLink
import com.ferbajoo.templetecleanapp.utils.toFormatDate

@Composable
fun NewsCard(articleModel: ArticleModel) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable {
                context.openLink(articleModel.url)
            }
    ) {
        Card(
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
        ) {
            ImageBlackLayer(url = articleModel.urlToImage)
        }
        Column(
            modifier = Modifier
                .weight(1.8f)
                .fillMaxHeight()
                .padding(vertical = 15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = articleModel.category.replaceFirstChar { it.uppercase() },
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onTertiary
            )
            Text(
                text = articleModel.title,
                color = MaterialTheme.colorScheme.onTertiary,
                maxLines = 2,
                style = MaterialTheme.typography.bodyMedium,
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = articleModel.author.orEmpty(),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onTertiary,
                    maxLines = 1,
                    modifier = Modifier.padding(end = 5.dp)
                )
                Text(
                    text = "•",
                    color = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.padding(horizontal = 5.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = articleModel.publishedAt.toFormatDate().orEmpty(),
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
    }
}

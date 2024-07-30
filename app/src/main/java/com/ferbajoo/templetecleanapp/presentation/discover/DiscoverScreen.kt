package com.ferbajoo.templetecleanapp.presentation.discover

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ferbajoo.templetecleanapp.R
import com.ferbajoo.templetecleanapp.data.model.CategoriesModel
import com.ferbajoo.templetecleanapp.data.model.getCategoriesFilter
import com.ferbajoo.templetecleanapp.presentation.components.NewsCard
import kotlinx.serialization.Serializable

@Serializable
object Discover

@Composable
fun DiscoverScreen() {
    Scaffold {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            item {
                HeaderDiscover()
            }
            item {
                Spacer(modifier = Modifier.size(10.dp))
                SearchNews()
                Spacer(modifier = Modifier.size(20.dp))
            }
            item {
                FilterCategoriesNews()
                Spacer(modifier = Modifier.size(20.dp))
            }
            items(10) {
                //NewsCard(it)
            }
        }
    }
}

@Composable
fun FilterCategoriesNews() {
    val selectedIndex = remember { mutableIntStateOf(0) }
    LazyRow {
        itemsIndexed(getCategoriesFilter()) { index, category ->
            FilterCategoryItem(category, selectedIndex.intValue == index) {
                selectedIndex.intValue = index
            }
        }
    }
}

@Composable
fun FilterCategoryItem(
    category: CategoriesModel,
    isSelected: Boolean,
    onSelectedFilter: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.onBackground
        ),
        modifier = Modifier
            .height(40.dp)
            .padding(horizontal = 10.dp)
            .clickable { onSelectedFilter() },
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.size(10.dp))
            Image(
                painterResource(id = category.image),
                contentDescription = null,
                modifier = Modifier.padding(3.dp)
            )
            Spacer(modifier = Modifier.size(4.dp))
            Text(
                text = category.name,
                color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onTertiary
            )
            Spacer(modifier = Modifier.size(10.dp))
        }
    }
}

@Composable
fun SearchNews() {
    var query by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(56.dp),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onBackground)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search_label),
                tint = MaterialTheme.colorScheme.surfaceTint,
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(30.dp)
            )
            TextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                placeholder = {
                    Text(
                        text = stringResource(R.string.search_label),
                        fontSize = 16.sp
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )
        }
    }
}

@Composable
fun HeaderDiscover() {
    Column(modifier = Modifier.padding(20.dp)) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Discover",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onTertiary,
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "News from all around the world",
            fontSize = 16.sp,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onTertiary,
        )
    }
}

package com.ferbajoo.templetecleanapp.presentation.discover.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ferbajoo.templetecleanapp.data.model.CategoriesModel
import com.ferbajoo.templetecleanapp.data.model.getCategoriesFilter

@Composable
fun FilterCategoriesNews(selectedFilter: (String) -> Unit) {
    val selectedIndex = rememberSaveable { mutableIntStateOf(0) }
    LazyRow {
        itemsIndexed(getCategoriesFilter()) { index, category ->
            FilterCategoryItem(category, selectedIndex.intValue == index) {
                selectedIndex.intValue = index
                selectedFilter(category.name)
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
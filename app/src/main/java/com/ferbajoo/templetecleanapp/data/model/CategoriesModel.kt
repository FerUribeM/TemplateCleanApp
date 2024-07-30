package com.ferbajoo.templetecleanapp.data.model

import androidx.annotation.DrawableRes
import com.ferbajoo.templetecleanapp.R

data class CategoriesModel(
    val name: String,
    @DrawableRes val image: Int
)

fun getCategoriesFilter(): List<CategoriesModel> {
    return listOf(
        CategoriesModel("All", R.drawable.ic_infinity),
        CategoriesModel("Business", R.drawable.ic_business),
        CategoriesModel("Technology", R.drawable.ic_tecnology),
        CategoriesModel("Sports", R.drawable.ic_sport),
        CategoriesModel("Entertainment", R.drawable.ic_movies),
        CategoriesModel("Science", R.drawable.ic_science),
    )
}
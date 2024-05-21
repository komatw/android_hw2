package com.example.lazycolumntest

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.lazycolumntest.data.DataProvider
import com.example.lazycolumntest.data.University


@Composable
fun UniversityInformationContent(navigateToProfile: (University) -> Unit) {
    val universities = remember {
        DataProvider.universityList
    }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical =8.dp)
    ){
        items(
            items = universities,
            itemContent = {
                UniversityListItem(university = it, navigateToProfile)
            }
        )
    }
}
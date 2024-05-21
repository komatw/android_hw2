package com.example.lazycolumntest

import android.security.identity.AccessControlProfile
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazycolumntest.data.University

@Composable
fun UniversityListItem(university: University, navigateToProfile: (University) -> Unit) {
    Card (
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ){
        Row (
            Modifier.clickable { navigateToProfile(university) }
        ){
            UniversityImage(university = university)
            Column (
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
                    .align(Alignment.CenterVertically)
            ){
                Text(text = university.title, style = MaterialTheme.typography.titleLarge)
                Text(text = "View Detail")
            }
        }
    }

}


@Composable
private fun UniversityImage(university: University) {
    Image(
        painter = painterResource(id = university.universityImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(84.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))

    )
}
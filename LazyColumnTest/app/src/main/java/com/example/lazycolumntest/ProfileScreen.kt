package com.example.lazycolumntest


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.lazycolumntest.data.University
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(university: University, navController: NavController) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {
        BoxWithConstraints {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ){
                    // TODO:
                    ProfileHeader(university = university, containerHeight = this@BoxWithConstraints.maxHeight)
                    ProfileContent(university = university, containerHeight = this@BoxWithConstraints.maxHeight)
                    ProfileBotton(university = university, navController = navController)
                }
            }
        }
    }
}

@Composable
private  fun ProfileHeader(
    university: University,
    containerHeight: Dp
) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = painterResource(id = university.universityImageId),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
private fun ProfileContent(university: University, containerHeight: Dp) {
    Column {
        //TODO:
        Title(university = university)
        ProfileProperty(label = stringResource(id = R.string.address), value = university.address)
        ProfileProperty(label = stringResource(id = R.string.phonenumber), value = university.phoneNum)
        ProfileProperty(label = stringResource(id = R.string.url), value = university.url)
    }
}

@Composable
private fun Title(university: University) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = university.title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun ProfileProperty(label: String, value: String) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        Text(
            text = label,
            modifier = Modifier.height(24.dp)
        )
        Text(
            text = value,
            modifier = Modifier.height(24.dp)
        )
    }
}

@Composable
private fun ProfileBotton(university: University, navController: NavController) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("MapScreen") }) {
            Text(text = "google map")
        }
    }
}
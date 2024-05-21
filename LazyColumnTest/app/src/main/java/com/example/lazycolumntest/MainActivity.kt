package com.example.lazycolumntest

import android.content.Intent
import android.os.Bundle
import android.security.identity.AccessControlProfile
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lazycolumntest.data.University
import com.example.lazycolumntest.ui.theme.LazyColumnTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTestTheme {
                MyApp{
                    startActivity(ProfileActivity.newIntent(this,it))
                }
            }
        }
    }
}

@Composable
fun MyApp(navigateToProfile: (University) -> Unit ) {
    Scaffold(
        content = {
            UniversityInformationContent(navigateToProfile = navigateToProfile)
        }
    )
}
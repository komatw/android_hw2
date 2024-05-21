package com.example.lazycolumntest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lazycolumntest.data.University
import com.example.lazycolumntest.ui.theme.LazyColumnTestTheme

class ProfileActivity : ComponentActivity() {
    private val university: University by lazy {
        intent?.getSerializableExtra(UNIVERSITY_ID) as University
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "ProfileScreen", builder = {
                composable("ProfileScreen"){
                    ProfileScreen(university = university, navController = navController)
                }
                composable("MapScreen"){
                    MapScreen(university = university)
                }
            } )

        }
    }
    companion object {
        private const val UNIVERSITY_ID = "university_id"
        fun newIntent(context: Context,  university: University) =
            Intent(context, ProfileActivity::class.java).apply {
                putExtra(UNIVERSITY_ID, university)
            }
    }
}


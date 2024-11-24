package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.statusBarIndicators.StatusItem
import com.example.composepractice.ui.statusBarIndicators.StatusBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                StatusBar(
                    paddingStart = 30.dp,
                    width = 500.dp,
                    statuses = listOf(
                        StatusItem(Color.Cyan, 1f),
                        StatusItem(Color.LightGray, 4f),
                        StatusItem(Color.Magenta, 5f)
                    )
                )
                StatusBar(
                    height = 15.dp,
                    paddingStart = 20.dp,
                    statuses = listOf(
                        StatusItem(Color.Cyan, 1f),
                        StatusItem(Color.LightGray, 4f),
                        StatusItem(Color.Magenta, 5f)
                    )
                )
                StatusBar(
                    roundStatus = 0.dp,
                    statuses = listOf(
                        StatusItem(Color.Cyan, 1f),
                        StatusItem(Color.LightGray, 4f),
                        StatusItem(Color.Magenta, 5f)
                    )
                )
            }
        }
    }
}


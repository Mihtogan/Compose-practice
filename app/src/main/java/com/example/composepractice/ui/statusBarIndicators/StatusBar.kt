package com.example.composepractice.ui.statusBarIndicators

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun StatusBar(
    height: Dp = 20.dp,
    width: Dp = 300.dp,
    paddingTop: Dp = 5.dp,
    paddingBottom: Dp = 5.dp,
    paddingStart: Dp = 5.dp,
    paddingEnd: Dp = 5.dp,
    roundedBackground: Dp = 10.dp,
    colorBackground: Color = Color.Gray,
    roundStatus: Dp = 10.dp,
    gap: Dp = 5.dp,
    statuses: List<StatusItem>,
) {
    Card(
        modifier = Modifier
            .height(height + paddingTop + paddingBottom)
            .width(width + paddingStart + paddingEnd)
            .padding(
                start = paddingStart,
                top = paddingTop,
                end = paddingEnd,
                bottom = paddingBottom
            ),
        shape = RoundedCornerShape(roundedBackground),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorBackground),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            var sumValue = 0f
            statuses.forEach {
                sumValue += it.value
            }

            statuses.forEachIndexed { index, status ->
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(status.value / sumValue)
                        .padding(
                            start = if (index != 0) gap / 2 else 0.dp,
                            end = if (index != statuses.size - 1) gap / 2 else 0.dp
                        ),
                    shape = RoundedCornerShape(roundStatus),
                    colors = CardColors(status.color, status.color, status.color, status.color)
                ) { }
            }
        }
    }
}

@Preview
@Composable
private fun StatusBarDemo() {
    StatusBar(
        statuses = listOf(
            StatusItem(Color.Green, 5f),
            StatusItem(Color.Yellow, 3f),
            StatusItem(Color.Red, 2f)
        )
    )
}
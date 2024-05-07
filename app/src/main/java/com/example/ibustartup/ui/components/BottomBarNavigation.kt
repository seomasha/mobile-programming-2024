package com.example.ibustartup.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.ibustartup.R
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightGray

@Composable
fun BottomBarNavigation() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
            .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(painter = painterResource(id = R.drawable.home), contentDescription = "Home icon")
            Text(text = "Home", fontSize = 12.sp, fontWeight = FontWeight.Light)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.startups),
                contentDescription = "Startups icon"
            )
            Text(text = "Startups", fontSize = 12.sp, fontWeight = FontWeight.Light)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.friends),
                contentDescription = "Friends icon"
            )
            Text(text = "Friends", fontSize = 12.sp, fontWeight = FontWeight.Light)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.notifications),
                contentDescription = "Notifications icon"
            )
            Text(text = "Notifications", fontSize = 12.sp, fontWeight = FontWeight.Light)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = R.drawable.investors),
                contentDescription = "Investors icon"
            )
            Text(text = "Investors", fontSize = 12.sp, fontWeight = FontWeight.Light)
        }
    }
}

@Composable
@Preview(showBackground = false)
fun BottomBarNavigationPreview() {
    BottomBarNavigation()
}
package com.example.ibustartup.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ibustartup.R
import com.example.ibustartup.data.StartupData
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue

@Composable
fun Startup(startup: StartupData) {
    Column(
        modifier = Modifier
            .background(
                color = Color.White, shape = RoundedCornerShape(8.dp)
            )
            .size(180.dp, 250.dp)
            .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = startup.logoImage),
            contentDescription = "Startup image",
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clip(
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp
                )
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = startup.name,
            fontSize = 16.sp,
            color = DarkBlue,
            fontWeight = FontWeight.Bold
        )
        Text(text = "@${startup.username}", fontSize = 12.sp, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue
            )
        ) {
            Text(text = "Apply")
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF656565)
@Composable
fun StartupPreview() {
    val startup = StartupData(
        name = "Sead Masetic",
        username = "seadmasetic",
        logoImage = R.drawable.profile
    )
    Startup(startup = startup)
}


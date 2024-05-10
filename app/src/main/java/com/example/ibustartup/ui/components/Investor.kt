package com.example.ibustartup.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import com.example.ibustartup.data.InvestorData
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue

@Composable
fun Investor(investor : InvestorData) {
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
            painter = painterResource(id = investor.logoImage),
            contentDescription = "Startup image",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = investor.name, fontSize = 16.sp, color = DarkBlue, fontWeight = FontWeight.Bold)
        Text(text = investor.username, fontSize = 12.sp, fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue
            )
        ) {
            Text(text = "Investor")
        }
    }
}

@Preview
@Composable
fun InvestorPreview() {
    val investor = InvestorData(
        name = "Sead Masetic",
        username = "seadmasetic",
        logoImage = R.drawable.investors_picture
    )
    Investor(investor = investor)
}
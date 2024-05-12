package com.example.ibustartup.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
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
import androidx.navigation.compose.rememberNavController
import com.example.ibustartup.R
import com.example.ibustartup.data.StartupData
import com.example.ibustartup.ui.components.Card
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

@Composable
fun MyProfile(startups: List<StartupData>) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        val navController = rememberNavController()
        Row(
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(top = 70.dp)
                .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(125.dp)
                    .clip(shape = CircleShape)
            )
            Column {
                Text(
                    text = "Sead Masetic",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue
                )
                Text(
                    text = "@seadmasetic",
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        containerColor = LightBlue
                    )
                ) {
                    Text(text = "Edit my profile")
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(
                        color = Color.White, shape = RoundedCornerShape(8.dp)
                    )
                    .size(180.dp)
                    .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "My friends",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue,
                    modifier = Modifier.padding(8.dp)
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Friend",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Friend",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Friend",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(shape = RoundedCornerShape(8.dp))
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier
                    .background(
                        color = Color.White, shape = RoundedCornerShape(8.dp)
                    )
                    .size(180.dp)
                    .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp)),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Suggested friends",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue,
                    modifier = Modifier.padding(8.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
                        .background(color = LightGray, shape = RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Sead Masetic",
                        color = LightBlue,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 12.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
                        .background(color = LightGray, shape = RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Fikret Zajmovic",
                        color = LightBlue,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        fontSize = 12.sp
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(modifier = Modifier.padding(bottom = 80.dp)) {
            itemsIndexed(startups.chunked(2)) { _, startup ->
                Row(modifier = Modifier.padding(12.dp)) {
                    startup.forEach { startupData ->
                        Card(
                            name = startupData.name,
                            username = startupData.username,
                            buttonText = "Apply",
                            image = startupData.logoImage,
                            onClick = {})
                        Spacer(modifier = Modifier.width(12.dp))
                    }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
fun MyProfilePreview() {
    //MyProfile()
}
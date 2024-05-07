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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.ibustartup.ui.components.BottomBarNavigation
import com.example.ibustartup.ui.components.Header
import com.example.ibustartup.ui.components.SmallCheckboxButton
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue

@Composable
fun Startups(){
    var isChecked by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                rememberScrollState()
            )
    ){
        Header(modifier = Modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)
            )
            .border(
                width = 2.dp,
                color = GrayStroke,
                shape = RoundedCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp)
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .padding(12.dp),
        ) {
            Column {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "Your friend requests",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkBlue
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column (
                    modifier = Modifier.padding(start = 10.dp)
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SmallCheckboxButton(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(
                            text = "IT",
                            fontWeight = FontWeight.Normal
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SmallCheckboxButton(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(
                            text = "Marketing",
                            fontWeight = FontWeight.Normal
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        SmallCheckboxButton(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                        )
                        Spacer(modifier = Modifier.width(7.dp))
                        Text(
                            text = "Graphic design",
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                            containerColor = LightBlue
                        )
                    ) {
                        Text(text = "Apply filters")
                    }
                }
            }
        }
            Row(modifier = Modifier.padding(12.dp)) {
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
                        painter = painterResource(id = R.drawable.positionimage),
                        contentDescription = "Startup image",
                        modifier = Modifier.clip(
                            shape = RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Sead Masetic",
                        fontSize = 16.sp,
                        color = DarkBlue,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "@seadmasetic", fontSize = 12.sp, fontWeight = FontWeight.Light)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                            containerColor = LightBlue
                        )
                    ) {
                        Text(text = "Apply")
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
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
                        painter = painterResource(id = R.drawable.positionimage),
                        contentDescription = "Startup image",
                        modifier = Modifier.clip(
                            shape = RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Sead Masetic",
                        fontSize = 16.sp,
                        color = DarkBlue,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "@seadmasetic", fontSize = 12.sp, fontWeight = FontWeight.Light)
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
            Row(modifier = Modifier.padding(12.dp)) {
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.White, shape = RoundedCornerShape(8.dp)
                        )
                        .size(180.dp, 250.dp)
                        .border(
                            width = 2.dp,
                            color = GrayStroke,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.positionimage),
                        contentDescription = "Startup image",
                        modifier = Modifier.clip(
                            shape = RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Sead Masetic",
                        fontSize = 16.sp,
                        color = DarkBlue,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "@seadmasetic", fontSize = 12.sp, fontWeight = FontWeight.Light)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                            containerColor = LightBlue
                        )
                    ) {
                        Text(text = "Apply")
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
                Column(
                    modifier = Modifier
                        .background(
                            color = Color.White, shape = RoundedCornerShape(8.dp)
                        )
                        .size(180.dp, 250.dp)
                        .border(
                            width = 2.dp,
                            color = GrayStroke,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.positionimage),
                        contentDescription = "Startup image",
                        modifier = Modifier.clip(
                            shape = RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Sead Masetic",
                        fontSize = 16.sp,
                        color = DarkBlue,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = "@seadmasetic", fontSize = 12.sp, fontWeight = FontWeight.Light)
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
        BottomBarNavigation()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
@Composable
fun StartupsPreview(){
    Startups()
}
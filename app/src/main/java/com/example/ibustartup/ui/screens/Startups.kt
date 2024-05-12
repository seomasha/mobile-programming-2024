package com.example.ibustartup.ui.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ibustartup.R
import com.example.ibustartup.ui.components.Startup
import com.example.ibustartup.data.StartupData
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue

@Composable
fun Startups(startups: List<StartupData>){
    var isChecked by remember { mutableStateOf(false) }
    val myCheckedColor = Color(0xFF008DDA)

    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
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
                        text = "Filters",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkBlue
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Column (
                    modifier = Modifier.padding(start = 5.dp)
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        var isChecked by remember { mutableStateOf(false) }
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = myCheckedColor,
                            )
                        )
                        Text(
                            text = "IT",
                            fontWeight = FontWeight.Normal
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        var isChecked by remember { mutableStateOf(false) }
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = myCheckedColor,
                            )
                        )
                        Text(
                            text = "Marketing",
                            fontWeight = FontWeight.Normal
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        var isChecked by remember { mutableStateOf(false) }
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = myCheckedColor,
                            )
                        )
                        Text(
                            text = "Graphic design",
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
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
        LazyColumn {
            items(startups.chunked(2)) { pairOfStartups ->
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Startup(startup = pairOfStartups[0])
                    if (pairOfStartups.size > 1) {
                        Startup(startup = pairOfStartups[1])
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
@Composable
fun StartupsPreview(){
    val startups = listOf(
        StartupData(
            name = "Startup 1",
            username = "username1",
            logoImage = R.drawable.profile
        ),
        StartupData(
            name = "Startup 2",
            username = "username2",
            logoImage = R.drawable.profile
        ),
        StartupData(
            name = "Startup 3",
            username = "username3",
            logoImage = R.drawable.profile
        ),
        StartupData(
            name = "Startup 4",
            username = "username4",
            logoImage = R.drawable.profile
        ),
        StartupData(
            name = "Startup 5",
            username = "username5",
            logoImage = R.drawable.profile
        ),
    )
    Startups(startups)
}

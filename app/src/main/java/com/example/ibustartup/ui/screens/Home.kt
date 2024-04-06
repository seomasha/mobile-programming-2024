package com.example.ibustartup.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ibustartup.R
import com.example.ibustartup.data.PositionData
import com.example.ibustartup.ui.components.BottomBarNavigation
import com.example.ibustartup.ui.components.Header
import com.example.ibustartup.ui.components.Position
import com.example.ibustartup.ui.theme.GrayBackground
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

@Composable
fun Home(positions: List<PositionData>) {
    Column(modifier = Modifier.fillMaxSize()) {
        Header(
            modifier = Modifier
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp, 70.dp)
                .padding(12.dp)
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.95f)
                    .padding(6.dp)
                    .background(color = LightGray, shape = RoundedCornerShape(8.dp))
                    .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
            ) {
                Button(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ), modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "Create a new position",
                        color = LightBlue,
                        fontSize = 12.sp,
                    )
                }
            }
        }
        LazyColumn {
            items(positions) { position ->
                Position(position = position)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        BottomBarNavigation()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
@Composable
fun HomePreview() {
    //Home()
}
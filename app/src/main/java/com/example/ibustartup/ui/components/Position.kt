package com.example.ibustartup.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

@Composable
fun Position() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Row() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(text = "Sead Masetic", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = "@seadmasetic", fontWeight = FontWeight.Light, fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                Row() {
                    Text(text = "Add friend", color = LightBlue)
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.addfriend),
                        contentDescription = "Add friend icon",
                        tint = LightBlue
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Some example text here", modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.positionimage),
            contentDescription = "Position image",
            modifier = Modifier.clip(shape = RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Row(modifier = Modifier.weight(1f)) {
                Icon(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = "Like",
                    tint = LightBlue,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "15 likes", fontSize = 12.sp)
            }
            Row(modifier = Modifier.weight(1f)) {
                Icon(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "Comment",
                    tint = LightBlue
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "15 comments", fontSize = 12.sp)
            }
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.apply),
                    contentDescription = "Apply",
                    tint = LightBlue
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "15 applies", fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(color = GrayStroke, thickness = 1.dp)
        Spacer(modifier = Modifier.height(15.dp))
        Row() {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBlue
                )
            ) {
                Text(text = "Like")
            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBlue
                )
            ) {
                Text(text = "Comment")
            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBlue
                )
            ) {
                Text(text = "Apply")
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(color = LightGray, shape = RoundedCornerShape(8.dp))
                .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(25.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = "Sead Masetic", fontWeight = FontWeight.Bold, fontSize = 14.sp)
                Text(
                    text = "Just a comment here used for testing and basically just a placeholder.",
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF656565)
@Composable
fun PositionPreview() {
    Position()
}
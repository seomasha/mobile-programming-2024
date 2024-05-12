package com.example.ibustartup.ui.components

import android.hardware.lights.Light
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ibustartup.R
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

@Composable
fun FriendRequest(name: String) {
    Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
            .background(color = LightGray, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = name,
                color = LightBlue,
                modifier = Modifier.align(Alignment.CenterVertically),
                fontSize = 12.sp
            )
        }
        Row {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.checkmark), contentDescription = "Checkmark", tint = LightBlue)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.close), contentDescription = "Close", tint = Color.Red)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
fun FriendRequestPreview() {
    FriendRequest(name = "Sead Masetic")
}
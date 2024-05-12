package com.example.ibustartup.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.example.ibustartup.data.FriendRequestData
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

@Composable
fun FriendRequest(friendRequestData: FriendRequestData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
            .background(color = LightGray, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(friendRequestData.logoImage),
            contentDescription = "Profile",
            modifier = Modifier
                .size(30.dp)
                .clip(shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = friendRequestData.message,
            color = LightBlue,
            modifier = Modifier.align(Alignment.CenterVertically),
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.width(120.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = LightBlue),
            modifier = Modifier
                .size(30.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.checkmark_small),
                contentDescription = "Accept",
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .size(30.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.decline_sign),
                contentDescription = "Decline",
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White)
            )
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
fun FriendRequestPreview() {
    FriendRequest(friendRequestData = FriendRequestData("Some text here", R.drawable.profile))
}
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
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ibustartup.R
import com.example.ibustartup.data.FriendData
import com.example.ibustartup.ui.components.AddFriend
import com.example.ibustartup.ui.components.FriendRequest
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

@Composable
fun Friends(friends: List<FriendData>) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
                    Text(text = "Go to my profile")
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(width = 2.dp, color = GrayStroke, shape = RoundedCornerShape(8.dp))
                .background(
                    color = Color.White, shape = RoundedCornerShape(8.dp)
                )
                .padding(12.dp)
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Your friend requests",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = DarkBlue
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            FriendRequest()
            FriendRequest()
            FriendRequest()
        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(friends.chunked(2)) { pairOfFriends ->
                Row(modifier = Modifier.padding(12.dp)) {
                    AddFriend(friend = pairOfFriends[0])
                    Spacer(modifier = Modifier.width(8.dp))
                    if (pairOfFriends.size > 1) {
                        AddFriend(friend = pairOfFriends[1])
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
fun FriendsPreview() {
    val friends = listOf(
        FriendData(
            name = "Sead Masetic",
            username = "seadmasetic",
            logoImage = R.drawable.profile
        ),
        FriendData(
            name = "Sead Masetic",
            username = "seadmasetic",
            logoImage = R.drawable.profile
        ),
        FriendData(
            name = "Sead Masetic",
            username = "seadmasetic",
            logoImage = R.drawable.profile
        ),
        FriendData(
            name = "Sead Masetic",
            username = "seadmasetic",
            logoImage = R.drawable.profile
        ),
        FriendData(
            name = "Sead Masetic",
            username = "seadmasetic",
            logoImage = R.drawable.profile
        ),
    )
    Friends(friends)
}
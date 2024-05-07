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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import com.example.ibustartup.data.CommentData
import com.example.ibustartup.data.PositionData
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

//TODO Create functional navigation

@Composable
fun Position(position: PositionData) {
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
                    painter = painterResource(id = position.profileImage),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(shape = CircleShape)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(text = position.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(
                        text = "@${position.username}",
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
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
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = position.description, modifier = Modifier.padding(8.dp))
        Spacer(modifier = Modifier.height(10.dp))
        if (position.positionImage != null) {
            Image(
                painter = painterResource(id = position.positionImage),
                contentDescription = "Position image",
                modifier = Modifier.clip(shape = RoundedCornerShape(8.dp))
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = "Like",
                    tint = LightBlue,
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "${position.likeCount.toString()} likes", fontSize = 12.sp)
            }
            Row(modifier = Modifier.weight(1f), verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "Comment",
                    tint = LightBlue
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "${position.commentCount.toString()} comments", fontSize = 12.sp)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.apply),
                    contentDescription = "Apply",
                    tint = LightBlue
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "${position.applyCount.toString()} applies", fontSize = 12.sp)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        HorizontalDivider(thickness = 1.dp, color = GrayStroke)
        Spacer(modifier = Modifier.height(15.dp))
        Row() {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBlue
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.like),
                    contentDescription = "Apply",
                    modifier = Modifier.size(15.dp)
                )

            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBlue
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.comment),
                    contentDescription = "Apply",
                    modifier = Modifier.size(15.dp)
                )

            }
            Spacer(modifier = Modifier.width(15.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LightBlue
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.apply),
                    contentDescription = "Apply",
                    modifier = Modifier.size(15.dp)
                )

            }
        }
        Spacer(modifier = Modifier.height(25.dp))
        for (comment in position.comments) {
            Comment(comment = comment)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF656565)
@Composable
fun PositionPreview() {
    val comments = mutableListOf(
        CommentData(
            profileImage = R.drawable.profile,
            name = "Sead Masetic",
            comment = "Test"
        ),
        CommentData(
            profileImage = R.drawable.profile,
            name = "Sead Masetic",
            comment = "Test"
        )
    )
    val position = PositionData(
        profileImage = R.drawable.profile,
        name = "Sead Masetic",
        username = "seadmasetic",
        description = "Test",
        positionImage = R.drawable.positionimage,
        likeCount = 15,
        commentCount = 1,
        applyCount = 14,
        comments = comments
    )
    Position(position = position)
}
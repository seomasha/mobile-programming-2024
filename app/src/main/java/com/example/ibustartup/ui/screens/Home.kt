package com.example.ibustartup.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.ibustartup.R
import com.example.ibustartup.data.CommentData
import com.example.ibustartup.data.PositionData
import com.example.ibustartup.ui.components.BottomBarNavigation
import com.example.ibustartup.ui.components.Header
import com.example.ibustartup.ui.components.Position
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.GrayBackground
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(positions: List<PositionData>, modifier: Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize().padding(top = 50.dp, bottom = 100.dp)
    ) {
        LazyColumn {
            items(positions) { position ->
                Position(position = position)
            }
        }

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
@Composable
fun HomePreview() {
    val comments = mutableListOf(
        CommentData(
            profileImage = R.drawable.profile,
            name = "Sead Fikret",
            "Komentar"
        )
    )
    val positions = mutableListOf(
        PositionData(
            name = "Sead Masetic",
            username = "seadmasetic",
            description = "Testiranje",
            profileImage = R.drawable.profile,
            positionImage = R.drawable.positionimage,
            likeCount = 45,
            commentCount = 25,
            applyCount = 128,
            comments = comments
        ),
        PositionData(
            name = "Sead Masetic",
            username = "seadmasetic",
            description = "Testiranje",
            profileImage = R.drawable.profile,
            positionImage = R.drawable.positionimage,
            likeCount = 45,
            commentCount = 25,
            applyCount = 128,
            comments = comments
        )
    )
    Home(positions = positions, modifier = Modifier)
}
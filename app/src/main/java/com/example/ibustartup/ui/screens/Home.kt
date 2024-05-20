package com.example.ibustartup.ui.screens

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.ibuPosition.backend.viewmodels.PositionEvent
import com.example.ibuPosition.backend.viewmodels.PositionUIState
import com.example.ibuPosition.backend.viewmodels.PositionViewModel
import com.example.ibustartup.R
import com.example.ibustartup.backend.tables.Position
import com.example.ibustartup.backend.viewmodels.StartupEvent
import com.example.ibustartup.backend.viewmodels.StartupUIState
import com.example.ibustartup.backend.viewmodels.UserViewModel
import com.example.ibustartup.data.CommentData
import com.example.ibustartup.data.PositionData
import com.example.ibustartup.ui.components.BottomBarNavigation
import com.example.ibustartup.ui.components.Card
import com.example.ibustartup.ui.components.Header
import com.example.ibustartup.ui.components.Position
import com.example.ibustartup.ui.theme.DarkBlue
import com.example.ibustartup.ui.theme.GrayBackground
import com.example.ibustartup.ui.theme.GrayStroke
import com.example.ibustartup.ui.theme.LightBlue
import com.example.ibustartup.ui.theme.LightGray

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(positionViewModel: PositionViewModel, modifier: Modifier, userViewModel: UserViewModel) {
    val positionsState by positionViewModel.UIState.collectAsState()
    LaunchedEffect(key1 = Unit) {
        positionViewModel.onEvent(PositionEvent.GetPositions)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, bottom = 5.dp)
    ) {
        when (positionsState) {
            is PositionUIState.Loading -> {
                CircularProgressIndicator()
            }

            is PositionUIState.SuccessWithData -> {
                val positions = (positionsState as PositionUIState.SuccessWithData).Positions

                LazyColumn(modifier = Modifier.padding(bottom = 80.dp)) {
                    items(positions.reversed()) { positionData ->
                        if (positionData != null) {
                            var username by remember {
                                mutableStateOf("")
                            }
                            Log.d("data",positionData.toString())
                            Position(
                                userViewModel = userViewModel,
                                positionName = positionData.positionName,
                                positionDescription = positionData.positionDescription,
                                likeCount = positionData.likeCount,
                                commentCount = positionData.commentCount,
                                applyCount = positionData.applyCount,
                                userID = positionData.userID,
                                onClick = {}
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                        } else {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }

            is PositionUIState.Error -> {
                val errorMessage = (positionsState as PositionUIState.Error).message
                Text(text = errorMessage)
            }

            is PositionUIState.Success -> {}
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
}
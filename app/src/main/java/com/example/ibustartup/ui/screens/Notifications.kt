package com.example.ibustartup.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ibustartup.R
import com.example.ibustartup.data.NotificationData
import com.example.ibustartup.ui.components.Notification

@Composable
fun Notifications(notifications: List<NotificationData>) {
    LazyColumn (modifier = Modifier.fillMaxSize()){
        items(notifications) { notification ->
            Notification(notification = notification)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
@Composable
fun NotificationsPreview(){
    val notifications = listOf(
        NotificationData(
            profileImage = R.drawable.profile,
            message = "Notification 1"
        ),
        NotificationData(
            profileImage = R.drawable.profile,
            message = "Notification 2"
        ),
        NotificationData(
            profileImage = R.drawable.profile,
            message = "Notification 3"
        ),
        NotificationData(
            profileImage = R.drawable.profile,
            message = "Notification 4"
        ),
        NotificationData(
            profileImage = R.drawable.profile,
            message = "Notification 5"
        ),
    )
    Notifications(notifications)
}
package com.example.ibustartup.data

data class PositionData(
    val name: String,
    val username: String,
    val description: String,
    val profileImage: Int,
    val positionImage: Int,
    val likeCount: Int,
    val commentCount: Int,
    val applyCount: Int,
    val comments: List<CommentData>
)

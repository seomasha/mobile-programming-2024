package com.example.ibustartup.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ibustartup.R
import com.example.ibustartup.data.InvestorData
import com.example.ibustartup.ui.components.Card

@Composable
fun Investors(investors: List<InvestorData>) {
    LazyColumn(modifier = Modifier.padding(vertical = 50.dp)) {
        itemsIndexed(investors.chunked(2)) { _, investor ->
            Row(modifier = Modifier.padding(12.dp)) {
                investor.forEach { investorData ->
                    Card(name = investorData.name,
                        username = investorData.username,
                        buttonText = "Apply",
                        image = investorData.logoImage,
                        onClick = {})
                    Spacer(modifier = Modifier.width(12.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
@Composable
fun InvestorsPreview() {
    val investors = listOf(
        InvestorData(
            name = "Investor 1", username = "username1", logoImage = R.drawable.investors_picture
        ),
        InvestorData(
            name = "Investor 2", username = "username2", logoImage = R.drawable.investors_picture
        ),
        InvestorData(
            name = "Investor 3", username = "username3", logoImage = R.drawable.investors_picture
        ),
        InvestorData(
            name = "Investor 4", username = "username4", logoImage = R.drawable.investors_picture
        ),
        InvestorData(
            name = "Investor 5", username = "username5", logoImage = R.drawable.investors_picture
        ),
    )
    Investors(investors)
}
package com.example.nbaschedule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

enum class MainTabs(val tabName: String, ) {
    ONE("One", ),
    TWO("Two", ),
    THREE("Three", ),
    FOUR("Four", )
}

@Composable
fun One() {
    BaseDefault(content = "One")
}

@Composable
fun Two() {
    BaseDefault(content = "Two")
}

@Composable
fun Three() {
    BaseDefault(content = "Three")
}

@Composable
fun Four() {
    BaseDefault(content = "Four")
}

@Composable
fun BaseDefault(content: String) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = content, fontSize = 50.sp) // tab对应的页面要展示的内容
    }
}

@Composable
fun BottomNavigationTest() {
    val tabs = MainTabs.values() // tab数据
//    var position by remember { mutableStateOf(MainTabs.ONE)}
    

}



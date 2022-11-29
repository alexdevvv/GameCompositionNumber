package com.example.gamecompositionnumber.domain.entities

data class Question(
    val sum: Int,
    val visibleNumber: Int,
    val option: List<Int>
)
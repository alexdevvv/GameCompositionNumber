package com.example.gamecompositionnumber.domain.entities

data class GameSetting(
    val maxSumValue: Int,
    val minCountOfRightAnswer: Int,
    val minPercentOfRightAnswer: Int,
    val gameTimeOfSeconds: Int
)
package com.example.gamecompositionnumber.domain.entities

data class GameResult(
    val winner: Boolean,
    val countRightAswers: Int,
    val countOfQuestions: Int,
    val gameSetting: GameSetting
)
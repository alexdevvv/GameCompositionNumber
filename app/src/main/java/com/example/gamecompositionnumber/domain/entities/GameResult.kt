package com.example.gamecompositionnumber.domain.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameResult(
    val winner: Boolean,
    val countRightAswers: Int,
    val countOfQuestions: Int,
    val gameSetting: GameSetting
): Parcelable
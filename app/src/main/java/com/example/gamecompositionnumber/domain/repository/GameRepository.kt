package com.example.gamecompositionnumber.domain.repository

import com.example.gamecompositionnumber.domain.entities.GameSettings
import com.example.gamecompositionnumber.domain.entities.Level
import com.example.gamecompositionnumber.domain.entities.Question

interface GameRepository {
    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}
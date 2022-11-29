package com.example.gamecompositionnumber.domain.repository

import com.example.gamecompositionnumber.domain.entities.GameSetting
import com.example.gamecompositionnumber.domain.entities.Level
import com.example.gamecompositionnumber.domain.entities.Question

interface GameRepository {

    fun getGameQuestion(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSetting
}
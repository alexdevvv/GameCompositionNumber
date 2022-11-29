package com.example.gamecompositionnumber.data

import com.example.gamecompositionnumber.domain.entities.GameSetting
import com.example.gamecompositionnumber.domain.entities.Level
import com.example.gamecompositionnumber.domain.entities.Question
import com.example.gamecompositionnumber.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    const val MIN_VALUE_GENERAL_NUMBER = 2
    const val MIN_VALUE_VISIBLE_NUMBER = 1

    override fun getGameQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val generalNumber = Random.nextInt(MIN_VALUE_GENERAL_NUMBER, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_VALUE_VISIBLE_NUMBER, generalNumber)
        val option = HashSet<Int>()
        val rightAnswer = generalNumber - visibleNumber
        option.add(rightAnswer)

        val from = max(rightAnswer - countOfOptions, MIN_VALUE_VISIBLE_NUMBER)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (option.size <= countOfOptions) {
            option.add(Random.nextInt(from, to))
        }

        return Question(generalNumber, visibleNumber, option.toList())

    }

    override fun getGameSettings(level: Level): GameSetting {
        return when (level) {
            Level.TEST ->
                GameSetting(
                10,
                3,
                50,
                8
            )
            Level.EASY ->
                GameSetting(
                    10,
                    10,
                    70,
                    60
                )
            Level.NORMAL ->
                GameSetting(
                    20,
                    20,
                    80,
                    40
                )
            Level.HARD ->
                GameSetting(
                    30,
                    30,
                    90,
                    40
                )
        }
    }
}
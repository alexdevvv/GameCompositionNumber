package com.example.gamecompositionnumber.domain.use_cases

import com.example.gamecompositionnumber.domain.entities.Question
import com.example.gamecompositionnumber.domain.repository.GameRepository

class GenerateQuestionUseCase(private val repository: GameRepository) {

   operator fun invoke(maxSumValue: Int): Question{
      return  repository.generateQuestion(maxSumValue, COUNT_OPTIONS)
    }
}

private const val COUNT_OPTIONS = 6
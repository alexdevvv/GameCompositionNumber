package com.example.gamecompositionnumber.domain.use_cases

import com.example.gamecompositionnumber.domain.entities.Level
import com.example.gamecompositionnumber.domain.entities.Question
import com.example.gamecompositionnumber.domain.repository.GameRepository

class GenerateQuestionUseCase(private val gameRepository: GameRepository) {

    operator fun invoke(maxSumValue: Int): Question{
      return  gameRepository.getGameQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }

    companion object{
        private const val COUNT_OF_OPTIONS = 6
    }
}
package com.example.gamecompositionnumber.domain.use_cases

import com.example.gamecompositionnumber.domain.entities.GameSetting
import com.example.gamecompositionnumber.domain.entities.Level
import com.example.gamecompositionnumber.domain.repository.GameRepository

class GetGameSettingUseCase(private val gameRepository: GameRepository) {
    operator fun invoke(level: Level): GameSetting{
        return gameRepository.getGameSettings(level)
    }
}
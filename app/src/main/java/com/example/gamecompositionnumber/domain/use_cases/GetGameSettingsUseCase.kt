package com.example.gamecompositionnumber.domain.use_cases

import com.example.gamecompositionnumber.domain.entities.GameSettings
import com.example.gamecompositionnumber.domain.entities.Level
import com.example.gamecompositionnumber.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {
   operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}
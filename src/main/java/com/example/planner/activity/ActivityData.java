package com.example.planner.activity;

import java.time.LocalDateTime;
import java.util.UUID;

public record ActivityData(UUID id, String title, LocalDateTime occurs_at) {
  public ActivityData {
    if (title == null || title.isBlank()) {
      throw new IllegalArgumentException("O título é obrigatório");
    }

    if (occurs_at == null) {
      throw new IllegalArgumentException("A data de ocorrência é obrigatória");
    }

    if (occurs_at.isBefore(LocalDateTime.now())) {
      throw new IllegalArgumentException("A data de ocorrência deve ser no futuro");
    }
  }
}

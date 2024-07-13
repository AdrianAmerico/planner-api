package com.example.planner.trip;

import java.util.List;

public record TripRequestPayload(
		String destination, String starts_at, String ends_at, List<String> emails_to_invite, String owner_email,
		String owner_name) {

	public TripRequestPayload {
		if (destination == null || destination.isBlank()) {
			throw new IllegalArgumentException("O destino é obrigatório");
		}

		if (starts_at == null || starts_at.isBlank()) {
			throw new IllegalArgumentException("A data de início é obrigatória");
		}

		if (ends_at == null || ends_at.isBlank()) {
			throw new IllegalArgumentException("A data de término é obrigatória");
		}

		if (emails_to_invite == null || emails_to_invite.isEmpty()) {
			throw new IllegalArgumentException("É necessário convidar pelo menos um participante");
		}

		if (owner_email == null || owner_email.isBlank()) {
			throw new IllegalArgumentException("O email do proprietário é obrigatório");
		}

		if (owner_name == null || owner_name.isBlank()) {
			throw new IllegalArgumentException("O nome do proprietário é obrigatório");
		}

		if (java.time.LocalDateTime.parse(starts_at).isAfter(java.time.LocalDateTime.parse(ends_at))) {
			throw new IllegalArgumentException("A data de início deve ser anterior à data de término");
		}
	}
}

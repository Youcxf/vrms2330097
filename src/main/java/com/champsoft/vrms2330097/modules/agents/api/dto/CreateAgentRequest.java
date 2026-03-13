package com.champsoft.vrms2330097.modules.agents.api.dto;

import com.champsoft.vrms2330097.modules.agents.domain.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAgentRequest(
        @NotBlank String name,
        @NotNull Role role) {}

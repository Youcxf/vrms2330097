package com.champsoft.vrms2330097.modules.owners.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateOwnerRequest(
        @NotBlank String fullName,
        String address) {}

package com.champsoft.vrms2330097.modules.owners.api.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateOwnerRequest(
        @NotBlank String fullName,
        String address) {}

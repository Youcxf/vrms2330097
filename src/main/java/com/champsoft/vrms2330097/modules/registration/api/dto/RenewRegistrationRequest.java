package com.champsoft.vrms2330097.modules.registration.api.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RenewRegistrationRequest(@NotNull LocalDate newExpiry) {}

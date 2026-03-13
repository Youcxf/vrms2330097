package com.champsoft.vrms2330097.modules.cars.api.dto;
public record VehicleResponse(
        String id,
        String vin,
        String make,
        String model,
        int year,
        String status) {}
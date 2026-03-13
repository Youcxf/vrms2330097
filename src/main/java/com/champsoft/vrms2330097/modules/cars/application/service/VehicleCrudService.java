package com.champsoft.vrms2330097.modules.cars.application.service;
import com.champsoft.vrms2330097.modules.cars.application.exception.DuplicateVinException;
import com.champsoft.vrms2330097.modules.cars.application.exception.VehicleNotFoundException;
import com.champsoft.vrms2330097.modules.cars.application.port.out.VehicleRepositoryPort;
import com.champsoft.vrms2330097.modules.cars.domain.model.*;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class VehicleCrudService {
    private final VehicleRepositoryPort repo;
    public VehicleCrudService(VehicleRepositoryPort repo) {
        this.repo = repo;
    }
    @Transactional
    public Vehicle create(String vin, String make, String model, int year) {
        var v = new Vin(vin);
        if (repo.existsByVin(v)) throw new DuplicateVinException("VIN already exists: " + v.value());
        var vehicle = new Vehicle(VehicleId.newId(), v, new VehicleSpecs(make, model, year));
        return repo.save(vehicle);
    }
    @Transactional(readOnly = true)
    public Vehicle getById(String id) {
        return repo.findById(VehicleId.of(id))
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found: " + id));
    }
package com.plans.groundstationserver.satellite.controller;

import com.plans.groundstationserver.dto.SatellitePosition;
import com.plans.groundstationserver.model.Satellite;
import com.plans.groundstationserver.satellite.service.SatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/satellites")
public class SatelliteController {

    @Autowired
    private SatelliteService satelliteService;

    @GetMapping
    public List<Satellite> getAllSatellites() {
        return satelliteService.getAllSatellites();
    }

    @PostMapping
    public Satellite createSatellite(@RequestBody Satellite satellite) {
        return satelliteService.saveSatellite(satellite);
    }

    @GetMapping("/{id}")
    public Satellite getSatelliteById(@PathVariable Long id) {
        return satelliteService.getSatelliteById(id);
    }

    @PutMapping("/{id}")
    public Satellite updateSatellite(@PathVariable Long id, @RequestBody Satellite satellite) {
        return satelliteService.updateSatellite(id, satellite);
    }

    @DeleteMapping("/{id}")
    public void deleteSatellite(@PathVariable Long id) {
        satelliteService.deleteSatellite(id);
    }

    @GetMapping("/{id}/position")
    public SatellitePosition getSatellitePosition(@PathVariable Long id) {
        return satelliteService.getSatellitePosition(id);
    }
}

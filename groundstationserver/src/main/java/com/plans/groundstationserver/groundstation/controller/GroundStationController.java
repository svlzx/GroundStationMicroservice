package com.plans.groundstationserver.groundstation.controller;

import com.plans.groundstationserver.groundstation.service.GroundStationService;
import com.plans.groundstationserver.model.GroundStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groundstations")
public class GroundStationController {

    @Autowired
    private GroundStationService groundStationService;

    @GetMapping
    public List<GroundStation> getAllGroundStations() {
        return groundStationService.getAllGroundStations();
    }

    @PostMapping
    public GroundStation createGroundStation(@RequestBody GroundStation groundStation) {
        return groundStationService.saveGroundStation(groundStation);
    }

    @GetMapping("/{id}")
    public GroundStation getGroundStationById(@PathVariable Long id) {
        return groundStationService.getGroundStationById(id);
    }

    @PutMapping("/{id}")
    public GroundStation updateGroundStation(@PathVariable Long id, @RequestBody GroundStation groundStation) {
        return groundStationService.updateGroundStation(id, groundStation);
    }

    @DeleteMapping("/{id}")
    public void deleteGroundStation(@PathVariable Long id) {
        groundStationService.deleteGroundStation(id);
    }
}
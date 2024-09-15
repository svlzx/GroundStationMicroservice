package com.plans.groundstationserver.groundstation.service;

import com.plans.groundstationserver.model.GroundStation;
import com.plans.groundstationserver.repository.GroundStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroundStationService {

    @Autowired
    private GroundStationRepository groundStationRepository;

    public List<GroundStation> getAllGroundStations() {
        return groundStationRepository.findAll();
    }

    public GroundStation saveGroundStation(GroundStation groundStation) {
        return groundStationRepository.save(groundStation);
    }

    public GroundStation getGroundStationById(Long id) {
        return groundStationRepository.findById(id).orElse(null);
    }

    public GroundStation updateGroundStation(Long id, GroundStation groundStation) {
        GroundStation existingGroundStation = groundStationRepository.findById(id).orElse(null);
        if (existingGroundStation != null) {
            existingGroundStation.setName(groundStation.getName());
            existingGroundStation.setLatitude(groundStation.getLatitude());
            existingGroundStation.setLongitude(groundStation.getLongitude());
            existingGroundStation.setAltitude(groundStation.getAltitude());
            existingGroundStation.setAzimuth(groundStation.getAzimuth());
            existingGroundStation.setElevation(groundStation.getElevation());
            existingGroundStation.setAddress(groundStation.getAddress());
            return groundStationRepository.save(existingGroundStation);
        }
        return null;
    }

    public void deleteGroundStation(Long id) {
        groundStationRepository.deleteById(id);
    }
}
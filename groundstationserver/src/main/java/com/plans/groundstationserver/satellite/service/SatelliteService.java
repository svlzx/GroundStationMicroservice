package com.plans.groundstationserver.satellite.service;

import com.plans.groundstationserver.dto.SatellitePosition;
import com.plans.groundstationserver.model.Satellite;
import com.plans.groundstationserver.repository.SatelliteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SatelliteService {
    @Autowired
    private SatelliteRepository satelliteRepository;

    public List<Satellite> getAllSatellites() {
        return satelliteRepository.findAll();
    }

    public Satellite saveSatellite(Satellite satellite) {
        return satelliteRepository.save(satellite);
    }

    public Satellite getSatelliteById(Long id) {
        return satelliteRepository.findById(id).orElse(null);
    }

    public Satellite updateSatellite(Long id, Satellite satellite) {
        Satellite existingSatellite = satelliteRepository.findById(id).orElse(null);
        if (existingSatellite != null) {
            existingSatellite.setName(satellite.getName());
            existingSatellite.setType(satellite.getType());
            existingSatellite.setNoradId(satellite.getNoradId());
            existingSatellite.setLatitude(satellite.getLatitude());
            existingSatellite.setLongitude(satellite.getLongitude());
            existingSatellite.setAltitude(satellite.getAltitude());
            existingSatellite.setSpeed(satellite.getSpeed());
            existingSatellite.setAzimuth(satellite.getAzimuth());
            existingSatellite.setElevation(satellite.getElevation());
            existingSatellite.setRightAscension(satellite.getRightAscension());
            existingSatellite.setDeclination(satellite.getDeclination());
            return satelliteRepository.save(existingSatellite);
        }
        return null;
    }

    public void deleteSatellite(Long id) {
        satelliteRepository.deleteById(id);
    }

    public SatellitePosition getSatellitePosition(Long id) {
        Satellite satellite = satelliteRepository.findById(id).orElse(null);
        if (satellite != null) {
            SatellitePosition position = new SatellitePosition();
            position.setSatelliteId(satellite.getId());
            position.setLatitude(satellite.getLatitude());
            position.setLongitude(satellite.getLongitude());
            position.setAltitude(satellite.getAltitude());
            position.setSpeed(satellite.getSpeed());
            position.setAzimuth(satellite.getAzimuth());
            position.setElevation(satellite.getElevation());
            position.setRightAscension(satellite.getRightAscension().toString());
            position.setDeclination(satellite.getDeclination());
            return position;
        }
        return null;
    }
}
package com.plans.groundstationserver.repository;

import com.plans.groundstationserver.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
}
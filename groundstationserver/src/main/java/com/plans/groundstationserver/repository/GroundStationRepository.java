package com.plans.groundstationserver.repository;

import com.plans.groundstationserver.model.GroundStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroundStationRepository extends JpaRepository<GroundStation, Long> {
}

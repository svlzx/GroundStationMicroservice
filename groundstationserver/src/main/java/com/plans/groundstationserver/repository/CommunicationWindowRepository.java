package com.plans.groundstationserver.repository;

import com.plans.groundstationserver.model.CommunicationWindow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationWindowRepository extends JpaRepository<CommunicationWindow, Long> {
}

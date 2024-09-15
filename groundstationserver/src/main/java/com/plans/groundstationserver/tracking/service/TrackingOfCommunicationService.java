package com.plans.groundstationserver.tracking.service;

import com.plans.groundstationserver.model.TrackingOfCommunication;
import com.plans.groundstationserver.repository.TrackingOfCommunicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackingOfCommunicationService {

    private final TrackingOfCommunicationRepository trackingOfCommunicationRepository;

    public TrackingOfCommunicationService(TrackingOfCommunicationRepository trackingOfCommunicationRepository) {
        this.trackingOfCommunicationRepository = trackingOfCommunicationRepository;
    }

    public List<TrackingOfCommunication> getAllTrackingOfCommunications() {
        return trackingOfCommunicationRepository.findAll();
    }

    public TrackingOfCommunication getTrackingOfCommunicationById(Long id) {
        return trackingOfCommunicationRepository.findById(id).orElse(null);
    }

    public TrackingOfCommunication createTrackingOfCommunication(TrackingOfCommunication trackingOfCommunication) {
        return trackingOfCommunicationRepository.save(trackingOfCommunication);
    }

    public TrackingOfCommunication updateTrackingOfCommunication(Long id, TrackingOfCommunication trackingOfCommunication) {
        if (trackingOfCommunicationRepository.existsById(id)) {
            trackingOfCommunication.setId(id);
            return trackingOfCommunicationRepository.save(trackingOfCommunication);
        } else {
            return null;
        }
    }

    public boolean deleteTrackingOfCommunication(Long id) {
        if (trackingOfCommunicationRepository.existsById(id)) {
            trackingOfCommunicationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}


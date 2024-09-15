package com.plans.groundstationserver.tracking.controller;

import com.plans.groundstationserver.model.TrackingOfCommunication;
import com.plans.groundstationserver.tracking.service.TrackingOfCommunicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trackingofcommunications")
public class TrackingOfCommunicationController {

    private final TrackingOfCommunicationService trackingOfCommunicationService;

    public TrackingOfCommunicationController(TrackingOfCommunicationService trackingOfCommunicationService) {
        this.trackingOfCommunicationService = trackingOfCommunicationService;
    }

    @GetMapping
    public ResponseEntity<List<TrackingOfCommunication>> getAllTrackingOfCommunications() {
        List<TrackingOfCommunication> trackingRecords = trackingOfCommunicationService.getAllTrackingOfCommunications();
        return ResponseEntity.ok(trackingRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackingOfCommunication> getTrackingOfCommunicationById(@PathVariable Long id) {
        TrackingOfCommunication trackingRecord = trackingOfCommunicationService.getTrackingOfCommunicationById(id);
        if (trackingRecord != null) {
            return ResponseEntity.ok(trackingRecord);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TrackingOfCommunication> createTrackingOfCommunication(@RequestBody TrackingOfCommunication trackingOfCommunication) {
        TrackingOfCommunication createdTracking = trackingOfCommunicationService.createTrackingOfCommunication(trackingOfCommunication);
        return ResponseEntity.ok(createdTracking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrackingOfCommunication> updateTrackingOfCommunication(
            @PathVariable Long id,
            @RequestBody TrackingOfCommunication trackingOfCommunication) {
        TrackingOfCommunication updatedTracking = trackingOfCommunicationService.updateTrackingOfCommunication(id, trackingOfCommunication);
        if (updatedTracking != null) {
            return ResponseEntity.ok(updatedTracking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrackingOfCommunication(@PathVariable Long id) {
        boolean deleted = trackingOfCommunicationService.deleteTrackingOfCommunication(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

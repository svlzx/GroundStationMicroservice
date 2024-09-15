package com.plans.groundstationserver.communicationwindow.controller;

import com.plans.groundstationserver.communicationwindow.service.CommunicationWindowService;
import com.plans.groundstationserver.model.CommunicationWindow;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communicationwindows")
public class CommunicationWindowController {

    private final CommunicationWindowService communicationWindowService;

    public CommunicationWindowController(CommunicationWindowService communicationWindowService) {
        this.communicationWindowService = communicationWindowService;
    }

    @GetMapping
    public ResponseEntity<List<CommunicationWindow>> getAllCommunicationWindows() {
        List<CommunicationWindow> windows = communicationWindowService.getAllCommunicationWindows();
        return ResponseEntity.ok(windows);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunicationWindow> getCommunicationWindowById(@PathVariable Long id) {
        CommunicationWindow window = communicationWindowService.getCommunicationWindowById(id);
        if (window != null) {
            return ResponseEntity.ok(window);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CommunicationWindow> createCommunicationWindow(@RequestBody CommunicationWindow communicationWindow) {
        CommunicationWindow createdWindow = communicationWindowService.createCommunicationWindow(communicationWindow);
        return ResponseEntity.ok(createdWindow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommunicationWindow> updateCommunicationWindow(
            @PathVariable Long id,
            @RequestBody CommunicationWindow communicationWindow) {
        CommunicationWindow updatedWindow = communicationWindowService.updateCommunicationWindow(id, communicationWindow);
        if (updatedWindow != null) {
            return ResponseEntity.ok(updatedWindow);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunicationWindow(@PathVariable Long id) {
        boolean deleted = communicationWindowService.deleteCommunicationWindow(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


package com.plans.groundstationserver.communicationwindow.service;

import com.plans.groundstationserver.model.CommunicationWindow;
import com.plans.groundstationserver.repository.CommunicationWindowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationWindowService {

    private final CommunicationWindowRepository communicationWindowRepository;

    public CommunicationWindowService(CommunicationWindowRepository communicationWindowRepository) {
        this.communicationWindowRepository = communicationWindowRepository;
    }

    public List<CommunicationWindow> getAllCommunicationWindows() {
        return communicationWindowRepository.findAll();
    }

    public CommunicationWindow getCommunicationWindowById(Long id) {
        return communicationWindowRepository.findById(id).orElse(null);
    }

    public CommunicationWindow createCommunicationWindow(CommunicationWindow communicationWindow) {
        return communicationWindowRepository.save(communicationWindow);
    }

    public CommunicationWindow updateCommunicationWindow(Long id, CommunicationWindow communicationWindow) {
        if (communicationWindowRepository.existsById(id)) {
            communicationWindow.setId(id);
            return communicationWindowRepository.save(communicationWindow);
        } else {
            return null;
        }
    }

    public boolean deleteCommunicationWindow(Long id) {
        if (communicationWindowRepository.existsById(id)) {
            communicationWindowRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}


package com.plans.groundstationserver.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "communicationwindow")
public class CommunicationWindow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "starttime")
    private LocalDateTime startTime;

    @Column(name = "endtime")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "satelliteid")
    private Satellite satellite;

    @ManyToOne
    @JoinColumn(name = "groundstationid")
    private GroundStation groundStation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Satellite getSatellite() {
        return satellite;
    }

    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }

    public GroundStation getGroundStation() {
        return groundStation;
    }

    public void setGroundStation(GroundStation groundStation) {
        this.groundStation = groundStation;
    }
}


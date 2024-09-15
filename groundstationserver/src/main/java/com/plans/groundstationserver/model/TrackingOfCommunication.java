package com.plans.groundstationserver.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "trackingofcommunication")
public class TrackingOfCommunication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "groundstationid")
    private GroundStation groundStation;

    @ManyToOne
    @JoinColumn(name = "satelliteid")
    private Satellite satellite;

    @Column(name = "trackingstarttime")
    private LocalDateTime trackingStartTime;

    @Column(name = "trackingendtime")
    private LocalDateTime trackingEndTime;

    @Column(name = "azimuth")
    private Double azimuth;

    @Column(name = "elevation")
    private Double elevation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GroundStation getGroundStation() {
        return groundStation;
    }

    public void setGroundStation(GroundStation groundStation) {
        this.groundStation = groundStation;
    }

    public Satellite getSatellite() {
        return satellite;
    }

    public void setSatellite(Satellite satellite) {
        this.satellite = satellite;
    }

    public LocalDateTime getTrackingStartTime() {
        return trackingStartTime;
    }

    public void setTrackingStartTime(LocalDateTime trackingStartTime) {
        this.trackingStartTime = trackingStartTime;
    }

    public LocalDateTime getTrackingEndTime() {
        return trackingEndTime;
    }

    public void setTrackingEndTime(LocalDateTime trackingEndTime) {
        this.trackingEndTime = trackingEndTime;
    }

    public Double getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(Double azimuth) {
        this.azimuth = azimuth;
    }

    public Double getElevation() {
        return elevation;
    }

    public void setElevation(Double elevation) {
        this.elevation = elevation;
    }
}


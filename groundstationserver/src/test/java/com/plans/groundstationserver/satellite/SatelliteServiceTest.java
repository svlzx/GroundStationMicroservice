package com.plans.groundstationserver.satellite;

import com.plans.groundstationserver.model.Satellite;
import com.plans.groundstationserver.repository.SatelliteRepository;
import com.plans.groundstationserver.satellite.service.SatelliteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class SatelliteServiceTest {

    @Mock
    private SatelliteRepository satelliteRepository;

    @InjectMocks
    private SatelliteService satelliteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllSatellites() {
        // Arrange
        Satellite satellite1 = new Satellite();
        satellite1.setId(1L);
        satellite1.setName("CONNECTA T1.1");

        Satellite satellite2 = new Satellite();
        satellite2.setId(2L);
        satellite2.setName("CONNECTA T1.2");

        List<Satellite> satellites = Arrays.asList(satellite1, satellite2);
        when(satelliteRepository.findAll()).thenReturn(satellites);

        // Act
        List<Satellite> result = satelliteService.getAllSatellites();

        // Assert
        assertEquals(2, result.size());
        verify(satelliteRepository, times(1)).findAll();
    }

    @Test
    void testGetSatelliteById() {
        // Arrange
        Satellite satellite = new Satellite();
        satellite.setId(1L);
        satellite.setName("CONNECTA T1.1");
        when(satelliteRepository.findById(1L)).thenReturn(Optional.of(satellite));

        // Act
        Satellite result = satelliteService.getSatelliteById(1L);

        // Assert
        assertTrue(result != null);
        assertEquals("CONNECTA T1.1", result.getName());
        verify(satelliteRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveSatellite() {
        // Arrange
        Satellite satellite = new Satellite();
        satellite.setId(1L);
        satellite.setName("CONNECTA T1.1");
        when(satelliteRepository.save(satellite)).thenReturn(satellite);

        // Act
        Satellite result = satelliteService.saveSatellite(satellite);

        // Assert
        assertEquals("CONNECTA T1.1", result.getName());
        verify(satelliteRepository, times(1)).save(satellite);
    }

    @Test
    void testDeleteSatellite() {
        // Arrange
        Long id = 1L;

        // Act
        satelliteService.deleteSatellite(id);

        // Assert
        verify(satelliteRepository, times(1)).deleteById(id);
    }
}

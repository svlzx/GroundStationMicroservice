import React, { useEffect, useState } from 'react';
import { getSatellites } from '../api';

const SatelliteList = () => {
    const [satellites, setSatellites] = useState([]);

    useEffect(() => {
        const fetchSatellites = async () => {
            try {
                const response = await getSatellites();
                setSatellites(response.data);

            } catch (error) {
                console.error('Error fetching satellites:', error);
            }
        };

        fetchSatellites();
    }, []);

    return (
        <div>
            <h2>Satellites</h2>
            <ul>
                {satellites.map((satellite) => (
                    <li key={satellite.id}>{satellite.name} (NORAD ID: {satellite.id})</li>
                ))}
            </ul>
        </div>
    );
};

export default SatelliteList;

import React, { useEffect, useState } from 'react';
import { getGroundStations } from '../api';

const GroundStationList = () => {
    const [groundStations, setGroundStations] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchGroundStations = async () => {
            try {
                const response = await getGroundStations(); // Adjust the URL as needed
                setGroundStations(response.data);
            } catch (error) {
                setError('Failed to fetch ground stations');
                console.error('Error fetching ground stations:', error);
            }
        };

        fetchGroundStations();
    }, []);

    return (
        <div>
            <h2>Ground Stations</h2>
            {error && <p>{error}</p>}
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Station ID</th>
                    <th>Address</th>
                    <th>Latitude</th>
                    <th>Longitude</th>
                </tr>
                </thead>
                <tbody>
                {groundStations.map((station) => (
                    <tr key={station.id}>
                        <td>{station.id}</td>
                        <td>{station.name}</td>
                        <td>{station.stationId}</td>
                        <td>{station.address}</td>
                        <td>{station.latitude}</td>
                        <td>{station.longitude}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default GroundStationList;

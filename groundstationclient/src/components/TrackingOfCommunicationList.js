import React, { useEffect, useState } from 'react';
import { getTrackingOfCommunications } from '../api';

const TrackingOfCommunicationList = () => {
    const [trackingRecords, setTrackingRecords] = useState([]);
    const [error, setError] = useState('');

    useEffect(() => {
        const fetchTrackingRecords = async () => {
            try {
                const response = await getTrackingOfCommunications(); // Adjust the URL as needed
                setTrackingRecords(response.data);
            } catch (error) {
                setError('Failed to fetch tracking records');
                console.error('Error fetching tracking records:', error);
            }
        };

        fetchTrackingRecords();
    }, []);

    return (
        <div>
            <h2>Tracking Communications</h2>
            {error && <p>{error}</p>}
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Ground Station ID</th>
                    <th>Satellite ID</th>
                    <th>Tracking Start Time</th>
                    <th>Tracking End Time</th>
                    <th>Azimuth</th>
                    <th>Elevation</th>
                </tr>
                </thead>
                <tbody>
                {trackingRecords.map((record) => (
                    <tr key={record.id}>
                        <td>{record.id}</td>
                        <td>{record.groundStationId}</td>
                        <td>{record.satelliteId}</td>
                        <td>{new Date(record.trackingStartTime).toLocaleString()}</td>
                        <td>{new Date(record.trackingEndTime).toLocaleString()}</td>
                        <td>{record.azimuth}</td>
                        <td>{record.elevation}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default TrackingOfCommunicationList;

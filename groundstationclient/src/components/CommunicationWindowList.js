import React, { useEffect, useState } from 'react';
import { getCommunicationWindows } from '../api';

const CommunicationWindowList = () => {
    const [windows, setWindows] = useState([]);

    useEffect(() => {
        const fetchWindows = async () => {
            try {
                const response = await getCommunicationWindows();
                setWindows(response.data);
            } catch (error) {
                console.error('Error fetching communication windows:', error);
            }
        };

        fetchWindows();
    }, []);

    return (
        <div>
            <h2>Communication Windows</h2>
            <ul>
                {windows.map((window) => (
                    <li key={window.id}>
                        {window.startTime} - {window.endTime}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default CommunicationWindowList;

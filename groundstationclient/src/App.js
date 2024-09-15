import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { AuthProvider } from './context/AuthContext';
import LoginPage from './components/LoginPage';
import SatelliteList from './components/SatelliteList';
import CommunicationWindowList from './components/CommunicationWindowList';
import GroundStationList from './components/GroundStationList';
import TrackingOfCommunicationList from "./components/TrackingOfCommunicationList";
import NavBar from './NavBar'; // Import the NavBar component

const App = () => {
    return (
        <Router> {/* Router bileşeni en üst düzeyde olmalı */}
            <NavBar /> {/* Include the NavBar component */}
            <AuthProvider>
                <Routes>
                    <Route path="/api/auth/login" element={<LoginPage />} />
                    <Route path="/satellites" element={<SatelliteList />} />
                    <Route path="/ground-stations" element={<GroundStationList />} />
                    <Route path="/communication-windows" element={<CommunicationWindowList />} />
                    <Route path="/tracking-of-communications" element={<TrackingOfCommunicationList />} />
                </Routes>
            </AuthProvider>
        </Router>
    );
};

export default App;

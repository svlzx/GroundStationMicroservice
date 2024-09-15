import axios from 'axios';

const API_URL = 'http://localhost:8080'; // Spring Boot mikroservisinizin adresi

const api = axios.create({
    baseURL: API_URL,
    // Burada authentication veya başka bir konfigürasyon ekleyebiliriz
});

// API çağrıları
export const login = (credentials) => api.post('/api/auth/login', credentials);
export const getSatellites = () => api.get('/satellites');
export const getGroundStations = () => api.get('/groundstations');
export const getCommunicationWindows = () => api.get('/communicationwindows');
export const getTrackingOfCommunications = () => api.get('/trackingofcommunications');

// Örnek API çağrıları
export const getSatelliteById = (id) => api.get(`/satellites/${id}`);
export const createSatellite = (data) => api.post('/satellites', data);
export const updateSatellite = (id, data) => api.put(`/satellites/${id}`, data);
export const deleteSatellite = (id) => api.delete(`/satellites/${id}`);

export const getGroundStationById = (id) => api.get(`/groundstations/${id}`);
export const createGroundStation = (data) => api.post('/groundstations', data);
export const updateGroundStation = (id, data) => api.put(`/groundstations/${id}`, data);
export const deleteGroundStation = (id) => api.delete(`/groundstations/${id}`);

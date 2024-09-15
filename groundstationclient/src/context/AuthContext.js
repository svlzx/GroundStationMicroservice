import React, { createContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { login as loginApi } from '../api';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [auth, setAuth] = useState(null);
    const navigate = useNavigate();

    const login = async (credentials) => {
        try {
            const response = await loginApi(credentials);
            setAuth(response.data);
            navigate('/satellites'); // Redirect to satellite list page after login
        } catch (error) {
            console.error('Login failed:', error);
        }
    };

    const logout = () => {
        setAuth(null);
        navigate('/');
    };

    return (
        <AuthContext.Provider value={{ auth, login, logout }}>
            {children}
        </AuthContext.Provider>
    );
};

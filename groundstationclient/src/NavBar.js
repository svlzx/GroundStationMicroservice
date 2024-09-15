// src/NavBar.js
import React from 'react';
import { Link } from 'react-router-dom';

const NavBar = () => {
    return (
        <nav>
            <ul className="navbar">
                <li><Link to="/">Home</Link></li>
                <li><Link to="/satellites">Satellites</Link></li>
                <li><Link to="/ground-stations">Ground Stations</Link></li>
                <li><Link to="/communication-windows">Communication Windows</Link></li>
                <li><Link to="/tracking-of-communications">Tracking Of Communications</Link></li>
                <li><Link to="/api/auth/login">Login</Link></li>
            </ul>
            <style jsx>{`
                nav {
                    background: #333;
                    color: white;
                    padding: 10px;
                }
                ul.navbar {
                    list-style: none;
                    margin: 0;
                    padding: 0;
                    display: flex;
                }
                .navbar li {
                    margin-right: 30px;
                }
                .navbar a {
                    color: white;
                    text-decoration: none;
                }
                .navbar a:hover {
                    text-decoration: underline;
                }
            `}</style>
        </nav>
    );
};

export default NavBar;

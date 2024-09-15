<h1 align="center">Satellite-Based Communication Service Application</h1>
<p>
  Satellite-based communication services to provide end-to-end connectivity between IoT devices located anywhere in the world and their corresponding end-users. We have numerous satellites orbiting in the sky and multiple ground stations placed on Earth.
</p>
<p>The Pandemic Blockchain Project is the new innovative healthCare ecosystem built upon Ethereum network and IPFS technology.</p>

## GroundStationServer Microservice

Satellite Service: Calculates the orbit information and positions of LEO satellites. This service updates the Satellite table.

Ground Station Service: Manages the positions and antenna rotators of ground stations. This service updates the GroundStation table.

Communication Window Service: Calculates the communication windows between satellites and ground stations. This service updates the CommunicationWindow table.

Tracking Of Communication Service: Allows ground stations to track satellites and sends necessary control signals. This service updates the TrackingOfCommunication table.

* Technology Used:
	+ Java 17, Spring Boot 3.3.2, Spring 6, Jakarta 6
	+ PostgreSQL 15.7
	+ IntellijIDEA Ultimate 2024.01

* How To Run:
	+ Select GroundStationServerApplication and Run

## GroundStationClient Microservice

* Technology Used:
	+ React
	+ IntellijIDEA Ultimate 2024.01

* How To Run:
	+ Open CMD and go to project directory. Then run command:
	+ \GroundStationMicroservice\groundstationclient> npm start


## Authors

👤 Seval Capraz

## Show your support

Give a ⭐️ if this project helped you!

## 📝 License

Copyright © 2024.<br/>
This project is [MIT](https://github.com/svlzx/GroundStationMicroservice/blob/master/LICENCE.txt) licensed.
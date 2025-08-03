# Converter Game - Full Stack Application

A unit conversion game implemented using **Java Spring Boot** for the backend and **React with Vite** for the frontend.

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Backend Setup](#backend-setup)
  - [Frontend Setup](#frontend-setup)
- [Running the Project](#running-the-project)
- [Features](#features)
- [Future Enhancements](#future-enhancements)
- [License](#license)

## Project Overview

This project is a converter game that allows users to select different types of unit conversions (e.g., meters to kilometers, liters to milliliters, Celsius to Fahrenheit), enter values, get converted results, guess answers, and track scores.

The backend is built using Java Spring Boot, applying core OOP principles for modularity and scalability. The frontend is built with React and uses Vite as the build tool for fast, modern development experience, and Material UI components for an attractive interface.

## Technologies Used

- **Backend:** Java 21, Spring Boot 3.1, Maven
- **Frontend:** React 18.x, Vite, Material UI (@mui)
- **Tools:** Node.js v22.18.0, npm

## Project Structure

```bash

backend-java-convertergame/
├── src/main/java/com/example/convertergame/ # Backend source code (Java)
│ ├── Converter.java
│ ├── MeterToKilometerConverter.java
│ ├── LiterToMilliliterConverter.java
│ ├── CelsiusToFahrenheitConverter.java
│ ├── Player.java
│ ├── GameController.java
│ └── ConverterGameApplication.java
├── pom.xml # Maven project configuration

frontend-react/
├── src/
│ ├── App.jsx # Main React component
│ ├── main.jsx # React entry point
│ └── index.css # Basic styles
├── vite.config.js # Vite configuration and proxy
├── package.json # Frontend dependencies and scripts
└── index.html # HTML entry

```

## Getting Started

### Prerequisites

- Java JDK 21 or above
- Maven 3.8+
- Node.js v22.18.0 or higher (with npm)
- Code editor (VS Code, IntelliJ IDEA, etc.)

### Backend Setup

1. Navigate to the backend folder:

```bash

cd backend-java-convertergame

```

2. Build and run the backend Spring Boot app:

```bash

mvn clean install
mvn spring-boot:run

```

> The backend will start at `http://localhost:8080`.

### Frontend Setup

1. Navigate to the frontend folder:
   
```bash

cd frontend-react

```
2. Install frontend dependencies:

```bash

npm install

```


3. Start the Vite development server:

```bash

npm run dev

```


> Frontend will be available at `http://localhost:5173`.

## Running the Project

Ensure both backend (`http://localhost:8080`) and frontend (`http://localhost:5173`) servers are running simultaneously.

The React frontend communicates with the backend via REST API to fetch converter types, perform conversions, and validate user answers.

## Features

- Multiple unit conversion types with modular backend converters
- User score tracking and feedback
- Responsive UI with Material UI components
- Fast hot-reloading development experience using Vite
- Proxy setup to avoid CORS issues between frontend and backend

## Future Enhancements

- Add user authentication and persistent score storage
- Expand conversion types and implement additional game mechanics
- Deploy full stack app to cloud platforms for public access
- Improve UI/UX with animations and sound feedback

## License

This project is open source and licensed under the MIT License.

---

## Contact

Connect with me on LinkedIn: [Ankit Yadav](https://www.linkedin.com/in/ankit-yadav-063216265/)

Or email me at: [a.k.chaudhary9838@gmail.com](mailto:a.k.chaudhary9838@gmail.com)


---
**Feel free to use or adapt this project. Contributions and feedback are welcome!**

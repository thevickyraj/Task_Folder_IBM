// Import Express
const express = require("express");

// Import dotenv
// This loads variables from the .env file into process.env
require("dotenv").config();

// Initialize the Express application
const app = express();

// Serve static files (CSS, images) from the "public" folder
app.use(express.static('public'));


// Function to get weather information
async function getWeather(city) {

    try {

        // Use Open-Meteo geocoding to get coordinates for the city
        const geoRes = await fetch(
            `https://geocoding-api.open-meteo.com/v1/search?name=${encodeURIComponent(city)}&count=1`
        );
        const geoData = await geoRes.json();

        if (!geoRes.ok || !geoData.results || geoData.results.length === 0) {
            throw new Error('Location not found');
        }

        const loc = geoData.results[0];
        const lat = loc.latitude;
        const lon = loc.longitude;
        const displayName = loc.name + (loc.country ? `, ${loc.country}` : '');

        // Fetch current weather from Open-Meteo (no API key required)
        const weatherRes = await fetch(
            `https://api.open-meteo.com/v1/forecast?latitude=${lat}&longitude=${lon}&current_weather=true&timezone=auto`
        );
        const weatherJson = await weatherRes.json();

        if (!weatherRes.ok || !weatherJson.current_weather) {
            throw new Error('Unable to fetch weather from Open-Meteo');
        }

        const current = weatherJson.current_weather;

        // Map common weather codes to human-friendly text
        const codeMap = {
            0: 'Clear sky',
            1: 'Mainly clear',
            2: 'Partly cloudy',
            3: 'Overcast',
            45: 'Fog',
            48: 'Depositing rime fog',
            51: 'Light drizzle',
            53: 'Moderate drizzle',
            55: 'Dense drizzle',
            61: 'Slight rain',
            63: 'Moderate rain',
            65: 'Heavy rain',
            71: 'Slight snow',
            73: 'Moderate snow',
            75: 'Heavy snow',
            80: 'Rain showers',
            81: 'Heavy rain showers',
            82: 'Violent rain showers',
            95: 'Thunderstorm',
            96: 'Thunderstorm with hail',
            99: 'Thunderstorm with heavy hail'
        };

        return {
            city: displayName,
            forecast: codeMap[current.weathercode] || `Weather code ${current.weathercode}`,
            temperature: current.temperature,
            windspeed: current.windspeed,
            winddirection: current.winddirection
        };

    } catch (error) {

        // Handle errors
        return {
            error: error.message
        };
    }
}


// Weather route
app.get("/weather", async (req, res) => {

    // Get city from query parameter.
    // If city is not provided, use Bengaluru.
    const city = req.query.city || "Bengaluru";

    // Call the asynchronous weather function
    const weatherData = await getWeather(city);

    // Send weather information as JSON
    res.json(weatherData);
});


// Start the server (use port 3005 to avoid conflicts)
const PORT = process.env.PORT || 3005;
app.listen(PORT, () => {
    console.log(`Weather server is running on port ${PORT}`);
});
document.getElementById("getWeather").addEventListener("click", async () => {
    const lat = document.getElementById("latitude").value;
    const lon = document.getElementById("longitude").value;
    const resultDiv = document.getElementById("result");

    if (!lat || !lon) {
        resultDiv.innerHTML = "<p>Please enter both latitude and longitude.</p>";
        return;
    }

    try {
        const response = await fetch(`/api/weather/${lat}/${lon}`);
        const data = await response.json();

        if (data.current_weather) {
            resultDiv.innerHTML = `
                <p><strong>Temperature:</strong> ${data.current_weather.temperature} °C</p>
                <p><strong>Wind Speed:</strong> ${data.current_weather.windspeed} km/h</p>
                <p><strong>Weather Code:</strong> ${data.current_weather.weathercode}</p>
            `;
        } else {
            resultDiv.innerHTML = `<p>No weather data found for these coordinates.</p>`;
        }
    } catch (error) {
        console.error(error);
        resultDiv.innerHTML = "<p>Error fetching weather data.</p>";
    }
});
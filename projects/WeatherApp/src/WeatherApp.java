// retreive weather app data from API - this backend logic will fetch the latest weather
// data from the external API and return ir. The GUI will display this data to the user

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {
    // fetch weather data for given location
    public static JSONObject getWeatherData(String locationName) {
        // get location coordinates using the geolocation API
        JSONArray locationData = getLocationData(locationName);
    }

    // retrieves geographic coordinates for given location name
    private static JSONArray getLocationData(String locationName) {
        // replace any whitespace in location name to + to adhere to APIs request format
        locationName = locationName.replaceAll(" ", "+");

        // build API url with location parameter https://geocoding-api.open-meteo.com/v1/search?name=Berlin&count=10&language=en&format=json
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name=" +
                 locationName +"&count=10&language=en&format=json";

        try {
            // call api and get a response
            HttpURLConnection connection = fetchAPIResponse(urlString);
        }catch (Exception e) {
            e.printStackTrace();
        }

        privat static HttpURLConnection fetchAPIResponse(String urlString) {
            try{
                // attemp to create connection
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            }
        }
    }
}

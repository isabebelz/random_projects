// retreive weather app data from API - this backend logic will fetch the latest weather
// data from the external API and return ir. The GUI will display this data to the user

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

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

            // check response status
            // 200 means successful connection
            if(connection.getResponseCode() != 200) {
                System.out.println("Error: Could not connect to API");
                return null;
            } else {
                // store the API results
                StringBuilder resultJson = new StringBuilder();
                Scanner sc = new Scanner(connection.getInputStream());

                // read and store the resulting json data into our string builder
                while (sc.hasNext()) {
                    resultJson.append(sc.nextLine());
                }

                sc.close();

                // close url connection
                connection.disconnect();

                // parse the JSON string into a JSON obj
                JSONParser parser = new JSONParser();
                JSONObject resultsJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                // get the list of location data the API generated from the location name
                JSONArray locationData = (JSONArray) resultsJsonObj.get("results");
                return locationData;
            }


        }catch (Exception e) {
            e.printStackTrace();
        }

        private static HttpURLConnection fetchAPIResponse(String urlString) {
            try{
                // attemp to create connection
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // set request method to get
                connection.setRequestMethod("GET");

                // connect to our API
                connection.connect();
                return connection;

            } catch (IOException e) {
                e.printStackTrace();
            }

            // could not make connection
            return null;
        }
    }
}

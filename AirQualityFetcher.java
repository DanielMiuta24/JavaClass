import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AirQualityFetcher {

    private String lat;
    private String lon;
    private String apiKey;

    // Constructor
    public AirQualityFetcher(String lat, String lon, String apiKey) {
        this.lat = lat;
        this.lon = lon;
        this.apiKey = apiKey;
    }

    // Method to fetch air quality data and return the response
    public String fetchAirQualityData() {
        String apiUrl = "http://api.openweathermap.org/data/2.5/air_pollution?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;

        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                conn.disconnect();

                return response.toString();  // Return the response JSON
            } else {
                return "Error: GET request failed. Response code: " + responseCode;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: Exception occurred while fetching data.";
        }
    }
}

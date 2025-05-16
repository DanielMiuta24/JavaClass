import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class AirQualityProcessor {
    public static void main(String[] args) {
        
        String lat = "45.8150";  // Zagreb latitude
        String lon = "15.9819";  // Zagreb longitude
        String apiKey = "58db9169cfed00922766afd73530ba0b"; 

        
        AirQualityFetcher fetcher = new AirQualityFetcher(lat, lon, apiKey);
        String airQualityData = fetcher.fetchAirQualityData();

        
        if (airQualityData == null || airQualityData.isEmpty()) {
            System.out.println("Error: No data received from the API.");
            return;
        }

        
        Gson gson = new Gson();
        try {
            JsonObject jsonObject = gson.fromJson(airQualityData, JsonObject.class);

            
            if (jsonObject.has("list") && jsonObject.getAsJsonArray("list").size() > 0) {
                JsonObject components = jsonObject
                    .getAsJsonArray("list")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("components");

                
                double pm25 = components.has("pm2_5") ? components.get("pm2_5").getAsDouble() : 0.0;
                double pm10 = components.has("pm10") ? components.get("pm10").getAsDouble() : 0.0;
                double co = components.has("co") ? components.get("co").getAsDouble() : 0.0;
                double no2 = components.has("no2") ? components.get("no2").getAsDouble() : 0.0;
                double so2 = components.has("so2") ? components.get("so2").getAsDouble() : 0.0;

               
                System.out.println("Air Quality Data for Location:");
                System.out.println("PM2.5: " + pm25 + " µg/m³");
                System.out.println("PM10: " + pm10 + " µg/m³");
                System.out.println("CO: " + co + " µg/m³");
                System.out.println("NO2: " + no2 + " µg/m³");
                System.out.println("SO2: " + so2 + " µg/m³");
                Map<String, Double> pollutionData = new HashMap<>();
        pollutionData.put("pm2_5", components.get("pm2_5").getAsDouble());
        pollutionData.put("pm10", components.get("pm10").getAsDouble());
        pollutionData.put("co", components.get("co").getAsDouble());
        pollutionData.put("no2", components.get("no2").getAsDouble());
        pollutionData.put("so2", components.get("so2").getAsDouble());

        
        HeatmapGenerator.setPollutionData(pollutionData);
        HeatmapGenerator.main(args);
            } else {
                System.out.println("Error: Invalid response structure from API.");
            }
        } catch (Exception e) {
            System.out.println("Error parsing air quality data: " + e.getMessage());
        }
    }
}

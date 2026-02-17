package com.ecodrive.ai;

import java.net.URI;
import java.net.http.*;
import org.json.JSONObject; // This requires the dependency in pom.xml

public class EcoCoach {
    // Make sure your .env file has GEMINI_API_KEY=your_key_here
    private static final String API_KEY = System.getenv("GEMINI_API_KEY");
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent?key=" + API_KEY;

    public String getEcoAdvice(double distance, double load, String fuelType) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String prompt = String.format("Driving %s for %.1f km with %.1f kg load. Give one short eco-tip.", fuelType, distance, load);
            String jsonRequest = "{\"contents\": [{\"parts\": [{\"text\": \"" + prompt + "\"}]}]}";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());

            return jsonResponse.getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");
        } catch (Exception e) {
            // This is the message you are currently seeing in the UI
            return "Eco-Coach is currently offline. Drive smoothly to save fuel!";
        }
    }
}
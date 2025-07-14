import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * WeatherFetcher
 *
 * A simple Java application that consumes a public REST API (OpenWeatherMap)
 * to fetch weather data for a given city and displays the data in a structured format.
 *
 * Features:
 * - HTTP GET request to the API
 * - Parses JSON response (simple string extraction)
 * - Displays description and temperature (in Celsius)
 *
 * Note: Requires a valid OpenWeatherMap API key.
 */
public class WeatherFetcher {

    /**
     * Main method to run the program.
     * Prompts the user for a city name and fetches weather data.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter the city name
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();

        // Your OpenWeatherMap API Key (replace with your valid key)
        String apiKey = "60725fbeeb5027cbacd5b752e23f8675";

        // Call the method to fetch and display weather
        fetchWeather(city, apiKey);

        scanner.close();
    }

    /**
     * Makes an HTTP GET request to the OpenWeatherMap API,
     * retrieves weather data, extracts relevant fields,
     * and prints a structured weather report.
     *
     * @param city   the city name to fetch weather for
     * @param apiKey your OpenWeatherMap API key
     */
    public static void fetchWeather(String city, String apiKey) {
        try {
            // Build the URL with city and API key
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + apiKey;

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();

            // Handle common error responses
            if (responseCode == 401) {
                System.out.println("Error: Unauthorized. Invalid API Key.");
                return;
            } else if (responseCode == 404) {
                System.out.println("Error: City not found.");
                return;
            } else if (responseCode != 200) {
                System.out.println("Error: Server returned response code " + responseCode);
                return;
            }

            // Read the response from the API
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String jsonResponse = response.toString();

            // Extract required fields from the JSON response
            String description = extractBetween(jsonResponse, "\"description\":\"", "\"");
            String tempStr = extractBetween(jsonResponse, "\"temp\":", ",");

            // Convert temperature from Kelvin to Celsius
            double tempKelvin = Double.parseDouble(tempStr);
            double tempCelsius = tempKelvin - 273.15;

            // Print the structured weather report
            System.out.println("\n---------------- Weather Report ----------------");
            System.out.printf("City        : %s\n", city);
            System.out.printf("Description : %s\n", capitalize(description));
            System.out.printf("Temperature : %.2f °C\n", tempCelsius);
            System.out.println("------------------------------------------------");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Helper method to extract a substring between two markers in text.
     *
     * @param text  the full text to search in
     * @param start the starting delimiter
     * @param end   the ending delimiter
     * @return extracted substring or "Not found" if markers are missing
     */
    private static String extractBetween(String text, String start, String end) {
        int startIdx = text.indexOf(start);
        if (startIdx == -1) return "Not found";
        startIdx += start.length();
        int endIdx = text.indexOf(end, startIdx);
        if (endIdx == -1) return "Not found";
        return text.substring(startIdx, endIdx);
    }

    /**
     * Helper method to capitalize the first letter of a string.
     *
     * @param text the input string
     * @return the string with the first letter capitalized
     */
    private static String capitalize(String text) {
        if (text == null || text.isEmpty()) return text;
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;


public class ChatbotWithWebSearch {

    //  Google API Key
    private static final String API_KEY = "AIzaSyDYqZglUABdOFxQZbW88j1JC5zFBC_8UUI";

    // Custom Search Engine ID
    private static final String CX = "20b31719a47e84d76";

    public static void main(String[] args) {
        System.out.println("Hello! I am your chatbot. How can I assist you?");
        System.out.println("You can ask me to search something by typing 'search <your query>'. Type 'exit' to quit.");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String userInput;

            while (true) {
                System.out.print("You: ");
                userInput = reader.readLine().trim();

                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Chatbot: Goodbye!");
                    break;
                } else if (userInput.startsWith("search ")) {
                    String query = userInput.substring(7).trim();
                    if (!query.isEmpty()) {
                        System.out.println("Chatbot: Searching for \"" + query + "\"...");
                        searchWeb(query);
                    } else {
                        System.out.println("Chatbot: Please enter a valid search query.");
                    }
                } else {
                    System.out.println("Chatbot: Sorry, I didn't understand that. Try using 'search <your query>'.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchWeb(String query) {
        try {
            // Construct the search URL
            String urlString = String.format(
                "https://www.googleapis.com/customsearch/v1?key=%s&cx=%s&q=%s",
                API_KEY, CX, query.replace(" ", "%20")
            );

            // Make the HTTP GET request
            @SuppressWarnings("deprecation")
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Check for a successful response
            if (conn.getResponseCode() == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // Parse and display results
                parseAndDisplayResults(response.toString());
            } else {
                System.out.println("Chatbot: Failed to fetch results. HTTP error code: " + conn.getResponseCode());
            }

            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Chatbot: An error occurred while searching. Please try again.");
            e.printStackTrace();
        }
    }

    private static void parseAndDisplayResults(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray items = jsonObject.optJSONArray("items");

            if (items != null && items.length() > 0) {
                System.out.println("Chatbot: Here are the top search results:");
                for (int i = 0; i < Math.min(items.length(), 5); i++) { // Show top 5 results
                    JSONObject item = items.getJSONObject(i);
                    String title = item.optString("title");
                    String link = item.optString("link");
                    System.out.println((i + 1) + ". " + title);
                    System.out.println("   " + link);
                }
            } else {
                System.out.println("Chatbot: No results found for your query.");
            }
        } catch (Exception e) {
            System.out.println("Chatbot: An error occurred while parsing search results.");
            e.printStackTrace();
        }
    }
}

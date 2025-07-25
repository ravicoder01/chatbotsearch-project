# 🤖 Java Chatbot with Google Web Search

This is a **command-line chatbot** built in Java that can perform real-time **Google web searches** using the **Google Custom Search API**. You can interact with the bot by typing search queries directly in your terminal.

---

## 🚀 Features

- ✅ Command-line chatbot interface
- 🔍 Searches the web using Google Custom Search API
- 📜 Parses and displays the **top 5 search results**
- ❌ Handles invalid input and API errors gracefully

---

## 📸 Demo

Hello! I am your chatbot. How can I assist you?
You can ask me to search something by typing 'search <your query>'. Type 'exit' to quit.

You: search how to make tea
Chatbot: Searching for "how to make tea"...
Chatbot: Here are the top search results:

How to Make the Perfect Cup of Tea
https://example.com/tea1

Traditional Indian Tea Recipe
https://example.com/tea2
...

yaml
Copy
Edit

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Google Custom Search JSON API
- JSON Parsing via `org.json` library

---

## 🔑 Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/chatbot-web-search.git
cd chatbot-web-search
2. Prerequisites
Java 8 or above installed

Internet access (since it makes API requests)

An API key and Custom Search Engine (CSE) ID from Google

3. Replace API Credentials
Open the Java file and update the following constants with your credentials:

java
Copy
Edit
private static final String API_KEY = "YOUR_GOOGLE_API_KEY";
private static final String CX = "YOUR_CUSTOM_SEARCH_ENGINE_ID";
You can get these from:

Google Cloud Console

Custom Search JSON API

▶️ How to Run
Compile the program:

bash
Copy
Edit
javac ChatbotWithWebSearch.java
Run the program:

bash
Copy
Edit
java ChatbotWithWebSearch

📂 Project Structure
lua
Copy
Edit
ChatbotWithWebSearch.java   <-- Main program file
README.md                 <-- Project documentation

🙋‍♂️ How It Works
The user types: search <your query>

The chatbot constructs an API request to Google’s Custom Search API.

It fetches results in JSON format.

Parses the top 5 results and prints title + link.

⚠️ Notes
Make sure you don’t exceed your API quota on Google.

This is a basic prototype and doesn’t include advanced NLP/chat logic.

📌 Future Improvements
Integrate NLP for better chatbot understanding.

Add GUI using JavaFX or Swing.

Allow voice-based interaction.

Implement search history or caching.

📃 License
This project is open-source and available under the MIT License.

👨‍💻 Author
Made with ❤️ by Ravi Raj

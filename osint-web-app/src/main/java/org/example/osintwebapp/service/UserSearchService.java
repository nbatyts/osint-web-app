package org.example.osintwebapp.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserSearchService {
    private static final String GITHUB_URL = "https://api.github.com/users/";
    private static final String TWITTER_URL = "https://api.twitter.com/2/users/by/username/";
    private static final String REDDIT_URL = "https://www.reddit.com/user/";
    private static final String TELEGRAM_URL = "https://t.me/";

    @Value("${twitter.bearer.token}")
    private String bearerToken;

    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public Map<String, String> searchUserAccounts(String username) {
        Map<String, String> result = new HashMap<>();

        // Check GitHub
        String githubUrl = GITHUB_URL + username;
        try {
            HttpResponse response = sendHttpRequest(githubUrl);
            if (response.getStatusLine().getStatusCode() == 200) {
                result.put("github", "https://github.com/" + username);
            } else {
                result.put("github", "Не знайдено");
            }
        } catch (IOException e) {
            result.put("github", "Помилка підключення");
        }

        // Check Twitter
        String twitterApiUrl = TWITTER_URL + username;
        HttpGet twitterRequest = new HttpGet(twitterApiUrl);
        twitterRequest.setHeader("Authorization", bearerToken);

        try {
            HttpResponse response = httpClient.execute(twitterRequest);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                result.put("twitter", "https://twitter.com/" + username);
            } else if (statusCode == 404) {
                result.put("twitter", "Не знайдено");
            } else {
                result.put("twitter", "Помилка: " + statusCode);
            }
        } catch (IOException e) {
            result.put("twitter", "Помилка підключення");
        }

        // Check Reddit
        String redditUrl = REDDIT_URL + username + "/about.json";
        try {
            HttpResponse response = sendHttpRequest(redditUrl);
            if (response.getStatusLine().getStatusCode() == 200) {
                result.put("reddit", "https://www.reddit.com/user/" + username);
            } else {
                result.put("reddit", "Не знайдено");
            }
        } catch (IOException e) {
            result.put("reddit", "Помилка підключення");
        }

        // Check Telegram
        String telegramUrl = TELEGRAM_URL + username;
        try {
            HttpResponse response = sendHttpRequest(telegramUrl);
            if (response.getStatusLine().getStatusCode() == 200) {
                result.put("telegram", "https://t.me/" + username);
            } else {
                result.put("telegram", "Не знайдено");
            }
        } catch (IOException e) {
            result.put("telegram", "Помилка підключення");
        }

        return result;
    }

    // Helper method to send HTTP requests and return the response
    private HttpResponse sendHttpRequest(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return httpClient.execute(request);
    }
}

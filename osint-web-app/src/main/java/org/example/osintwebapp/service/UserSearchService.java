package org.example.osintwebapp.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

@Service
public class UserSearchService {
    private static final String GITHUB_URL = "https://api.github.com/users/";
    private static final String TWITTER_URL = "https://api.twitter.com/2/users/by/username/";
    private static final String REDDIT_URL = "https://www.reddit.com/user/";
    private static final String TELEGRAM_URL = "https://t.me/";

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
            result.put("github", "Не знайдено");
        }

        // Check Twitter
        String twitterUrl = TWITTER_URL + username;
        try {
            HttpResponse response = sendHttpRequest(twitterUrl);
            if (response.getStatusLine().getStatusCode() == 200) {
                result.put("twitter", "https://twitter.com/" + username);
            } else {
                result.put("twitter", "Не знайдено");
            }
        } catch (IOException e) {
            result.put("twitter", "Не знайдено");
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
            result.put("reddit", "Не знайдено");
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
            result.put("telegram", "Не знайдено");
        }

        return result;
    }

    // Helper method to send HTTP requests and return the response
    private HttpResponse sendHttpRequest(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return httpClient.execute(request);
    }
}

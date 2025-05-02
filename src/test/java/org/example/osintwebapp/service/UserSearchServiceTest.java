package org.example.osintwebapp.service;

import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserSearchServiceTest {
    @Autowired
    private UserSearchService userSearchService;

    @Test
    public void testSearchUserAccounts() {
        String token = System.getenv("BEARER_TOKEN");
        assertNotNull(token, "Token must be set in the environment variable BEARER_TOKEN");

        Map<String, String> result = userSearchService.searchUserAccounts("kateryna");

        assertNotNull(result);
        assertTrue(result.containsKey("github"));
        assertTrue(result.containsKey("reddit"));
        assertTrue(result.containsKey("twitter"));
        assertTrue(result.containsKey("telegram"));
    }
}

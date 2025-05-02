package org.example.osintwebapp.controller;

import java.util.Map;
import org.example.osintwebapp.model.SearchRequest;
import org.example.osintwebapp.service.UserSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserSearchController {

    private final UserSearchService userSearchService;

    @Autowired
    public UserSearchController(UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    @PostMapping("/search")
    public ResponseEntity<Map<String, String>> searchUserAccounts(@RequestBody SearchRequest request) {
        Map<String, String> result = userSearchService.searchUserAccounts(request.getUsername());

        if (result.containsValue(null)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }

        return ResponseEntity.ok(result);
    }
}

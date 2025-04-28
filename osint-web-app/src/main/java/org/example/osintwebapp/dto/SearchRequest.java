package org.example.osintwebapp.dto;

public class SearchRequest {
    private String username;

    public SearchRequest() {
    }

    public SearchRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

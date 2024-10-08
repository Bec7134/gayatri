package com.example.demo;

import java.util.List;

public class ApiResponse {
    private boolean is_success;
    private String user_id;
    private String email;
    private String roll_number;
    private List<String> numbers;
    private List<String> alphabets;
    private List<String> highest_lowercase_alphabet;

    public ApiResponse(boolean is_success, String user_id, String email, String roll_number, List<String> numbers, List<String> alphabets, List<String> highest_lowercase_alphabet) {
        this.is_success = is_success;
        this.user_id = user_id;
        this.email = email;
        this.roll_number = roll_number;
        this.numbers = numbers;
        this.alphabets = alphabets;
        this.highest_lowercase_alphabet = highest_lowercase_alphabet;
    }

}
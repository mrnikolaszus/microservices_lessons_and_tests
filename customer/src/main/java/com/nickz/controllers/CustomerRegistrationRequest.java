package com.nickz.controllers;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}

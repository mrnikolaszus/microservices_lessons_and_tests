package com.nickz.customer.controllers;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}

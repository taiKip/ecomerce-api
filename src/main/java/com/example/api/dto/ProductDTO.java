package com.example.api.dto;

public record ProductDTO(String name, double price, String description, String imageUrl, int inventory, Long categoryId) {
}

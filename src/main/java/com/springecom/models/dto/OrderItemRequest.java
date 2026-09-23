package com.springecom.models.dto;

public record OrderItemRequest(
		int productId,
		int quantity) {}

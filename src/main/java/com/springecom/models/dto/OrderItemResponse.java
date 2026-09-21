package com.springecom.models.dto;

import java.math.BigDecimal;
// response dto

public record OrderItemResponse(
		String productName,
		int quantity,
		BigDecimal totalPrice) {
	
}

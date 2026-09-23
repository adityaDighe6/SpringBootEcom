package com.springecom.models.dtos;

import java.math.BigDecimal;

public record OrderItemResponse(String productName,
		int quantity,
		BigDecimal totalPrice) {

}

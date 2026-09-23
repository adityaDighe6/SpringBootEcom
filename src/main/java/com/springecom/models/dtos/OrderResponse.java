package com.springecom.models.dtos;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(String orderId,
		String customerName,
		String email,
		String status,
		LocalDate orderdate,
		List<OrderItemResponse> items) {

}

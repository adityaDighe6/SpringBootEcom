package com.springecom.models.dto;

import java.util.List;

public record OrderRequest(String customerName,
		String email,
		List<OrderItemRequest> items) {

}

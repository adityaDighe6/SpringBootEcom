package com.springecom.models.dtos;

import java.util.List;

public record OrderRequest(String customerName,
		String email,
		List<OrderItemRequest> items) {

}

package com.springecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springecom.models.dtos.OrderRequest;
import com.springecom.models.dtos.OrderResponse;
import com.springecom.services.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders/place")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
		OrderResponse orderResponse = orderService.placeOrder(orderRequest);
		
		return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<OrderResponse>> getAllOrders(){
		
		List<OrderResponse> orderResponseList = orderService.getAllOrderResponses();
		
		return new ResponseEntity<>(orderResponseList, HttpStatus.OK);
		
	}
}

package com.spring.elastic.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.elastic.domain.model.Address;
import com.spring.elastic.domain.service.AddressService;

@RestController
@RequestMapping("/users")
public class AddressController {

	private final AddressService userService;

	public AddressController(AddressService userService) {
		this.userService = userService;
	}

	@PostMapping
	public void save(@RequestBody Address user) {
		userService.save(user);
	}
}

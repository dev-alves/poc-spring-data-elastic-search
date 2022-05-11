package com.spring.elastic.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.elastic.domain.model.Address;
import com.spring.elastic.domain.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	private final AddressService addressService;

	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@PostMapping
	public void save(@RequestBody Address user) {
		addressService.save(user);
	}

	@GetMapping
	public void searchByName(@RequestParam("street") String street) {

	}

}

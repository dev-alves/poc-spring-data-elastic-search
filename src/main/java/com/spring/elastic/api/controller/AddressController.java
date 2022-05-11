package com.spring.elastic.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.spring.elastic.domain.model.Address;
import com.spring.elastic.domain.service.AddressService;
import com.spring.elastic.infrastructure.service.AddressElasticSearchService;

@RestController
@RequestMapping("/address")
public class AddressController {

	private final AddressService addressService;
	private final AddressElasticSearchService addressElasticSearch;

	public AddressController(AddressService addressService,
			AddressElasticSearchService addressElasticSearch) {
		this.addressService = addressService;
		this.addressElasticSearch = addressElasticSearch;
	}

	@PostMapping
	public void save(@RequestBody Address user) {
		addressService.save(user);
	}

	@GetMapping
	public List<String> search(@RequestParam("street") String street) {
		return addressElasticSearch.search(street);
	}

}

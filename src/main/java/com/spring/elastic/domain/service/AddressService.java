package com.spring.elastic.domain.service;

import javax.transaction.Transactional;
import com.spring.elastic.domain.model.Address;
import com.spring.elastic.domain.repository.AddressRepository;
import com.spring.elastic.infrastructure.service.AddressElasticService;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	private final AddressRepository addressRepository;
	private final AddressElasticService addressElasticService;

	public AddressService(AddressRepository addressRepository,
			AddressElasticService addressElasticService) {
		this.addressRepository = addressRepository;
		this.addressElasticService = addressElasticService;
	}

	@Transactional
	public void save(Address user) {
		addressElasticService.save(addressRepository.save(user));
	}

}

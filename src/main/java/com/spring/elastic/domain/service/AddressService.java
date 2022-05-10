package com.spring.elastic.domain.service;

import javax.transaction.Transactional;

import com.spring.elastic.domain.model.Address;
import com.spring.elastic.domain.repository.AddressRepository;
import com.spring.elastic.infrastructure.service.UserElasticService;

import org.springframework.stereotype.Service;

@Service
public class AddressService {

	private final AddressRepository userRepository;
	private final UserElasticService userElasticService;

	public AddressService(AddressRepository userRepository, UserElasticService userElasticService) {
		this.userRepository = userRepository;
		this.userElasticService = userElasticService;
	}

	@Transactional
	public void save(Address user) {
		userElasticService.save(userRepository.save(user));
	}

}

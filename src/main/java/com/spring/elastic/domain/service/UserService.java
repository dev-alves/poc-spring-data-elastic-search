package com.spring.elastic.domain.service;

import javax.transaction.Transactional;

import com.spring.elastic.domain.model.User;
import com.spring.elastic.domain.repository.UserRepository;
import com.spring.elastic.infrastructure.service.UserElasticService;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserElasticService userElasticService;

	public UserService(UserRepository userRepository, UserElasticService userElasticService) {
		this.userRepository = userRepository;
		this.userElasticService = userElasticService;
	}

	@Transactional
	public void save(User user) {
		userElasticService.save(userRepository.save(user));
	}

}

package com.spring.elastic.infrastructure.repository;

import com.spring.elastic.domain.model.User;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserSearchRepository extends ElasticsearchRepository<User, Long> {

}

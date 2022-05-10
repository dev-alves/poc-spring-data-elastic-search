package com.spring.elastic.infrastructure.repository;

import java.util.UUID;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.spring.elastic.domain.model.User;

public interface UserSearchRepository extends ElasticsearchRepository<User, UUID> {

}

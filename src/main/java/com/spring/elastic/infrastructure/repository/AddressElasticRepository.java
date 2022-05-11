package com.spring.elastic.infrastructure.repository;

import com.spring.elastic.domain.model.Address;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AddressElasticRepository extends ElasticsearchRepository<Address, Long> {

}

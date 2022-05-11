package com.spring.elastic.domain.service;

import javax.transaction.Transactional;
import com.spring.elastic.domain.model.Address;
import com.spring.elastic.domain.repository.AddressRepository;
import com.spring.elastic.infrastructure.service.AddressElasticService;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

	private final AddressRepository addressRepository;
	private final AddressElasticService addressElasticService;

	private final ElasticsearchRestTemplate elasticsearchRestTemplate;

	public AddressService(AddressRepository addressRepository,
			AddressElasticService addressElasticService,
			ElasticsearchRestTemplate elasticsearchRestTemplate) {
		this.addressRepository = addressRepository;
		this.elasticsearchRestTemplate = elasticsearchRestTemplate;
		this.addressElasticService = addressElasticService;
	}

	@Transactional
	public void save(Address user) {
		addressElasticService.save(addressRepository.save(user));
	}

	public Page<Address> findByStreet(String street) {
		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.fuzzyQuery("street", street))
				.build();
		SearchHits<Address> addresses = elasticsearchRestTemplate
				.search(nativeSearchQuery, Address.class, IndexCoordinates.of("index_address"));

		return null;
	}

}

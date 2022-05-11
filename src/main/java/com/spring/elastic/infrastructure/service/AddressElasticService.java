package com.spring.elastic.infrastructure.service;

import java.util.Arrays;
import java.util.List;

import com.spring.elastic.domain.model.Address;
import com.spring.elastic.infrastructure.repository.AddressSearchRepository;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

@Service
public class AddressElasticService {

	private ElasticsearchOperations elasticsearchOperations;
	private AddressSearchRepository addressSearchRepository;

	public AddressElasticService(ElasticsearchOperations elasticsearchOperations,
			AddressSearchRepository addressSearchRepository) {
		this.elasticsearchOperations = elasticsearchOperations;
		this.addressSearchRepository = addressSearchRepository;
	}

	public void save(Address address) {
		IndexQuery indexQuery = new IndexQueryBuilder().withId(address.getId().toString())
				.withObject(address).build();
		List<IndexQuery> indexQueries = Arrays.asList(indexQuery);
		elasticsearchOperations.bulkIndex(indexQueries, IndexCoordinates.of("index_address"));
	}

	public List<Object> findByName(String name) {
		return null;
	}

}

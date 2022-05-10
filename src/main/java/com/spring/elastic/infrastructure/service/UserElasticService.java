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
public class UserElasticService {

	private ElasticsearchOperations elasticsearchOperations;
	private AddressSearchRepository userSearchRepository;

	public UserElasticService(ElasticsearchOperations elasticsearchOperations,
			AddressSearchRepository userSearchRepository) {
		this.elasticsearchOperations = elasticsearchOperations;
		this.userSearchRepository = userSearchRepository;
	}

	public void save(Address user) {
		IndexQuery indexQuery = new IndexQueryBuilder()
				.withId(user.getId().toString())
				.withObject(user)
				.build();
		List<IndexQuery> indexQueries = Arrays.asList(indexQuery);
		elasticsearchOperations.bulkIndex(indexQueries, IndexCoordinates.of("index_address"));
	}

	public List<Object> findByName(String name) {
		return null;
	}

}

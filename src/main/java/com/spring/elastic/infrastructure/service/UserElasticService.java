package com.spring.elastic.infrastructure.service;

import java.util.Arrays;
import java.util.List;

import com.spring.elastic.domain.model.User;
import com.spring.elastic.infrastructure.repository.UserSearchRepository;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserElasticService {

	private ElasticsearchOperations elasticsearchOperations;
	private UserSearchRepository userSearchRepository;

	public UserElasticService(ElasticsearchOperations elasticsearchOperations,
			UserSearchRepository userSearchRepository) {
		this.elasticsearchOperations = elasticsearchOperations;
		this.userSearchRepository = userSearchRepository;
	}

	public void save(User user) {
		IndexQuery indexQuery = new IndexQueryBuilder()
				.withId(user.getId().toString())
				.withObject(user)
				.build();
		List<IndexQuery> indexQueries = Arrays.asList(indexQuery);
		elasticsearchOperations.bulkIndex(indexQueries, IndexCoordinates.of("index_users"));
	}

	public List<Object> findByName(String name) {
		return null;
	}

}

package com.spring.elastic.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.spring.elastic.domain.model.Address;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

@Component
public class AddressElasticSearchService {

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;

    public AddressElasticSearchService(ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }

    public List<String> search(String street) {
        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("street", street);
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("street", street);

        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(fuzzyQueryBuilder)
                .withQuery(matchQueryBuilder)
                .build();

        SearchHits<Address> searchHitsAddress = elasticsearchRestTemplate
                .search(nativeSearchQuery, Address.class, IndexCoordinates.of("index_address"));

        return searchHitsAddress.getSearchHits()
                .stream()
                .map(s -> s.getContent().getStreet())
                .collect(Collectors.toList());
    }
}

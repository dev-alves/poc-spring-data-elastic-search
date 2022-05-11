package com.spring.elastic.infrastructure.service;

import java.util.ArrayList;
import java.util.List;
import com.spring.elastic.domain.model.Address;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
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
        FuzzyQueryBuilder fuzzyQueryBuilder =
                QueryBuilders.fuzzyQuery("street", street).maxExpansions(20);

        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(fuzzyQueryBuilder)
                .build();

        SearchHits<Address> searchHitsAddress = elasticsearchRestTemplate
                .search(nativeSearchQuery, Address.class, IndexCoordinates.of("index_address"));

        List<String> streets = new ArrayList<>();
        for (SearchHit<Address> searchHits : searchHitsAddress.getSearchHits()) {
            streets.add(searchHits.getContent().getStreet());
        }
        return streets;
    }
}

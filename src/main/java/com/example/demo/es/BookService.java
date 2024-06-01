package com.example.demo.es;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.client.elc.NativeQueryBuilder;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexBoost;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private ElasticsearchTemplate template;


    /**
     * 创建索引
     *
     * @param bookIndex
     * @return
     */
    public BookIndex doIndex(BookIndex bookIndex) {
        return template.save(bookIndex);
    }


    public List<BookIndex> getIndexData(String str) {
        IndexCoordinates indexCoordinates =  template.getIndexCoordinatesFor(BookIndex.class);

        IndexBoost indexBoost = new IndexBoost("books_1",1f);
//        IndexBoost indexBoost1 = new IndexBoost("books_2",1f);
//        IndexBoost indexBoost2 = new IndexBoost("books_3",1f);



        Query query = NativeQuery.builder().withQuery(q->q.match(m->m.field("title").query(str))).withPageable(Pageable.ofSize(1000)).build();
        List<BookIndex> resList = new ArrayList<>();

        List<SearchHit<BookIndex>> list = template.search(query, BookIndex.class).getSearchHits();
        for (SearchHit<BookIndex> s : list) {
            resList.add(s.getContent());
        }

        return resList;
    }

}

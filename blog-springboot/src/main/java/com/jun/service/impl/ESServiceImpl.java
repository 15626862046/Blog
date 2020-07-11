package com.jun.service.impl;

import com.alibaba.fastjson.JSON;
import com.jun.entity.Article;
import com.jun.service.ArticleService;
import com.jun.service.ESService;
import io.swagger.models.auth.In;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@Service
public class ESServiceImpl implements ESService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private ArticleService articleService;
    //解析数据放入ES索引中
    @Override
    public Boolean findALLToES() throws Exception {
        //调用文章查询所有方法
        List<Article> list = articleService.list();
        //将数据插入ES
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("3m");
        for (int i = 1; i< list.size();i++){
            bulkRequest.add(
                    new IndexRequest("article")
                            .source(JSON.toJSONString(list.get(i)), XContentType.JSON)
            );
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulk.hasFailures();
    }

    @Override
    public List<Map<String, Object>> searchPageHighlightBuilder(String keyword, Integer currentPage, Integer pageSize) throws Exception {
        /**
        if(currentPage == null ||currentPage <1){
            currentPage=1;
        }
        // 页数
        if (pageSize == null || pageSize < 1) {
            pageSize = 3;
        }
        */

        //条件搜索
        SearchRequest searchRequest = new SearchRequest("article");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        //分页
        //sourceBuilder.from(currentPage);
        //sourceBuilder.size(pageSize);


        //精准匹配
        //TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keyword.toLowerCase());
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("title", keyword);
        sourceBuilder.query(matchPhraseQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        //高亮
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.requireFieldMatch(false);//多个高亮显示
        highlightBuilder.preTags("<span style=\"color:red\">");
        highlightBuilder.postTags("</span>");
        sourceBuilder.highlighter(highlightBuilder);

        //执行搜索
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(searchResponse);
        //解析结果
        ArrayList<Map<String,Object>> list = new ArrayList<>();
        for (SearchHit documentFields:searchResponse.getHits()){
            //获取高亮字段
            Map<String, HighlightField> highlightFields = documentFields.getHighlightFields();
            HighlightField title = highlightFields.get("title");
            Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();//原来的结果
            //解析高亮字段,将原来的字段换为我们高亮字段即可
            if(title!=null){
                Text[] fragments = title.fragments();
                String n_title="";
                for(Text text:fragments){
                    n_title += text;
                }
                sourceAsMap.put("title",n_title);//高亮字段替换原来的内容
            }
            list.add(sourceAsMap);
        }
        return list;
    }

}

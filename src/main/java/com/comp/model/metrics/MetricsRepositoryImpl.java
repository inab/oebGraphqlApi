/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.metrics;

import com.comp.pagination.PaginationFilters;
import com.comp.pagination.PaginationMethods;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author vsundesh
 */
public class MetricsRepositoryImpl implements MetricsRepositoryCustom{

    @Autowired
    private MongoTemplate mt;
    
    @Override
    public List<Metrics> getMetrics(MetricsFilters metricsFilters, PaginationFilters paginationFilters) {
        List <Metrics> metrics = new ArrayList<>();
         Query query = new Query();
         
         if(paginationFilters != null){
            query = PaginationMethods.paginationQueryBuilder(query, paginationFilters);
        }
         
        if(metricsFilters!=null){
            if(metricsFilters.getId()!=null){
                query.addCriteria(Criteria.where("_id").is(metricsFilters.getId()));
            }
            if(metricsFilters.getCommunity_id()!=null){
                query.addCriteria(Criteria.where("community_id").is(metricsFilters.getCommunity_id()));
            }
        }
        
        metrics = mt.find(query,Metrics.class);
        return metrics;
    }
    
}

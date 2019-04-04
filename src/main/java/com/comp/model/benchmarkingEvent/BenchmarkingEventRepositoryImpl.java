/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.benchmarkingEvent;

import com.comp.pagination.PaginationFilters;
import com.comp.pagination.PaginationMethods;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;



/**
 *
 * @author vsundesh
 */
@Service
public class BenchmarkingEventRepositoryImpl implements BenchmarkingEventRepositoryCustom {

    @Autowired
    MongoTemplate mt;

    @Override
    public List<BenchmarkingEvent> getBenchmarkingEvents(BenchmarkingEventFilters benchmarkingEventFilters,
            PaginationFilters paginationFilters){  
        
        List <BenchmarkingEvent> bevents = new ArrayList<>();
        Query query = new Query();
        
        if(paginationFilters != null){
            query = PaginationMethods.paginationQueryBuilder(query, paginationFilters);
        }
         
        
        if(benchmarkingEventFilters!=null){
            if(benchmarkingEventFilters.getId()!=null){
                query.addCriteria(Criteria.where("_id").is(benchmarkingEventFilters.getId()));
            }
            if(benchmarkingEventFilters.getCommunity_id()!=null){
                query.addCriteria(Criteria.where("community_id").is(benchmarkingEventFilters.getCommunity_id()));
            }
        }
        
        bevents = mt.find(query,BenchmarkingEvent.class);
        return bevents;
    }
}

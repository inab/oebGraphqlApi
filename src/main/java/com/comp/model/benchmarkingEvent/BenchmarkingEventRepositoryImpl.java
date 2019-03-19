/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.benchmarkingEvent;

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
public class BenchmarkingEventRepositoryImpl implements BenchmarkingEventRepositoryCustom {

    @Autowired
    private MongoTemplate mt;


    @Override
    public List<BenchmarkingEvent> getBenchmarkingEvents(BenchmarkingEventFilters benchmarkingEventFilters){
        List <BenchmarkingEvent> bevents = new ArrayList<>();
        Query query = new Query();
        if(benchmarkingEventFilters!=null){
            if(benchmarkingEventFilters.getId()!=null){
                query.addCriteria(Criteria.where("_id").is(benchmarkingEventFilters.getId()));
            }
            if(benchmarkingEventFilters.getCommunity_id()!=null){
                query.addCriteria(Criteria.where("community_id").is(benchmarkingEventFilters.getCommunity_id()));
            }
//            System.out.println(query.toString());
            bevents = mt.find(query,BenchmarkingEvent.class);
            
        }else{
            bevents = mt.findAll(BenchmarkingEvent.class);
        }
        return bevents;
    }
}

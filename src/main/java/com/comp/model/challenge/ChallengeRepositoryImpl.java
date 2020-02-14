/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.challenge;


import com.comp.pagination.PaginationFilters;
import com.comp.pagination.PaginationMethods;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author vsundesh
 */
public class ChallengeRepositoryImpl implements ChallengeRepositoryCustom {
    
    @Autowired
    private MongoTemplate mt;

    @Override
    public List<Challenge> getChallenges(ChallengeFilters challengeFilters, PaginationFilters paginationFilters) {
        
        List <Challenge> challenges = new ArrayList<>();
        Query query = new Query();
        
        if(paginationFilters != null){
            query = PaginationMethods.paginationQueryBuilder(query, paginationFilters);
        }
        
        if(challengeFilters!=null){
            if(challengeFilters.getId()!=null){
                query.addCriteria(Criteria.where("_id").is(challengeFilters.getId().toUpperCase()));
            }
            if(challengeFilters.getBenchmarking_event_id()!=null){
                query.addCriteria(Criteria.where("benchmarking_event_id").is(challengeFilters.getBenchmarking_event_id().toUpperCase()));
            }
        }
        query.with(Sort.by("acronym"));
        
        challenges = mt.find(query,Challenge.class);
        return challenges;
    }
}

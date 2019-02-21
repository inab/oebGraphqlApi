/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.challenge;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Challenge> getChallengesByBEventId(String id) {
        Query query = new Query(Criteria.where("benchmarking_event_id").is(id));
        return mt.find(query, Challenge.class);
    }
    
}

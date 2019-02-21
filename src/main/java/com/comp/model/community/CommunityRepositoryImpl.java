/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.community;

import com.comp.model.community.CommunityRepositoryCustom;
import com.comp.model.community.Community;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;



/**
 *
 * @author vsundesh
 */
public class CommunityRepositoryImpl implements CommunityRepositoryCustom {

    @Autowired
    private MongoTemplate mt;
    
    
    @Override
    public Community getCommunityById(String id) {
         Query query = new Query(Criteria.where("_id").is(id));
         return mt.findOne(query, Community.class);
    }  


}

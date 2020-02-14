/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.community;

import com.comp.pagination.PaginationFilters;
import com.comp.pagination.PaginationMethods;
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
public class CommunityRepositoryImpl implements CommunityRepositoryCustom {

    @Autowired
    private MongoTemplate mt; 

    @Override
    public List<Community> getCommunities(CommunityFilters communityFilters, PaginationFilters paginationFilters) {
         
        List <Community> comms = new ArrayList<>();
        Query query = new Query();
        
        
        if(paginationFilters != null){
            query = PaginationMethods.paginationQueryBuilder(query, paginationFilters);
        }
         
        if(communityFilters!=null){
            if(communityFilters.getId() !=null){
                query.addCriteria(Criteria.where("_id").is(communityFilters.getId().toUpperCase()));
            }
            if(communityFilters.getStatus() !=null){
                query.addCriteria(Criteria.where("status").is(communityFilters.getStatus().toUpperCase()));
            }
        }

        comms = mt.find(query,Community.class);
        return comms;
    }

   
    
    


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.contact;

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
 * @author vicky
 */
public class ContactRepositoryImpl implements ContactRepositoryCustom {
    
    @Autowired
    private MongoTemplate mt; 

    @Override
    public List<Contact> getContacts(ContactFilters contactFilters, PaginationFilters paginationFilters) {
        List <Contact> comms = new ArrayList<>();
        Query query = new Query();
        
        
        if(paginationFilters != null){
            query = PaginationMethods.paginationQueryBuilder(query, paginationFilters);
        }
         
        if(contactFilters!=null){
            if(contactFilters.getId() !=null){
                query.addCriteria(Criteria.where("_id").is(contactFilters.getId()));
            }
            if(contactFilters.getCommunity_id()!=null){
                query.addCriteria(Criteria.where("community_id").is(contactFilters.getCommunity_id().toUpperCase()));
            }
        }

        comms = mt.find(query,Contact.class);
        return comms;
    }
    
}

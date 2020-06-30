/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.testAction;

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
public class TestActionRepositoryImpl implements TestActionRepositoryCustom {
    @Autowired
    private MongoTemplate mt;

    @Override
    public List<TestAction> getTestActions(TestActionFilters testActionFilters, PaginationFilters paginationFilters) {
        List <TestAction> testActions = new ArrayList<>();
         Query query = new Query();
         
         if(paginationFilters != null){
            query = PaginationMethods.paginationQueryBuilder(query, paginationFilters);
        }
         
        if(testActionFilters!=null){
            if(testActionFilters.getId()!=null){
                query.addCriteria(Criteria.where("_id").is(testActionFilters.getId().toUpperCase()));
            }
            if(testActionFilters.getTool_id()!=null){
                query.addCriteria(Criteria.where("tool_id").is(testActionFilters.getTool_id().toUpperCase()));
            }
            if(testActionFilters.getAction_type()!=null){
                query.addCriteria(Criteria.where("action_type").is(testActionFilters.getAction_type()));
            }
        }
        
        testActions = mt.find(query,TestAction.class);
        return testActions;
    }
    
}
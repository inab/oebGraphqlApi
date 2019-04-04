/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.tool;

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
public class ToolRepositoryImpl implements ToolRepositoryCustom{
    
    @Autowired
    private MongoTemplate mt;

    @Override
    public List<Tool> getTools(ToolFilters toolFilters, PaginationFilters paginationFilters) {
        List <Tool> tools = new ArrayList<>();
         Query query = new Query();
         
        if(paginationFilters != null){
            query = PaginationMethods.paginationQueryBuilder(query, paginationFilters);
        }
         
        if(toolFilters!=null){
            if(toolFilters.getId() !=null){
                query.addCriteria(Criteria.where("_id").is(toolFilters.getId()));
            }
            if(toolFilters.getCommunity_id() !=null){
                query.addCriteria(Criteria.where("community_id").is(toolFilters.getCommunity_id()));
            }
        }
        
        tools = mt.find(query,Tool.class);
        return tools;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.pagination;

import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author vsundesh
 */
public class PaginationMethods {
    
    public static Query paginationQueryBuilder(Query query, PaginationFilters paginationFilters){
        
        if(paginationFilters.getSkip()!=null){
            query.skip(paginationFilters.getSkip());
        }
        if(paginationFilters.getLimit()!=null){
            query.limit(paginationFilters.getLimit());
        }
        return query;
    }
    
    
}

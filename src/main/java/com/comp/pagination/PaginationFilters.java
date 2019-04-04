/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.pagination;

/**
 *
 * @author vsundesh
 */
public class PaginationFilters {
    
    private Integer skip;
    private Integer limit;

    public PaginationFilters(Integer skip, Integer limit) {
        this.skip = skip;
        this.limit = limit;
    }

    public PaginationFilters() {
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
    
    
    

    
    
    
}

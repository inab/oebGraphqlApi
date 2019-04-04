/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.community;

import com.comp.model.benchmarkingEvent.BenchmarkingEventFilters;
import com.comp.pagination.PaginationFilters;
import java.util.List;

/**
 *
 * @author vsundesh
 */
public class CommunityFilters {
    private String id;
    private List<String> keywords;
    private String status;
    private BenchmarkingEventFilters filters;

    

    public CommunityFilters() {
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BenchmarkingEventFilters getFilters() {
        return filters;
    }

    public void setFilters(BenchmarkingEventFilters filters) {
        this.filters = filters;
    }
    
    
    
    
}

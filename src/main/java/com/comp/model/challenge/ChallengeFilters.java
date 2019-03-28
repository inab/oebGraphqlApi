/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.challenge;

/**
 *
 * @author vsundesh
 */
public class ChallengeFilters {
    private String id;
    private String benchmarking_event_id;

    public ChallengeFilters() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBenchmarking_event_id() {
        return benchmarking_event_id;
    }

    public void setBenchmarking_event_id(String benchmarking_event_id) {
        this.benchmarking_event_id = benchmarking_event_id;
    }
    
    
}

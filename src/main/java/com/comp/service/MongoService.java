/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.service;

import com.comp.model.benchmarkingEvent.BenchmarkingEvent;
import com.comp.model.benchmarkingEvent.BenchmarkingEventFilters;
import com.comp.model.benchmarkingEvent.BenchmarkingEventRepository;
import com.comp.model.challenge.Challenge;
import com.comp.model.challenge.ChallengeRepository;

import com.comp.model.community.Community;
import com.comp.model.community.CommunityFilters;
import com.comp.model.community.CommunityRepository;
import com.comp.model.dataset.Dataset;
import com.comp.model.dataset.DatasetFilters;
import com.comp.model.dataset.DatasetRepository;
import com.comp.model.tool.Tool;
import com.comp.model.tool.ToolRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vsundesh
 */
@Service
public class MongoService {

    @Autowired
    private CommunityRepository cr;

    @Autowired
    private BenchmarkingEventRepository br;

    @Autowired
    private ChallengeRepository chr;

    @Autowired
    private ToolRepository tr;
    
    @Autowired
    private DatasetRepository dr;
    
    public List<Community> getCommunities(CommunityFilters communityFilters, BenchmarkingEventFilters benchmarkingEventFilters) {
        List<Community> c = new ArrayList<>();
        c = cr.getCommunities(communityFilters);
        for (Community com : c){
            if(benchmarkingEventFilters==null){
                benchmarkingEventFilters = new BenchmarkingEventFilters();
            }
            benchmarkingEventFilters.setCommunity_id(com.getId());
            List<BenchmarkingEvent> b = this.getBenchmarkingEvents(benchmarkingEventFilters);
            com.setbEvents(b);
        }
        return c;
    }
        
        
    public List<BenchmarkingEvent> getBenchmarkingEvents(BenchmarkingEventFilters benchmarkingEventFilters){
        return br.getBenchmarkingEvents(benchmarkingEventFilters);
    }

    public List<Challenge> getChallengesByBEventId(String id) {
        return chr.getChallengesByBEventId(id);
    }

    public List<Tool> getAllTools(){
        return tr.findAll();
    }
    
    public List<Dataset> getDatasets(DatasetFilters datasetFilters){
        return dr.getDatasets(datasetFilters);
    }
}
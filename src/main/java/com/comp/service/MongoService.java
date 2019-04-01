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
import com.comp.model.challenge.ChallengeFilters;
import com.comp.model.challenge.ChallengeRepository;

import com.comp.model.community.Community;
import com.comp.model.community.CommunityFilters;
import com.comp.model.community.CommunityRepository;
import com.comp.model.dataset.Dataset;
import com.comp.model.dataset.DatasetFilters;
import com.comp.model.dataset.DatasetRepository;
import com.comp.model.tool.Tool;
import com.comp.model.tool.ToolFilters;
import com.comp.model.tool.ToolRepository;
import graphql.schema.DataFetcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetchingEnvironment;
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
    
    @Autowired
    ObjectMapper mapper;
    
    public String age(){
        return "hola";
    }
    
    
    
    
//    public List<Community> getCommunities(CommunityFilters communityFilters) {
//        DataFetcher bevent = (DataFetcher<List<BenchmarkingEvent>>) (DataFetchingEnvironment environment) -> {
//            System.out.println(environment);
//            return null;
//        };
//        
//        List<Community> c = new ArrayList<>();
//        c = cr.getCommunities(communityFilters);   
//        for (Community com : c){
//            BenchmarkingEventFilters benchmarkingEventFilters = new BenchmarkingEventFilters();
//            benchmarkingEventFilters.setCommunity_id(com.getId());
//            List<BenchmarkingEvent> b = this.getBenchmarkingEvents(benchmarkingEventFilters);
//            com.setBenchmarkingEvents(b);
//        }
//        return c;
//    }
        
        
    public List<BenchmarkingEvent> getBenchmarkingEvents(BenchmarkingEventFilters benchmarkingEventFilters){
        
        List<BenchmarkingEvent> b = new ArrayList<>();
        b = br.getBenchmarkingEvents(benchmarkingEventFilters);   
        for (BenchmarkingEvent ben : b){
            ChallengeFilters cf = new ChallengeFilters();
            cf.setBenchmarking_event_id(ben.getId());
            List<Challenge> c = this.getChallenges(cf);
            ben.setChallenges(c);
        }
        return b;
    }

    public List<Challenge> getChallenges(ChallengeFilters challengeFilters) {
        List<Challenge> c = new ArrayList<>();
        c = chr.getChallenges(challengeFilters);
        for (Challenge cha : c){
            DatasetFilters df = new DatasetFilters ();
            df.setChallenge_id(cha.getId());
            List<Dataset> d = this.getDatasets(df);
            cha.setDatasets(d);   
        }
        return c;
    }

    public List<Tool> getTools(ToolFilters toolFilters){
        return tr.getTools(toolFilters);
    }
    
    public List<Dataset> getDatasets(DatasetFilters datasetFilters){
        return dr.getDatasets(datasetFilters);
    }

    public List<Community> getCommunities(DataFetchingEnvironment environment) {
        CommunityFilters cf = mapper.convertValue(environment.getArgument("communityFilters"), CommunityFilters.class);
        return cr.getCommunities(cf);
    };
}
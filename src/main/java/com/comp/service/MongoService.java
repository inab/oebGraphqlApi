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
import com.comp.model.challenge.EmbededDatasetFilters;

import com.comp.model.community.Community;
import com.comp.model.community.CommunityFilters;
import com.comp.model.community.CommunityRepository;
import com.comp.model.contact.Contact;
import com.comp.model.contact.ContactFilters;
import com.comp.model.contact.ContactRepository;
import com.comp.model.dataset.Dataset;
import com.comp.model.dataset.DatasetFilters;
import com.comp.model.dataset.DatasetRepository;
import com.comp.model.metrics.Metrics;
import com.comp.model.metrics.MetricsFilters;
import com.comp.model.metrics.MetricsRepository;
import com.comp.model.tool.Tool;
import com.comp.model.tool.ToolFilters;
import com.comp.model.tool.ToolRepository;
import com.comp.pagination.PaginationFilters;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
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
    private MetricsRepository mr;
    
    @Autowired
    private ContactRepository conr;
    
    @Autowired
    ObjectMapper mapper;
    
    public List<Tool> getTools(DataFetchingEnvironment environment){
        ToolFilters tf = mapper.convertValue(environment.getArgument("toolFilters"), ToolFilters.class);
        PaginationFilters pf = mapper.convertValue(environment.getArgument("pagination"), PaginationFilters.class);
        return tr.getTools(tf,pf);
    }
    
    public List<Community> getCommunities(DataFetchingEnvironment environment) {
        CommunityFilters cf = mapper.convertValue(environment.getArgument("communityFilters"), CommunityFilters.class);
        PaginationFilters pf = mapper.convertValue(environment.getArgument("pagination"), PaginationFilters.class);
        return cr.getCommunities(cf,pf);
    };
    
    public List<BenchmarkingEvent> getBenchmarkingEvents(DataFetchingEnvironment environment) {
        BenchmarkingEventFilters bf = new BenchmarkingEventFilters();
        Community c = environment.getSource();
        if(c != null){
            bf.setCommunity_id(c.getId());
        } else {
            bf = mapper.convertValue(environment.getArgument("benchmarkingEventFilters"), BenchmarkingEventFilters.class);
        }

        PaginationFilters pf = mapper.convertValue(environment.getArgument("pagination"), PaginationFilters.class);
        return br.getBenchmarkingEvents(bf, pf);
    }

    public List<Challenge> getChallenges(DataFetchingEnvironment environment) {
        ChallengeFilters chf = new ChallengeFilters();
        BenchmarkingEvent b = environment.getSource();
        if(b != null){
            chf.setBenchmarking_event_id(b.getId());
        } else {
            chf = mapper.convertValue(environment.getArgument("challengeFilters"), ChallengeFilters.class);
        }
        PaginationFilters pf = mapper.convertValue(environment.getArgument("pagination"), PaginationFilters.class);
        return chr.getChallenges(chf,pf);
    }
    
    public List <Dataset> getDatasets(DataFetchingEnvironment environment){
        System.out.println(environment);
        DatasetFilters edsf = new DatasetFilters();
        Challenge ch = environment.getSource();
        if(ch != null){
            EmbededDatasetFilters dsf = new EmbededDatasetFilters();
            if(environment.containsArgument("datasetFilters")){
                dsf = mapper.convertValue(environment.getArgument("datasetFilters"), EmbededDatasetFilters.class);
            }
            edsf.setChallenge_id(ch.getId());
            edsf.setType(dsf.getType());
            edsf.setVisibility(dsf.getVisibility());
        } else {
            edsf = mapper.convertValue(environment.getArgument("datasetFilters"), DatasetFilters.class);
        }   
        
        PaginationFilters pf = mapper.convertValue(environment.getArgument("pagination"), PaginationFilters.class);
        return dr.getDatasets(edsf,pf);
    }

    public List<Metrics> getMetrics(DataFetchingEnvironment environment) {
        MetricsFilters mf = mapper.convertValue(environment.getArgument("metricsFilters"), MetricsFilters.class);
        PaginationFilters pf = mapper.convertValue(environment.getArgument("pagination"), PaginationFilters.class);
        return mr.getMetrics(mf, pf);
    }

    public List<Contact> getContacts(DataFetchingEnvironment environment) {
        ContactFilters cf = mapper.convertValue(environment.getArgument("contactFilters"), ContactFilters.class);
        PaginationFilters pf = mapper.convertValue(environment.getArgument("pagination"), PaginationFilters.class);
        return conr.getContacts(cf, pf);
    }
}
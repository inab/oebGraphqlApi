/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.graphqlResolver;

import com.comp.model.benchmarkingEvent.BenchmarkingEvent;
import com.comp.model.benchmarkingEvent.BenchmarkingEventFilters;
import com.comp.model.challenge.Challenge;
import com.comp.model.community.Community;
import com.comp.model.community.CommunityFilters;
import com.comp.model.dataset.Dataset;
import com.comp.model.dataset.DatasetFilters;
import com.comp.model.tool.Tool;
import com.comp.service.MongoService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import graphql.schema.GraphQLObjectType;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author vsundesh
 */
@Component
public class Query implements GraphQLQueryResolver{
    
    @Autowired    
    private MongoService ms;    
   
    public List<Community> getCommunities(CommunityFilters communityFilters, BenchmarkingEventFilters benchmarkingEventFilters){
        return ms.getCommunities(communityFilters, benchmarkingEventFilters);
    }
    
    public List<BenchmarkingEvent> getBenchmarkingEvents(BenchmarkingEventFilters benchmarkingEventFilters){
        return ms.getBenchmarkingEvents(benchmarkingEventFilters);
    }
     
    public List<Challenge> getChallengesByBEventId(String id){
        return ms.getChallengesByBEventId(id);
    }
    
    public List<Tool> getAllTools(){
        return ms.getAllTools();
    }
    
    public List<Dataset> getDatasets(DatasetFilters datasetFilters){
        return ms.getDatasets(datasetFilters);
    }
}

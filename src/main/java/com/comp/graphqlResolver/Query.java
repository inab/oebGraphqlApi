/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.graphqlResolver;

import com.comp.model.benchmarkingEvent.BenchmarkingEvent;
import com.comp.model.benchmarkingEvent.BenchmarkingEventFilters;
import com.comp.model.challenge.Challenge;
import com.comp.model.challenge.ChallengeFilters;
import com.comp.model.community.Community;
import com.comp.model.community.CommunityFilters;
import com.comp.model.dataset.Dataset;
import com.comp.model.dataset.DatasetFilters;
import com.comp.model.tool.Tool;
import com.comp.model.tool.ToolFilters;
import com.comp.service.MongoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author vsundesh
 */
@Component
public class Query{
    
    @Autowired    
    private MongoService ms;    
   
//    public List<Community> getCommunities(CommunityFilters communityFilters){
//        return ms.getCommunities(communityFilters);
//    }
    
//    public List<BenchmarkingEvent> getBenchmarkingEvents(BenchmarkingEventFilters benchmarkingEventFilters){
//        return ms.getBenchmarkingEvents(benchmarkingEventFilters);
//    }
     
    public List<Challenge> getChallenges(ChallengeFilters challengeFilters){
        return ms.getChallenges(challengeFilters);
    }
    
    public List<Tool> getTools(ToolFilters toolFilters){
        return ms.getTools(toolFilters);
    }
    
    public List<Dataset> getDatasets(DatasetFilters datasetFilters){
        return ms.getDatasets(datasetFilters);
    }
}

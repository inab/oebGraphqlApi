/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.graphqlResolver;

import com.comp.model.benchmarkingEvent.BenchmarkingEvent;
import com.comp.model.challenge.Challenge;
import com.comp.model.community.Community;
import com.comp.model.dataset.Dataset;
import com.comp.model.tool.Tool;
//import com.comp.model.community.CommunityRepository;
import com.comp.service.MongoService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
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
   
    public List<Community> getAllCommunities(){
        return ms.getAllCommunities();
    }
        
    public Community getCommunityById(String id){
        return ms.getCommunityById(id);
    }
    
    public List<BenchmarkingEvent> getAllBEvents(){
        return ms.getAllBEvents();
    }
    
    public List<BenchmarkingEvent> getBEventsByCommunityId(String id){
        return ms.getBEventsByCommunityId(id);
    }
    
    public List<Challenge> getChallengesByBEventId(String id){
        return ms.getChallengesByBEventId(id);
    }
    
    public List<Tool> getAllTools(){
        return ms.getAllTools();
    }
    
    public List<Dataset> getAllDatasets(){
        return ms.getAllDatasets();
    }
}

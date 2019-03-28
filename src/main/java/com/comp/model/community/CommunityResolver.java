/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.community;

import com.comp.model.benchmarkingEvent.BenchmarkingEvent;
import com.comp.model.benchmarkingEvent.BenchmarkingEventFilters;
import com.comp.service.MongoService;
import com.coxautodev.graphql.tools.GraphQLResolver;
import java.util.List;

/**
 *
 * @author vsundesh
 */
public class CommunityResolver implements GraphQLResolver<Community>{
    
    private MongoService ms;
    
    
    public List<BenchmarkingEvent> benchmarkingEventss (BenchmarkingEventFilters benchmarkingEventFilters){
        System.out.println("hola");
        return ms.getBenchmarkingEvents(benchmarkingEventFilters);
    }

    
}

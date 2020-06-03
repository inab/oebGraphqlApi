/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp;

import com.comp.service.MongoService;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author vsundesh
 */
@Component
public class GraphQLDataFetchers {

    @Autowired    
    private MongoService ms;  
    
    DataFetcher getCommunities() {
        return environment -> {
            return  ms.getCommunities(environment);
        };
    }

    DataFetcher getBenchmarkingEvents() {
        return environment -> {
            return  ms.getBenchmarkingEvents(environment);
        };
    }

    DataFetcher getChallenges() {
        return environment -> {
            return  ms.getChallenges(environment);
        };
    }

    DataFetcher getDatasets() {
        return environment -> {
            return  ms.getDatasets(environment);
        };
    }

    DataFetcher getTools() {
        return environment -> {
            return  ms.getTools(environment);
        };
    }

    DataFetcher getMetrics() {
        return environment -> {
            return  ms.getMetrics(environment);
        };
    }

    DataFetcher getContacts() {
        return environment -> {
            return  ms.getContacts(environment);
        };
    }
}

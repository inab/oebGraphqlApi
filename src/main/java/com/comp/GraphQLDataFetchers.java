/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp;

import com.comp.model.community.Community;
import com.comp.service.MongoService;
import graphql.schema.DataFetcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            return  ms.getComs(environment);
        };
    }

    
}

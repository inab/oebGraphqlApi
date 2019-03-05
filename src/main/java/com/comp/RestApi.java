/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp;


import com.comp.service.MongoService;
import com.comp.model.community.Community;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author vsundesh
 */

@RestController
@RequestMapping("/")

public class RestApi {
    
    @Autowired
    private MongoService ms;
    
    @RequestMapping()
    public String getCommunities(){
        return "Only Graphql Api implemented. use the endpoint /graphiql";
    };

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.dataset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author vsundesh
 */
public class DatasetRepositoryImpl implements DatasetRepositoryCustom {
    
    @Autowired
    private MongoTemplate mt;
}

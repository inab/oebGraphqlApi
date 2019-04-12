/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.metrics;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author vsundesh
 */
public interface MetricsRepository extends MetricsRepositoryCustom, MongoRepository<Metrics, String>{
    
}


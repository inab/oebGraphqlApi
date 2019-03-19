/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.benchmarkingEvent;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vsundesh
 */
@Repository
public interface BenchmarkingEventRepository extends BenchmarkingEventRepositoryCustom, MongoRepository<BenchmarkingEvent, String>{
    
}

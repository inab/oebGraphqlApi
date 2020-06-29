/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.testAction;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author vicky
 */
public interface TestActionRepository extends TestActionRepositoryCustom, MongoRepository<TestAction, String>{
    
}

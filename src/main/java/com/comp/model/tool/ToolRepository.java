/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.tool;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vsundesh
 */
@Repository
public interface ToolRepository extends ToolRepositoryCustom, MongoRepository<Tool, String>{
    
}

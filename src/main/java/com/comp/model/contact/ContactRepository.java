/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.contact;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vicky
 */
@Repository
public interface ContactRepository extends ContactRepositoryCustom, MongoRepository<Contact, String>{
    
}

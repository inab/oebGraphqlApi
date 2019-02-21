/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.challenge;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author vsundesh
 */
public class Dates {
    private String creation;
    private String modification;    
    @Field("public")
    private String _public;
    private String challenge_start;
    private String challenge_stop;
    
    
}

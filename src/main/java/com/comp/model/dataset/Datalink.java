/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.dataset;


import java.util.List;




/**
 *
 * @author vsundesh
 */
public class Datalink {
    private List<String> attrs;
    private String validation_date;
    private String status;
    // TODO 
    //The uri will change !!
    // this uses scalar type Json to print what ever is present in the DB
    private Object uri;
    private Object inline_data;
}


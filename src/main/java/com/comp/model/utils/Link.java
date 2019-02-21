/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.utils;

/**
 *
 * @author vsundesh
 */
public class Link {
    
    private String label;
    private String uri;
    
    public Link(String label, String uri) {
        this.label = label;
        this.uri = uri;
    }

    public Link() {
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }    
    
}

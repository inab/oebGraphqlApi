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
    private String comment;
    
    public Link(String label, String uri, String comment) {
        this.label = label;
        this.uri = uri;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}

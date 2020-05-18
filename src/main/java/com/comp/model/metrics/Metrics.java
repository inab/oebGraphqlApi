/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.metrics;

import com.comp.model.utils.Implementations;
import com.comp.model.utils.Link;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author vsundesh
 */
@Document (collection="Metrics")
public class Metrics {
    private String _id;
    private String _schema;
    private String orig_id;
    private String title;
    private String description;
    private List<String> metrics_contact_ids;
    private String formal_definition;
//    private List<Implementations> implementations;
    private String execution_type;
    private String data_schemas;
    private List<Link> links;
    private List<String> references;
    private Object representation_hints;
    private Object _metadata;
    
    //NOT IN SCHEMA
    //private String community_id;
}

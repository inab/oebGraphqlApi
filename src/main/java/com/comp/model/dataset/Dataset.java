/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.dataset;

import com.comp.model.utils.Dates;
import com.comp.model.utils.DependsOn;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 *
 * @author vsundesh
 */
@Document (collection="Dataset")
public class Dataset {
    private String _id;
    private String _schema;
    private String orig_id;
    private String community_id;
    @Field("challenge_id")
    private List<String> challenge_ids;
    private String visibility;
    private String name;
    private String version;
    private String description;
    private Dates dates;  
    private String type;
    private Datalink datalink;
    private List<String> dataset_contact_ids;
    private DependsOn depends_on;
    private List<String> references;

}
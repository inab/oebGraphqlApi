/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.dataset;

import com.comp.model.challenge.Challenge;
import com.comp.model.utils.Dates;
import com.comp.model.utils.Datalink;
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

    public Dataset() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getSchema() {
        return _schema;
    }

    public void setSchema(String _schema) {
        this._schema = _schema;
    }

    public String getOrig_id() {
        return orig_id;
    }

    public void setOrig_id(String orig_id) {
        this.orig_id = orig_id;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public List<String> getChallenge_ids() {
        return challenge_ids;
    }

    public void setChallenge_ids(List<String> challenge_ids) {
        this.challenge_ids = challenge_ids;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Datalink getDatalink() {
        return datalink;
    }

    public void setDatalink(Datalink datalink) {
        this.datalink = datalink;
    }

    public List<String> getDataset_contact_ids() {
        return dataset_contact_ids;
    }

    public void setDataset_contact_ids(List<String> dataset_contact_ids) {
        this.dataset_contact_ids = dataset_contact_ids;
    }

    public DependsOn getDepends_on() {
        return depends_on;
    }

    public void setDepends_on(DependsOn depends_on) {
        this.depends_on = depends_on;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }


    
    
    
}

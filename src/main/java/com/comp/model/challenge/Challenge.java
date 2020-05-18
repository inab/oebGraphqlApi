/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.challenge;

import com.comp.model.dataset.Dataset;
import com.comp.model.utils.MetricsCategory;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author vsundesh
 */
@Document (collection="Challenge")
public class Challenge {
    
    private String _id;
    private String _schema;
    private String acronym;
    private String orig_id;
    private String description;
    private String name;
    private Boolean is_automated;
    private Dates dates;
    private String url;
    private List<MetricsCategory> metrics_categories;
    private String benchmarking_event_id;
    private List<String> challenge_contact_ids;
    private List<String> references;
    private Object _metadata;


    public Challenge() {
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

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }
    
    public String getOrig_id() {
        return orig_id;
    }

    public void setOrig_id(String orig_id) {
        this.orig_id = orig_id;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_automated() {
        return is_automated;
    }

    public void setIs_automated(Boolean is_automated) {
        this.is_automated = is_automated;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MetricsCategory> getMetrics_categories() {
        return metrics_categories;
    }

    public void setMetrics_categories(List<MetricsCategory> metrics_categories) {
        this.metrics_categories = metrics_categories;
    }



        

    public String getBenchmarking_event_id() {
        return benchmarking_event_id;
    }

    public void setBenchmarking_event_id(String benchmarking_event_id) {
        this.benchmarking_event_id = benchmarking_event_id;
    }

    public List<String> getChallenge_contact_ids() {
        return challenge_contact_ids;
    }

    public void setChallenge_contact_ids(List<String> challenge_contact_ids) {
        this.challenge_contact_ids = challenge_contact_ids;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

   
    
}

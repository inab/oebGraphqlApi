/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.dataset;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 *
 * @author vsundesh
 */
public class DatasetRepositoryImpl implements DatasetRepositoryCustom {
    
    @Autowired
    private MongoTemplate mt;

    @Override
    public List<Dataset> getDatasets(DatasetFilters datasetFilters) {
         
         List <Dataset> datasets = new ArrayList<>();
         Query query = new Query();
        if(datasetFilters!=null){
            if(datasetFilters.getVisibility()!=null){
                query.addCriteria(Criteria.where("visibility").is(datasetFilters.getVisibility()));
            }
            if(datasetFilters.getCommunity_id()!=null){
                query.addCriteria(Criteria.where("community_id").is(datasetFilters.getCommunity_id()));
            }
            datasets = mt.find(query,Dataset.class);
            
        }else{
            datasets = mt.findAll(Dataset.class);
        }
        return datasets;
    }
}

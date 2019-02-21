/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.benchmarkingEvent;

import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vsundesh
 */
@Repository
public interface BenchmarkingEventRepositoryCustom {
    public List<BenchmarkingEvent> getBEventsByCommunityId(String id);
    
}
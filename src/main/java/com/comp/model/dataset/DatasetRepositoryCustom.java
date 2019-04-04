/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.dataset;

import com.comp.pagination.PaginationFilters;
import java.util.List;

/**
 *
 * @author vsundesh
 */
public interface DatasetRepositoryCustom {
    List<Dataset> getDatasets(DatasetFilters datasetFilters, PaginationFilters pagination);
}

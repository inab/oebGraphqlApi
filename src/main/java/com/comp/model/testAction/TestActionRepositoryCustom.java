/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.testAction;

import com.comp.pagination.PaginationFilters;
import java.util.List;

/**
 *
 * @author vicky
 */
public interface TestActionRepositoryCustom {
    List<TestAction> getTestActions(TestActionFilters testActionFilters, PaginationFilters pagination);
    
}

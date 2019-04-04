/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.community;

import com.comp.pagination.PaginationFilters;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vsundesh
 */
@Repository
public interface CommunityRepositoryCustom {
    public List<Community> getCommunities(CommunityFilters communityFilters, PaginationFilters paginationFilters);
    
}
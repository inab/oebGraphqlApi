/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.contact;

import com.comp.pagination.PaginationFilters;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vicky
 */
@Repository
public interface ContactRepositoryCustom {
    public List<Contact> getContacts(ContactFilters contactFilters, PaginationFilters paginationFilters);
}

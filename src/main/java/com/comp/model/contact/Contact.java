/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.contact;

import com.comp.model.utils.Link;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author vsundesh
 */
@Document (collection="Contact")
public class Contact {
    public String _id;
    public String _schema;
    public String contact_type;
    public String givenName;
    public String surname;
    public List<String> email;
    public String community_id;
    public String notes;
    public List<Link> links;
    private Object _metadata;
    
}

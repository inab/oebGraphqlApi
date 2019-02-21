/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.reference;

import com.comp.model.utils.Author;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 *
 * @author vsundesh
 */
@Document (collection="References")
public class Reference {
    private String _id;
    private String _schema;
    private String title;
    private List<String> bibliographic_ids;
    @Field("abstract")
    private String _abstract;
    private List<Author> authors;
    
}

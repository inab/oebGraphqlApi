/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.tool;

import com.comp.model.utils.ToolAccess;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author vsundesh
 */
@Document (collection="Tool")
public class Tool {
    private String _id;
    private String _schema;
    private String registry_tool_id;
    private String name;
    private String description;
    private Boolean is_automated;
    @Field("tool_contact_id")
    private List<String> tool_contact_ids;
    private String status;
    private String activation;
    private String deactivation;
    private List<String> references;
    private List<ToolAccess> tool_access;
    //Not in schema
    private List<String> community_id;
    
}

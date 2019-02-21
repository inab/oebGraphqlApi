/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.tool;

import com.comp.model.utils.ToolAccess;
import java.util.List;

/**
 *
 * @author vsundesh
 */
public class Tool {
    private String tool;
    private String _schema;
    private String registry_tool_id;
    private String name;
    private String description;
    private Boolean is_automated;
    private List<String> tool_contat_ids;
    private String status;
    private String activation;
    private String deactivation;
    private List<String> references;
    private List<ToolAccess> tool_access;
}

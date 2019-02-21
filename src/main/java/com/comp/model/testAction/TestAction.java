/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.model.testAction;

import com.comp.model.utils.Dates;
import com.comp.model.utils.InvolvedDataset;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author vsundesh
 */
@Document (collection="TestAction")
public class TestAction {
    private String _id;
    private String _schema;
    private String orig_id;
    private String tool_id;
    private String action_type;
    private List<InvolvedDataset> involved_datasets;
    private String challenge_id;
    private List<String> test_contact_ids;
    private String status;
    private Dates dates;
    private String metadata;
}

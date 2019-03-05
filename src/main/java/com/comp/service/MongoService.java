/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp.service;

import com.comp.model.benchmarkingEvent.BenchmarkingEvent;
import com.comp.model.benchmarkingEvent.BenchmarkingEventRepository;
import com.comp.model.challenge.Challenge;
import com.comp.model.challenge.ChallengeRepository;

import com.comp.model.community.Community;
import com.comp.model.community.CommunityRepository;
import com.comp.model.dataset.Dataset;
import com.comp.model.dataset.DatasetRepository;
import com.comp.model.tool.Tool;
import com.comp.model.tool.ToolRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vsundesh
 */
@Service
public class MongoService {

    @Autowired
    private CommunityRepository cr;

    @Autowired
    private BenchmarkingEventRepository br;

    @Autowired
    private ChallengeRepository chr;

    @Autowired
    private ToolRepository tr;
    
    @Autowired
    private DatasetRepository dr;
    /**
     * Get all the communities
     *
     * @return list of communities
     */
        public List<Community> getAllCommunities() {
        List<Community> comm = new ArrayList<>();
        try {
            comm = cr.findAll();
            for (Community c : comm) {
                List<BenchmarkingEvent> be = new ArrayList<>();
                be = this.getBEventsByCommunityId(c.getId());
                c.setbEvents(be);
            }
            return comm;
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        return comm;
    }

    /**
     * Get the community by id and all its benchmarking events and all
     * challenges for the benchmarking events
     *
     * @param id
     * @return list of communities with hierarchy
     */
    public Community getCommunityById(String id) {
        Community comm = new Community();
        try {
            comm = cr.getCommunityById(id);
            List<BenchmarkingEvent> be = this.getBEventsByCommunityId(id);
            comm.setbEvents(be);
            return comm;
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return comm;
    }

    /**
     * Get all benchmarking events
     *
     * @return list of benchmarking events
     */
    public List<BenchmarkingEvent> getAllBEvents() {

        List<BenchmarkingEvent> be = new ArrayList<>();
        be = br.findAll();
        for (BenchmarkingEvent b : be) {
            List<Challenge> challenges = new ArrayList<>();
            challenges = this.getChallengesByBEventId(b.getId());
            b.setChallenges(challenges);
        }
        return be;
    }

    /**
     * Get benchmarking event by id and and all the challenges for that event
     *
     * @param id
     * @return list of benchmarking event with hierarchy
     */
    public List<BenchmarkingEvent> getBEventsByCommunityId(String id) {

        List<BenchmarkingEvent> be = new ArrayList<>();
        try {
            be = br.getBEventsByCommunityId(id);
            for (BenchmarkingEvent b : be) {
                List<Challenge> challenges = new ArrayList<>();
                challenges = this.getChallengesByBEventId(b.getId());
                b.setChallenges(challenges);
            }

            return be;
        } catch (NullPointerException e) {
            System.out.println(e);
        }
        return be;
    }

    /**
     * Get Challenge by id
     *
     * @param id
     * @return Challenge
     */
    public List<Challenge> getChallengesByBEventId(String id) {
        return chr.getChallengesByBEventId(id);
    }

    public List<Tool> getAllTools(){
        return tr.findAll();
    }
    
    public List<Dataset> getAllDatasets(){
        return dr.findAll();
    }
}
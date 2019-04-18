/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comp;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author vsundesh
 */
@Component
public class GraphQLProvider {
    @Autowired
    GraphQLDataFetchers graphQLDataFetchers;

    private GraphQL graphQL;

    @PostConstruct
    public void init() {
        URL url = Resources.getResource("schema.graphql");
        String sdl = null;
        try {
            sdl = Resources.toString(url, Charsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(GraphQLProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        
        RuntimeWiring runtimeWiring = buildWiring();

        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
            .scalar(ExtendedScalars.Json)
            .type("Query",typeWiring -> typeWiring       
                    .dataFetcher("getCommunities", graphQLDataFetchers.getCommunities())
                    .dataFetcher("getBenchmarkingEvents",graphQLDataFetchers.getBenchmarkingEvents())
                    .dataFetcher("getChallenges",graphQLDataFetchers.getChallenges())
                    .dataFetcher("getDatasets",graphQLDataFetchers.getDatasets())
                    .dataFetcher("getTools",graphQLDataFetchers.getTools())
                    .dataFetcher("getMetrics", graphQLDataFetchers.getMetrics())
            )
            .type("Community",typeWiring -> typeWiring
                    .dataFetcher("benchmarkingEvents", graphQLDataFetchers.getBenchmarkingEvents())
            )
            .type("BenchmarkingEvent",typeWiring -> typeWiring
                    .dataFetcher("challenges",graphQLDataFetchers.getChallenges())
            )
            .type("Challenge", typeWiring -> typeWiring
                    .dataFetcher("datasets",graphQLDataFetchers.getDatasets())
            )
            .build();
    }

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}

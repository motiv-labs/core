package com.dotcms.graphql;

import com.dotcms.graphql.util.TypeUtil;

import java.util.HashMap;
import java.util.Map;

import graphql.schema.GraphQLInterfaceType;
import graphql.schema.GraphQLOutputType;

import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.BASE_TYPE;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.CATEGORIES;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.CONTENTLET_FOLER;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.CONTENTLET_HOST;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.CONTENT_TYPE;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.DELETED;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.EXPIRE_DATE;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.IDENTIFIER;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.INODE;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.LANGUAGE_ID;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.LIVE;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.LOCKED;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.MOD_DATE;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.PARENT_PATH;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.PATH;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.PUBLISH_DATE;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.TITLE;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.URL_MAP;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.WORKFLOW_ASSIGN;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.WORKFLOW_CREATED_BY;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.WORKFLOW_MOD_DATE;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.WORKFLOW_STEP;
import static com.dotcms.content.elasticsearch.constants.ESMappingConstants.WORKING;
import static graphql.Scalars.GraphQLBoolean;
import static graphql.Scalars.GraphQLID;
import static graphql.Scalars.GraphQLInt;
import static graphql.Scalars.GraphQLString;

public enum InterfaceType {
    CONTENT,
    FILEASSET,
    PAGE,
    PERSONA;

    private static Map<String, GraphQLInterfaceType> interfaceTypes = new HashMap<>();

    static {

        final Map<String, GraphQLOutputType> contentFields = new HashMap<>();
        contentFields.put(MOD_DATE, GraphQLString);
        contentFields.put(TITLE, GraphQLString);
        contentFields.put(CONTENT_TYPE, GraphQLString);
        contentFields.put(BASE_TYPE, GraphQLInt);
        contentFields.put(LIVE, GraphQLBoolean);
        contentFields.put(WORKING, GraphQLBoolean);
        contentFields.put(DELETED, GraphQLBoolean);
        contentFields.put(LOCKED, GraphQLBoolean);
        contentFields.put(LANGUAGE_ID, GraphQLBoolean);
        contentFields.put(IDENTIFIER, GraphQLID);
        contentFields.put(INODE, GraphQLID);
        contentFields.put(CONTENTLET_HOST, GraphQLID);
        contentFields.put(CONTENTLET_FOLER, GraphQLID);
        contentFields.put(PARENT_PATH, GraphQLString);
        contentFields.put(PATH, GraphQLString);
        contentFields.put(WORKFLOW_CREATED_BY, GraphQLString);
        contentFields.put(WORKFLOW_ASSIGN, GraphQLString);
        contentFields.put(WORKFLOW_STEP, GraphQLString);
        contentFields.put(WORKFLOW_MOD_DATE, GraphQLString);
        contentFields.put(PUBLISH_DATE, GraphQLString);
        contentFields.put(EXPIRE_DATE, GraphQLString);
        contentFields.put(URL_MAP, GraphQLString);
        contentFields.put(CATEGORIES, GraphQLString);

        interfaceTypes.put("CONTENT", TypeUtil.createInterfaceType("Content", contentFields, new ContentResolver()));
    }

    public GraphQLInterfaceType getType() {
        return interfaceTypes.get(this.name());
    }
}

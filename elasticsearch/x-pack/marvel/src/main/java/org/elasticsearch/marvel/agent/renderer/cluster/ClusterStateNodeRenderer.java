/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.marvel.agent.renderer.cluster;

import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentBuilderString;
import org.elasticsearch.marvel.agent.collector.cluster.ClusterStateNodeMarvelDoc;
import org.elasticsearch.marvel.agent.renderer.AbstractRenderer;

import java.io.IOException;

public class ClusterStateNodeRenderer extends AbstractRenderer<ClusterStateNodeMarvelDoc> {

    public ClusterStateNodeRenderer() {
        super(null, false);
    }

    @Override
    protected void doRender(ClusterStateNodeMarvelDoc marvelDoc, XContentBuilder builder, ToXContent.Params params) throws IOException {
        builder.field(Fields.STATE_UUID, marvelDoc.getStateUUID());
        builder.startObject(Fields.NODE);
        builder.field(Fields.ID, marvelDoc.getNodeId());
        builder.endObject();
    }

    static final class Fields {
        static final XContentBuilderString STATE_UUID = new XContentBuilderString("state_uuid");
        static final XContentBuilderString NODE = new XContentBuilderString("node");
        static final XContentBuilderString ID = new XContentBuilderString("id");
    }
}

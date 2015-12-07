/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.license.plugin.action.get;

import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.license.core.License;

import java.io.IOException;

public class GetLicenseResponse extends ActionResponse {

    private License license;

    GetLicenseResponse() {
    }

    GetLicenseResponse(License license) {
        this.license = license;
    }

    public License license() {
        return license;
    }

    @Override
    public void readFrom(StreamInput in) throws IOException {
        super.readFrom(in);
        if (in.readBoolean()) {
            license = License.readLicense(in);
        }
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        super.writeTo(out);
        if (license == null) {
            out.writeBoolean(false);
        } else {
            out.writeBoolean(true);
            license.writeTo(out);
        }
    }

}
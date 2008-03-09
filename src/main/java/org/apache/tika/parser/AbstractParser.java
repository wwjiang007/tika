/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.tika.parser;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Abstract parser base class. Contains a default implementation of the
 * {@link #parse(InputStream, Metadata)} method.
 */
public abstract class AbstractParser implements Parser {

    /**
     * Calls the full
     * {@link Parser#parse(InputStream, org.xml.sax.ContentHandler, Metadata)}
     * method and keeps only the extracted metatdata.
     */
    public void parse(InputStream stream, Metadata metadata)
            throws IOException, TikaException {
        try {
            parse(stream, new DefaultHandler(), metadata);
        } catch (SAXException e) {
            throw new TikaException("Unexpected SAX error", e);
        }
    }

}

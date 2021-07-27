/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hudi.io.storage.row;

import org.apache.flink.table.data.RowData;

import java.io.IOException;

/**
 * Abstraction to assist in writing {@link RowData}s to be used in datasource implementation.
 */
public interface HoodieRowDataFileWriter {

  /**
   * Returns {@code true} if this RowFileWriter can take in more writes. else {@code false}.
   */
  boolean canWrite();

  /**
   * Writes an {@link RowData} to the {@link HoodieRowDataFileWriter}. Also takes in associated record key to be added to bloom filter if required.
   *
   * @throws IOException on any exception while writing.
   */
  void writeRow(String key, RowData row) throws IOException;

  /**
   * Writes an {@link RowData} to the {@link HoodieRowDataFileWriter}.
   *
   * @throws IOException on any exception while writing.
   */
  void writeRow(RowData row) throws IOException;

  /**
   * Closes the {@link HoodieRowDataFileWriter} and may not take in any more writes.
   */
  void close() throws IOException;
}

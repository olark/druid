/*
 * Druid - a distributed column store.
 * Copyright (C) 2012  Metamarkets Group Inc.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package com.metamx.druid.shard;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Maps;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.metamx.druid.input.InputRow;
import com.metamx.druid.jackson.DefaultObjectMapper;
import com.metamx.druid.partition.NumberedPartitionChunk;
import com.metamx.druid.partition.PartitionChunk;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class NumberedShardSpec implements ShardSpec
{
  @JsonIgnore
  final private int partitionNum;

  @JsonIgnore
  final private int partitions;

  private static HashFunction hashFunction = null;
  public static ObjectMapper jsonMapper;

  static {
    jsonMapper = new DefaultObjectMapper();
    jsonMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
  }

  @JsonCreator
  public NumberedShardSpec(
      @JsonProperty("partitionNum") int partitionNum,
      @JsonProperty("partitions") int partitions
  )
  {
    Preconditions.checkArgument(partitionNum >= 0, "partitionNum >= 0");
    Preconditions.checkArgument(partitionNum < partitions, "partitionNum < partitions");
    this.partitionNum = partitionNum;
    this.partitions = partitions;
    hashFunction = Hashing.murmur3_32();
  }

  @JsonProperty("partitionNum")
  @Override
  public int getPartitionNum()
  {
    return partitionNum;
  }

  @JsonProperty("partitions")
  public int getPartitions()
  {
    return partitions;
  }

  @Override
  public <T> PartitionChunk<T> createChunk(T obj)
  {
    return NumberedPartitionChunk.make(partitionNum, partitions, obj);
  }

  @Override
  public boolean isInChunk(Map<String, String> dimensions)
  {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isInChunk(InputRow inputRow)
  {
    final Map<String, Set<String>> dims = Maps.newTreeMap();
    for(final String dim : inputRow.getDimensions()) {
      final Set<String> dimValues = ImmutableSortedSet.copyOf(inputRow.getDimension(dim));
      if(dimValues.size() > 0) {
        dims.put(dim, dimValues);
      }
    }
    final List<Object> groupKey = ImmutableList.of(
        inputRow.getTimestampFromEpoch(),
        dims
    );
    try {
      int x = hashFunction.hashBytes(jsonMapper.writeValueAsBytes(groupKey)).asInt();
      return Math.abs(x) % partitions == partitionNum;
    }
    catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return true;
  }
}

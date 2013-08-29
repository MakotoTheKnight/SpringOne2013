/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.springframework.xd.demo.gemfire.function;

import java.util.List;
import java.util.Map;

import org.springframework.data.gemfire.function.annotation.OnRegion;

/**
 * @author David Turanski
 *
 */
@OnRegion(region="hashtags")
public interface HashTagAnalyzer {
	public abstract List<Map<String,Integer>> aggregateAssociatedHashTags(String targetHashTag);

}
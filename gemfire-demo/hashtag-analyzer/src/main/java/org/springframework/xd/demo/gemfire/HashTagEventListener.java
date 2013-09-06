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
package org.springframework.xd.demo.gemfire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gemstone.gemfire.cache.query.CqEvent;
import com.gemstone.gemfire.cache.query.CqListener;

/**
 * @author David Turanski
 *
 */
public class HashTagEventListener implements CqListener {
	protected final List<TweetSummary> results;
	public HashTagEventListener() {
		this.results = Collections.synchronizedList(new ArrayList<TweetSummary>());
	}
	
	/* (non-Javadoc)
	 * @see com.gemstone.gemfire.cache.CacheCallback#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.gemstone.gemfire.cache.query.CqListener#onError(com.gemstone.gemfire.cache.query.CqEvent)
	 */
	@Override
	public void onError(CqEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.gemstone.gemfire.cache.query.CqListener#onEvent(com.gemstone.gemfire.cache.query.CqEvent)
	 */
	@Override
	public void onEvent(CqEvent event) {
		TweetSummary tweet = (TweetSummary) event.getNewValue();
		results.add(tweet);
	}
	
	public void reset() {
		results.clear();
	}
	
	public List<TweetSummary> getTweets() {
		return results;
	}

}

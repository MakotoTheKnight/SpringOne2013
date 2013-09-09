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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;
import org.springframework.integration.x.twitter.XDHashTagEntity;
import org.springframework.integration.x.twitter.XDTweet;
/**
 * Value object for cached tweets
 * 
 * @author David Turanski
 *
 */
@SuppressWarnings("serial")
@Region("hashtags")
public class TweetSummary implements Serializable {
	@Id
	private String id;
	private String text;
	private String lang;
	private List<String> hashTags;
	private long createdAt;

	public TweetSummary(XDTweet tweet){
		this.id = String.valueOf(tweet.getId());
		this.text = tweet.getText();
		this.lang = tweet.getLanguageCode();
		this.createdAt = tweet.getCreatedAt().getTime();
		this.hashTags = new ArrayList<String>(tweet.getEntities().getHashTags().size());
		List<XDHashTagEntity> tags = tweet.getEntities().getHashTags();
		for (XDHashTagEntity tag: tags) {
			hashTags.add(tag.getText());
		}
	}
	
	public TweetSummary(){
		
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	/**
	 * @return the hashTags
	 */
	public List<String> getHashTags() {
		return hashTags;
	}
	/**
	 * @param hashTags the hashTags to set
	 */
	public void setHashTags(List<String> hashTags) {
		this.hashTags = hashTags;
	}
	/**
	 * @return the createdAt
	 */
	public long getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
}

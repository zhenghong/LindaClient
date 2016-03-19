package com.lm.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisServiceCluster {

	// String
	void setString(String key, String value);

	void delString(String key);

	String getString(String key, String value);

	// hash
	void addHash(String key, Map<String,String> value);

	void delHash(String key);

	void setHash(String key, String cKey, String cValue);

	String getHash(String key, String cKey);

	// list
	void addList(String key, String... value);

	void delList(String key);

	Long getLenList(String key);

	void setIndexList(String key, Long index, String value);

	String getList(String key, Long index);

	List<String> getAllList(String key, Long start, Long end);

	// set
	void addSet(String key, String... value);

	void delSet(String key);

	void delSomeSet(String key, String... value);

	Set<String> getAllSet(String key);

	// sorted set
	void addZSet(String key, Map<String,Double> value);

	void delZSet(String key);

	void delSomeZSet(String key, String... value);

	Set<String> getAllZSet(String key, long start, long end);

}

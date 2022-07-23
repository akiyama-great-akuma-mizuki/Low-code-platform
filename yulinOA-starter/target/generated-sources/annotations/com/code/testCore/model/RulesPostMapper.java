package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesPostMapper {
  public String rulesTitle;

  public Long releaseTime;

  public Long executeTime;

  public String userId;

  public RulesPostMapper() {
  }

  public RulesPostMapper(String rulesTitle, Long releaseTime, Long executeTime, String userId) {
    this.rulesTitle=rulesTitle;
    this.releaseTime=releaseTime;
    this.executeTime=executeTime;
    this.userId=userId;
  }

  public static RulesPostMapper buildMapper(Rules obj) {
    RulesPostMapper mapper = new RulesPostMapper();
    mapper.rulesTitle=obj.getRulesTitle();
    mapper.releaseTime=obj.modifyTime(obj.getReleaseTime());
    mapper.executeTime=obj.modifyTime(obj.getExecuteTime());
    mapper.userId=obj.getUserId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("rulesTitle",this.rulesTitle);
    map.put("releaseTime",this.releaseTime);
    map.put("executeTime",this.executeTime);
    map.put("userId",this.userId);
    return map;
  }

  public static Map<String, Object> buildMap(Rules obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("rulesTitle", obj.getRulesTitle());
    map.put("releaseTime", obj.modifyTime(obj.getReleaseTime()));
    map.put("executeTime", obj.modifyTime(obj.getExecuteTime()));
    map.put("userId", obj.getUserId());
    return map;
  }

  public static Map<String, String> buildSerialMap(Rules obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("rulesTitle", JSONObject.toJSONString(obj.getRulesTitle()));
    map.put("releaseTime", JSONObject.toJSONString(obj.modifyTime(obj.getReleaseTime())));
    map.put("executeTime", JSONObject.toJSONString(obj.modifyTime(obj.getExecuteTime())));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    return map;
  }

  public Rules buildEntity() {
    Rules obj = new Rules();
    obj.setRulesTitle(this.rulesTitle);
    obj.setReleaseTime(obj.recoverTime(this.releaseTime));
    obj.setExecuteTime(obj.recoverTime(this.executeTime));
    obj.setUserId(this.userId);
    return obj;
  }

  public static Rules parseEntity(Map<String, Object> map) {
    Rules obj = new Rules();
    if (map == null) return obj;
    obj.setRulesTitle((String) map.get("rulesTitle"));
    obj.setReleaseTime(obj.recoverTime((Long) map.get("releaseTime")));
    obj.setExecuteTime(obj.recoverTime((Long) map.get("executeTime")));
    obj.setUserId((String) map.get("userId"));
    return obj;
  }

  public static Rules parseSerialEntity(Map<String, String> map) {
    Rules obj = new Rules();
    if (map == null) return obj;
    obj.setRulesTitle(JSONObject.parseObject(map.get("rulesTitle"), String.class));
    obj.setReleaseTime(obj.recoverTime(JSONObject.parseObject(map.get("releaseTime"), Long.class)));
    obj.setExecuteTime(obj.recoverTime(JSONObject.parseObject(map.get("executeTime"), Long.class)));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    return obj;
  }
}

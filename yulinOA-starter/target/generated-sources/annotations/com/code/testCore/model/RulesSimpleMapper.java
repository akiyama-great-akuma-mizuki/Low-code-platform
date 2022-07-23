package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesSimpleMapper {
  public String id;

  public String rulesTitle;

  public Long releaseTime;

  public Long executeTime;

  public String userId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public RulesSimpleMapper() {
  }

  public RulesSimpleMapper(String id, String rulesTitle, Long releaseTime, Long executeTime,
      String userId, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.rulesTitle=rulesTitle;
    this.releaseTime=releaseTime;
    this.executeTime=executeTime;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static RulesSimpleMapper buildMapper(Rules obj) {
    RulesSimpleMapper mapper = new RulesSimpleMapper();
    mapper.id=obj.getId();
    mapper.rulesTitle=obj.getRulesTitle();
    mapper.releaseTime=obj.modifyTime(obj.getReleaseTime());
    mapper.executeTime=obj.modifyTime(obj.getExecuteTime());
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("rulesTitle",this.rulesTitle);
    map.put("releaseTime",this.releaseTime);
    map.put("executeTime",this.executeTime);
    map.put("userId",this.userId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Rules obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("rulesTitle", obj.getRulesTitle());
    map.put("releaseTime", obj.modifyTime(obj.getReleaseTime()));
    map.put("executeTime", obj.modifyTime(obj.getExecuteTime()));
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Rules obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("rulesTitle", JSONObject.toJSONString(obj.getRulesTitle()));
    map.put("releaseTime", JSONObject.toJSONString(obj.modifyTime(obj.getReleaseTime())));
    map.put("executeTime", JSONObject.toJSONString(obj.modifyTime(obj.getExecuteTime())));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Rules buildEntity() {
    Rules obj = new Rules();
    obj.setId(this.id);
    obj.setRulesTitle(this.rulesTitle);
    obj.setReleaseTime(obj.recoverTime(this.releaseTime));
    obj.setExecuteTime(obj.recoverTime(this.executeTime));
    obj.setUserId(this.userId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Rules parseEntity(Map<String, Object> map) {
    Rules obj = new Rules();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setRulesTitle((String) map.get("rulesTitle"));
    obj.setReleaseTime(obj.recoverTime((Long) map.get("releaseTime")));
    obj.setExecuteTime(obj.recoverTime((Long) map.get("executeTime")));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Rules parseSerialEntity(Map<String, String> map) {
    Rules obj = new Rules();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setRulesTitle(JSONObject.parseObject(map.get("rulesTitle"), String.class));
    obj.setReleaseTime(obj.recoverTime(JSONObject.parseObject(map.get("releaseTime"), Long.class)));
    obj.setExecuteTime(obj.recoverTime(JSONObject.parseObject(map.get("executeTime"), Long.class)));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

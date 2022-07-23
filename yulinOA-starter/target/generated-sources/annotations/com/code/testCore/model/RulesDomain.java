package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.RulesTO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesDomain {
  public String id;

  public String rulesTitle;

  public Date releaseTime;

  public Date executeTime;

  public String userId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public RulesDomain() {
  }

  public RulesDomain(String id, String rulesTitle, Date releaseTime, Date executeTime,
      String userId, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.rulesTitle=rulesTitle;
    this.releaseTime=releaseTime;
    this.executeTime=executeTime;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static RulesDomain buildMapper(Rules obj) {
    RulesDomain mapper = new RulesDomain();
    mapper.id=obj.getId();
    mapper.rulesTitle=obj.getRulesTitle();
    mapper.releaseTime=obj.getReleaseTime();
    mapper.executeTime=obj.getExecuteTime();
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("releaseTime", obj.getReleaseTime());
    map.put("executeTime", obj.getExecuteTime());
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(Rules obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("rulesTitle", JSONObject.toJSONString(obj.getRulesTitle()));
    map.put("releaseTime", JSONObject.toJSONString(obj.getReleaseTime()));
    map.put("executeTime", JSONObject.toJSONString(obj.getExecuteTime()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public Rules buildEntity() {
    Rules obj = new Rules();
    obj.setId(this.id);
    obj.setRulesTitle(this.rulesTitle);
    obj.setReleaseTime(this.releaseTime);
    obj.setExecuteTime(this.executeTime);
    obj.setUserId(this.userId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static Rules parseEntity(Map<String, Object> map) {
    Rules obj = new Rules();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setRulesTitle((String) map.get("rulesTitle"));
    obj.setReleaseTime((Date) map.get("releaseTime"));
    obj.setExecuteTime((Date) map.get("executeTime"));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static Rules parseSerialEntity(Map<String, String> map) {
    Rules obj = new Rules();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setRulesTitle(JSONObject.parseObject(map.get("rulesTitle"), String.class));
    obj.setReleaseTime(JSONObject.parseObject(map.get("releaseTime"), Date.class));
    obj.setExecuteTime(JSONObject.parseObject(map.get("executeTime"), Date.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static RulesTO convert(Rules from, RulesTO to) {
    if (from == null) return to;
    if (to == null) to = new RulesTO();
    to.setId(from.getId());
    to.setRulesTitle(from.getRulesTitle());
    to.setReleaseTime(from.getReleaseTime());
    to.setExecuteTime(from.getExecuteTime());
    to.setUserId(from.getUserId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static Rules convert(RulesTO from, Rules to) {
    if (from == null) return to;
    if (to == null) to = new Rules();
    to.setId(from.getId());
    to.setRulesTitle(from.getRulesTitle());
    to.setReleaseTime(from.getReleaseTime());
    to.setExecuteTime(from.getExecuteTime());
    to.setUserId(from.getUserId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

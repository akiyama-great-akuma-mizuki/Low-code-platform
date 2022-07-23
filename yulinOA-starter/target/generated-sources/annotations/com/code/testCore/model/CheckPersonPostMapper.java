package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckPersonPostMapper {
  public String checkId;

  public Integer status;

  public String userId;

  public CheckPersonPostMapper() {
  }

  public CheckPersonPostMapper(String checkId, Integer status, String userId) {
    this.checkId=checkId;
    this.status=status;
    this.userId=userId;
  }

  public static CheckPersonPostMapper buildMapper(CheckPerson obj) {
    CheckPersonPostMapper mapper = new CheckPersonPostMapper();
    mapper.checkId=obj.getCheckId();
    mapper.status=obj.getStatus();
    mapper.userId=obj.getUserId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("checkId",this.checkId);
    map.put("status",this.status);
    map.put("userId",this.userId);
    return map;
  }

  public static Map<String, Object> buildMap(CheckPerson obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("checkId", obj.getCheckId());
    map.put("status", obj.getStatus());
    map.put("userId", obj.getUserId());
    return map;
  }

  public static Map<String, String> buildSerialMap(CheckPerson obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("checkId", JSONObject.toJSONString(obj.getCheckId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    return map;
  }

  public CheckPerson buildEntity() {
    CheckPerson obj = new CheckPerson();
    obj.setCheckId(this.checkId);
    obj.setStatus(this.status);
    obj.setUserId(this.userId);
    return obj;
  }

  public static CheckPerson parseEntity(Map<String, Object> map) {
    CheckPerson obj = new CheckPerson();
    if (map == null) return obj;
    obj.setCheckId((String) map.get("checkId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setUserId((String) map.get("userId"));
    return obj;
  }

  public static CheckPerson parseSerialEntity(Map<String, String> map) {
    CheckPerson obj = new CheckPerson();
    if (map == null) return obj;
    obj.setCheckId(JSONObject.parseObject(map.get("checkId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    return obj;
  }
}

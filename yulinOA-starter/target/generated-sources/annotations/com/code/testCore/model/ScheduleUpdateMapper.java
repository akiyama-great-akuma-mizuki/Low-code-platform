package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScheduleUpdateMapper {
  public String id;

  public String userId;

  public ScheduleUpdateMapper() {
  }

  public ScheduleUpdateMapper(String id, String userId) {
    this.id=id;
    this.userId=userId;
  }

  public static ScheduleUpdateMapper buildMapper(Schedule obj) {
    ScheduleUpdateMapper mapper = new ScheduleUpdateMapper();
    mapper.id=obj.getId();
    mapper.userId=obj.getUserId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("userId",this.userId);
    return map;
  }

  public static Map<String, Object> buildMap(Schedule obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("userId", obj.getUserId());
    return map;
  }

  public static Map<String, String> buildSerialMap(Schedule obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    return map;
  }

  public Schedule buildEntity() {
    Schedule obj = new Schedule();
    obj.setId(this.id);
    obj.setUserId(this.userId);
    return obj;
  }

  public static Schedule parseEntity(Map<String, Object> map) {
    Schedule obj = new Schedule();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setUserId((String) map.get("userId"));
    return obj;
  }

  public static Schedule parseSerialEntity(Map<String, String> map) {
    Schedule obj = new Schedule();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    return obj;
  }
}

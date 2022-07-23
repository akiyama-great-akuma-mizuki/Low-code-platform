package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckPostMapper {
  public String eventId;

  public Integer status;

  public Integer type;

  public CheckPostMapper() {
  }

  public CheckPostMapper(String eventId, Integer status, Integer type) {
    this.eventId=eventId;
    this.status=status;
    this.type=type;
  }

  public static CheckPostMapper buildMapper(Check obj) {
    CheckPostMapper mapper = new CheckPostMapper();
    mapper.eventId=obj.getEventId();
    mapper.status=obj.getStatus();
    mapper.type=obj.getType();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("eventId",this.eventId);
    map.put("status",this.status);
    map.put("type",this.type);
    return map;
  }

  public static Map<String, Object> buildMap(Check obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("eventId", obj.getEventId());
    map.put("status", obj.getStatus());
    map.put("type", obj.getType());
    return map;
  }

  public static Map<String, String> buildSerialMap(Check obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    return map;
  }

  public Check buildEntity() {
    Check obj = new Check();
    obj.setEventId(this.eventId);
    obj.setStatus(this.status);
    obj.setType(this.type);
    return obj;
  }

  public static Check parseEntity(Map<String, Object> map) {
    Check obj = new Check();
    if (map == null) return obj;
    obj.setEventId((String) map.get("eventId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setType((Integer) map.get("type"));
    return obj;
  }

  public static Check parseSerialEntity(Map<String, String> map) {
    Check obj = new Check();
    if (map == null) return obj;
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setType(JSONObject.parseObject(map.get("type"), Integer.class));
    return obj;
  }
}

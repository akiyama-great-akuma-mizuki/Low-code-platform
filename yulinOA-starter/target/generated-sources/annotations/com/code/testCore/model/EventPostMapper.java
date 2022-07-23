package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class EventPostMapper {
  public String type;

  public String status;

  public String name;

  public EventPostMapper() {
  }

  public EventPostMapper(String type, String status, String name) {
    this.type=type;
    this.status=status;
    this.name=name;
  }

  public static EventPostMapper buildMapper(Event obj) {
    EventPostMapper mapper = new EventPostMapper();
    mapper.type=obj.getType();
    mapper.status=obj.getStatus();
    mapper.name=obj.getName();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("type",this.type);
    map.put("status",this.status);
    map.put("name",this.name);
    return map;
  }

  public static Map<String, Object> buildMap(Event obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("type", obj.getType());
    map.put("status", obj.getStatus());
    map.put("name", obj.getName());
    return map;
  }

  public static Map<String, String> buildSerialMap(Event obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    return map;
  }

  public Event buildEntity() {
    Event obj = new Event();
    obj.setType(this.type);
    obj.setStatus(this.status);
    obj.setName(this.name);
    return obj;
  }

  public static Event parseEntity(Map<String, Object> map) {
    Event obj = new Event();
    if (map == null) return obj;
    obj.setType((String) map.get("type"));
    obj.setStatus((String) map.get("status"));
    obj.setName((String) map.get("name"));
    return obj;
  }

  public static Event parseSerialEntity(Map<String, String> map) {
    Event obj = new Event();
    if (map == null) return obj;
    obj.setType(JSONObject.parseObject(map.get("type"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    return obj;
  }
}

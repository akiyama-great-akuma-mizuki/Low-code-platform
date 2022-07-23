package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EventFilterMapper {
  public String id;

  public String type;

  public String status;

  public String name;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public EventFilterMapper() {
  }

  public EventFilterMapper(String id, String type, String status, String name) {
    this.id=id;
    this.type=type;
    this.status=status;
    this.name=name;
  }

  public static EventFilterMapper buildMapper(Event obj) {
    EventFilterMapper mapper = new EventFilterMapper();
    mapper.id=obj.getId();
    mapper.type=obj.getType();
    mapper.status=obj.getStatus();
    mapper.name=obj.getName();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("type",this.type);
    map.put("status",this.status);
    map.put("name",this.name);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Event obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("type", obj.getType());
    map.put("status", obj.getStatus());
    map.put("name", obj.getName());
    return map;
  }

  public static Map<String, String> buildSerialMap(Event obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    return map;
  }

  public Event buildEntity() {
    Event obj = new Event();
    obj.setId(this.id);
    obj.setType(this.type);
    obj.setStatus(this.status);
    obj.setName(this.name);
    return obj;
  }

  public static Event parseEntity(Map<String, Object> map) {
    Event obj = new Event();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setType((String) map.get("type"));
    obj.setStatus((String) map.get("status"));
    obj.setName((String) map.get("name"));
    return obj;
  }

  public static Event parseSerialEntity(Map<String, String> map) {
    Event obj = new Event();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setType(JSONObject.parseObject(map.get("type"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Event obj, Long page, Integer rows,
      List<String> orderBy, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Event obj, Long page, Integer rows,
      List<String> orderBy, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

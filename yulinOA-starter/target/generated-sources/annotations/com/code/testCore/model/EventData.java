package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.EventDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class EventData {
  public String id;

  public String type;

  public String status;

  public String name;

  public Date gmtUpdate;

  public Date gmtCreate;

  public EventData() {
  }

  public EventData(String id, String type, String status, String name, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.type=type;
    this.status=status;
    this.name=name;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static EventData buildMapper(Event obj) {
    EventData mapper = new EventData();
    mapper.id=obj.getId();
    mapper.type=obj.getType();
    mapper.status=obj.getStatus();
    mapper.name=obj.getName();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("type",this.type);
    map.put("status",this.status);
    map.put("name",this.name);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Event obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("type", obj.getType());
    map.put("status", obj.getStatus());
    map.put("name", obj.getName());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(Event obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public Event buildEntity() {
    Event obj = new Event();
    obj.setId(this.id);
    obj.setType(this.type);
    obj.setStatus(this.status);
    obj.setName(this.name);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static Event parseEntity(Map<String, Object> map) {
    Event obj = new Event();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setType((String) map.get("type"));
    obj.setStatus((String) map.get("status"));
    obj.setName((String) map.get("name"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static Event parseSerialEntity(Map<String, String> map) {
    Event obj = new Event();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setType(JSONObject.parseObject(map.get("type"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static EventDO convert(Event from, EventDO to) {
    if (from == null) return to;
    if (to == null) to = new EventDO();
    to.setId(from.getId());
    to.setType(from.getType());
    to.setStatus(from.getStatus());
    to.setName(from.getName());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static Event convert(EventDO from, Event to) {
    if (from == null) return to;
    if (to == null) to = new Event();
    to.setId(from.getId());
    to.setType(from.getType());
    to.setStatus(from.getStatus());
    to.setName(from.getName());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

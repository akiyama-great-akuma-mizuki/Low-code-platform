package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScheduleItemFilterMapper {
  public String id;

  public String scheduleId;

  public Integer status;

  public String eventName;

  public Integer eventType;

  public String eventId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public ScheduleItemFilterMapper() {
  }

  public ScheduleItemFilterMapper(String id, String scheduleId, Integer status, String eventName,
      Integer eventType, String eventId) {
    this.id=id;
    this.scheduleId=scheduleId;
    this.status=status;
    this.eventName=eventName;
    this.eventType=eventType;
    this.eventId=eventId;
  }

  public static ScheduleItemFilterMapper buildMapper(ScheduleItem obj) {
    ScheduleItemFilterMapper mapper = new ScheduleItemFilterMapper();
    mapper.id=obj.getId();
    mapper.scheduleId=obj.getScheduleId();
    mapper.status=obj.getStatus();
    mapper.eventName=obj.getEventName();
    mapper.eventType=obj.getEventType();
    mapper.eventId=obj.getEventId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("scheduleId",this.scheduleId);
    map.put("status",this.status);
    map.put("eventName",this.eventName);
    map.put("eventType",this.eventType);
    map.put("eventId",this.eventId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(ScheduleItem obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("scheduleId", obj.getScheduleId());
    map.put("status", obj.getStatus());
    map.put("eventName", obj.getEventName());
    map.put("eventType", obj.getEventType());
    map.put("eventId", obj.getEventId());
    return map;
  }

  public static Map<String, String> buildSerialMap(ScheduleItem obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("scheduleId", JSONObject.toJSONString(obj.getScheduleId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("eventName", JSONObject.toJSONString(obj.getEventName()));
    map.put("eventType", JSONObject.toJSONString(obj.getEventType()));
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    return map;
  }

  public ScheduleItem buildEntity() {
    ScheduleItem obj = new ScheduleItem();
    obj.setId(this.id);
    obj.setScheduleId(this.scheduleId);
    obj.setStatus(this.status);
    obj.setEventName(this.eventName);
    obj.setEventType(this.eventType);
    obj.setEventId(this.eventId);
    return obj;
  }

  public static ScheduleItem parseEntity(Map<String, Object> map) {
    ScheduleItem obj = new ScheduleItem();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setScheduleId((String) map.get("scheduleId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setEventName((String) map.get("eventName"));
    obj.setEventType((Integer) map.get("eventType"));
    obj.setEventId((String) map.get("eventId"));
    return obj;
  }

  public static ScheduleItem parseSerialEntity(Map<String, String> map) {
    ScheduleItem obj = new ScheduleItem();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setScheduleId(JSONObject.parseObject(map.get("scheduleId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setEventName(JSONObject.parseObject(map.get("eventName"), String.class));
    obj.setEventType(JSONObject.parseObject(map.get("eventType"), Integer.class));
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(ScheduleItem obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(ScheduleItem obj, Long page, Integer rows,
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

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScheduleItemPostMapper {
  public String scheduleId;

  public Long beginDate;

  public Long endDate;

  public Integer status;

  public String eventName;

  public Integer eventType;

  public String eventId;

  public ScheduleItemPostMapper() {
  }

  public ScheduleItemPostMapper(String scheduleId, Long beginDate, Long endDate, Integer status,
      String eventName, Integer eventType, String eventId) {
    this.scheduleId=scheduleId;
    this.beginDate=beginDate;
    this.endDate=endDate;
    this.status=status;
    this.eventName=eventName;
    this.eventType=eventType;
    this.eventId=eventId;
  }

  public static ScheduleItemPostMapper buildMapper(ScheduleItem obj) {
    ScheduleItemPostMapper mapper = new ScheduleItemPostMapper();
    mapper.scheduleId=obj.getScheduleId();
    mapper.beginDate=obj.modifyTime(obj.getBeginDate());
    mapper.endDate=obj.modifyTime(obj.getEndDate());
    mapper.status=obj.getStatus();
    mapper.eventName=obj.getEventName();
    mapper.eventType=obj.getEventType();
    mapper.eventId=obj.getEventId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("scheduleId",this.scheduleId);
    map.put("beginDate",this.beginDate);
    map.put("endDate",this.endDate);
    map.put("status",this.status);
    map.put("eventName",this.eventName);
    map.put("eventType",this.eventType);
    map.put("eventId",this.eventId);
    return map;
  }

  public static Map<String, Object> buildMap(ScheduleItem obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("scheduleId", obj.getScheduleId());
    map.put("beginDate", obj.modifyTime(obj.getBeginDate()));
    map.put("endDate", obj.modifyTime(obj.getEndDate()));
    map.put("status", obj.getStatus());
    map.put("eventName", obj.getEventName());
    map.put("eventType", obj.getEventType());
    map.put("eventId", obj.getEventId());
    return map;
  }

  public static Map<String, String> buildSerialMap(ScheduleItem obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("scheduleId", JSONObject.toJSONString(obj.getScheduleId()));
    map.put("beginDate", JSONObject.toJSONString(obj.modifyTime(obj.getBeginDate())));
    map.put("endDate", JSONObject.toJSONString(obj.modifyTime(obj.getEndDate())));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("eventName", JSONObject.toJSONString(obj.getEventName()));
    map.put("eventType", JSONObject.toJSONString(obj.getEventType()));
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    return map;
  }

  public ScheduleItem buildEntity() {
    ScheduleItem obj = new ScheduleItem();
    obj.setScheduleId(this.scheduleId);
    obj.setBeginDate(obj.recoverTime(this.beginDate));
    obj.setEndDate(obj.recoverTime(this.endDate));
    obj.setStatus(this.status);
    obj.setEventName(this.eventName);
    obj.setEventType(this.eventType);
    obj.setEventId(this.eventId);
    return obj;
  }

  public static ScheduleItem parseEntity(Map<String, Object> map) {
    ScheduleItem obj = new ScheduleItem();
    if (map == null) return obj;
    obj.setScheduleId((String) map.get("scheduleId"));
    obj.setBeginDate(obj.recoverTime((Long) map.get("beginDate")));
    obj.setEndDate(obj.recoverTime((Long) map.get("endDate")));
    obj.setStatus((Integer) map.get("status"));
    obj.setEventName((String) map.get("eventName"));
    obj.setEventType((Integer) map.get("eventType"));
    obj.setEventId((String) map.get("eventId"));
    return obj;
  }

  public static ScheduleItem parseSerialEntity(Map<String, String> map) {
    ScheduleItem obj = new ScheduleItem();
    if (map == null) return obj;
    obj.setScheduleId(JSONObject.parseObject(map.get("scheduleId"), String.class));
    obj.setBeginDate(obj.recoverTime(JSONObject.parseObject(map.get("beginDate"), Long.class)));
    obj.setEndDate(obj.recoverTime(JSONObject.parseObject(map.get("endDate"), Long.class)));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setEventName(JSONObject.parseObject(map.get("eventName"), String.class));
    obj.setEventType(JSONObject.parseObject(map.get("eventType"), Integer.class));
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    return obj;
  }
}

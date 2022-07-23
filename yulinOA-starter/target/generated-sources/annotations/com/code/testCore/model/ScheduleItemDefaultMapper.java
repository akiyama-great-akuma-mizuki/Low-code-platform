package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScheduleItemDefaultMapper {
  public String id;

  public String scheduleId;

  public Date beginDate;

  public Date endDate;

  public Integer status;

  public String eventName;

  public Integer eventType;

  public String eventId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public ScheduleItemDefaultMapper() {
  }

  public ScheduleItemDefaultMapper(String id, String scheduleId, Date beginDate, Date endDate,
      Integer status, String eventName, Integer eventType, String eventId, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.scheduleId=scheduleId;
    this.beginDate=beginDate;
    this.endDate=endDate;
    this.status=status;
    this.eventName=eventName;
    this.eventType=eventType;
    this.eventId=eventId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ScheduleItemDefaultMapper buildMapper(ScheduleItem obj) {
    ScheduleItemDefaultMapper mapper = new ScheduleItemDefaultMapper();
    mapper.id=obj.getId();
    mapper.scheduleId=obj.getScheduleId();
    mapper.beginDate=obj.getBeginDate();
    mapper.endDate=obj.getEndDate();
    mapper.status=obj.getStatus();
    mapper.eventName=obj.getEventName();
    mapper.eventType=obj.getEventType();
    mapper.eventId=obj.getEventId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("scheduleId",this.scheduleId);
    map.put("beginDate",this.beginDate);
    map.put("endDate",this.endDate);
    map.put("status",this.status);
    map.put("eventName",this.eventName);
    map.put("eventType",this.eventType);
    map.put("eventId",this.eventId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(ScheduleItem obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("scheduleId", obj.getScheduleId());
    map.put("beginDate", obj.getBeginDate());
    map.put("endDate", obj.getEndDate());
    map.put("status", obj.getStatus());
    map.put("eventName", obj.getEventName());
    map.put("eventType", obj.getEventType());
    map.put("eventId", obj.getEventId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(ScheduleItem obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("scheduleId", JSONObject.toJSONString(obj.getScheduleId()));
    map.put("beginDate", JSONObject.toJSONString(obj.getBeginDate()));
    map.put("endDate", JSONObject.toJSONString(obj.getEndDate()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("eventName", JSONObject.toJSONString(obj.getEventName()));
    map.put("eventType", JSONObject.toJSONString(obj.getEventType()));
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public ScheduleItem buildEntity() {
    ScheduleItem obj = new ScheduleItem();
    obj.setId(this.id);
    obj.setScheduleId(this.scheduleId);
    obj.setBeginDate(this.beginDate);
    obj.setEndDate(this.endDate);
    obj.setStatus(this.status);
    obj.setEventName(this.eventName);
    obj.setEventType(this.eventType);
    obj.setEventId(this.eventId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static ScheduleItem parseEntity(Map<String, Object> map) {
    ScheduleItem obj = new ScheduleItem();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setScheduleId((String) map.get("scheduleId"));
    obj.setBeginDate((Date) map.get("beginDate"));
    obj.setEndDate((Date) map.get("endDate"));
    obj.setStatus((Integer) map.get("status"));
    obj.setEventName((String) map.get("eventName"));
    obj.setEventType((Integer) map.get("eventType"));
    obj.setEventId((String) map.get("eventId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static ScheduleItem parseSerialEntity(Map<String, String> map) {
    ScheduleItem obj = new ScheduleItem();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setScheduleId(JSONObject.parseObject(map.get("scheduleId"), String.class));
    obj.setBeginDate(JSONObject.parseObject(map.get("beginDate"), Date.class));
    obj.setEndDate(JSONObject.parseObject(map.get("endDate"), Date.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setEventName(JSONObject.parseObject(map.get("eventName"), String.class));
    obj.setEventType(JSONObject.parseObject(map.get("eventType"), Integer.class));
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }
}

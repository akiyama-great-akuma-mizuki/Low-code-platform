package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScheduleItemDetailMapper {
  public String id;

  public String scheduleId;

  public Long beginDate;

  public Long endDate;

  public Integer status;

  public String eventName;

  public Integer eventType;

  public String eventId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map schedule = null;

  public ScheduleItemDetailMapper() {
  }

  public ScheduleItemDetailMapper(String id, String scheduleId, Long beginDate, Long endDate,
      Integer status, String eventName, Integer eventType, String eventId, Long gmtUpdate,
      Long gmtCreate) {
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

  public static ScheduleItemDetailMapper buildMapper(ScheduleItem obj) {
    ScheduleItemDetailMapper mapper = new ScheduleItemDetailMapper();
    mapper.id=obj.getId();
    mapper.scheduleId=obj.getScheduleId();
    mapper.beginDate=obj.modifyTime(obj.getBeginDate());
    mapper.endDate=obj.modifyTime(obj.getEndDate());
    mapper.status=obj.getStatus();
    mapper.eventName=obj.getEventName();
    mapper.eventType=obj.getEventType();
    mapper.eventId=obj.getEventId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
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
    map.put("schedule",this.schedule);
    return map;
  }

  public static Map<String, Object> buildMap(ScheduleItem obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("scheduleId", obj.getScheduleId());
    map.put("beginDate", obj.modifyTime(obj.getBeginDate()));
    map.put("endDate", obj.modifyTime(obj.getEndDate()));
    map.put("status", obj.getStatus());
    map.put("eventName", obj.getEventName());
    map.put("eventType", obj.getEventType());
    map.put("eventId", obj.getEventId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(ScheduleItem obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("scheduleId", JSONObject.toJSONString(obj.getScheduleId()));
    map.put("beginDate", JSONObject.toJSONString(obj.modifyTime(obj.getBeginDate())));
    map.put("endDate", JSONObject.toJSONString(obj.modifyTime(obj.getEndDate())));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("eventName", JSONObject.toJSONString(obj.getEventName()));
    map.put("eventType", JSONObject.toJSONString(obj.getEventType()));
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public ScheduleItem buildEntity() {
    ScheduleItem obj = new ScheduleItem();
    obj.setId(this.id);
    obj.setScheduleId(this.scheduleId);
    obj.setBeginDate(obj.recoverTime(this.beginDate));
    obj.setEndDate(obj.recoverTime(this.endDate));
    obj.setStatus(this.status);
    obj.setEventName(this.eventName);
    obj.setEventType(this.eventType);
    obj.setEventId(this.eventId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static ScheduleItem parseEntity(Map<String, Object> map) {
    ScheduleItem obj = new ScheduleItem();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setScheduleId((String) map.get("scheduleId"));
    obj.setBeginDate(obj.recoverTime((Long) map.get("beginDate")));
    obj.setEndDate(obj.recoverTime((Long) map.get("endDate")));
    obj.setStatus((Integer) map.get("status"));
    obj.setEventName((String) map.get("eventName"));
    obj.setEventType((Integer) map.get("eventType"));
    obj.setEventId((String) map.get("eventId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static ScheduleItem parseSerialEntity(Map<String, String> map) {
    ScheduleItem obj = new ScheduleItem();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setScheduleId(JSONObject.parseObject(map.get("scheduleId"), String.class));
    obj.setBeginDate(obj.recoverTime(JSONObject.parseObject(map.get("beginDate"), Long.class)));
    obj.setEndDate(obj.recoverTime(JSONObject.parseObject(map.get("endDate"), Long.class)));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setEventName(JSONObject.parseObject(map.get("eventName"), String.class));
    obj.setEventType(JSONObject.parseObject(map.get("eventType"), Integer.class));
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(ScheduleItem obj, Map<String, Object> schedule) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("schedule", schedule);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(ScheduleItem obj,
      Map<String, Object> schedule) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("schedule", JSONObject.toJSONString(schedule));
    return map;
  }
}

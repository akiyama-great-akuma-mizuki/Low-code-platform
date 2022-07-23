package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class EventTaskSimpleMapper {
  public String id;

  public String eventId;

  public String taskId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public EventTaskSimpleMapper() {
  }

  public EventTaskSimpleMapper(String id, String eventId, String taskId, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.eventId=eventId;
    this.taskId=taskId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static EventTaskSimpleMapper buildMapper(EventTask obj) {
    EventTaskSimpleMapper mapper = new EventTaskSimpleMapper();
    mapper.id=obj.getId();
    mapper.eventId=obj.getEventId();
    mapper.taskId=obj.getTaskId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("eventId",this.eventId);
    map.put("taskId",this.taskId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(EventTask obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("eventId", obj.getEventId());
    map.put("taskId", obj.getTaskId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(EventTask obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    map.put("taskId", JSONObject.toJSONString(obj.getTaskId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public EventTask buildEntity() {
    EventTask obj = new EventTask();
    obj.setId(this.id);
    obj.setEventId(this.eventId);
    obj.setTaskId(this.taskId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static EventTask parseEntity(Map<String, Object> map) {
    EventTask obj = new EventTask();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setEventId((String) map.get("eventId"));
    obj.setTaskId((String) map.get("taskId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static EventTask parseSerialEntity(Map<String, String> map) {
    EventTask obj = new EventTask();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    obj.setTaskId(JSONObject.parseObject(map.get("taskId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

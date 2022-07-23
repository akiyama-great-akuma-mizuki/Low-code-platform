package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class EventTaskPostMapper {
  public String eventId;

  public String taskId;

  public EventTaskPostMapper() {
  }

  public EventTaskPostMapper(String eventId, String taskId) {
    this.eventId=eventId;
    this.taskId=taskId;
  }

  public static EventTaskPostMapper buildMapper(EventTask obj) {
    EventTaskPostMapper mapper = new EventTaskPostMapper();
    mapper.eventId=obj.getEventId();
    mapper.taskId=obj.getTaskId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("eventId",this.eventId);
    map.put("taskId",this.taskId);
    return map;
  }

  public static Map<String, Object> buildMap(EventTask obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("eventId", obj.getEventId());
    map.put("taskId", obj.getTaskId());
    return map;
  }

  public static Map<String, String> buildSerialMap(EventTask obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    map.put("taskId", JSONObject.toJSONString(obj.getTaskId()));
    return map;
  }

  public EventTask buildEntity() {
    EventTask obj = new EventTask();
    obj.setEventId(this.eventId);
    obj.setTaskId(this.taskId);
    return obj;
  }

  public static EventTask parseEntity(Map<String, Object> map) {
    EventTask obj = new EventTask();
    if (map == null) return obj;
    obj.setEventId((String) map.get("eventId"));
    obj.setTaskId((String) map.get("taskId"));
    return obj;
  }

  public static EventTask parseSerialEntity(Map<String, String> map) {
    EventTask obj = new EventTask();
    if (map == null) return obj;
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    obj.setTaskId(JSONObject.parseObject(map.get("taskId"), String.class));
    return obj;
  }
}

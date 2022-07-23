package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.EventTaskTO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class EventTaskDomain {
  public String id;

  public String eventId;

  public String taskId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public EventTaskDomain() {
  }

  public EventTaskDomain(String id, String eventId, String taskId, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.eventId=eventId;
    this.taskId=taskId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static EventTaskDomain buildMapper(EventTask obj) {
    EventTaskDomain mapper = new EventTaskDomain();
    mapper.id=obj.getId();
    mapper.eventId=obj.getEventId();
    mapper.taskId=obj.getTaskId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(EventTask obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    map.put("taskId", JSONObject.toJSONString(obj.getTaskId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public EventTask buildEntity() {
    EventTask obj = new EventTask();
    obj.setId(this.id);
    obj.setEventId(this.eventId);
    obj.setTaskId(this.taskId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static EventTask parseEntity(Map<String, Object> map) {
    EventTask obj = new EventTask();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setEventId((String) map.get("eventId"));
    obj.setTaskId((String) map.get("taskId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static EventTask parseSerialEntity(Map<String, String> map) {
    EventTask obj = new EventTask();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    obj.setTaskId(JSONObject.parseObject(map.get("taskId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static EventTaskTO convert(EventTask from, EventTaskTO to) {
    if (from == null) return to;
    if (to == null) to = new EventTaskTO();
    to.setId(from.getId());
    to.setEventId(from.getEventId());
    to.setTaskId(from.getTaskId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static EventTask convert(EventTaskTO from, EventTask to) {
    if (from == null) return to;
    if (to == null) to = new EventTask();
    to.setId(from.getId());
    to.setEventId(from.getEventId());
    to.setTaskId(from.getTaskId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

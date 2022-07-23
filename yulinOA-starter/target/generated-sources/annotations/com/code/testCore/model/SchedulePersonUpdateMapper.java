package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SchedulePersonUpdateMapper {
  public String id;

  public String scheduleId;

  public String userId;

  public SchedulePersonUpdateMapper() {
  }

  public SchedulePersonUpdateMapper(String id, String scheduleId, String userId) {
    this.id=id;
    this.scheduleId=scheduleId;
    this.userId=userId;
  }

  public static SchedulePersonUpdateMapper buildMapper(SchedulePerson obj) {
    SchedulePersonUpdateMapper mapper = new SchedulePersonUpdateMapper();
    mapper.id=obj.getId();
    mapper.scheduleId=obj.getScheduleId();
    mapper.userId=obj.getUserId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("scheduleId",this.scheduleId);
    map.put("userId",this.userId);
    return map;
  }

  public static Map<String, Object> buildMap(SchedulePerson obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("scheduleId", obj.getScheduleId());
    map.put("userId", obj.getUserId());
    return map;
  }

  public static Map<String, String> buildSerialMap(SchedulePerson obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("scheduleId", JSONObject.toJSONString(obj.getScheduleId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    return map;
  }

  public SchedulePerson buildEntity() {
    SchedulePerson obj = new SchedulePerson();
    obj.setId(this.id);
    obj.setScheduleId(this.scheduleId);
    obj.setUserId(this.userId);
    return obj;
  }

  public static SchedulePerson parseEntity(Map<String, Object> map) {
    SchedulePerson obj = new SchedulePerson();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setScheduleId((String) map.get("scheduleId"));
    obj.setUserId((String) map.get("userId"));
    return obj;
  }

  public static SchedulePerson parseSerialEntity(Map<String, String> map) {
    SchedulePerson obj = new SchedulePerson();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setScheduleId(JSONObject.parseObject(map.get("scheduleId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    return obj;
  }
}

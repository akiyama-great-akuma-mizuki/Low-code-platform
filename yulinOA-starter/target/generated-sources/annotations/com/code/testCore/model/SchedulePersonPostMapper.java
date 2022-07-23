package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SchedulePersonPostMapper {
  public String scheduleId;

  public String userId;

  public SchedulePersonPostMapper() {
  }

  public SchedulePersonPostMapper(String scheduleId, String userId) {
    this.scheduleId=scheduleId;
    this.userId=userId;
  }

  public static SchedulePersonPostMapper buildMapper(SchedulePerson obj) {
    SchedulePersonPostMapper mapper = new SchedulePersonPostMapper();
    mapper.scheduleId=obj.getScheduleId();
    mapper.userId=obj.getUserId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("scheduleId",this.scheduleId);
    map.put("userId",this.userId);
    return map;
  }

  public static Map<String, Object> buildMap(SchedulePerson obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("scheduleId", obj.getScheduleId());
    map.put("userId", obj.getUserId());
    return map;
  }

  public static Map<String, String> buildSerialMap(SchedulePerson obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("scheduleId", JSONObject.toJSONString(obj.getScheduleId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    return map;
  }

  public SchedulePerson buildEntity() {
    SchedulePerson obj = new SchedulePerson();
    obj.setScheduleId(this.scheduleId);
    obj.setUserId(this.userId);
    return obj;
  }

  public static SchedulePerson parseEntity(Map<String, Object> map) {
    SchedulePerson obj = new SchedulePerson();
    if (map == null) return obj;
    obj.setScheduleId((String) map.get("scheduleId"));
    obj.setUserId((String) map.get("userId"));
    return obj;
  }

  public static SchedulePerson parseSerialEntity(Map<String, String> map) {
    SchedulePerson obj = new SchedulePerson();
    if (map == null) return obj;
    obj.setScheduleId(JSONObject.parseObject(map.get("scheduleId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    return obj;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SchedulePersonDetailMapper {
  public String id;

  public String scheduleId;

  public String userId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map user = null;

  public SchedulePersonDetailMapper() {
  }

  public SchedulePersonDetailMapper(String id, String scheduleId, String userId, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.scheduleId=scheduleId;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static SchedulePersonDetailMapper buildMapper(SchedulePerson obj) {
    SchedulePersonDetailMapper mapper = new SchedulePersonDetailMapper();
    mapper.id=obj.getId();
    mapper.scheduleId=obj.getScheduleId();
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("scheduleId",this.scheduleId);
    map.put("userId",this.userId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("user",this.user);
    return map;
  }

  public static Map<String, Object> buildMap(SchedulePerson obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("scheduleId", obj.getScheduleId());
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(SchedulePerson obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("scheduleId", JSONObject.toJSONString(obj.getScheduleId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public SchedulePerson buildEntity() {
    SchedulePerson obj = new SchedulePerson();
    obj.setId(this.id);
    obj.setScheduleId(this.scheduleId);
    obj.setUserId(this.userId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static SchedulePerson parseEntity(Map<String, Object> map) {
    SchedulePerson obj = new SchedulePerson();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setScheduleId((String) map.get("scheduleId"));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static SchedulePerson parseSerialEntity(Map<String, String> map) {
    SchedulePerson obj = new SchedulePerson();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setScheduleId(JSONObject.parseObject(map.get("scheduleId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(SchedulePerson obj, Map<String, Object> user) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("user", user);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(SchedulePerson obj,
      Map<String, Object> user) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("user", JSONObject.toJSONString(user));
    return map;
  }
}

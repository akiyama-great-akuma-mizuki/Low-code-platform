package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScheduleDetailMapper {
  public String id;

  public String userId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public List<Map> scheduleItemList = null;

  public Map user = null;

  public List<Map> schedulePersonList = null;

  public ScheduleDetailMapper() {
  }

  public ScheduleDetailMapper(String id, String userId, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ScheduleDetailMapper buildMapper(Schedule obj) {
    ScheduleDetailMapper mapper = new ScheduleDetailMapper();
    mapper.id=obj.getId();
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("userId",this.userId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("scheduleItemList",this.scheduleItemList);
    map.put("user",this.user);
    map.put("schedulePersonList",this.schedulePersonList);
    return map;
  }

  public static Map<String, Object> buildMap(Schedule obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Schedule obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Schedule buildEntity() {
    Schedule obj = new Schedule();
    obj.setId(this.id);
    obj.setUserId(this.userId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Schedule parseEntity(Map<String, Object> map) {
    Schedule obj = new Schedule();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Schedule parseSerialEntity(Map<String, String> map) {
    Schedule obj = new Schedule();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Schedule obj,
      List<Map<String, Object>> scheduleItemList, Map<String, Object> user,
      List<Map<String, Object>> schedulePersonList) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("scheduleItemList", scheduleItemList);
    map.put("user", user);
    map.put("schedulePersonList", schedulePersonList);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Schedule obj,
      List<Map<String, Object>> scheduleItemList, Map<String, Object> user,
      List<Map<String, Object>> schedulePersonList) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("scheduleItemList", JSONObject.toJSONString(scheduleItemList));
    map.put("user", JSONObject.toJSONString(user));
    map.put("schedulePersonList", JSONObject.toJSONString(schedulePersonList));
    return map;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ScheduleSimpleMapper {
  public String id;

  public String userId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public ScheduleSimpleMapper() {
  }

  public ScheduleSimpleMapper(String id, String userId, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ScheduleSimpleMapper buildMapper(Schedule obj) {
    ScheduleSimpleMapper mapper = new ScheduleSimpleMapper();
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
}

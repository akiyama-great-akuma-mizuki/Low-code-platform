package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class HolidayPostMapper {
  public String holidayClass;

  public Long hilidayStartTime;

  public Long holidayEndTime;

  public String holidayReason;

  public String userId;

  public String status;

  public HolidayPostMapper() {
  }

  public HolidayPostMapper(String holidayClass, Long hilidayStartTime, Long holidayEndTime,
      String holidayReason, String userId, String status) {
    this.holidayClass=holidayClass;
    this.hilidayStartTime=hilidayStartTime;
    this.holidayEndTime=holidayEndTime;
    this.holidayReason=holidayReason;
    this.userId=userId;
    this.status=status;
  }

  public static HolidayPostMapper buildMapper(Holiday obj) {
    HolidayPostMapper mapper = new HolidayPostMapper();
    mapper.holidayClass=obj.getHolidayClass();
    mapper.hilidayStartTime=obj.modifyTime(obj.getHilidayStartTime());
    mapper.holidayEndTime=obj.modifyTime(obj.getHolidayEndTime());
    mapper.holidayReason=obj.getHolidayReason();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("holidayClass",this.holidayClass);
    map.put("hilidayStartTime",this.hilidayStartTime);
    map.put("holidayEndTime",this.holidayEndTime);
    map.put("holidayReason",this.holidayReason);
    map.put("userId",this.userId);
    map.put("status",this.status);
    return map;
  }

  public static Map<String, Object> buildMap(Holiday obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("holidayClass", obj.getHolidayClass());
    map.put("hilidayStartTime", obj.modifyTime(obj.getHilidayStartTime()));
    map.put("holidayEndTime", obj.modifyTime(obj.getHolidayEndTime()));
    map.put("holidayReason", obj.getHolidayReason());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(Holiday obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("holidayClass", JSONObject.toJSONString(obj.getHolidayClass()));
    map.put("hilidayStartTime", JSONObject.toJSONString(obj.modifyTime(obj.getHilidayStartTime())));
    map.put("holidayEndTime", JSONObject.toJSONString(obj.modifyTime(obj.getHolidayEndTime())));
    map.put("holidayReason", JSONObject.toJSONString(obj.getHolidayReason()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public Holiday buildEntity() {
    Holiday obj = new Holiday();
    obj.setHolidayClass(this.holidayClass);
    obj.setHilidayStartTime(obj.recoverTime(this.hilidayStartTime));
    obj.setHolidayEndTime(obj.recoverTime(this.holidayEndTime));
    obj.setHolidayReason(this.holidayReason);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    return obj;
  }

  public static Holiday parseEntity(Map<String, Object> map) {
    Holiday obj = new Holiday();
    if (map == null) return obj;
    obj.setHolidayClass((String) map.get("holidayClass"));
    obj.setHilidayStartTime(obj.recoverTime((Long) map.get("hilidayStartTime")));
    obj.setHolidayEndTime(obj.recoverTime((Long) map.get("holidayEndTime")));
    obj.setHolidayReason((String) map.get("holidayReason"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((String) map.get("status"));
    return obj;
  }

  public static Holiday parseSerialEntity(Map<String, String> map) {
    Holiday obj = new Holiday();
    if (map == null) return obj;
    obj.setHolidayClass(JSONObject.parseObject(map.get("holidayClass"), String.class));
    obj.setHilidayStartTime(obj.recoverTime(JSONObject.parseObject(map.get("hilidayStartTime"), Long.class)));
    obj.setHolidayEndTime(obj.recoverTime(JSONObject.parseObject(map.get("holidayEndTime"), Long.class)));
    obj.setHolidayReason(JSONObject.parseObject(map.get("holidayReason"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), String.class));
    return obj;
  }
}

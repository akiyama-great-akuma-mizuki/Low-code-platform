package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HolidayDetailMapper {
  public String id;

  public String holidayClass;

  public Long hilidayStartTime;

  public Long holidayEndTime;

  public String holidayReason;

  public String userId;

  public String status;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map user = null;

  public List<Map> holidayCheckList = null;

  public HolidayDetailMapper() {
  }

  public HolidayDetailMapper(String id, String holidayClass, Long hilidayStartTime,
      Long holidayEndTime, String holidayReason, String userId, String status, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.holidayClass=holidayClass;
    this.hilidayStartTime=hilidayStartTime;
    this.holidayEndTime=holidayEndTime;
    this.holidayReason=holidayReason;
    this.userId=userId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static HolidayDetailMapper buildMapper(Holiday obj) {
    HolidayDetailMapper mapper = new HolidayDetailMapper();
    mapper.id=obj.getId();
    mapper.holidayClass=obj.getHolidayClass();
    mapper.hilidayStartTime=obj.modifyTime(obj.getHilidayStartTime());
    mapper.holidayEndTime=obj.modifyTime(obj.getHolidayEndTime());
    mapper.holidayReason=obj.getHolidayReason();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("holidayClass",this.holidayClass);
    map.put("hilidayStartTime",this.hilidayStartTime);
    map.put("holidayEndTime",this.holidayEndTime);
    map.put("holidayReason",this.holidayReason);
    map.put("userId",this.userId);
    map.put("status",this.status);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("user",this.user);
    map.put("holidayCheckList",this.holidayCheckList);
    return map;
  }

  public static Map<String, Object> buildMap(Holiday obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("holidayClass", obj.getHolidayClass());
    map.put("hilidayStartTime", obj.modifyTime(obj.getHilidayStartTime()));
    map.put("holidayEndTime", obj.modifyTime(obj.getHolidayEndTime()));
    map.put("holidayReason", obj.getHolidayReason());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Holiday obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("holidayClass", JSONObject.toJSONString(obj.getHolidayClass()));
    map.put("hilidayStartTime", JSONObject.toJSONString(obj.modifyTime(obj.getHilidayStartTime())));
    map.put("holidayEndTime", JSONObject.toJSONString(obj.modifyTime(obj.getHolidayEndTime())));
    map.put("holidayReason", JSONObject.toJSONString(obj.getHolidayReason()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Holiday buildEntity() {
    Holiday obj = new Holiday();
    obj.setId(this.id);
    obj.setHolidayClass(this.holidayClass);
    obj.setHilidayStartTime(obj.recoverTime(this.hilidayStartTime));
    obj.setHolidayEndTime(obj.recoverTime(this.holidayEndTime));
    obj.setHolidayReason(this.holidayReason);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Holiday parseEntity(Map<String, Object> map) {
    Holiday obj = new Holiday();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHolidayClass((String) map.get("holidayClass"));
    obj.setHilidayStartTime(obj.recoverTime((Long) map.get("hilidayStartTime")));
    obj.setHolidayEndTime(obj.recoverTime((Long) map.get("holidayEndTime")));
    obj.setHolidayReason((String) map.get("holidayReason"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((String) map.get("status"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Holiday parseSerialEntity(Map<String, String> map) {
    Holiday obj = new Holiday();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHolidayClass(JSONObject.parseObject(map.get("holidayClass"), String.class));
    obj.setHilidayStartTime(obj.recoverTime(JSONObject.parseObject(map.get("hilidayStartTime"), Long.class)));
    obj.setHolidayEndTime(obj.recoverTime(JSONObject.parseObject(map.get("holidayEndTime"), Long.class)));
    obj.setHolidayReason(JSONObject.parseObject(map.get("holidayReason"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Holiday obj, Map<String, Object> user,
      List<Map<String, Object>> holidayCheckList) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("user", user);
    map.put("holidayCheckList", holidayCheckList);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Holiday obj, Map<String, Object> user,
      List<Map<String, Object>> holidayCheckList) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("user", JSONObject.toJSONString(user));
    map.put("holidayCheckList", JSONObject.toJSONString(holidayCheckList));
    return map;
  }
}

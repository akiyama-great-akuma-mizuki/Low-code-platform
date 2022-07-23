package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.HolidayDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class HolidayData {
  public String id;

  public String holidayClass;

  public Date hilidayStartTime;

  public Date holidayEndTime;

  public String holidayReason;

  public String userId;

  public String status;

  public Date gmtUpdate;

  public Date gmtCreate;

  public HolidayData() {
  }

  public HolidayData(String id, String holidayClass, Date hilidayStartTime, Date holidayEndTime,
      String holidayReason, String userId, String status, Date gmtUpdate, Date gmtCreate) {
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

  public static HolidayData buildMapper(Holiday obj) {
    HolidayData mapper = new HolidayData();
    mapper.id=obj.getId();
    mapper.holidayClass=obj.getHolidayClass();
    mapper.hilidayStartTime=obj.getHilidayStartTime();
    mapper.holidayEndTime=obj.getHolidayEndTime();
    mapper.holidayReason=obj.getHolidayReason();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    return map;
  }

  public static Map<String, Object> buildMap(Holiday obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("holidayClass", obj.getHolidayClass());
    map.put("hilidayStartTime", obj.getHilidayStartTime());
    map.put("holidayEndTime", obj.getHolidayEndTime());
    map.put("holidayReason", obj.getHolidayReason());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(Holiday obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("holidayClass", JSONObject.toJSONString(obj.getHolidayClass()));
    map.put("hilidayStartTime", JSONObject.toJSONString(obj.getHilidayStartTime()));
    map.put("holidayEndTime", JSONObject.toJSONString(obj.getHolidayEndTime()));
    map.put("holidayReason", JSONObject.toJSONString(obj.getHolidayReason()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public Holiday buildEntity() {
    Holiday obj = new Holiday();
    obj.setId(this.id);
    obj.setHolidayClass(this.holidayClass);
    obj.setHilidayStartTime(this.hilidayStartTime);
    obj.setHolidayEndTime(this.holidayEndTime);
    obj.setHolidayReason(this.holidayReason);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static Holiday parseEntity(Map<String, Object> map) {
    Holiday obj = new Holiday();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHolidayClass((String) map.get("holidayClass"));
    obj.setHilidayStartTime((Date) map.get("hilidayStartTime"));
    obj.setHolidayEndTime((Date) map.get("holidayEndTime"));
    obj.setHolidayReason((String) map.get("holidayReason"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((String) map.get("status"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static Holiday parseSerialEntity(Map<String, String> map) {
    Holiday obj = new Holiday();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHolidayClass(JSONObject.parseObject(map.get("holidayClass"), String.class));
    obj.setHilidayStartTime(JSONObject.parseObject(map.get("hilidayStartTime"), Date.class));
    obj.setHolidayEndTime(JSONObject.parseObject(map.get("holidayEndTime"), Date.class));
    obj.setHolidayReason(JSONObject.parseObject(map.get("holidayReason"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static HolidayDO convert(Holiday from, HolidayDO to) {
    if (from == null) return to;
    if (to == null) to = new HolidayDO();
    to.setId(from.getId());
    to.setHolidayClass(from.getHolidayClass());
    to.setHilidayStartTime(from.getHilidayStartTime());
    to.setHolidayEndTime(from.getHolidayEndTime());
    to.setHolidayReason(from.getHolidayReason());
    to.setUserId(from.getUserId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static Holiday convert(HolidayDO from, Holiday to) {
    if (from == null) return to;
    if (to == null) to = new Holiday();
    to.setId(from.getId());
    to.setHolidayClass(from.getHolidayClass());
    to.setHilidayStartTime(from.getHilidayStartTime());
    to.setHolidayEndTime(from.getHolidayEndTime());
    to.setHolidayReason(from.getHolidayReason());
    to.setUserId(from.getUserId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

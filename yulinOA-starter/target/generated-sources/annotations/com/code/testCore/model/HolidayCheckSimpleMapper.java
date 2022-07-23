package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class HolidayCheckSimpleMapper {
  public String id;

  public String holidayId;

  public String approverId;

  public Integer status;

  public Long gmtUpdate;

  public Long gmtCreate;

  public HolidayCheckSimpleMapper() {
  }

  public HolidayCheckSimpleMapper(String id, String holidayId, String approverId, Integer status,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.holidayId=holidayId;
    this.approverId=approverId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static HolidayCheckSimpleMapper buildMapper(HolidayCheck obj) {
    HolidayCheckSimpleMapper mapper = new HolidayCheckSimpleMapper();
    mapper.id=obj.getId();
    mapper.holidayId=obj.getHolidayId();
    mapper.approverId=obj.getApproverId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("holidayId",this.holidayId);
    map.put("approverId",this.approverId);
    map.put("status",this.status);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(HolidayCheck obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("holidayId", obj.getHolidayId());
    map.put("approverId", obj.getApproverId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(HolidayCheck obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("holidayId", JSONObject.toJSONString(obj.getHolidayId()));
    map.put("approverId", JSONObject.toJSONString(obj.getApproverId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public HolidayCheck buildEntity() {
    HolidayCheck obj = new HolidayCheck();
    obj.setId(this.id);
    obj.setHolidayId(this.holidayId);
    obj.setApproverId(this.approverId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static HolidayCheck parseEntity(Map<String, Object> map) {
    HolidayCheck obj = new HolidayCheck();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHolidayId((String) map.get("holidayId"));
    obj.setApproverId((String) map.get("approverId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static HolidayCheck parseSerialEntity(Map<String, String> map) {
    HolidayCheck obj = new HolidayCheck();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHolidayId(JSONObject.parseObject(map.get("holidayId"), String.class));
    obj.setApproverId(JSONObject.parseObject(map.get("approverId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

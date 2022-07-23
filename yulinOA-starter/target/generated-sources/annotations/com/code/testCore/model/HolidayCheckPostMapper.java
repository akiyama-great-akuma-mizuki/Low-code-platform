package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class HolidayCheckPostMapper {
  public String holidayId;

  public String approverId;

  public Integer status;

  public HolidayCheckPostMapper() {
  }

  public HolidayCheckPostMapper(String holidayId, String approverId, Integer status) {
    this.holidayId=holidayId;
    this.approverId=approverId;
    this.status=status;
  }

  public static HolidayCheckPostMapper buildMapper(HolidayCheck obj) {
    HolidayCheckPostMapper mapper = new HolidayCheckPostMapper();
    mapper.holidayId=obj.getHolidayId();
    mapper.approverId=obj.getApproverId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("holidayId",this.holidayId);
    map.put("approverId",this.approverId);
    map.put("status",this.status);
    return map;
  }

  public static Map<String, Object> buildMap(HolidayCheck obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("holidayId", obj.getHolidayId());
    map.put("approverId", obj.getApproverId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(HolidayCheck obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("holidayId", JSONObject.toJSONString(obj.getHolidayId()));
    map.put("approverId", JSONObject.toJSONString(obj.getApproverId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public HolidayCheck buildEntity() {
    HolidayCheck obj = new HolidayCheck();
    obj.setHolidayId(this.holidayId);
    obj.setApproverId(this.approverId);
    obj.setStatus(this.status);
    return obj;
  }

  public static HolidayCheck parseEntity(Map<String, Object> map) {
    HolidayCheck obj = new HolidayCheck();
    if (map == null) return obj;
    obj.setHolidayId((String) map.get("holidayId"));
    obj.setApproverId((String) map.get("approverId"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static HolidayCheck parseSerialEntity(Map<String, String> map) {
    HolidayCheck obj = new HolidayCheck();
    if (map == null) return obj;
    obj.setHolidayId(JSONObject.parseObject(map.get("holidayId"), String.class));
    obj.setApproverId(JSONObject.parseObject(map.get("approverId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }
}

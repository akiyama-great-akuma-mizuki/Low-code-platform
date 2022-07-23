package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HolidayCheckFilterMapper {
  public String id;

  public String holidayId;

  public String approverId;

  public Integer status;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public List<Integer> statusIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public HolidayCheckFilterMapper() {
  }

  public HolidayCheckFilterMapper(String id, String holidayId, String approverId, Integer status) {
    this.id=id;
    this.holidayId=holidayId;
    this.approverId=approverId;
    this.status=status;
  }

  public static HolidayCheckFilterMapper buildMapper(HolidayCheck obj) {
    HolidayCheckFilterMapper mapper = new HolidayCheckFilterMapper();
    mapper.id=obj.getId();
    mapper.holidayId=obj.getHolidayId();
    mapper.approverId=obj.getApproverId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("holidayId",this.holidayId);
    map.put("approverId",this.approverId);
    map.put("status",this.status);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("statusIn",this.statusIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(HolidayCheck obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("holidayId", obj.getHolidayId());
    map.put("approverId", obj.getApproverId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(HolidayCheck obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("holidayId", JSONObject.toJSONString(obj.getHolidayId()));
    map.put("approverId", JSONObject.toJSONString(obj.getApproverId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public HolidayCheck buildEntity() {
    HolidayCheck obj = new HolidayCheck();
    obj.setId(this.id);
    obj.setHolidayId(this.holidayId);
    obj.setApproverId(this.approverId);
    obj.setStatus(this.status);
    return obj;
  }

  public static HolidayCheck parseEntity(Map<String, Object> map) {
    HolidayCheck obj = new HolidayCheck();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHolidayId((String) map.get("holidayId"));
    obj.setApproverId((String) map.get("approverId"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static HolidayCheck parseSerialEntity(Map<String, String> map) {
    HolidayCheck obj = new HolidayCheck();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHolidayId(JSONObject.parseObject(map.get("holidayId"), String.class));
    obj.setApproverId(JSONObject.parseObject(map.get("approverId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(HolidayCheck obj, Long page, Integer rows,
      List<String> orderBy, List<Integer> statusIn, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("statusIn", statusIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(HolidayCheck obj, Long page, Integer rows,
      List<String> orderBy, List<Integer> statusIn, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("statusIn", JSONObject.toJSONString(statusIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

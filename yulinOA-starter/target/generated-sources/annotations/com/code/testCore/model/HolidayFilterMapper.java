package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HolidayFilterMapper {
  public String id;

  public String holidayClass;

  public String holidayReason;

  public String userId;

  public String status;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String holidayClassLike = null;

  public Long holidayEndTimeFrom = null;

  public Long holidayEndTimeTo = null;

  public String holidayReasonLike = null;

  public List<String> holidayReasonIn = null;

  public List<String> statusIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public HolidayFilterMapper() {
  }

  public HolidayFilterMapper(String id, String holidayClass, String holidayReason, String userId,
      String status) {
    this.id=id;
    this.holidayClass=holidayClass;
    this.holidayReason=holidayReason;
    this.userId=userId;
    this.status=status;
  }

  public static HolidayFilterMapper buildMapper(Holiday obj) {
    HolidayFilterMapper mapper = new HolidayFilterMapper();
    mapper.id=obj.getId();
    mapper.holidayClass=obj.getHolidayClass();
    mapper.holidayReason=obj.getHolidayReason();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("holidayClass",this.holidayClass);
    map.put("holidayReason",this.holidayReason);
    map.put("userId",this.userId);
    map.put("status",this.status);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("holidayClassLike",this.holidayClassLike);
    map.put("holidayEndTimeFrom",this.holidayEndTimeFrom);
    map.put("holidayEndTimeTo",this.holidayEndTimeTo);
    map.put("holidayReasonLike",this.holidayReasonLike);
    map.put("holidayReasonIn",this.holidayReasonIn);
    map.put("statusIn",this.statusIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Holiday obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("holidayClass", obj.getHolidayClass());
    map.put("holidayReason", obj.getHolidayReason());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(Holiday obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("holidayClass", JSONObject.toJSONString(obj.getHolidayClass()));
    map.put("holidayReason", JSONObject.toJSONString(obj.getHolidayReason()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public Holiday buildEntity() {
    Holiday obj = new Holiday();
    obj.setId(this.id);
    obj.setHolidayClass(this.holidayClass);
    obj.setHolidayReason(this.holidayReason);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    return obj;
  }

  public static Holiday parseEntity(Map<String, Object> map) {
    Holiday obj = new Holiday();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHolidayClass((String) map.get("holidayClass"));
    obj.setHolidayReason((String) map.get("holidayReason"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((String) map.get("status"));
    return obj;
  }

  public static Holiday parseSerialEntity(Map<String, String> map) {
    Holiday obj = new Holiday();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHolidayClass(JSONObject.parseObject(map.get("holidayClass"), String.class));
    obj.setHolidayReason(JSONObject.parseObject(map.get("holidayReason"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Holiday obj, Long page, Integer rows,
      List<String> orderBy, String holidayClassLike, Long holidayEndTimeFrom, Long holidayEndTimeTo,
      String holidayReasonLike, List<String> holidayReasonIn, List<String> statusIn,
      Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("holidayClassLike", holidayClassLike);
    map.put("holidayEndTimeFrom", holidayEndTimeFrom);
    map.put("holidayEndTimeTo", holidayEndTimeTo);
    map.put("holidayReasonLike", holidayReasonLike);
    map.put("holidayReasonIn", holidayReasonIn);
    map.put("statusIn", statusIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Holiday obj, Long page, Integer rows,
      List<String> orderBy, String holidayClassLike, Long holidayEndTimeFrom, Long holidayEndTimeTo,
      String holidayReasonLike, List<String> holidayReasonIn, List<String> statusIn,
      Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("holidayClassLike", JSONObject.toJSONString(holidayClassLike));
    map.put("holidayEndTimeFrom", JSONObject.toJSONString(holidayEndTimeFrom));
    map.put("holidayEndTimeTo", JSONObject.toJSONString(holidayEndTimeTo));
    map.put("holidayReasonLike", JSONObject.toJSONString(holidayReasonLike));
    map.put("holidayReasonIn", JSONObject.toJSONString(holidayReasonIn));
    map.put("statusIn", JSONObject.toJSONString(statusIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

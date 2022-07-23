package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.HolidayCheckTO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class HolidayCheckDomain {
  public String id;

  public String holidayId;

  public String approverId;

  public Integer status;

  public Date gmtUpdate;

  public Date gmtCreate;

  public HolidayCheckDomain() {
  }

  public HolidayCheckDomain(String id, String holidayId, String approverId, Integer status,
      Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.holidayId=holidayId;
    this.approverId=approverId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static HolidayCheckDomain buildMapper(HolidayCheck obj) {
    HolidayCheckDomain mapper = new HolidayCheckDomain();
    mapper.id=obj.getId();
    mapper.holidayId=obj.getHolidayId();
    mapper.approverId=obj.getApproverId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(HolidayCheck obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("holidayId", JSONObject.toJSONString(obj.getHolidayId()));
    map.put("approverId", JSONObject.toJSONString(obj.getApproverId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public HolidayCheck buildEntity() {
    HolidayCheck obj = new HolidayCheck();
    obj.setId(this.id);
    obj.setHolidayId(this.holidayId);
    obj.setApproverId(this.approverId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static HolidayCheck parseEntity(Map<String, Object> map) {
    HolidayCheck obj = new HolidayCheck();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHolidayId((String) map.get("holidayId"));
    obj.setApproverId((String) map.get("approverId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static HolidayCheck parseSerialEntity(Map<String, String> map) {
    HolidayCheck obj = new HolidayCheck();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHolidayId(JSONObject.parseObject(map.get("holidayId"), String.class));
    obj.setApproverId(JSONObject.parseObject(map.get("approverId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static HolidayCheckTO convert(HolidayCheck from, HolidayCheckTO to) {
    if (from == null) return to;
    if (to == null) to = new HolidayCheckTO();
    to.setId(from.getId());
    to.setHolidayId(from.getHolidayId());
    to.setApproverId(from.getApproverId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static HolidayCheck convert(HolidayCheckTO from, HolidayCheck to) {
    if (from == null) return to;
    if (to == null) to = new HolidayCheck();
    to.setId(from.getId());
    to.setHolidayId(from.getHolidayId());
    to.setApproverId(from.getApproverId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessTripCheckPostMapper {
  public String businessTripId;

  public String approverId;

  public Integer status;

  public BusinessTripCheckPostMapper() {
  }

  public BusinessTripCheckPostMapper(String businessTripId, String approverId, Integer status) {
    this.businessTripId=businessTripId;
    this.approverId=approverId;
    this.status=status;
  }

  public static BusinessTripCheckPostMapper buildMapper(BusinessTripCheck obj) {
    BusinessTripCheckPostMapper mapper = new BusinessTripCheckPostMapper();
    mapper.businessTripId=obj.getBusinessTripId();
    mapper.approverId=obj.getApproverId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("businessTripId",this.businessTripId);
    map.put("approverId",this.approverId);
    map.put("status",this.status);
    return map;
  }

  public static Map<String, Object> buildMap(BusinessTripCheck obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("businessTripId", obj.getBusinessTripId());
    map.put("approverId", obj.getApproverId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(BusinessTripCheck obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("businessTripId", JSONObject.toJSONString(obj.getBusinessTripId()));
    map.put("approverId", JSONObject.toJSONString(obj.getApproverId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public BusinessTripCheck buildEntity() {
    BusinessTripCheck obj = new BusinessTripCheck();
    obj.setBusinessTripId(this.businessTripId);
    obj.setApproverId(this.approverId);
    obj.setStatus(this.status);
    return obj;
  }

  public static BusinessTripCheck parseEntity(Map<String, Object> map) {
    BusinessTripCheck obj = new BusinessTripCheck();
    if (map == null) return obj;
    obj.setBusinessTripId((String) map.get("businessTripId"));
    obj.setApproverId((String) map.get("approverId"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static BusinessTripCheck parseSerialEntity(Map<String, String> map) {
    BusinessTripCheck obj = new BusinessTripCheck();
    if (map == null) return obj;
    obj.setBusinessTripId(JSONObject.parseObject(map.get("businessTripId"), String.class));
    obj.setApproverId(JSONObject.parseObject(map.get("approverId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }
}

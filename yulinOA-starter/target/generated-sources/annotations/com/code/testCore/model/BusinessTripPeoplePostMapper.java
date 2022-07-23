package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessTripPeoplePostMapper {
  public String businessTripId;

  public String userId;

  public BusinessTripPeoplePostMapper() {
  }

  public BusinessTripPeoplePostMapper(String businessTripId, String userId) {
    this.businessTripId=businessTripId;
    this.userId=userId;
  }

  public static BusinessTripPeoplePostMapper buildMapper(BusinessTripPeople obj) {
    BusinessTripPeoplePostMapper mapper = new BusinessTripPeoplePostMapper();
    mapper.businessTripId=obj.getBusinessTripId();
    mapper.userId=obj.getUserId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("businessTripId",this.businessTripId);
    map.put("userId",this.userId);
    return map;
  }

  public static Map<String, Object> buildMap(BusinessTripPeople obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("businessTripId", obj.getBusinessTripId());
    map.put("userId", obj.getUserId());
    return map;
  }

  public static Map<String, String> buildSerialMap(BusinessTripPeople obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("businessTripId", JSONObject.toJSONString(obj.getBusinessTripId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    return map;
  }

  public BusinessTripPeople buildEntity() {
    BusinessTripPeople obj = new BusinessTripPeople();
    obj.setBusinessTripId(this.businessTripId);
    obj.setUserId(this.userId);
    return obj;
  }

  public static BusinessTripPeople parseEntity(Map<String, Object> map) {
    BusinessTripPeople obj = new BusinessTripPeople();
    if (map == null) return obj;
    obj.setBusinessTripId((String) map.get("businessTripId"));
    obj.setUserId((String) map.get("userId"));
    return obj;
  }

  public static BusinessTripPeople parseSerialEntity(Map<String, String> map) {
    BusinessTripPeople obj = new BusinessTripPeople();
    if (map == null) return obj;
    obj.setBusinessTripId(JSONObject.parseObject(map.get("businessTripId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    return obj;
  }
}

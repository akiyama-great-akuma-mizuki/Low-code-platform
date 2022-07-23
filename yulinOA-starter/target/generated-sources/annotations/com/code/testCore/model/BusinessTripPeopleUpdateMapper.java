package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessTripPeopleUpdateMapper {
  public String id;

  public String businessTripId;

  public String userId;

  public BusinessTripPeopleUpdateMapper() {
  }

  public BusinessTripPeopleUpdateMapper(String id, String businessTripId, String userId) {
    this.id=id;
    this.businessTripId=businessTripId;
    this.userId=userId;
  }

  public static BusinessTripPeopleUpdateMapper buildMapper(BusinessTripPeople obj) {
    BusinessTripPeopleUpdateMapper mapper = new BusinessTripPeopleUpdateMapper();
    mapper.id=obj.getId();
    mapper.businessTripId=obj.getBusinessTripId();
    mapper.userId=obj.getUserId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("businessTripId",this.businessTripId);
    map.put("userId",this.userId);
    return map;
  }

  public static Map<String, Object> buildMap(BusinessTripPeople obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("businessTripId", obj.getBusinessTripId());
    map.put("userId", obj.getUserId());
    return map;
  }

  public static Map<String, String> buildSerialMap(BusinessTripPeople obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("businessTripId", JSONObject.toJSONString(obj.getBusinessTripId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    return map;
  }

  public BusinessTripPeople buildEntity() {
    BusinessTripPeople obj = new BusinessTripPeople();
    obj.setId(this.id);
    obj.setBusinessTripId(this.businessTripId);
    obj.setUserId(this.userId);
    return obj;
  }

  public static BusinessTripPeople parseEntity(Map<String, Object> map) {
    BusinessTripPeople obj = new BusinessTripPeople();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setBusinessTripId((String) map.get("businessTripId"));
    obj.setUserId((String) map.get("userId"));
    return obj;
  }

  public static BusinessTripPeople parseSerialEntity(Map<String, String> map) {
    BusinessTripPeople obj = new BusinessTripPeople();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setBusinessTripId(JSONObject.parseObject(map.get("businessTripId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    return obj;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessTripPeopleDetailMapper {
  public String id;

  public String businessTripId;

  public String userId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map businessTrip = null;

  public Map user = null;

  public BusinessTripPeopleDetailMapper() {
  }

  public BusinessTripPeopleDetailMapper(String id, String businessTripId, String userId,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.businessTripId=businessTripId;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static BusinessTripPeopleDetailMapper buildMapper(BusinessTripPeople obj) {
    BusinessTripPeopleDetailMapper mapper = new BusinessTripPeopleDetailMapper();
    mapper.id=obj.getId();
    mapper.businessTripId=obj.getBusinessTripId();
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("businessTripId",this.businessTripId);
    map.put("userId",this.userId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("businessTrip",this.businessTrip);
    map.put("user",this.user);
    return map;
  }

  public static Map<String, Object> buildMap(BusinessTripPeople obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("businessTripId", obj.getBusinessTripId());
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(BusinessTripPeople obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("businessTripId", JSONObject.toJSONString(obj.getBusinessTripId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public BusinessTripPeople buildEntity() {
    BusinessTripPeople obj = new BusinessTripPeople();
    obj.setId(this.id);
    obj.setBusinessTripId(this.businessTripId);
    obj.setUserId(this.userId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static BusinessTripPeople parseEntity(Map<String, Object> map) {
    BusinessTripPeople obj = new BusinessTripPeople();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setBusinessTripId((String) map.get("businessTripId"));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static BusinessTripPeople parseSerialEntity(Map<String, String> map) {
    BusinessTripPeople obj = new BusinessTripPeople();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setBusinessTripId(JSONObject.parseObject(map.get("businessTripId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(BusinessTripPeople obj,
      Map<String, Object> businessTrip, Map<String, Object> user) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("businessTrip", businessTrip);
    map.put("user", user);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(BusinessTripPeople obj,
      Map<String, Object> businessTrip, Map<String, Object> user) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("businessTrip", JSONObject.toJSONString(businessTrip));
    map.put("user", JSONObject.toJSONString(user));
    return map;
  }
}

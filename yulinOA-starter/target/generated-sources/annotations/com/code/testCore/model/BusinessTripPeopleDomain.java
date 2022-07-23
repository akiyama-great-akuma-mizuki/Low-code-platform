package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.BusinessTripPeopleTO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessTripPeopleDomain {
  public String id;

  public String businessTripId;

  public String userId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public BusinessTripPeopleDomain() {
  }

  public BusinessTripPeopleDomain(String id, String businessTripId, String userId, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.businessTripId=businessTripId;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static BusinessTripPeopleDomain buildMapper(BusinessTripPeople obj) {
    BusinessTripPeopleDomain mapper = new BusinessTripPeopleDomain();
    mapper.id=obj.getId();
    mapper.businessTripId=obj.getBusinessTripId();
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("businessTripId",this.businessTripId);
    map.put("userId",this.userId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(BusinessTripPeople obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("businessTripId", obj.getBusinessTripId());
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(BusinessTripPeople obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("businessTripId", JSONObject.toJSONString(obj.getBusinessTripId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public BusinessTripPeople buildEntity() {
    BusinessTripPeople obj = new BusinessTripPeople();
    obj.setId(this.id);
    obj.setBusinessTripId(this.businessTripId);
    obj.setUserId(this.userId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static BusinessTripPeople parseEntity(Map<String, Object> map) {
    BusinessTripPeople obj = new BusinessTripPeople();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setBusinessTripId((String) map.get("businessTripId"));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static BusinessTripPeople parseSerialEntity(Map<String, String> map) {
    BusinessTripPeople obj = new BusinessTripPeople();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setBusinessTripId(JSONObject.parseObject(map.get("businessTripId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static BusinessTripPeopleTO convert(BusinessTripPeople from, BusinessTripPeopleTO to) {
    if (from == null) return to;
    if (to == null) to = new BusinessTripPeopleTO();
    to.setId(from.getId());
    to.setBusinessTripId(from.getBusinessTripId());
    to.setUserId(from.getUserId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static BusinessTripPeople convert(BusinessTripPeopleTO from, BusinessTripPeople to) {
    if (from == null) return to;
    if (to == null) to = new BusinessTripPeople();
    to.setId(from.getId());
    to.setBusinessTripId(from.getBusinessTripId());
    to.setUserId(from.getUserId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

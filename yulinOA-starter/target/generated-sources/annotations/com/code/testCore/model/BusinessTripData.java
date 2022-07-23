package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.BusinessTripDO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessTripData {
  public String id;

  public Date tripStartTime;

  public Date tripEndTime;

  public String tripStartPlace;

  public String tripEndPlace;

  public String trafficTool;

  public String tripBack;

  public String tripRemark;

  public String userId;

  public Integer status;

  public Date gmtUpdate;

  public Date gmtCreate;

  public BusinessTripData() {
  }

  public BusinessTripData(String id, Date tripStartTime, Date tripEndTime, String tripStartPlace,
      String tripEndPlace, String trafficTool, String tripBack, String tripRemark, String userId,
      Integer status, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.tripStartTime=tripStartTime;
    this.tripEndTime=tripEndTime;
    this.tripStartPlace=tripStartPlace;
    this.tripEndPlace=tripEndPlace;
    this.trafficTool=trafficTool;
    this.tripBack=tripBack;
    this.tripRemark=tripRemark;
    this.userId=userId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static BusinessTripData buildMapper(BusinessTrip obj) {
    BusinessTripData mapper = new BusinessTripData();
    mapper.id=obj.getId();
    mapper.tripStartTime=obj.getTripStartTime();
    mapper.tripEndTime=obj.getTripEndTime();
    mapper.tripStartPlace=obj.getTripStartPlace();
    mapper.tripEndPlace=obj.getTripEndPlace();
    mapper.trafficTool=obj.getTrafficTool();
    mapper.tripBack=obj.getTripBack();
    mapper.tripRemark=obj.getTripRemark();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("tripStartTime",this.tripStartTime);
    map.put("tripEndTime",this.tripEndTime);
    map.put("tripStartPlace",this.tripStartPlace);
    map.put("tripEndPlace",this.tripEndPlace);
    map.put("trafficTool",this.trafficTool);
    map.put("tripBack",this.tripBack);
    map.put("tripRemark",this.tripRemark);
    map.put("userId",this.userId);
    map.put("status",this.status);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(BusinessTrip obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("tripStartTime", obj.getTripStartTime());
    map.put("tripEndTime", obj.getTripEndTime());
    map.put("tripStartPlace", obj.getTripStartPlace());
    map.put("tripEndPlace", obj.getTripEndPlace());
    map.put("trafficTool", obj.getTrafficTool());
    map.put("tripBack", obj.getTripBack());
    map.put("tripRemark", obj.getTripRemark());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(BusinessTrip obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("tripStartTime", JSONObject.toJSONString(obj.getTripStartTime()));
    map.put("tripEndTime", JSONObject.toJSONString(obj.getTripEndTime()));
    map.put("tripStartPlace", JSONObject.toJSONString(obj.getTripStartPlace()));
    map.put("tripEndPlace", JSONObject.toJSONString(obj.getTripEndPlace()));
    map.put("trafficTool", JSONObject.toJSONString(obj.getTrafficTool()));
    map.put("tripBack", JSONObject.toJSONString(obj.getTripBack()));
    map.put("tripRemark", JSONObject.toJSONString(obj.getTripRemark()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public BusinessTrip buildEntity() {
    BusinessTrip obj = new BusinessTrip();
    obj.setId(this.id);
    obj.setTripStartTime(this.tripStartTime);
    obj.setTripEndTime(this.tripEndTime);
    obj.setTripStartPlace(this.tripStartPlace);
    obj.setTripEndPlace(this.tripEndPlace);
    obj.setTrafficTool(this.trafficTool);
    obj.setTripBack(this.tripBack);
    obj.setTripRemark(this.tripRemark);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static BusinessTrip parseEntity(Map<String, Object> map) {
    BusinessTrip obj = new BusinessTrip();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setTripStartTime((Date) map.get("tripStartTime"));
    obj.setTripEndTime((Date) map.get("tripEndTime"));
    obj.setTripStartPlace((String) map.get("tripStartPlace"));
    obj.setTripEndPlace((String) map.get("tripEndPlace"));
    obj.setTrafficTool((String) map.get("trafficTool"));
    obj.setTripBack((String) map.get("tripBack"));
    obj.setTripRemark((String) map.get("tripRemark"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static BusinessTrip parseSerialEntity(Map<String, String> map) {
    BusinessTrip obj = new BusinessTrip();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setTripStartTime(JSONObject.parseObject(map.get("tripStartTime"), Date.class));
    obj.setTripEndTime(JSONObject.parseObject(map.get("tripEndTime"), Date.class));
    obj.setTripStartPlace(JSONObject.parseObject(map.get("tripStartPlace"), String.class));
    obj.setTripEndPlace(JSONObject.parseObject(map.get("tripEndPlace"), String.class));
    obj.setTrafficTool(JSONObject.parseObject(map.get("trafficTool"), String.class));
    obj.setTripBack(JSONObject.parseObject(map.get("tripBack"), String.class));
    obj.setTripRemark(JSONObject.parseObject(map.get("tripRemark"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static BusinessTripDO convert(BusinessTrip from, BusinessTripDO to) {
    if (from == null) return to;
    if (to == null) to = new BusinessTripDO();
    to.setId(from.getId());
    to.setTripStartTime(from.getTripStartTime());
    to.setTripEndTime(from.getTripEndTime());
    to.setTripStartPlace(from.getTripStartPlace());
    to.setTripEndPlace(from.getTripEndPlace());
    to.setTrafficTool(from.getTrafficTool());
    to.setTripBack(from.getTripBack());
    to.setTripRemark(from.getTripRemark());
    to.setUserId(from.getUserId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static BusinessTrip convert(BusinessTripDO from, BusinessTrip to) {
    if (from == null) return to;
    if (to == null) to = new BusinessTrip();
    to.setId(from.getId());
    to.setTripStartTime(from.getTripStartTime());
    to.setTripEndTime(from.getTripEndTime());
    to.setTripStartPlace(from.getTripStartPlace());
    to.setTripEndPlace(from.getTripEndPlace());
    to.setTrafficTool(from.getTrafficTool());
    to.setTripBack(from.getTripBack());
    to.setTripRemark(from.getTripRemark());
    to.setUserId(from.getUserId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BusinessTripFilterMapper {
  public String id;

  public String tripStartPlace;

  public String tripEndPlace;

  public String trafficTool;

  public String tripBack;

  public String tripRemark;

  public String userId;

  public Integer status;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long tripStartTimeFrom = null;

  public Long tripStartTimeTo = null;

  public Long tripEndTimeFrom = null;

  public Long tripEndTimeTo = null;

  public String tripStartPlaceLike = null;

  public List<String> tripStartPlaceIn = null;

  public String tripEndPlaceLike = null;

  public List<String> tripEndPlaceIn = null;

  public String trafficToolLike = null;

  public List<String> trafficToolIn = null;

  public String tripBackLike = null;

  public List<String> tripBackIn = null;

  public String tripRemarkLike = null;

  public List<String> tripRemarkIn = null;

  public List<Integer> statusIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public BusinessTripFilterMapper() {
  }

  public BusinessTripFilterMapper(String id, String tripStartPlace, String tripEndPlace,
      String trafficTool, String tripBack, String tripRemark, String userId, Integer status) {
    this.id=id;
    this.tripStartPlace=tripStartPlace;
    this.tripEndPlace=tripEndPlace;
    this.trafficTool=trafficTool;
    this.tripBack=tripBack;
    this.tripRemark=tripRemark;
    this.userId=userId;
    this.status=status;
  }

  public static BusinessTripFilterMapper buildMapper(BusinessTrip obj) {
    BusinessTripFilterMapper mapper = new BusinessTripFilterMapper();
    mapper.id=obj.getId();
    mapper.tripStartPlace=obj.getTripStartPlace();
    mapper.tripEndPlace=obj.getTripEndPlace();
    mapper.trafficTool=obj.getTrafficTool();
    mapper.tripBack=obj.getTripBack();
    mapper.tripRemark=obj.getTripRemark();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("tripStartPlace",this.tripStartPlace);
    map.put("tripEndPlace",this.tripEndPlace);
    map.put("trafficTool",this.trafficTool);
    map.put("tripBack",this.tripBack);
    map.put("tripRemark",this.tripRemark);
    map.put("userId",this.userId);
    map.put("status",this.status);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("tripStartTimeFrom",this.tripStartTimeFrom);
    map.put("tripStartTimeTo",this.tripStartTimeTo);
    map.put("tripEndTimeFrom",this.tripEndTimeFrom);
    map.put("tripEndTimeTo",this.tripEndTimeTo);
    map.put("tripStartPlaceLike",this.tripStartPlaceLike);
    map.put("tripStartPlaceIn",this.tripStartPlaceIn);
    map.put("tripEndPlaceLike",this.tripEndPlaceLike);
    map.put("tripEndPlaceIn",this.tripEndPlaceIn);
    map.put("trafficToolLike",this.trafficToolLike);
    map.put("trafficToolIn",this.trafficToolIn);
    map.put("tripBackLike",this.tripBackLike);
    map.put("tripBackIn",this.tripBackIn);
    map.put("tripRemarkLike",this.tripRemarkLike);
    map.put("tripRemarkIn",this.tripRemarkIn);
    map.put("statusIn",this.statusIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(BusinessTrip obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("tripStartPlace", obj.getTripStartPlace());
    map.put("tripEndPlace", obj.getTripEndPlace());
    map.put("trafficTool", obj.getTrafficTool());
    map.put("tripBack", obj.getTripBack());
    map.put("tripRemark", obj.getTripRemark());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(BusinessTrip obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("tripStartPlace", JSONObject.toJSONString(obj.getTripStartPlace()));
    map.put("tripEndPlace", JSONObject.toJSONString(obj.getTripEndPlace()));
    map.put("trafficTool", JSONObject.toJSONString(obj.getTrafficTool()));
    map.put("tripBack", JSONObject.toJSONString(obj.getTripBack()));
    map.put("tripRemark", JSONObject.toJSONString(obj.getTripRemark()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public BusinessTrip buildEntity() {
    BusinessTrip obj = new BusinessTrip();
    obj.setId(this.id);
    obj.setTripStartPlace(this.tripStartPlace);
    obj.setTripEndPlace(this.tripEndPlace);
    obj.setTrafficTool(this.trafficTool);
    obj.setTripBack(this.tripBack);
    obj.setTripRemark(this.tripRemark);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    return obj;
  }

  public static BusinessTrip parseEntity(Map<String, Object> map) {
    BusinessTrip obj = new BusinessTrip();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setTripStartPlace((String) map.get("tripStartPlace"));
    obj.setTripEndPlace((String) map.get("tripEndPlace"));
    obj.setTrafficTool((String) map.get("trafficTool"));
    obj.setTripBack((String) map.get("tripBack"));
    obj.setTripRemark((String) map.get("tripRemark"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static BusinessTrip parseSerialEntity(Map<String, String> map) {
    BusinessTrip obj = new BusinessTrip();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setTripStartPlace(JSONObject.parseObject(map.get("tripStartPlace"), String.class));
    obj.setTripEndPlace(JSONObject.parseObject(map.get("tripEndPlace"), String.class));
    obj.setTrafficTool(JSONObject.parseObject(map.get("trafficTool"), String.class));
    obj.setTripBack(JSONObject.parseObject(map.get("tripBack"), String.class));
    obj.setTripRemark(JSONObject.parseObject(map.get("tripRemark"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(BusinessTrip obj, Long page, Integer rows,
      List<String> orderBy, Long tripStartTimeFrom, Long tripStartTimeTo, Long tripEndTimeFrom,
      Long tripEndTimeTo, String tripStartPlaceLike, List<String> tripStartPlaceIn,
      String tripEndPlaceLike, List<String> tripEndPlaceIn, String trafficToolLike,
      List<String> trafficToolIn, String tripBackLike, List<String> tripBackIn,
      String tripRemarkLike, List<String> tripRemarkIn, List<Integer> statusIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("tripStartTimeFrom", tripStartTimeFrom);
    map.put("tripStartTimeTo", tripStartTimeTo);
    map.put("tripEndTimeFrom", tripEndTimeFrom);
    map.put("tripEndTimeTo", tripEndTimeTo);
    map.put("tripStartPlaceLike", tripStartPlaceLike);
    map.put("tripStartPlaceIn", tripStartPlaceIn);
    map.put("tripEndPlaceLike", tripEndPlaceLike);
    map.put("tripEndPlaceIn", tripEndPlaceIn);
    map.put("trafficToolLike", trafficToolLike);
    map.put("trafficToolIn", trafficToolIn);
    map.put("tripBackLike", tripBackLike);
    map.put("tripBackIn", tripBackIn);
    map.put("tripRemarkLike", tripRemarkLike);
    map.put("tripRemarkIn", tripRemarkIn);
    map.put("statusIn", statusIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(BusinessTrip obj, Long page, Integer rows,
      List<String> orderBy, Long tripStartTimeFrom, Long tripStartTimeTo, Long tripEndTimeFrom,
      Long tripEndTimeTo, String tripStartPlaceLike, List<String> tripStartPlaceIn,
      String tripEndPlaceLike, List<String> tripEndPlaceIn, String trafficToolLike,
      List<String> trafficToolIn, String tripBackLike, List<String> tripBackIn,
      String tripRemarkLike, List<String> tripRemarkIn, List<Integer> statusIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("tripStartTimeFrom", JSONObject.toJSONString(tripStartTimeFrom));
    map.put("tripStartTimeTo", JSONObject.toJSONString(tripStartTimeTo));
    map.put("tripEndTimeFrom", JSONObject.toJSONString(tripEndTimeFrom));
    map.put("tripEndTimeTo", JSONObject.toJSONString(tripEndTimeTo));
    map.put("tripStartPlaceLike", JSONObject.toJSONString(tripStartPlaceLike));
    map.put("tripStartPlaceIn", JSONObject.toJSONString(tripStartPlaceIn));
    map.put("tripEndPlaceLike", JSONObject.toJSONString(tripEndPlaceLike));
    map.put("tripEndPlaceIn", JSONObject.toJSONString(tripEndPlaceIn));
    map.put("trafficToolLike", JSONObject.toJSONString(trafficToolLike));
    map.put("trafficToolIn", JSONObject.toJSONString(trafficToolIn));
    map.put("tripBackLike", JSONObject.toJSONString(tripBackLike));
    map.put("tripBackIn", JSONObject.toJSONString(tripBackIn));
    map.put("tripRemarkLike", JSONObject.toJSONString(tripRemarkLike));
    map.put("tripRemarkIn", JSONObject.toJSONString(tripRemarkIn));
    map.put("statusIn", JSONObject.toJSONString(statusIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarParkFilterMapper {
  public String id;

  public Integer status;

  public String time;

  public String carId;

  public String parkPlaceId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public CarParkFilterMapper() {
  }

  public CarParkFilterMapper(String id, Integer status, String time, String carId,
      String parkPlaceId) {
    this.id=id;
    this.status=status;
    this.time=time;
    this.carId=carId;
    this.parkPlaceId=parkPlaceId;
  }

  public static CarParkFilterMapper buildMapper(CarPark obj) {
    CarParkFilterMapper mapper = new CarParkFilterMapper();
    mapper.id=obj.getId();
    mapper.status=obj.getStatus();
    mapper.time=obj.getTime();
    mapper.carId=obj.getCarId();
    mapper.parkPlaceId=obj.getParkPlaceId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("status",this.status);
    map.put("time",this.time);
    map.put("carId",this.carId);
    map.put("parkPlaceId",this.parkPlaceId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(CarPark obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("status", obj.getStatus());
    map.put("time", obj.getTime());
    map.put("carId", obj.getCarId());
    map.put("parkPlaceId", obj.getParkPlaceId());
    return map;
  }

  public static Map<String, String> buildSerialMap(CarPark obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("time", JSONObject.toJSONString(obj.getTime()));
    map.put("carId", JSONObject.toJSONString(obj.getCarId()));
    map.put("parkPlaceId", JSONObject.toJSONString(obj.getParkPlaceId()));
    return map;
  }

  public CarPark buildEntity() {
    CarPark obj = new CarPark();
    obj.setId(this.id);
    obj.setStatus(this.status);
    obj.setTime(this.time);
    obj.setCarId(this.carId);
    obj.setParkPlaceId(this.parkPlaceId);
    return obj;
  }

  public static CarPark parseEntity(Map<String, Object> map) {
    CarPark obj = new CarPark();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setStatus((Integer) map.get("status"));
    obj.setTime((String) map.get("time"));
    obj.setCarId((String) map.get("carId"));
    obj.setParkPlaceId((String) map.get("parkPlaceId"));
    return obj;
  }

  public static CarPark parseSerialEntity(Map<String, String> map) {
    CarPark obj = new CarPark();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setTime(JSONObject.parseObject(map.get("time"), String.class));
    obj.setCarId(JSONObject.parseObject(map.get("carId"), String.class));
    obj.setParkPlaceId(JSONObject.parseObject(map.get("parkPlaceId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(CarPark obj, Long page, Integer rows,
      List<String> orderBy, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(CarPark obj, Long page, Integer rows,
      List<String> orderBy, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.CarParkDO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarParkData {
  public String id;

  public Integer status;

  public String time;

  public String carId;

  public String parkPlaceId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public CarParkData() {
  }

  public CarParkData(String id, Integer status, String time, String carId, String parkPlaceId,
      Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.status=status;
    this.time=time;
    this.carId=carId;
    this.parkPlaceId=parkPlaceId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static CarParkData buildMapper(CarPark obj) {
    CarParkData mapper = new CarParkData();
    mapper.id=obj.getId();
    mapper.status=obj.getStatus();
    mapper.time=obj.getTime();
    mapper.carId=obj.getCarId();
    mapper.parkPlaceId=obj.getParkPlaceId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("status",this.status);
    map.put("time",this.time);
    map.put("carId",this.carId);
    map.put("parkPlaceId",this.parkPlaceId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(CarPark obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("time", JSONObject.toJSONString(obj.getTime()));
    map.put("carId", JSONObject.toJSONString(obj.getCarId()));
    map.put("parkPlaceId", JSONObject.toJSONString(obj.getParkPlaceId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public CarPark buildEntity() {
    CarPark obj = new CarPark();
    obj.setId(this.id);
    obj.setStatus(this.status);
    obj.setTime(this.time);
    obj.setCarId(this.carId);
    obj.setParkPlaceId(this.parkPlaceId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
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
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
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
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static CarParkDO convert(CarPark from, CarParkDO to) {
    if (from == null) return to;
    if (to == null) to = new CarParkDO();
    to.setId(from.getId());
    to.setStatus(from.getStatus());
    to.setTime(from.getTime());
    to.setCarId(from.getCarId());
    to.setParkPlaceId(from.getParkPlaceId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static CarPark convert(CarParkDO from, CarPark to) {
    if (from == null) return to;
    if (to == null) to = new CarPark();
    to.setId(from.getId());
    to.setStatus(from.getStatus());
    to.setTime(from.getTime());
    to.setCarId(from.getCarId());
    to.setParkPlaceId(from.getParkPlaceId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

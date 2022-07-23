package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarUpdateMapper {
  public String id;

  public String driverName;

  public String driverPhone;

  public String carID;

  public String parkType;

  public String carState;

  public String enterpriseId;

  public CarUpdateMapper() {
  }

  public CarUpdateMapper(String id, String driverName, String driverPhone, String carID,
      String parkType, String carState, String enterpriseId) {
    this.id=id;
    this.driverName=driverName;
    this.driverPhone=driverPhone;
    this.carID=carID;
    this.parkType=parkType;
    this.carState=carState;
    this.enterpriseId=enterpriseId;
  }

  public static CarUpdateMapper buildMapper(Car obj) {
    CarUpdateMapper mapper = new CarUpdateMapper();
    mapper.id=obj.getId();
    mapper.driverName=obj.getDriverName();
    mapper.driverPhone=obj.getDriverPhone();
    mapper.carID=obj.getCarID();
    mapper.parkType=obj.getParkType();
    mapper.carState=obj.getCarState();
    mapper.enterpriseId=obj.getEnterpriseId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("driverName",this.driverName);
    map.put("driverPhone",this.driverPhone);
    map.put("carID",this.carID);
    map.put("parkType",this.parkType);
    map.put("carState",this.carState);
    map.put("enterpriseId",this.enterpriseId);
    return map;
  }

  public static Map<String, Object> buildMap(Car obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("driverName", obj.getDriverName());
    map.put("driverPhone", obj.getDriverPhone());
    map.put("carID", obj.getCarID());
    map.put("parkType", obj.getParkType());
    map.put("carState", obj.getCarState());
    map.put("enterpriseId", obj.getEnterpriseId());
    return map;
  }

  public static Map<String, String> buildSerialMap(Car obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("driverName", JSONObject.toJSONString(obj.getDriverName()));
    map.put("driverPhone", JSONObject.toJSONString(obj.getDriverPhone()));
    map.put("carID", JSONObject.toJSONString(obj.getCarID()));
    map.put("parkType", JSONObject.toJSONString(obj.getParkType()));
    map.put("carState", JSONObject.toJSONString(obj.getCarState()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    return map;
  }

  public Car buildEntity() {
    Car obj = new Car();
    obj.setId(this.id);
    obj.setDriverName(this.driverName);
    obj.setDriverPhone(this.driverPhone);
    obj.setCarID(this.carID);
    obj.setParkType(this.parkType);
    obj.setCarState(this.carState);
    obj.setEnterpriseId(this.enterpriseId);
    return obj;
  }

  public static Car parseEntity(Map<String, Object> map) {
    Car obj = new Car();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setDriverName((String) map.get("driverName"));
    obj.setDriverPhone((String) map.get("driverPhone"));
    obj.setCarID((String) map.get("carID"));
    obj.setParkType((String) map.get("parkType"));
    obj.setCarState((String) map.get("carState"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    return obj;
  }

  public static Car parseSerialEntity(Map<String, String> map) {
    Car obj = new Car();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setDriverName(JSONObject.parseObject(map.get("driverName"), String.class));
    obj.setDriverPhone(JSONObject.parseObject(map.get("driverPhone"), String.class));
    obj.setCarID(JSONObject.parseObject(map.get("carID"), String.class));
    obj.setParkType(JSONObject.parseObject(map.get("parkType"), String.class));
    obj.setCarState(JSONObject.parseObject(map.get("carState"), String.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    return obj;
  }
}

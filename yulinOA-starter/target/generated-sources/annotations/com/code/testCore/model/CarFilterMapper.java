package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CarFilterMapper {
  public String id;

  public String driverName;

  public String driverPhone;

  public String carID;

  public String parkType;

  public String carState;

  public String enterpriseId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String driverNameLike = null;

  public String driverPhoneLike = null;

  public String carIDLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public CarFilterMapper() {
  }

  public CarFilterMapper(String id, String driverName, String driverPhone, String carID,
      String parkType, String carState, String enterpriseId) {
    this.id=id;
    this.driverName=driverName;
    this.driverPhone=driverPhone;
    this.carID=carID;
    this.parkType=parkType;
    this.carState=carState;
    this.enterpriseId=enterpriseId;
  }

  public static CarFilterMapper buildMapper(Car obj) {
    CarFilterMapper mapper = new CarFilterMapper();
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
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("driverNameLike",this.driverNameLike);
    map.put("driverPhoneLike",this.driverPhoneLike);
    map.put("carIDLike",this.carIDLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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

  public static Map<String, Object> buildMapExtra(Car obj, Long page, Integer rows,
      List<String> orderBy, String driverNameLike, String driverPhoneLike, String carIDLike,
      Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("driverNameLike", driverNameLike);
    map.put("driverPhoneLike", driverPhoneLike);
    map.put("carIDLike", carIDLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Car obj, Long page, Integer rows,
      List<String> orderBy, String driverNameLike, String driverPhoneLike, String carIDLike,
      Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("driverNameLike", JSONObject.toJSONString(driverNameLike));
    map.put("driverPhoneLike", JSONObject.toJSONString(driverPhoneLike));
    map.put("carIDLike", JSONObject.toJSONString(carIDLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

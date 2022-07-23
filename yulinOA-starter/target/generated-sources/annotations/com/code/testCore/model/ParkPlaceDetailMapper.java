package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParkPlaceDetailMapper {
  public String id;

  public String parkParkId;

  public String name;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map parkPark = null;

  public ParkPlaceDetailMapper() {
  }

  public ParkPlaceDetailMapper(String id, String parkParkId, String name, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.parkParkId=parkParkId;
    this.name=name;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ParkPlaceDetailMapper buildMapper(ParkPlace obj) {
    ParkPlaceDetailMapper mapper = new ParkPlaceDetailMapper();
    mapper.id=obj.getId();
    mapper.parkParkId=obj.getParkParkId();
    mapper.name=obj.getName();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("parkParkId",this.parkParkId);
    map.put("name",this.name);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("parkPark",this.parkPark);
    return map;
  }

  public static Map<String, Object> buildMap(ParkPlace obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("parkParkId", obj.getParkParkId());
    map.put("name", obj.getName());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(ParkPlace obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("parkParkId", JSONObject.toJSONString(obj.getParkParkId()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public ParkPlace buildEntity() {
    ParkPlace obj = new ParkPlace();
    obj.setId(this.id);
    obj.setParkParkId(this.parkParkId);
    obj.setName(this.name);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static ParkPlace parseEntity(Map<String, Object> map) {
    ParkPlace obj = new ParkPlace();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setParkParkId((String) map.get("parkParkId"));
    obj.setName((String) map.get("name"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static ParkPlace parseSerialEntity(Map<String, String> map) {
    ParkPlace obj = new ParkPlace();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setParkParkId(JSONObject.parseObject(map.get("parkParkId"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(ParkPlace obj, Map<String, Object> parkPark) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("parkPark", parkPark);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(ParkPlace obj,
      Map<String, Object> parkPark) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("parkPark", JSONObject.toJSONString(parkPark));
    return map;
  }
}

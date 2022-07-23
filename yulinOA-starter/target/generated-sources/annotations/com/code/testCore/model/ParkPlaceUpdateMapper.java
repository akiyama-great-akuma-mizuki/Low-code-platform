package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParkPlaceUpdateMapper {
  public String id;

  public String parkParkId;

  public String name;

  public ParkPlaceUpdateMapper() {
  }

  public ParkPlaceUpdateMapper(String id, String parkParkId, String name) {
    this.id=id;
    this.parkParkId=parkParkId;
    this.name=name;
  }

  public static ParkPlaceUpdateMapper buildMapper(ParkPlace obj) {
    ParkPlaceUpdateMapper mapper = new ParkPlaceUpdateMapper();
    mapper.id=obj.getId();
    mapper.parkParkId=obj.getParkParkId();
    mapper.name=obj.getName();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("parkParkId",this.parkParkId);
    map.put("name",this.name);
    return map;
  }

  public static Map<String, Object> buildMap(ParkPlace obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("parkParkId", obj.getParkParkId());
    map.put("name", obj.getName());
    return map;
  }

  public static Map<String, String> buildSerialMap(ParkPlace obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("parkParkId", JSONObject.toJSONString(obj.getParkParkId()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    return map;
  }

  public ParkPlace buildEntity() {
    ParkPlace obj = new ParkPlace();
    obj.setId(this.id);
    obj.setParkParkId(this.parkParkId);
    obj.setName(this.name);
    return obj;
  }

  public static ParkPlace parseEntity(Map<String, Object> map) {
    ParkPlace obj = new ParkPlace();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setParkParkId((String) map.get("parkParkId"));
    obj.setName((String) map.get("name"));
    return obj;
  }

  public static ParkPlace parseSerialEntity(Map<String, String> map) {
    ParkPlace obj = new ParkPlace();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setParkParkId(JSONObject.parseObject(map.get("parkParkId"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    return obj;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParkPlacePostMapper {
  public String parkParkId;

  public String name;

  public ParkPlacePostMapper() {
  }

  public ParkPlacePostMapper(String parkParkId, String name) {
    this.parkParkId=parkParkId;
    this.name=name;
  }

  public static ParkPlacePostMapper buildMapper(ParkPlace obj) {
    ParkPlacePostMapper mapper = new ParkPlacePostMapper();
    mapper.parkParkId=obj.getParkParkId();
    mapper.name=obj.getName();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("parkParkId",this.parkParkId);
    map.put("name",this.name);
    return map;
  }

  public static Map<String, Object> buildMap(ParkPlace obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("parkParkId", obj.getParkParkId());
    map.put("name", obj.getName());
    return map;
  }

  public static Map<String, String> buildSerialMap(ParkPlace obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("parkParkId", JSONObject.toJSONString(obj.getParkParkId()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    return map;
  }

  public ParkPlace buildEntity() {
    ParkPlace obj = new ParkPlace();
    obj.setParkParkId(this.parkParkId);
    obj.setName(this.name);
    return obj;
  }

  public static ParkPlace parseEntity(Map<String, Object> map) {
    ParkPlace obj = new ParkPlace();
    if (map == null) return obj;
    obj.setParkParkId((String) map.get("parkParkId"));
    obj.setName((String) map.get("name"));
    return obj;
  }

  public static ParkPlace parseSerialEntity(Map<String, String> map) {
    ParkPlace obj = new ParkPlace();
    if (map == null) return obj;
    obj.setParkParkId(JSONObject.parseObject(map.get("parkParkId"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    return obj;
  }
}

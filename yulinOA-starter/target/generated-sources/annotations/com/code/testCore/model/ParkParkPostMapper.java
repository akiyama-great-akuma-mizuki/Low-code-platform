package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParkParkPostMapper {
  public String parkName;

  public Integer allStall;

  public String place;

  public Integer residueStall;

  public ParkParkPostMapper() {
  }

  public ParkParkPostMapper(String parkName, Integer allStall, String place, Integer residueStall) {
    this.parkName=parkName;
    this.allStall=allStall;
    this.place=place;
    this.residueStall=residueStall;
  }

  public static ParkParkPostMapper buildMapper(ParkPark obj) {
    ParkParkPostMapper mapper = new ParkParkPostMapper();
    mapper.parkName=obj.getParkName();
    mapper.allStall=obj.getAllStall();
    mapper.place=obj.getPlace();
    mapper.residueStall=obj.getResidueStall();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("parkName",this.parkName);
    map.put("allStall",this.allStall);
    map.put("place",this.place);
    map.put("residueStall",this.residueStall);
    return map;
  }

  public static Map<String, Object> buildMap(ParkPark obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("parkName", obj.getParkName());
    map.put("allStall", obj.getAllStall());
    map.put("place", obj.getPlace());
    map.put("residueStall", obj.getResidueStall());
    return map;
  }

  public static Map<String, String> buildSerialMap(ParkPark obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("parkName", JSONObject.toJSONString(obj.getParkName()));
    map.put("allStall", JSONObject.toJSONString(obj.getAllStall()));
    map.put("place", JSONObject.toJSONString(obj.getPlace()));
    map.put("residueStall", JSONObject.toJSONString(obj.getResidueStall()));
    return map;
  }

  public ParkPark buildEntity() {
    ParkPark obj = new ParkPark();
    obj.setParkName(this.parkName);
    obj.setAllStall(this.allStall);
    obj.setPlace(this.place);
    obj.setResidueStall(this.residueStall);
    return obj;
  }

  public static ParkPark parseEntity(Map<String, Object> map) {
    ParkPark obj = new ParkPark();
    if (map == null) return obj;
    obj.setParkName((String) map.get("parkName"));
    obj.setAllStall((Integer) map.get("allStall"));
    obj.setPlace((String) map.get("place"));
    obj.setResidueStall((Integer) map.get("residueStall"));
    return obj;
  }

  public static ParkPark parseSerialEntity(Map<String, String> map) {
    ParkPark obj = new ParkPark();
    if (map == null) return obj;
    obj.setParkName(JSONObject.parseObject(map.get("parkName"), String.class));
    obj.setAllStall(JSONObject.parseObject(map.get("allStall"), Integer.class));
    obj.setPlace(JSONObject.parseObject(map.get("place"), String.class));
    obj.setResidueStall(JSONObject.parseObject(map.get("residueStall"), Integer.class));
    return obj;
  }
}

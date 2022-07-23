package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParkParkDetailMapper {
  public String id;

  public String parkName;

  public Integer allStall;

  public String place;

  public Integer residueStall;

  public Long gmtUpdate;

  public Long gmtCreate;

  public List<Map> parkPlaceList = null;

  public ParkParkDetailMapper() {
  }

  public ParkParkDetailMapper(String id, String parkName, Integer allStall, String place,
      Integer residueStall, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.parkName=parkName;
    this.allStall=allStall;
    this.place=place;
    this.residueStall=residueStall;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ParkParkDetailMapper buildMapper(ParkPark obj) {
    ParkParkDetailMapper mapper = new ParkParkDetailMapper();
    mapper.id=obj.getId();
    mapper.parkName=obj.getParkName();
    mapper.allStall=obj.getAllStall();
    mapper.place=obj.getPlace();
    mapper.residueStall=obj.getResidueStall();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("parkName",this.parkName);
    map.put("allStall",this.allStall);
    map.put("place",this.place);
    map.put("residueStall",this.residueStall);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("parkPlaceList",this.parkPlaceList);
    return map;
  }

  public static Map<String, Object> buildMap(ParkPark obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("parkName", obj.getParkName());
    map.put("allStall", obj.getAllStall());
    map.put("place", obj.getPlace());
    map.put("residueStall", obj.getResidueStall());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(ParkPark obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("parkName", JSONObject.toJSONString(obj.getParkName()));
    map.put("allStall", JSONObject.toJSONString(obj.getAllStall()));
    map.put("place", JSONObject.toJSONString(obj.getPlace()));
    map.put("residueStall", JSONObject.toJSONString(obj.getResidueStall()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public ParkPark buildEntity() {
    ParkPark obj = new ParkPark();
    obj.setId(this.id);
    obj.setParkName(this.parkName);
    obj.setAllStall(this.allStall);
    obj.setPlace(this.place);
    obj.setResidueStall(this.residueStall);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static ParkPark parseEntity(Map<String, Object> map) {
    ParkPark obj = new ParkPark();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setParkName((String) map.get("parkName"));
    obj.setAllStall((Integer) map.get("allStall"));
    obj.setPlace((String) map.get("place"));
    obj.setResidueStall((Integer) map.get("residueStall"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static ParkPark parseSerialEntity(Map<String, String> map) {
    ParkPark obj = new ParkPark();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setParkName(JSONObject.parseObject(map.get("parkName"), String.class));
    obj.setAllStall(JSONObject.parseObject(map.get("allStall"), Integer.class));
    obj.setPlace(JSONObject.parseObject(map.get("place"), String.class));
    obj.setResidueStall(JSONObject.parseObject(map.get("residueStall"), Integer.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(ParkPark obj,
      List<Map<String, Object>> parkPlaceList) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("parkPlaceList", parkPlaceList);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(ParkPark obj,
      List<Map<String, Object>> parkPlaceList) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("parkPlaceList", JSONObject.toJSONString(parkPlaceList));
    return map;
  }
}

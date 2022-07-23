package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParkParkDefaultMapper {
  public String id;

  public String parkName;

  public Integer allStall;

  public String place;

  public Integer residueStall;

  public Date gmtUpdate;

  public Date gmtCreate;

  public ParkParkDefaultMapper() {
  }

  public ParkParkDefaultMapper(String id, String parkName, Integer allStall, String place,
      Integer residueStall, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.parkName=parkName;
    this.allStall=allStall;
    this.place=place;
    this.residueStall=residueStall;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ParkParkDefaultMapper buildMapper(ParkPark obj) {
    ParkParkDefaultMapper mapper = new ParkParkDefaultMapper();
    mapper.id=obj.getId();
    mapper.parkName=obj.getParkName();
    mapper.allStall=obj.getAllStall();
    mapper.place=obj.getPlace();
    mapper.residueStall=obj.getResidueStall();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(ParkPark obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("parkName", JSONObject.toJSONString(obj.getParkName()));
    map.put("allStall", JSONObject.toJSONString(obj.getAllStall()));
    map.put("place", JSONObject.toJSONString(obj.getPlace()));
    map.put("residueStall", JSONObject.toJSONString(obj.getResidueStall()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public ParkPark buildEntity() {
    ParkPark obj = new ParkPark();
    obj.setId(this.id);
    obj.setParkName(this.parkName);
    obj.setAllStall(this.allStall);
    obj.setPlace(this.place);
    obj.setResidueStall(this.residueStall);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
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
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
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
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }
}

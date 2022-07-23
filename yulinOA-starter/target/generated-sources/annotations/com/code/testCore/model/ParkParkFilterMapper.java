package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ParkParkFilterMapper {
  public String id;

  public String parkName;

  public Integer allStall;

  public String place;

  public Integer residueStall;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String parkNameLike = null;

  public String placeLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public ParkParkFilterMapper() {
  }

  public ParkParkFilterMapper(String id, String parkName, Integer allStall, String place,
      Integer residueStall) {
    this.id=id;
    this.parkName=parkName;
    this.allStall=allStall;
    this.place=place;
    this.residueStall=residueStall;
  }

  public static ParkParkFilterMapper buildMapper(ParkPark obj) {
    ParkParkFilterMapper mapper = new ParkParkFilterMapper();
    mapper.id=obj.getId();
    mapper.parkName=obj.getParkName();
    mapper.allStall=obj.getAllStall();
    mapper.place=obj.getPlace();
    mapper.residueStall=obj.getResidueStall();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("parkName",this.parkName);
    map.put("allStall",this.allStall);
    map.put("place",this.place);
    map.put("residueStall",this.residueStall);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("parkNameLike",this.parkNameLike);
    map.put("placeLike",this.placeLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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
    return map;
  }

  public static Map<String, String> buildSerialMap(ParkPark obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("parkName", JSONObject.toJSONString(obj.getParkName()));
    map.put("allStall", JSONObject.toJSONString(obj.getAllStall()));
    map.put("place", JSONObject.toJSONString(obj.getPlace()));
    map.put("residueStall", JSONObject.toJSONString(obj.getResidueStall()));
    return map;
  }

  public ParkPark buildEntity() {
    ParkPark obj = new ParkPark();
    obj.setId(this.id);
    obj.setParkName(this.parkName);
    obj.setAllStall(this.allStall);
    obj.setPlace(this.place);
    obj.setResidueStall(this.residueStall);
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
    return obj;
  }

  public static Map<String, Object> buildMapExtra(ParkPark obj, Long page, Integer rows,
      List<String> orderBy, String parkNameLike, String placeLike, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("parkNameLike", parkNameLike);
    map.put("placeLike", placeLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(ParkPark obj, Long page, Integer rows,
      List<String> orderBy, String parkNameLike, String placeLike, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("parkNameLike", JSONObject.toJSONString(parkNameLike));
    map.put("placeLike", JSONObject.toJSONString(placeLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

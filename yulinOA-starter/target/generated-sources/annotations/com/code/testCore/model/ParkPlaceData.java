package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.ParkPlaceDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParkPlaceData {
  public String id;

  public String parkParkId;

  public String name;

  public Date gmtUpdate;

  public Date gmtCreate;

  public ParkPlaceData() {
  }

  public ParkPlaceData(String id, String parkParkId, String name, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.parkParkId=parkParkId;
    this.name=name;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ParkPlaceData buildMapper(ParkPlace obj) {
    ParkPlaceData mapper = new ParkPlaceData();
    mapper.id=obj.getId();
    mapper.parkParkId=obj.getParkParkId();
    mapper.name=obj.getName();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("parkParkId",this.parkParkId);
    map.put("name",this.name);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(ParkPlace obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("parkParkId", obj.getParkParkId());
    map.put("name", obj.getName());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(ParkPlace obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("parkParkId", JSONObject.toJSONString(obj.getParkParkId()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public ParkPlace buildEntity() {
    ParkPlace obj = new ParkPlace();
    obj.setId(this.id);
    obj.setParkParkId(this.parkParkId);
    obj.setName(this.name);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static ParkPlace parseEntity(Map<String, Object> map) {
    ParkPlace obj = new ParkPlace();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setParkParkId((String) map.get("parkParkId"));
    obj.setName((String) map.get("name"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static ParkPlace parseSerialEntity(Map<String, String> map) {
    ParkPlace obj = new ParkPlace();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setParkParkId(JSONObject.parseObject(map.get("parkParkId"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static ParkPlaceDO convert(ParkPlace from, ParkPlaceDO to) {
    if (from == null) return to;
    if (to == null) to = new ParkPlaceDO();
    to.setId(from.getId());
    to.setParkParkId(from.getParkParkId());
    to.setName(from.getName());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static ParkPlace convert(ParkPlaceDO from, ParkPlace to) {
    if (from == null) return to;
    if (to == null) to = new ParkPlace();
    to.setId(from.getId());
    to.setParkParkId(from.getParkParkId());
    to.setName(from.getName());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

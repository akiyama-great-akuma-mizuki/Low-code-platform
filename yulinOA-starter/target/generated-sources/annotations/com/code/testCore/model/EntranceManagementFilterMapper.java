package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EntranceManagementFilterMapper {
  public String id;

  public String entranceName;

  public String inOrOut;

  public String address;

  public Integer useNum;

  public String belongBuilding;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String entranceNameLike = null;

  public String addressLike = null;

  public String belongBuildingLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public EntranceManagementFilterMapper() {
  }

  public EntranceManagementFilterMapper(String id, String entranceName, String inOrOut,
      String address, Integer useNum, String belongBuilding) {
    this.id=id;
    this.entranceName=entranceName;
    this.inOrOut=inOrOut;
    this.address=address;
    this.useNum=useNum;
    this.belongBuilding=belongBuilding;
  }

  public static EntranceManagementFilterMapper buildMapper(EntranceManagement obj) {
    EntranceManagementFilterMapper mapper = new EntranceManagementFilterMapper();
    mapper.id=obj.getId();
    mapper.entranceName=obj.getEntranceName();
    mapper.inOrOut=obj.getInOrOut();
    mapper.address=obj.getAddress();
    mapper.useNum=obj.getUseNum();
    mapper.belongBuilding=obj.getBelongBuilding();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("entranceName",this.entranceName);
    map.put("inOrOut",this.inOrOut);
    map.put("address",this.address);
    map.put("useNum",this.useNum);
    map.put("belongBuilding",this.belongBuilding);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("entranceNameLike",this.entranceNameLike);
    map.put("addressLike",this.addressLike);
    map.put("belongBuildingLike",this.belongBuildingLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(EntranceManagement obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("entranceName", obj.getEntranceName());
    map.put("inOrOut", obj.getInOrOut());
    map.put("address", obj.getAddress());
    map.put("useNum", obj.getUseNum());
    map.put("belongBuilding", obj.getBelongBuilding());
    return map;
  }

  public static Map<String, String> buildSerialMap(EntranceManagement obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("entranceName", JSONObject.toJSONString(obj.getEntranceName()));
    map.put("inOrOut", JSONObject.toJSONString(obj.getInOrOut()));
    map.put("address", JSONObject.toJSONString(obj.getAddress()));
    map.put("useNum", JSONObject.toJSONString(obj.getUseNum()));
    map.put("belongBuilding", JSONObject.toJSONString(obj.getBelongBuilding()));
    return map;
  }

  public EntranceManagement buildEntity() {
    EntranceManagement obj = new EntranceManagement();
    obj.setId(this.id);
    obj.setEntranceName(this.entranceName);
    obj.setInOrOut(this.inOrOut);
    obj.setAddress(this.address);
    obj.setUseNum(this.useNum);
    obj.setBelongBuilding(this.belongBuilding);
    return obj;
  }

  public static EntranceManagement parseEntity(Map<String, Object> map) {
    EntranceManagement obj = new EntranceManagement();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setEntranceName((String) map.get("entranceName"));
    obj.setInOrOut((String) map.get("inOrOut"));
    obj.setAddress((String) map.get("address"));
    obj.setUseNum((Integer) map.get("useNum"));
    obj.setBelongBuilding((String) map.get("belongBuilding"));
    return obj;
  }

  public static EntranceManagement parseSerialEntity(Map<String, String> map) {
    EntranceManagement obj = new EntranceManagement();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setEntranceName(JSONObject.parseObject(map.get("entranceName"), String.class));
    obj.setInOrOut(JSONObject.parseObject(map.get("inOrOut"), String.class));
    obj.setAddress(JSONObject.parseObject(map.get("address"), String.class));
    obj.setUseNum(JSONObject.parseObject(map.get("useNum"), Integer.class));
    obj.setBelongBuilding(JSONObject.parseObject(map.get("belongBuilding"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(EntranceManagement obj, Long page, Integer rows,
      List<String> orderBy, String entranceNameLike, String addressLike, String belongBuildingLike,
      Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("entranceNameLike", entranceNameLike);
    map.put("addressLike", addressLike);
    map.put("belongBuildingLike", belongBuildingLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(EntranceManagement obj, Long page,
      Integer rows, List<String> orderBy, String entranceNameLike, String addressLike,
      String belongBuildingLike, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("entranceNameLike", JSONObject.toJSONString(entranceNameLike));
    map.put("addressLike", JSONObject.toJSONString(addressLike));
    map.put("belongBuildingLike", JSONObject.toJSONString(belongBuildingLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

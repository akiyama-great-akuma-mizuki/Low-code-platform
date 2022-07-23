package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntranceManagementUpdateMapper {
  public String id;

  public String entranceName;

  public String inOrOut;

  public String address;

  public Integer useNum;

  public String belongBuilding;

  public EntranceManagementUpdateMapper() {
  }

  public EntranceManagementUpdateMapper(String id, String entranceName, String inOrOut,
      String address, Integer useNum, String belongBuilding) {
    this.id=id;
    this.entranceName=entranceName;
    this.inOrOut=inOrOut;
    this.address=address;
    this.useNum=useNum;
    this.belongBuilding=belongBuilding;
  }

  public static EntranceManagementUpdateMapper buildMapper(EntranceManagement obj) {
    EntranceManagementUpdateMapper mapper = new EntranceManagementUpdateMapper();
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
}

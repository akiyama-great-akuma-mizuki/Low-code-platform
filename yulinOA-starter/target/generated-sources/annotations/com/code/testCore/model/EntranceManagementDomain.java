package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.EntranceManagementTO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntranceManagementDomain {
  public String id;

  public String entranceName;

  public String inOrOut;

  public String address;

  public Integer useNum;

  public String belongBuilding;

  public Date gmtUpdate;

  public Date gmtCreate;

  public EntranceManagementDomain() {
  }

  public EntranceManagementDomain(String id, String entranceName, String inOrOut, String address,
      Integer useNum, String belongBuilding, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.entranceName=entranceName;
    this.inOrOut=inOrOut;
    this.address=address;
    this.useNum=useNum;
    this.belongBuilding=belongBuilding;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static EntranceManagementDomain buildMapper(EntranceManagement obj) {
    EntranceManagementDomain mapper = new EntranceManagementDomain();
    mapper.id=obj.getId();
    mapper.entranceName=obj.getEntranceName();
    mapper.inOrOut=obj.getInOrOut();
    mapper.address=obj.getAddress();
    mapper.useNum=obj.getUseNum();
    mapper.belongBuilding=obj.getBelongBuilding();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
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
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
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
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
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
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
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
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static EntranceManagementTO convert(EntranceManagement from, EntranceManagementTO to) {
    if (from == null) return to;
    if (to == null) to = new EntranceManagementTO();
    to.setId(from.getId());
    to.setEntranceName(from.getEntranceName());
    to.setInOrOut(from.getInOrOut());
    to.setAddress(from.getAddress());
    to.setUseNum(from.getUseNum());
    to.setBelongBuilding(from.getBelongBuilding());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static EntranceManagement convert(EntranceManagementTO from, EntranceManagement to) {
    if (from == null) return to;
    if (to == null) to = new EntranceManagement();
    to.setId(from.getId());
    to.setEntranceName(from.getEntranceName());
    to.setInOrOut(from.getInOrOut());
    to.setAddress(from.getAddress());
    to.setUseNum(from.getUseNum());
    to.setBelongBuilding(from.getBelongBuilding());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.CheckPersonDO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckPersonData {
  public String id;

  public String checkId;

  public Integer status;

  public String userId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public CheckPersonData() {
  }

  public CheckPersonData(String id, String checkId, Integer status, String userId, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.checkId=checkId;
    this.status=status;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static CheckPersonData buildMapper(CheckPerson obj) {
    CheckPersonData mapper = new CheckPersonData();
    mapper.id=obj.getId();
    mapper.checkId=obj.getCheckId();
    mapper.status=obj.getStatus();
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("checkId",this.checkId);
    map.put("status",this.status);
    map.put("userId",this.userId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(CheckPerson obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("checkId", obj.getCheckId());
    map.put("status", obj.getStatus());
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(CheckPerson obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("checkId", JSONObject.toJSONString(obj.getCheckId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public CheckPerson buildEntity() {
    CheckPerson obj = new CheckPerson();
    obj.setId(this.id);
    obj.setCheckId(this.checkId);
    obj.setStatus(this.status);
    obj.setUserId(this.userId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static CheckPerson parseEntity(Map<String, Object> map) {
    CheckPerson obj = new CheckPerson();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setCheckId((String) map.get("checkId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static CheckPerson parseSerialEntity(Map<String, String> map) {
    CheckPerson obj = new CheckPerson();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setCheckId(JSONObject.parseObject(map.get("checkId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static CheckPersonDO convert(CheckPerson from, CheckPersonDO to) {
    if (from == null) return to;
    if (to == null) to = new CheckPersonDO();
    to.setId(from.getId());
    to.setCheckId(from.getCheckId());
    to.setStatus(from.getStatus());
    to.setUserId(from.getUserId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static CheckPerson convert(CheckPersonDO from, CheckPerson to) {
    if (from == null) return to;
    if (to == null) to = new CheckPerson();
    to.setId(from.getId());
    to.setCheckId(from.getCheckId());
    to.setStatus(from.getStatus());
    to.setUserId(from.getUserId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

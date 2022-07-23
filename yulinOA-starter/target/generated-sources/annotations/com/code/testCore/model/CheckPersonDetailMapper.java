package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class CheckPersonDetailMapper {
  public String id;

  public String checkId;

  public Integer status;

  public String userId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map user = null;

  public CheckPersonDetailMapper() {
  }

  public CheckPersonDetailMapper(String id, String checkId, Integer status, String userId,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.checkId=checkId;
    this.status=status;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static CheckPersonDetailMapper buildMapper(CheckPerson obj) {
    CheckPersonDetailMapper mapper = new CheckPersonDetailMapper();
    mapper.id=obj.getId();
    mapper.checkId=obj.getCheckId();
    mapper.status=obj.getStatus();
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
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
    map.put("user",this.user);
    return map;
  }

  public static Map<String, Object> buildMap(CheckPerson obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("checkId", obj.getCheckId());
    map.put("status", obj.getStatus());
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(CheckPerson obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("checkId", JSONObject.toJSONString(obj.getCheckId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public CheckPerson buildEntity() {
    CheckPerson obj = new CheckPerson();
    obj.setId(this.id);
    obj.setCheckId(this.checkId);
    obj.setStatus(this.status);
    obj.setUserId(this.userId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static CheckPerson parseEntity(Map<String, Object> map) {
    CheckPerson obj = new CheckPerson();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setCheckId((String) map.get("checkId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static CheckPerson parseSerialEntity(Map<String, String> map) {
    CheckPerson obj = new CheckPerson();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setCheckId(JSONObject.parseObject(map.get("checkId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(CheckPerson obj, Map<String, Object> user) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("user", user);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(CheckPerson obj, Map<String, Object> user) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("user", JSONObject.toJSONString(user));
    return map;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckPersonFilterMapper {
  public String id;

  public String checkId;

  public Integer status;

  public String userId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public CheckPersonFilterMapper() {
  }

  public CheckPersonFilterMapper(String id, String checkId, Integer status, String userId) {
    this.id=id;
    this.checkId=checkId;
    this.status=status;
    this.userId=userId;
  }

  public static CheckPersonFilterMapper buildMapper(CheckPerson obj) {
    CheckPersonFilterMapper mapper = new CheckPersonFilterMapper();
    mapper.id=obj.getId();
    mapper.checkId=obj.getCheckId();
    mapper.status=obj.getStatus();
    mapper.userId=obj.getUserId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("checkId",this.checkId);
    map.put("status",this.status);
    map.put("userId",this.userId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(CheckPerson obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("checkId", obj.getCheckId());
    map.put("status", obj.getStatus());
    map.put("userId", obj.getUserId());
    return map;
  }

  public static Map<String, String> buildSerialMap(CheckPerson obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("checkId", JSONObject.toJSONString(obj.getCheckId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    return map;
  }

  public CheckPerson buildEntity() {
    CheckPerson obj = new CheckPerson();
    obj.setId(this.id);
    obj.setCheckId(this.checkId);
    obj.setStatus(this.status);
    obj.setUserId(this.userId);
    return obj;
  }

  public static CheckPerson parseEntity(Map<String, Object> map) {
    CheckPerson obj = new CheckPerson();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setCheckId((String) map.get("checkId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setUserId((String) map.get("userId"));
    return obj;
  }

  public static CheckPerson parseSerialEntity(Map<String, String> map) {
    CheckPerson obj = new CheckPerson();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setCheckId(JSONObject.parseObject(map.get("checkId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(CheckPerson obj, Long page, Integer rows,
      List<String> orderBy, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(CheckPerson obj, Long page, Integer rows,
      List<String> orderBy, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

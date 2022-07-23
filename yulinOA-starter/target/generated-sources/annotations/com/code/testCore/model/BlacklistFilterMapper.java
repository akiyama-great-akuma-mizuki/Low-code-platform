package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BlacklistFilterMapper {
  public String id;

  public String operator;

  public String carId;

  public String reason;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public BlacklistFilterMapper() {
  }

  public BlacklistFilterMapper(String id, String operator, String carId, String reason) {
    this.id=id;
    this.operator=operator;
    this.carId=carId;
    this.reason=reason;
  }

  public static BlacklistFilterMapper buildMapper(Blacklist obj) {
    BlacklistFilterMapper mapper = new BlacklistFilterMapper();
    mapper.id=obj.getId();
    mapper.operator=obj.getOperator();
    mapper.carId=obj.getCarId();
    mapper.reason=obj.getReason();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("operator",this.operator);
    map.put("carId",this.carId);
    map.put("reason",this.reason);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Blacklist obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("operator", obj.getOperator());
    map.put("carId", obj.getCarId());
    map.put("reason", obj.getReason());
    return map;
  }

  public static Map<String, String> buildSerialMap(Blacklist obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("operator", JSONObject.toJSONString(obj.getOperator()));
    map.put("carId", JSONObject.toJSONString(obj.getCarId()));
    map.put("reason", JSONObject.toJSONString(obj.getReason()));
    return map;
  }

  public Blacklist buildEntity() {
    Blacklist obj = new Blacklist();
    obj.setId(this.id);
    obj.setOperator(this.operator);
    obj.setCarId(this.carId);
    obj.setReason(this.reason);
    return obj;
  }

  public static Blacklist parseEntity(Map<String, Object> map) {
    Blacklist obj = new Blacklist();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setOperator((String) map.get("operator"));
    obj.setCarId((String) map.get("carId"));
    obj.setReason((String) map.get("reason"));
    return obj;
  }

  public static Blacklist parseSerialEntity(Map<String, String> map) {
    Blacklist obj = new Blacklist();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setOperator(JSONObject.parseObject(map.get("operator"), String.class));
    obj.setCarId(JSONObject.parseObject(map.get("carId"), String.class));
    obj.setReason(JSONObject.parseObject(map.get("reason"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Blacklist obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(Blacklist obj, Long page, Integer rows,
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

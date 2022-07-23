package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckFilterMapper {
  public String id;

  public String eventId;

  public Integer status;

  public Integer type;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public List<Integer> typeIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public CheckFilterMapper() {
  }

  public CheckFilterMapper(String id, String eventId, Integer status, Integer type) {
    this.id=id;
    this.eventId=eventId;
    this.status=status;
    this.type=type;
  }

  public static CheckFilterMapper buildMapper(Check obj) {
    CheckFilterMapper mapper = new CheckFilterMapper();
    mapper.id=obj.getId();
    mapper.eventId=obj.getEventId();
    mapper.status=obj.getStatus();
    mapper.type=obj.getType();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("eventId",this.eventId);
    map.put("status",this.status);
    map.put("type",this.type);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("typeIn",this.typeIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Check obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("eventId", obj.getEventId());
    map.put("status", obj.getStatus());
    map.put("type", obj.getType());
    return map;
  }

  public static Map<String, String> buildSerialMap(Check obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    return map;
  }

  public Check buildEntity() {
    Check obj = new Check();
    obj.setId(this.id);
    obj.setEventId(this.eventId);
    obj.setStatus(this.status);
    obj.setType(this.type);
    return obj;
  }

  public static Check parseEntity(Map<String, Object> map) {
    Check obj = new Check();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setEventId((String) map.get("eventId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setType((Integer) map.get("type"));
    return obj;
  }

  public static Check parseSerialEntity(Map<String, String> map) {
    Check obj = new Check();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setType(JSONObject.parseObject(map.get("type"), Integer.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Check obj, Long page, Integer rows,
      List<String> orderBy, List<Integer> typeIn, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("typeIn", typeIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Check obj, Long page, Integer rows,
      List<String> orderBy, List<Integer> typeIn, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("typeIn", JSONObject.toJSONString(typeIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiyFlowFilterMapper {
  public String id;

  public String url;

  public String name;

  public String person;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public DiyFlowFilterMapper() {
  }

  public DiyFlowFilterMapper(String id, String url, String name, String person) {
    this.id=id;
    this.url=url;
    this.name=name;
    this.person=person;
  }

  public static DiyFlowFilterMapper buildMapper(DiyFlow obj) {
    DiyFlowFilterMapper mapper = new DiyFlowFilterMapper();
    mapper.id=obj.getId();
    mapper.url=obj.getUrl();
    mapper.name=obj.getName();
    mapper.person=obj.getPerson();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("url",this.url);
    map.put("name",this.name);
    map.put("person",this.person);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlow obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("url", obj.getUrl());
    map.put("name", obj.getName());
    map.put("person", obj.getPerson());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlow obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("url", JSONObject.toJSONString(obj.getUrl()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("person", JSONObject.toJSONString(obj.getPerson()));
    return map;
  }

  public DiyFlow buildEntity() {
    DiyFlow obj = new DiyFlow();
    obj.setId(this.id);
    obj.setUrl(this.url);
    obj.setName(this.name);
    obj.setPerson(this.person);
    return obj;
  }

  public static DiyFlow parseEntity(Map<String, Object> map) {
    DiyFlow obj = new DiyFlow();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setUrl((String) map.get("url"));
    obj.setName((String) map.get("name"));
    obj.setPerson((String) map.get("person"));
    return obj;
  }

  public static DiyFlow parseSerialEntity(Map<String, String> map) {
    DiyFlow obj = new DiyFlow();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setUrl(JSONObject.parseObject(map.get("url"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setPerson(JSONObject.parseObject(map.get("person"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(DiyFlow obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(DiyFlow obj, Long page, Integer rows,
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

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowUpdateMapper {
  public String id;

  public String url;

  public String name;

  public String person;

  public DiyFlowUpdateMapper() {
  }

  public DiyFlowUpdateMapper(String id, String url, String name, String person) {
    this.id=id;
    this.url=url;
    this.name=name;
    this.person=person;
  }

  public static DiyFlowUpdateMapper buildMapper(DiyFlow obj) {
    DiyFlowUpdateMapper mapper = new DiyFlowUpdateMapper();
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
}

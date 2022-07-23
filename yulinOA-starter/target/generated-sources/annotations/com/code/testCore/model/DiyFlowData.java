package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.DiyFlowDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowData {
  public String id;

  public String url;

  public String name;

  public String person;

  public Date gmtUpdate;

  public Date gmtCreate;

  public DiyFlowData() {
  }

  public DiyFlowData(String id, String url, String name, String person, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.url=url;
    this.name=name;
    this.person=person;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static DiyFlowData buildMapper(DiyFlow obj) {
    DiyFlowData mapper = new DiyFlowData();
    mapper.id=obj.getId();
    mapper.url=obj.getUrl();
    mapper.name=obj.getName();
    mapper.person=obj.getPerson();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("url",this.url);
    map.put("name",this.name);
    map.put("person",this.person);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlow obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("url", obj.getUrl());
    map.put("name", obj.getName());
    map.put("person", obj.getPerson());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlow obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("url", JSONObject.toJSONString(obj.getUrl()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("person", JSONObject.toJSONString(obj.getPerson()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public DiyFlow buildEntity() {
    DiyFlow obj = new DiyFlow();
    obj.setId(this.id);
    obj.setUrl(this.url);
    obj.setName(this.name);
    obj.setPerson(this.person);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static DiyFlow parseEntity(Map<String, Object> map) {
    DiyFlow obj = new DiyFlow();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setUrl((String) map.get("url"));
    obj.setName((String) map.get("name"));
    obj.setPerson((String) map.get("person"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static DiyFlow parseSerialEntity(Map<String, String> map) {
    DiyFlow obj = new DiyFlow();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setUrl(JSONObject.parseObject(map.get("url"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setPerson(JSONObject.parseObject(map.get("person"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static DiyFlowDO convert(DiyFlow from, DiyFlowDO to) {
    if (from == null) return to;
    if (to == null) to = new DiyFlowDO();
    to.setId(from.getId());
    to.setUrl(from.getUrl());
    to.setName(from.getName());
    to.setPerson(from.getPerson());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static DiyFlow convert(DiyFlowDO from, DiyFlow to) {
    if (from == null) return to;
    if (to == null) to = new DiyFlow();
    to.setId(from.getId());
    to.setUrl(from.getUrl());
    to.setName(from.getName());
    to.setPerson(from.getPerson());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

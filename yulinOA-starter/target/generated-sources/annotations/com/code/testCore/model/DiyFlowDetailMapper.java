package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiyFlowDetailMapper {
  public String id;

  public String url;

  public String name;

  public String person;

  public Long gmtUpdate;

  public Long gmtCreate;

  public List<Map> diyFlowTextList = null;

  public List<Map> diyFlowNodeList = null;

  public DiyFlowDetailMapper() {
  }

  public DiyFlowDetailMapper(String id, String url, String name, String person, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.url=url;
    this.name=name;
    this.person=person;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static DiyFlowDetailMapper buildMapper(DiyFlow obj) {
    DiyFlowDetailMapper mapper = new DiyFlowDetailMapper();
    mapper.id=obj.getId();
    mapper.url=obj.getUrl();
    mapper.name=obj.getName();
    mapper.person=obj.getPerson();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
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
    map.put("diyFlowTextList",this.diyFlowTextList);
    map.put("diyFlowNodeList",this.diyFlowNodeList);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlow obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("url", obj.getUrl());
    map.put("name", obj.getName());
    map.put("person", obj.getPerson());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlow obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("url", JSONObject.toJSONString(obj.getUrl()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("person", JSONObject.toJSONString(obj.getPerson()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public DiyFlow buildEntity() {
    DiyFlow obj = new DiyFlow();
    obj.setId(this.id);
    obj.setUrl(this.url);
    obj.setName(this.name);
    obj.setPerson(this.person);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static DiyFlow parseEntity(Map<String, Object> map) {
    DiyFlow obj = new DiyFlow();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setUrl((String) map.get("url"));
    obj.setName((String) map.get("name"));
    obj.setPerson((String) map.get("person"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static DiyFlow parseSerialEntity(Map<String, String> map) {
    DiyFlow obj = new DiyFlow();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setUrl(JSONObject.parseObject(map.get("url"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setPerson(JSONObject.parseObject(map.get("person"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(DiyFlow obj,
      List<Map<String, Object>> diyFlowTextList, List<Map<String, Object>> diyFlowNodeList) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("diyFlowTextList", diyFlowTextList);
    map.put("diyFlowNodeList", diyFlowNodeList);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(DiyFlow obj,
      List<Map<String, Object>> diyFlowTextList, List<Map<String, Object>> diyFlowNodeList) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("diyFlowTextList", JSONObject.toJSONString(diyFlowTextList));
    map.put("diyFlowNodeList", JSONObject.toJSONString(diyFlowNodeList));
    return map;
  }
}
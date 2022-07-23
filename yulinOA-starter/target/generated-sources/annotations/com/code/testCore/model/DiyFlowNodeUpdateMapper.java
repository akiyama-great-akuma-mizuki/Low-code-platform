package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowNodeUpdateMapper {
  public String id;

  public Integer type;

  public String title;

  public String diyFlowId;

  public DiyFlowNodeUpdateMapper() {
  }

  public DiyFlowNodeUpdateMapper(String id, Integer type, String title, String diyFlowId) {
    this.id=id;
    this.type=type;
    this.title=title;
    this.diyFlowId=diyFlowId;
  }

  public static DiyFlowNodeUpdateMapper buildMapper(DiyFlowNode obj) {
    DiyFlowNodeUpdateMapper mapper = new DiyFlowNodeUpdateMapper();
    mapper.id=obj.getId();
    mapper.type=obj.getType();
    mapper.title=obj.getTitle();
    mapper.diyFlowId=obj.getDiyFlowId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("type",this.type);
    map.put("title",this.title);
    map.put("diyFlowId",this.diyFlowId);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlowNode obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("type", obj.getType());
    map.put("title", obj.getTitle());
    map.put("diyFlowId", obj.getDiyFlowId());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowNode obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("title", JSONObject.toJSONString(obj.getTitle()));
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    return map;
  }

  public DiyFlowNode buildEntity() {
    DiyFlowNode obj = new DiyFlowNode();
    obj.setId(this.id);
    obj.setType(this.type);
    obj.setTitle(this.title);
    obj.setDiyFlowId(this.diyFlowId);
    return obj;
  }

  public static DiyFlowNode parseEntity(Map<String, Object> map) {
    DiyFlowNode obj = new DiyFlowNode();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setType((Integer) map.get("type"));
    obj.setTitle((String) map.get("title"));
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    return obj;
  }

  public static DiyFlowNode parseSerialEntity(Map<String, String> map) {
    DiyFlowNode obj = new DiyFlowNode();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setType(JSONObject.parseObject(map.get("type"), Integer.class));
    obj.setTitle(JSONObject.parseObject(map.get("title"), String.class));
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    return obj;
  }
}

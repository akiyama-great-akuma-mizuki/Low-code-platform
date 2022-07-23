package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowNodePostMapper {
  public Integer type;

  public String title;

  public String diyFlowId;

  public DiyFlowNodePostMapper() {
  }

  public DiyFlowNodePostMapper(Integer type, String title, String diyFlowId) {
    this.type=type;
    this.title=title;
    this.diyFlowId=diyFlowId;
  }

  public static DiyFlowNodePostMapper buildMapper(DiyFlowNode obj) {
    DiyFlowNodePostMapper mapper = new DiyFlowNodePostMapper();
    mapper.type=obj.getType();
    mapper.title=obj.getTitle();
    mapper.diyFlowId=obj.getDiyFlowId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("type",this.type);
    map.put("title",this.title);
    map.put("diyFlowId",this.diyFlowId);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlowNode obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("type", obj.getType());
    map.put("title", obj.getTitle());
    map.put("diyFlowId", obj.getDiyFlowId());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowNode obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("title", JSONObject.toJSONString(obj.getTitle()));
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    return map;
  }

  public DiyFlowNode buildEntity() {
    DiyFlowNode obj = new DiyFlowNode();
    obj.setType(this.type);
    obj.setTitle(this.title);
    obj.setDiyFlowId(this.diyFlowId);
    return obj;
  }

  public static DiyFlowNode parseEntity(Map<String, Object> map) {
    DiyFlowNode obj = new DiyFlowNode();
    if (map == null) return obj;
    obj.setType((Integer) map.get("type"));
    obj.setTitle((String) map.get("title"));
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    return obj;
  }

  public static DiyFlowNode parseSerialEntity(Map<String, String> map) {
    DiyFlowNode obj = new DiyFlowNode();
    if (map == null) return obj;
    obj.setType(JSONObject.parseObject(map.get("type"), Integer.class));
    obj.setTitle(JSONObject.parseObject(map.get("title"), String.class));
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    return obj;
  }
}

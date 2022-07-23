package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowTextPostMapper {
  public String title;

  public Integer type;

  public String diyFlowId;

  public DiyFlowTextPostMapper() {
  }

  public DiyFlowTextPostMapper(String title, Integer type, String diyFlowId) {
    this.title=title;
    this.type=type;
    this.diyFlowId=diyFlowId;
  }

  public static DiyFlowTextPostMapper buildMapper(DiyFlowText obj) {
    DiyFlowTextPostMapper mapper = new DiyFlowTextPostMapper();
    mapper.title=obj.getTitle();
    mapper.type=obj.getType();
    mapper.diyFlowId=obj.getDiyFlowId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("title",this.title);
    map.put("type",this.type);
    map.put("diyFlowId",this.diyFlowId);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlowText obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("title", obj.getTitle());
    map.put("type", obj.getType());
    map.put("diyFlowId", obj.getDiyFlowId());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowText obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("title", JSONObject.toJSONString(obj.getTitle()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    return map;
  }

  public DiyFlowText buildEntity() {
    DiyFlowText obj = new DiyFlowText();
    obj.setTitle(this.title);
    obj.setType(this.type);
    obj.setDiyFlowId(this.diyFlowId);
    return obj;
  }

  public static DiyFlowText parseEntity(Map<String, Object> map) {
    DiyFlowText obj = new DiyFlowText();
    if (map == null) return obj;
    obj.setTitle((String) map.get("title"));
    obj.setType((Integer) map.get("type"));
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    return obj;
  }

  public static DiyFlowText parseSerialEntity(Map<String, String> map) {
    DiyFlowText obj = new DiyFlowText();
    if (map == null) return obj;
    obj.setTitle(JSONObject.parseObject(map.get("title"), String.class));
    obj.setType(JSONObject.parseObject(map.get("type"), Integer.class));
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    return obj;
  }
}

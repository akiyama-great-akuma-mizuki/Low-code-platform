package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiyFlowNodeFilterMapper {
  public String id;

  public Integer type;

  public String title;

  public String diyFlowId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public DiyFlowNodeFilterMapper() {
  }

  public DiyFlowNodeFilterMapper(String id, Integer type, String title, String diyFlowId) {
    this.id=id;
    this.type=type;
    this.title=title;
    this.diyFlowId=diyFlowId;
  }

  public static DiyFlowNodeFilterMapper buildMapper(DiyFlowNode obj) {
    DiyFlowNodeFilterMapper mapper = new DiyFlowNodeFilterMapper();
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
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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

  public static Map<String, Object> buildMapExtra(DiyFlowNode obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(DiyFlowNode obj, Long page, Integer rows,
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

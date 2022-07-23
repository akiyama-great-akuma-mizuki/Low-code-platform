package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowNodeDetailMapper {
  public String id;

  public Integer type;

  public String title;

  public String diyFlowId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public DiyFlowNodeDetailMapper() {
  }

  public DiyFlowNodeDetailMapper(String id, Integer type, String title, String diyFlowId,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.type=type;
    this.title=title;
    this.diyFlowId=diyFlowId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static DiyFlowNodeDetailMapper buildMapper(DiyFlowNode obj) {
    DiyFlowNodeDetailMapper mapper = new DiyFlowNodeDetailMapper();
    mapper.id=obj.getId();
    mapper.type=obj.getType();
    mapper.title=obj.getTitle();
    mapper.diyFlowId=obj.getDiyFlowId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("type",this.type);
    map.put("title",this.title);
    map.put("diyFlowId",this.diyFlowId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlowNode obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("type", obj.getType());
    map.put("title", obj.getTitle());
    map.put("diyFlowId", obj.getDiyFlowId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowNode obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("title", JSONObject.toJSONString(obj.getTitle()));
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public DiyFlowNode buildEntity() {
    DiyFlowNode obj = new DiyFlowNode();
    obj.setId(this.id);
    obj.setType(this.type);
    obj.setTitle(this.title);
    obj.setDiyFlowId(this.diyFlowId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static DiyFlowNode parseEntity(Map<String, Object> map) {
    DiyFlowNode obj = new DiyFlowNode();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setType((Integer) map.get("type"));
    obj.setTitle((String) map.get("title"));
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static DiyFlowNode parseSerialEntity(Map<String, String> map) {
    DiyFlowNode obj = new DiyFlowNode();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setType(JSONObject.parseObject(map.get("type"), Integer.class));
    obj.setTitle(JSONObject.parseObject(map.get("title"), String.class));
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

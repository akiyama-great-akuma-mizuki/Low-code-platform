package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.DiyFlowNodeDO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowNodeData {
  public String id;

  public Integer type;

  public String title;

  public String diyFlowId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public DiyFlowNodeData() {
  }

  public DiyFlowNodeData(String id, Integer type, String title, String diyFlowId, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.type=type;
    this.title=title;
    this.diyFlowId=diyFlowId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static DiyFlowNodeData buildMapper(DiyFlowNode obj) {
    DiyFlowNodeData mapper = new DiyFlowNodeData();
    mapper.id=obj.getId();
    mapper.type=obj.getType();
    mapper.title=obj.getTitle();
    mapper.diyFlowId=obj.getDiyFlowId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowNode obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("title", JSONObject.toJSONString(obj.getTitle()));
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public DiyFlowNode buildEntity() {
    DiyFlowNode obj = new DiyFlowNode();
    obj.setId(this.id);
    obj.setType(this.type);
    obj.setTitle(this.title);
    obj.setDiyFlowId(this.diyFlowId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static DiyFlowNode parseEntity(Map<String, Object> map) {
    DiyFlowNode obj = new DiyFlowNode();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setType((Integer) map.get("type"));
    obj.setTitle((String) map.get("title"));
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static DiyFlowNode parseSerialEntity(Map<String, String> map) {
    DiyFlowNode obj = new DiyFlowNode();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setType(JSONObject.parseObject(map.get("type"), Integer.class));
    obj.setTitle(JSONObject.parseObject(map.get("title"), String.class));
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static DiyFlowNodeDO convert(DiyFlowNode from, DiyFlowNodeDO to) {
    if (from == null) return to;
    if (to == null) to = new DiyFlowNodeDO();
    to.setId(from.getId());
    to.setType(from.getType());
    to.setTitle(from.getTitle());
    to.setDiyFlowId(from.getDiyFlowId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static DiyFlowNode convert(DiyFlowNodeDO from, DiyFlowNode to) {
    if (from == null) return to;
    if (to == null) to = new DiyFlowNode();
    to.setId(from.getId());
    to.setType(from.getType());
    to.setTitle(from.getTitle());
    to.setDiyFlowId(from.getDiyFlowId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

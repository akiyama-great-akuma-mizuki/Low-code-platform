package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowTextDefaultMapper {
  public String id;

  public String title;

  public Integer type;

  public String diyFlowId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public DiyFlowTextDefaultMapper() {
  }

  public DiyFlowTextDefaultMapper(String id, String title, Integer type, String diyFlowId,
      Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.title=title;
    this.type=type;
    this.diyFlowId=diyFlowId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static DiyFlowTextDefaultMapper buildMapper(DiyFlowText obj) {
    DiyFlowTextDefaultMapper mapper = new DiyFlowTextDefaultMapper();
    mapper.id=obj.getId();
    mapper.title=obj.getTitle();
    mapper.type=obj.getType();
    mapper.diyFlowId=obj.getDiyFlowId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("title",this.title);
    map.put("type",this.type);
    map.put("diyFlowId",this.diyFlowId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlowText obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("title", obj.getTitle());
    map.put("type", obj.getType());
    map.put("diyFlowId", obj.getDiyFlowId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowText obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("title", JSONObject.toJSONString(obj.getTitle()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public DiyFlowText buildEntity() {
    DiyFlowText obj = new DiyFlowText();
    obj.setId(this.id);
    obj.setTitle(this.title);
    obj.setType(this.type);
    obj.setDiyFlowId(this.diyFlowId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static DiyFlowText parseEntity(Map<String, Object> map) {
    DiyFlowText obj = new DiyFlowText();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setTitle((String) map.get("title"));
    obj.setType((Integer) map.get("type"));
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static DiyFlowText parseSerialEntity(Map<String, String> map) {
    DiyFlowText obj = new DiyFlowText();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setTitle(JSONObject.parseObject(map.get("title"), String.class));
    obj.setType(JSONObject.parseObject(map.get("type"), Integer.class));
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }
}

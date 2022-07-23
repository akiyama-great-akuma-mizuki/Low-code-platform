package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowFinishSimpleMapper {
  public String id;

  public String diyFlowId;

  public Integer status;

  public Long gmtUpdate;

  public Long gmtCreate;

  public DiyFlowFinishSimpleMapper() {
  }

  public DiyFlowFinishSimpleMapper(String id, String diyFlowId, Integer status, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.diyFlowId=diyFlowId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static DiyFlowFinishSimpleMapper buildMapper(DiyFlowFinish obj) {
    DiyFlowFinishSimpleMapper mapper = new DiyFlowFinishSimpleMapper();
    mapper.id=obj.getId();
    mapper.diyFlowId=obj.getDiyFlowId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("diyFlowId",this.diyFlowId);
    map.put("status",this.status);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlowFinish obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("diyFlowId", obj.getDiyFlowId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowFinish obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public DiyFlowFinish buildEntity() {
    DiyFlowFinish obj = new DiyFlowFinish();
    obj.setId(this.id);
    obj.setDiyFlowId(this.diyFlowId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static DiyFlowFinish parseEntity(Map<String, Object> map) {
    DiyFlowFinish obj = new DiyFlowFinish();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static DiyFlowFinish parseSerialEntity(Map<String, String> map) {
    DiyFlowFinish obj = new DiyFlowFinish();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

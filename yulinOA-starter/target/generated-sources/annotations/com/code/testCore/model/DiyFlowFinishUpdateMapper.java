package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowFinishUpdateMapper {
  public String id;

  public String diyFlowId;

  public Integer status;

  public DiyFlowFinishUpdateMapper() {
  }

  public DiyFlowFinishUpdateMapper(String id, String diyFlowId, Integer status) {
    this.id=id;
    this.diyFlowId=diyFlowId;
    this.status=status;
  }

  public static DiyFlowFinishUpdateMapper buildMapper(DiyFlowFinish obj) {
    DiyFlowFinishUpdateMapper mapper = new DiyFlowFinishUpdateMapper();
    mapper.id=obj.getId();
    mapper.diyFlowId=obj.getDiyFlowId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("diyFlowId",this.diyFlowId);
    map.put("status",this.status);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlowFinish obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("diyFlowId", obj.getDiyFlowId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowFinish obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public DiyFlowFinish buildEntity() {
    DiyFlowFinish obj = new DiyFlowFinish();
    obj.setId(this.id);
    obj.setDiyFlowId(this.diyFlowId);
    obj.setStatus(this.status);
    return obj;
  }

  public static DiyFlowFinish parseEntity(Map<String, Object> map) {
    DiyFlowFinish obj = new DiyFlowFinish();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static DiyFlowFinish parseSerialEntity(Map<String, String> map) {
    DiyFlowFinish obj = new DiyFlowFinish();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }
}

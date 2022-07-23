package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowFinishPostMapper {
  public String diyFlowId;

  public Integer status;

  public DiyFlowFinishPostMapper() {
  }

  public DiyFlowFinishPostMapper(String diyFlowId, Integer status) {
    this.diyFlowId=diyFlowId;
    this.status=status;
  }

  public static DiyFlowFinishPostMapper buildMapper(DiyFlowFinish obj) {
    DiyFlowFinishPostMapper mapper = new DiyFlowFinishPostMapper();
    mapper.diyFlowId=obj.getDiyFlowId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("diyFlowId",this.diyFlowId);
    map.put("status",this.status);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlowFinish obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("diyFlowId", obj.getDiyFlowId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowFinish obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public DiyFlowFinish buildEntity() {
    DiyFlowFinish obj = new DiyFlowFinish();
    obj.setDiyFlowId(this.diyFlowId);
    obj.setStatus(this.status);
    return obj;
  }

  public static DiyFlowFinish parseEntity(Map<String, Object> map) {
    DiyFlowFinish obj = new DiyFlowFinish();
    if (map == null) return obj;
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static DiyFlowFinish parseSerialEntity(Map<String, String> map) {
    DiyFlowFinish obj = new DiyFlowFinish();
    if (map == null) return obj;
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }
}

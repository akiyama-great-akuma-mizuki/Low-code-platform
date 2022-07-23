package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiyFlowFinishFilterMapper {
  public String id;

  public String diyFlowId;

  public Integer status;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public DiyFlowFinishFilterMapper() {
  }

  public DiyFlowFinishFilterMapper(String id, String diyFlowId, Integer status) {
    this.id=id;
    this.diyFlowId=diyFlowId;
    this.status=status;
  }

  public static DiyFlowFinishFilterMapper buildMapper(DiyFlowFinish obj) {
    DiyFlowFinishFilterMapper mapper = new DiyFlowFinishFilterMapper();
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
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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

  public static Map<String, Object> buildMapExtra(DiyFlowFinish obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(DiyFlowFinish obj, Long page, Integer rows,
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

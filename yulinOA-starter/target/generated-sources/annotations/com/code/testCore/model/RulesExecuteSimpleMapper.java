package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesExecuteSimpleMapper {
  public String id;

  public String rulesId;

  public String departmentId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public RulesExecuteSimpleMapper() {
  }

  public RulesExecuteSimpleMapper(String id, String rulesId, String departmentId, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.rulesId=rulesId;
    this.departmentId=departmentId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static RulesExecuteSimpleMapper buildMapper(RulesExecute obj) {
    RulesExecuteSimpleMapper mapper = new RulesExecuteSimpleMapper();
    mapper.id=obj.getId();
    mapper.rulesId=obj.getRulesId();
    mapper.departmentId=obj.getDepartmentId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("rulesId",this.rulesId);
    map.put("departmentId",this.departmentId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(RulesExecute obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("rulesId", obj.getRulesId());
    map.put("departmentId", obj.getDepartmentId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(RulesExecute obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("rulesId", JSONObject.toJSONString(obj.getRulesId()));
    map.put("departmentId", JSONObject.toJSONString(obj.getDepartmentId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public RulesExecute buildEntity() {
    RulesExecute obj = new RulesExecute();
    obj.setId(this.id);
    obj.setRulesId(this.rulesId);
    obj.setDepartmentId(this.departmentId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static RulesExecute parseEntity(Map<String, Object> map) {
    RulesExecute obj = new RulesExecute();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setRulesId((String) map.get("rulesId"));
    obj.setDepartmentId((String) map.get("departmentId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static RulesExecute parseSerialEntity(Map<String, String> map) {
    RulesExecute obj = new RulesExecute();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setRulesId(JSONObject.parseObject(map.get("rulesId"), String.class));
    obj.setDepartmentId(JSONObject.parseObject(map.get("departmentId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

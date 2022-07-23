package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesExecutePostMapper {
  public String rulesId;

  public String departmentId;

  public RulesExecutePostMapper() {
  }

  public RulesExecutePostMapper(String rulesId, String departmentId) {
    this.rulesId=rulesId;
    this.departmentId=departmentId;
  }

  public static RulesExecutePostMapper buildMapper(RulesExecute obj) {
    RulesExecutePostMapper mapper = new RulesExecutePostMapper();
    mapper.rulesId=obj.getRulesId();
    mapper.departmentId=obj.getDepartmentId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("rulesId",this.rulesId);
    map.put("departmentId",this.departmentId);
    return map;
  }

  public static Map<String, Object> buildMap(RulesExecute obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("rulesId", obj.getRulesId());
    map.put("departmentId", obj.getDepartmentId());
    return map;
  }

  public static Map<String, String> buildSerialMap(RulesExecute obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("rulesId", JSONObject.toJSONString(obj.getRulesId()));
    map.put("departmentId", JSONObject.toJSONString(obj.getDepartmentId()));
    return map;
  }

  public RulesExecute buildEntity() {
    RulesExecute obj = new RulesExecute();
    obj.setRulesId(this.rulesId);
    obj.setDepartmentId(this.departmentId);
    return obj;
  }

  public static RulesExecute parseEntity(Map<String, Object> map) {
    RulesExecute obj = new RulesExecute();
    if (map == null) return obj;
    obj.setRulesId((String) map.get("rulesId"));
    obj.setDepartmentId((String) map.get("departmentId"));
    return obj;
  }

  public static RulesExecute parseSerialEntity(Map<String, String> map) {
    RulesExecute obj = new RulesExecute();
    if (map == null) return obj;
    obj.setRulesId(JSONObject.parseObject(map.get("rulesId"), String.class));
    obj.setDepartmentId(JSONObject.parseObject(map.get("departmentId"), String.class));
    return obj;
  }
}

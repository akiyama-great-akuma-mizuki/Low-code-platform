package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RulesExecuteFilterMapper {
  public String id;

  public String rulesId;

  public String departmentId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public RulesExecuteFilterMapper() {
  }

  public RulesExecuteFilterMapper(String id, String rulesId, String departmentId) {
    this.id=id;
    this.rulesId=rulesId;
    this.departmentId=departmentId;
  }

  public static RulesExecuteFilterMapper buildMapper(RulesExecute obj) {
    RulesExecuteFilterMapper mapper = new RulesExecuteFilterMapper();
    mapper.id=obj.getId();
    mapper.rulesId=obj.getRulesId();
    mapper.departmentId=obj.getDepartmentId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("rulesId",this.rulesId);
    map.put("departmentId",this.departmentId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(RulesExecute obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("rulesId", obj.getRulesId());
    map.put("departmentId", obj.getDepartmentId());
    return map;
  }

  public static Map<String, String> buildSerialMap(RulesExecute obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("rulesId", JSONObject.toJSONString(obj.getRulesId()));
    map.put("departmentId", JSONObject.toJSONString(obj.getDepartmentId()));
    return map;
  }

  public RulesExecute buildEntity() {
    RulesExecute obj = new RulesExecute();
    obj.setId(this.id);
    obj.setRulesId(this.rulesId);
    obj.setDepartmentId(this.departmentId);
    return obj;
  }

  public static RulesExecute parseEntity(Map<String, Object> map) {
    RulesExecute obj = new RulesExecute();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setRulesId((String) map.get("rulesId"));
    obj.setDepartmentId((String) map.get("departmentId"));
    return obj;
  }

  public static RulesExecute parseSerialEntity(Map<String, String> map) {
    RulesExecute obj = new RulesExecute();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setRulesId(JSONObject.parseObject(map.get("rulesId"), String.class));
    obj.setDepartmentId(JSONObject.parseObject(map.get("departmentId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(RulesExecute obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(RulesExecute obj, Long page, Integer rows,
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

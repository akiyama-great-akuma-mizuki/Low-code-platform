package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.RulesExecuteDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesExecuteData {
  public String id;

  public String rulesId;

  public String departmentId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public RulesExecuteData() {
  }

  public RulesExecuteData(String id, String rulesId, String departmentId, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.rulesId=rulesId;
    this.departmentId=departmentId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static RulesExecuteData buildMapper(RulesExecute obj) {
    RulesExecuteData mapper = new RulesExecuteData();
    mapper.id=obj.getId();
    mapper.rulesId=obj.getRulesId();
    mapper.departmentId=obj.getDepartmentId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(RulesExecute obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("rulesId", JSONObject.toJSONString(obj.getRulesId()));
    map.put("departmentId", JSONObject.toJSONString(obj.getDepartmentId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public RulesExecute buildEntity() {
    RulesExecute obj = new RulesExecute();
    obj.setId(this.id);
    obj.setRulesId(this.rulesId);
    obj.setDepartmentId(this.departmentId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static RulesExecute parseEntity(Map<String, Object> map) {
    RulesExecute obj = new RulesExecute();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setRulesId((String) map.get("rulesId"));
    obj.setDepartmentId((String) map.get("departmentId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static RulesExecute parseSerialEntity(Map<String, String> map) {
    RulesExecute obj = new RulesExecute();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setRulesId(JSONObject.parseObject(map.get("rulesId"), String.class));
    obj.setDepartmentId(JSONObject.parseObject(map.get("departmentId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static RulesExecuteDO convert(RulesExecute from, RulesExecuteDO to) {
    if (from == null) return to;
    if (to == null) to = new RulesExecuteDO();
    to.setId(from.getId());
    to.setRulesId(from.getRulesId());
    to.setDepartmentId(from.getDepartmentId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static RulesExecute convert(RulesExecuteDO from, RulesExecute to) {
    if (from == null) return to;
    if (to == null) to = new RulesExecute();
    to.setId(from.getId());
    to.setRulesId(from.getRulesId());
    to.setDepartmentId(from.getDepartmentId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

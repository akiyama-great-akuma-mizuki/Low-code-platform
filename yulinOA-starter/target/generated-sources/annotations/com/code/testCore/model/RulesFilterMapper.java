package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RulesFilterMapper {
  public String id;

  public String rulesTitle;

  public String userId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String rulesTitleLike = null;

  public List<String> rulesTitleIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public RulesFilterMapper() {
  }

  public RulesFilterMapper(String id, String rulesTitle, String userId) {
    this.id=id;
    this.rulesTitle=rulesTitle;
    this.userId=userId;
  }

  public static RulesFilterMapper buildMapper(Rules obj) {
    RulesFilterMapper mapper = new RulesFilterMapper();
    mapper.id=obj.getId();
    mapper.rulesTitle=obj.getRulesTitle();
    mapper.userId=obj.getUserId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("rulesTitle",this.rulesTitle);
    map.put("userId",this.userId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("rulesTitleLike",this.rulesTitleLike);
    map.put("rulesTitleIn",this.rulesTitleIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Rules obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("rulesTitle", obj.getRulesTitle());
    map.put("userId", obj.getUserId());
    return map;
  }

  public static Map<String, String> buildSerialMap(Rules obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("rulesTitle", JSONObject.toJSONString(obj.getRulesTitle()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    return map;
  }

  public Rules buildEntity() {
    Rules obj = new Rules();
    obj.setId(this.id);
    obj.setRulesTitle(this.rulesTitle);
    obj.setUserId(this.userId);
    return obj;
  }

  public static Rules parseEntity(Map<String, Object> map) {
    Rules obj = new Rules();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setRulesTitle((String) map.get("rulesTitle"));
    obj.setUserId((String) map.get("userId"));
    return obj;
  }

  public static Rules parseSerialEntity(Map<String, String> map) {
    Rules obj = new Rules();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setRulesTitle(JSONObject.parseObject(map.get("rulesTitle"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Rules obj, Long page, Integer rows,
      List<String> orderBy, String rulesTitleLike, List<String> rulesTitleIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("rulesTitleLike", rulesTitleLike);
    map.put("rulesTitleIn", rulesTitleIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Rules obj, Long page, Integer rows,
      List<String> orderBy, String rulesTitleLike, List<String> rulesTitleIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("rulesTitleLike", JSONObject.toJSONString(rulesTitleLike));
    map.put("rulesTitleIn", JSONObject.toJSONString(rulesTitleIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

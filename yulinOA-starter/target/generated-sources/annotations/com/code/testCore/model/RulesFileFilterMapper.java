package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RulesFileFilterMapper {
  public String id;

  public String fileUrl;

  public String fileName;

  public String rulesId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public RulesFileFilterMapper() {
  }

  public RulesFileFilterMapper(String id, String fileUrl, String fileName, String rulesId) {
    this.id=id;
    this.fileUrl=fileUrl;
    this.fileName=fileName;
    this.rulesId=rulesId;
  }

  public static RulesFileFilterMapper buildMapper(RulesFile obj) {
    RulesFileFilterMapper mapper = new RulesFileFilterMapper();
    mapper.id=obj.getId();
    mapper.fileUrl=obj.getFileUrl();
    mapper.fileName=obj.getFileName();
    mapper.rulesId=obj.getRulesId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("fileUrl",this.fileUrl);
    map.put("fileName",this.fileName);
    map.put("rulesId",this.rulesId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(RulesFile obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("fileUrl", obj.getFileUrl());
    map.put("fileName", obj.getFileName());
    map.put("rulesId", obj.getRulesId());
    return map;
  }

  public static Map<String, String> buildSerialMap(RulesFile obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("fileUrl", JSONObject.toJSONString(obj.getFileUrl()));
    map.put("fileName", JSONObject.toJSONString(obj.getFileName()));
    map.put("rulesId", JSONObject.toJSONString(obj.getRulesId()));
    return map;
  }

  public RulesFile buildEntity() {
    RulesFile obj = new RulesFile();
    obj.setId(this.id);
    obj.setFileUrl(this.fileUrl);
    obj.setFileName(this.fileName);
    obj.setRulesId(this.rulesId);
    return obj;
  }

  public static RulesFile parseEntity(Map<String, Object> map) {
    RulesFile obj = new RulesFile();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setFileUrl((String) map.get("fileUrl"));
    obj.setFileName((String) map.get("fileName"));
    obj.setRulesId((String) map.get("rulesId"));
    return obj;
  }

  public static RulesFile parseSerialEntity(Map<String, String> map) {
    RulesFile obj = new RulesFile();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setFileUrl(JSONObject.parseObject(map.get("fileUrl"), String.class));
    obj.setFileName(JSONObject.parseObject(map.get("fileName"), String.class));
    obj.setRulesId(JSONObject.parseObject(map.get("rulesId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(RulesFile obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(RulesFile obj, Long page, Integer rows,
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

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesFilePostMapper {
  public String fileUrl;

  public String fileName;

  public String rulesId;

  public RulesFilePostMapper() {
  }

  public RulesFilePostMapper(String fileUrl, String fileName, String rulesId) {
    this.fileUrl=fileUrl;
    this.fileName=fileName;
    this.rulesId=rulesId;
  }

  public static RulesFilePostMapper buildMapper(RulesFile obj) {
    RulesFilePostMapper mapper = new RulesFilePostMapper();
    mapper.fileUrl=obj.getFileUrl();
    mapper.fileName=obj.getFileName();
    mapper.rulesId=obj.getRulesId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("fileUrl",this.fileUrl);
    map.put("fileName",this.fileName);
    map.put("rulesId",this.rulesId);
    return map;
  }

  public static Map<String, Object> buildMap(RulesFile obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("fileUrl", obj.getFileUrl());
    map.put("fileName", obj.getFileName());
    map.put("rulesId", obj.getRulesId());
    return map;
  }

  public static Map<String, String> buildSerialMap(RulesFile obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("fileUrl", JSONObject.toJSONString(obj.getFileUrl()));
    map.put("fileName", JSONObject.toJSONString(obj.getFileName()));
    map.put("rulesId", JSONObject.toJSONString(obj.getRulesId()));
    return map;
  }

  public RulesFile buildEntity() {
    RulesFile obj = new RulesFile();
    obj.setFileUrl(this.fileUrl);
    obj.setFileName(this.fileName);
    obj.setRulesId(this.rulesId);
    return obj;
  }

  public static RulesFile parseEntity(Map<String, Object> map) {
    RulesFile obj = new RulesFile();
    if (map == null) return obj;
    obj.setFileUrl((String) map.get("fileUrl"));
    obj.setFileName((String) map.get("fileName"));
    obj.setRulesId((String) map.get("rulesId"));
    return obj;
  }

  public static RulesFile parseSerialEntity(Map<String, String> map) {
    RulesFile obj = new RulesFile();
    if (map == null) return obj;
    obj.setFileUrl(JSONObject.parseObject(map.get("fileUrl"), String.class));
    obj.setFileName(JSONObject.parseObject(map.get("fileName"), String.class));
    obj.setRulesId(JSONObject.parseObject(map.get("rulesId"), String.class));
    return obj;
  }
}

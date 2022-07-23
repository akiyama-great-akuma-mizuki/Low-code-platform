package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesFileUpdateMapper {
  public String id;

  public String fileUrl;

  public String fileName;

  public String rulesId;

  public RulesFileUpdateMapper() {
  }

  public RulesFileUpdateMapper(String id, String fileUrl, String fileName, String rulesId) {
    this.id=id;
    this.fileUrl=fileUrl;
    this.fileName=fileName;
    this.rulesId=rulesId;
  }

  public static RulesFileUpdateMapper buildMapper(RulesFile obj) {
    RulesFileUpdateMapper mapper = new RulesFileUpdateMapper();
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
}

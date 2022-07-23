package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesFileSimpleMapper {
  public String id;

  public String fileUrl;

  public String fileName;

  public String rulesId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public RulesFileSimpleMapper() {
  }

  public RulesFileSimpleMapper(String id, String fileUrl, String fileName, String rulesId,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.fileUrl=fileUrl;
    this.fileName=fileName;
    this.rulesId=rulesId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static RulesFileSimpleMapper buildMapper(RulesFile obj) {
    RulesFileSimpleMapper mapper = new RulesFileSimpleMapper();
    mapper.id=obj.getId();
    mapper.fileUrl=obj.getFileUrl();
    mapper.fileName=obj.getFileName();
    mapper.rulesId=obj.getRulesId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("fileUrl",this.fileUrl);
    map.put("fileName",this.fileName);
    map.put("rulesId",this.rulesId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(RulesFile obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("fileUrl", obj.getFileUrl());
    map.put("fileName", obj.getFileName());
    map.put("rulesId", obj.getRulesId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(RulesFile obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("fileUrl", JSONObject.toJSONString(obj.getFileUrl()));
    map.put("fileName", JSONObject.toJSONString(obj.getFileName()));
    map.put("rulesId", JSONObject.toJSONString(obj.getRulesId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public RulesFile buildEntity() {
    RulesFile obj = new RulesFile();
    obj.setId(this.id);
    obj.setFileUrl(this.fileUrl);
    obj.setFileName(this.fileName);
    obj.setRulesId(this.rulesId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static RulesFile parseEntity(Map<String, Object> map) {
    RulesFile obj = new RulesFile();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setFileUrl((String) map.get("fileUrl"));
    obj.setFileName((String) map.get("fileName"));
    obj.setRulesId((String) map.get("rulesId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static RulesFile parseSerialEntity(Map<String, String> map) {
    RulesFile obj = new RulesFile();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setFileUrl(JSONObject.parseObject(map.get("fileUrl"), String.class));
    obj.setFileName(JSONObject.parseObject(map.get("fileName"), String.class));
    obj.setRulesId(JSONObject.parseObject(map.get("rulesId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

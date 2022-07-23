package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.RulesFileDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class RulesFileData {
  public String id;

  public String fileUrl;

  public String fileName;

  public String rulesId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public RulesFileData() {
  }

  public RulesFileData(String id, String fileUrl, String fileName, String rulesId, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.fileUrl=fileUrl;
    this.fileName=fileName;
    this.rulesId=rulesId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static RulesFileData buildMapper(RulesFile obj) {
    RulesFileData mapper = new RulesFileData();
    mapper.id=obj.getId();
    mapper.fileUrl=obj.getFileUrl();
    mapper.fileName=obj.getFileName();
    mapper.rulesId=obj.getRulesId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(RulesFile obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("fileUrl", JSONObject.toJSONString(obj.getFileUrl()));
    map.put("fileName", JSONObject.toJSONString(obj.getFileName()));
    map.put("rulesId", JSONObject.toJSONString(obj.getRulesId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public RulesFile buildEntity() {
    RulesFile obj = new RulesFile();
    obj.setId(this.id);
    obj.setFileUrl(this.fileUrl);
    obj.setFileName(this.fileName);
    obj.setRulesId(this.rulesId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static RulesFile parseEntity(Map<String, Object> map) {
    RulesFile obj = new RulesFile();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setFileUrl((String) map.get("fileUrl"));
    obj.setFileName((String) map.get("fileName"));
    obj.setRulesId((String) map.get("rulesId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static RulesFile parseSerialEntity(Map<String, String> map) {
    RulesFile obj = new RulesFile();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setFileUrl(JSONObject.parseObject(map.get("fileUrl"), String.class));
    obj.setFileName(JSONObject.parseObject(map.get("fileName"), String.class));
    obj.setRulesId(JSONObject.parseObject(map.get("rulesId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static RulesFileDO convert(RulesFile from, RulesFileDO to) {
    if (from == null) return to;
    if (to == null) to = new RulesFileDO();
    to.setId(from.getId());
    to.setFileUrl(from.getFileUrl());
    to.setFileName(from.getFileName());
    to.setRulesId(from.getRulesId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static RulesFile convert(RulesFileDO from, RulesFile to) {
    if (from == null) return to;
    if (to == null) to = new RulesFile();
    to.setId(from.getId());
    to.setFileUrl(from.getFileUrl());
    to.setFileName(from.getFileName());
    to.setRulesId(from.getRulesId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

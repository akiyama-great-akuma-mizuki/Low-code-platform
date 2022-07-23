package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class KnowledgePostMapper {
  public String knowledgeName;

  public String upload;

  public String lookUp;

  public String describe;

  public String contentDetail;

  public String accessory;

  public Long uploadTime;

  public KnowledgePostMapper() {
  }

  public KnowledgePostMapper(String knowledgeName, String upload, String lookUp, String describe,
      String contentDetail, String accessory, Long uploadTime) {
    this.knowledgeName=knowledgeName;
    this.upload=upload;
    this.lookUp=lookUp;
    this.describe=describe;
    this.contentDetail=contentDetail;
    this.accessory=accessory;
    this.uploadTime=uploadTime;
  }

  public static KnowledgePostMapper buildMapper(Knowledge obj) {
    KnowledgePostMapper mapper = new KnowledgePostMapper();
    mapper.knowledgeName=obj.getKnowledgeName();
    mapper.upload=obj.getUpload();
    mapper.lookUp=obj.getLookUp();
    mapper.describe=obj.getDescribe();
    mapper.contentDetail=obj.getContentDetail();
    mapper.accessory=obj.getAccessory();
    mapper.uploadTime=obj.modifyTime(obj.getUploadTime());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("knowledgeName",this.knowledgeName);
    map.put("upload",this.upload);
    map.put("lookUp",this.lookUp);
    map.put("describe",this.describe);
    map.put("contentDetail",this.contentDetail);
    map.put("accessory",this.accessory);
    map.put("uploadTime",this.uploadTime);
    return map;
  }

  public static Map<String, Object> buildMap(Knowledge obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("knowledgeName", obj.getKnowledgeName());
    map.put("upload", obj.getUpload());
    map.put("lookUp", obj.getLookUp());
    map.put("describe", obj.getDescribe());
    map.put("contentDetail", obj.getContentDetail());
    map.put("accessory", obj.getAccessory());
    map.put("uploadTime", obj.modifyTime(obj.getUploadTime()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Knowledge obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("knowledgeName", JSONObject.toJSONString(obj.getKnowledgeName()));
    map.put("upload", JSONObject.toJSONString(obj.getUpload()));
    map.put("lookUp", JSONObject.toJSONString(obj.getLookUp()));
    map.put("describe", JSONObject.toJSONString(obj.getDescribe()));
    map.put("contentDetail", JSONObject.toJSONString(obj.getContentDetail()));
    map.put("accessory", JSONObject.toJSONString(obj.getAccessory()));
    map.put("uploadTime", JSONObject.toJSONString(obj.modifyTime(obj.getUploadTime())));
    return map;
  }

  public Knowledge buildEntity() {
    Knowledge obj = new Knowledge();
    obj.setKnowledgeName(this.knowledgeName);
    obj.setUpload(this.upload);
    obj.setLookUp(this.lookUp);
    obj.setDescribe(this.describe);
    obj.setContentDetail(this.contentDetail);
    obj.setAccessory(this.accessory);
    obj.setUploadTime(obj.recoverTime(this.uploadTime));
    return obj;
  }

  public static Knowledge parseEntity(Map<String, Object> map) {
    Knowledge obj = new Knowledge();
    if (map == null) return obj;
    obj.setKnowledgeName((String) map.get("knowledgeName"));
    obj.setUpload((String) map.get("upload"));
    obj.setLookUp((String) map.get("lookUp"));
    obj.setDescribe((String) map.get("describe"));
    obj.setContentDetail((String) map.get("contentDetail"));
    obj.setAccessory((String) map.get("accessory"));
    obj.setUploadTime(obj.recoverTime((Long) map.get("uploadTime")));
    return obj;
  }

  public static Knowledge parseSerialEntity(Map<String, String> map) {
    Knowledge obj = new Knowledge();
    if (map == null) return obj;
    obj.setKnowledgeName(JSONObject.parseObject(map.get("knowledgeName"), String.class));
    obj.setUpload(JSONObject.parseObject(map.get("upload"), String.class));
    obj.setLookUp(JSONObject.parseObject(map.get("lookUp"), String.class));
    obj.setDescribe(JSONObject.parseObject(map.get("describe"), String.class));
    obj.setContentDetail(JSONObject.parseObject(map.get("contentDetail"), String.class));
    obj.setAccessory(JSONObject.parseObject(map.get("accessory"), String.class));
    obj.setUploadTime(obj.recoverTime(JSONObject.parseObject(map.get("uploadTime"), Long.class)));
    return obj;
  }
}

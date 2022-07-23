package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class KnowledgeDetailMapper {
  public String id;

  public String knowledgeName;

  public String upload;

  public String lookUp;

  public String describe;

  public String contentDetail;

  public Integer browse;

  public String accessory;

  public Long uploadTime;

  public Long gmtUpdate;

  public Long gmtCreate;

  public KnowledgeDetailMapper() {
  }

  public KnowledgeDetailMapper(String id, String knowledgeName, String upload, String lookUp,
      String describe, String contentDetail, Integer browse, String accessory, Long uploadTime,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.knowledgeName=knowledgeName;
    this.upload=upload;
    this.lookUp=lookUp;
    this.describe=describe;
    this.contentDetail=contentDetail;
    this.browse=browse;
    this.accessory=accessory;
    this.uploadTime=uploadTime;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static KnowledgeDetailMapper buildMapper(Knowledge obj) {
    KnowledgeDetailMapper mapper = new KnowledgeDetailMapper();
    mapper.id=obj.getId();
    mapper.knowledgeName=obj.getKnowledgeName();
    mapper.upload=obj.getUpload();
    mapper.lookUp=obj.getLookUp();
    mapper.describe=obj.getDescribe();
    mapper.contentDetail=obj.getContentDetail();
    mapper.browse=obj.getBrowse();
    mapper.accessory=obj.getAccessory();
    mapper.uploadTime=obj.modifyTime(obj.getUploadTime());
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("knowledgeName",this.knowledgeName);
    map.put("upload",this.upload);
    map.put("lookUp",this.lookUp);
    map.put("describe",this.describe);
    map.put("contentDetail",this.contentDetail);
    map.put("browse",this.browse);
    map.put("accessory",this.accessory);
    map.put("uploadTime",this.uploadTime);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Knowledge obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("knowledgeName", obj.getKnowledgeName());
    map.put("upload", obj.getUpload());
    map.put("lookUp", obj.getLookUp());
    map.put("describe", obj.getDescribe());
    map.put("contentDetail", obj.getContentDetail());
    map.put("browse", obj.getBrowse());
    map.put("accessory", obj.getAccessory());
    map.put("uploadTime", obj.modifyTime(obj.getUploadTime()));
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Knowledge obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("knowledgeName", JSONObject.toJSONString(obj.getKnowledgeName()));
    map.put("upload", JSONObject.toJSONString(obj.getUpload()));
    map.put("lookUp", JSONObject.toJSONString(obj.getLookUp()));
    map.put("describe", JSONObject.toJSONString(obj.getDescribe()));
    map.put("contentDetail", JSONObject.toJSONString(obj.getContentDetail()));
    map.put("browse", JSONObject.toJSONString(obj.getBrowse()));
    map.put("accessory", JSONObject.toJSONString(obj.getAccessory()));
    map.put("uploadTime", JSONObject.toJSONString(obj.modifyTime(obj.getUploadTime())));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Knowledge buildEntity() {
    Knowledge obj = new Knowledge();
    obj.setId(this.id);
    obj.setKnowledgeName(this.knowledgeName);
    obj.setUpload(this.upload);
    obj.setLookUp(this.lookUp);
    obj.setDescribe(this.describe);
    obj.setContentDetail(this.contentDetail);
    obj.setBrowse(this.browse);
    obj.setAccessory(this.accessory);
    obj.setUploadTime(obj.recoverTime(this.uploadTime));
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Knowledge parseEntity(Map<String, Object> map) {
    Knowledge obj = new Knowledge();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setKnowledgeName((String) map.get("knowledgeName"));
    obj.setUpload((String) map.get("upload"));
    obj.setLookUp((String) map.get("lookUp"));
    obj.setDescribe((String) map.get("describe"));
    obj.setContentDetail((String) map.get("contentDetail"));
    obj.setBrowse((Integer) map.get("browse"));
    obj.setAccessory((String) map.get("accessory"));
    obj.setUploadTime(obj.recoverTime((Long) map.get("uploadTime")));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Knowledge parseSerialEntity(Map<String, String> map) {
    Knowledge obj = new Knowledge();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setKnowledgeName(JSONObject.parseObject(map.get("knowledgeName"), String.class));
    obj.setUpload(JSONObject.parseObject(map.get("upload"), String.class));
    obj.setLookUp(JSONObject.parseObject(map.get("lookUp"), String.class));
    obj.setDescribe(JSONObject.parseObject(map.get("describe"), String.class));
    obj.setContentDetail(JSONObject.parseObject(map.get("contentDetail"), String.class));
    obj.setBrowse(JSONObject.parseObject(map.get("browse"), Integer.class));
    obj.setAccessory(JSONObject.parseObject(map.get("accessory"), String.class));
    obj.setUploadTime(obj.recoverTime(JSONObject.parseObject(map.get("uploadTime"), Long.class)));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

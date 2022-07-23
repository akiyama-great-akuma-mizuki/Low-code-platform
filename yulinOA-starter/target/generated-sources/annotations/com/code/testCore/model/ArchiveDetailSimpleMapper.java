package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArchiveDetailSimpleMapper {
  public String id;

  public String attachmentUrl;

  public String attachmentName;

  public Long gmtUpdate;

  public Long gmtCreate;

  public ArchiveDetailSimpleMapper() {
  }

  public ArchiveDetailSimpleMapper(String id, String attachmentUrl, String attachmentName,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.attachmentUrl=attachmentUrl;
    this.attachmentName=attachmentName;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ArchiveDetailSimpleMapper buildMapper(ArchiveDetail obj) {
    ArchiveDetailSimpleMapper mapper = new ArchiveDetailSimpleMapper();
    mapper.id=obj.getId();
    mapper.attachmentUrl=obj.getAttachmentUrl();
    mapper.attachmentName=obj.getAttachmentName();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("attachmentUrl",this.attachmentUrl);
    map.put("attachmentName",this.attachmentName);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(ArchiveDetail obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("attachmentUrl", obj.getAttachmentUrl());
    map.put("attachmentName", obj.getAttachmentName());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(ArchiveDetail obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("attachmentUrl", JSONObject.toJSONString(obj.getAttachmentUrl()));
    map.put("attachmentName", JSONObject.toJSONString(obj.getAttachmentName()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public ArchiveDetail buildEntity() {
    ArchiveDetail obj = new ArchiveDetail();
    obj.setId(this.id);
    obj.setAttachmentUrl(this.attachmentUrl);
    obj.setAttachmentName(this.attachmentName);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static ArchiveDetail parseEntity(Map<String, Object> map) {
    ArchiveDetail obj = new ArchiveDetail();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setAttachmentUrl((String) map.get("attachmentUrl"));
    obj.setAttachmentName((String) map.get("attachmentName"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static ArchiveDetail parseSerialEntity(Map<String, String> map) {
    ArchiveDetail obj = new ArchiveDetail();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setAttachmentUrl(JSONObject.parseObject(map.get("attachmentUrl"), String.class));
    obj.setAttachmentName(JSONObject.parseObject(map.get("attachmentName"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

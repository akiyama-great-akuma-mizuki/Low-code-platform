package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArchiveDetailUpdateMapper {
  public String id;

  public String attachmentUrl;

  public String attachmentName;

  public ArchiveDetailUpdateMapper() {
  }

  public ArchiveDetailUpdateMapper(String id, String attachmentUrl, String attachmentName) {
    this.id=id;
    this.attachmentUrl=attachmentUrl;
    this.attachmentName=attachmentName;
  }

  public static ArchiveDetailUpdateMapper buildMapper(ArchiveDetail obj) {
    ArchiveDetailUpdateMapper mapper = new ArchiveDetailUpdateMapper();
    mapper.id=obj.getId();
    mapper.attachmentUrl=obj.getAttachmentUrl();
    mapper.attachmentName=obj.getAttachmentName();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("attachmentUrl",this.attachmentUrl);
    map.put("attachmentName",this.attachmentName);
    return map;
  }

  public static Map<String, Object> buildMap(ArchiveDetail obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("attachmentUrl", obj.getAttachmentUrl());
    map.put("attachmentName", obj.getAttachmentName());
    return map;
  }

  public static Map<String, String> buildSerialMap(ArchiveDetail obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("attachmentUrl", JSONObject.toJSONString(obj.getAttachmentUrl()));
    map.put("attachmentName", JSONObject.toJSONString(obj.getAttachmentName()));
    return map;
  }

  public ArchiveDetail buildEntity() {
    ArchiveDetail obj = new ArchiveDetail();
    obj.setId(this.id);
    obj.setAttachmentUrl(this.attachmentUrl);
    obj.setAttachmentName(this.attachmentName);
    return obj;
  }

  public static ArchiveDetail parseEntity(Map<String, Object> map) {
    ArchiveDetail obj = new ArchiveDetail();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setAttachmentUrl((String) map.get("attachmentUrl"));
    obj.setAttachmentName((String) map.get("attachmentName"));
    return obj;
  }

  public static ArchiveDetail parseSerialEntity(Map<String, String> map) {
    ArchiveDetail obj = new ArchiveDetail();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setAttachmentUrl(JSONObject.parseObject(map.get("attachmentUrl"), String.class));
    obj.setAttachmentName(JSONObject.parseObject(map.get("attachmentName"), String.class));
    return obj;
  }
}

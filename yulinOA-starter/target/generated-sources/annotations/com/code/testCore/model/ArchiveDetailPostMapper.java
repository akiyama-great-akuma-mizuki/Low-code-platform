package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArchiveDetailPostMapper {
  public String attachmentUrl;

  public String attachmentName;

  public ArchiveDetailPostMapper() {
  }

  public ArchiveDetailPostMapper(String attachmentUrl, String attachmentName) {
    this.attachmentUrl=attachmentUrl;
    this.attachmentName=attachmentName;
  }

  public static ArchiveDetailPostMapper buildMapper(ArchiveDetail obj) {
    ArchiveDetailPostMapper mapper = new ArchiveDetailPostMapper();
    mapper.attachmentUrl=obj.getAttachmentUrl();
    mapper.attachmentName=obj.getAttachmentName();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("attachmentUrl",this.attachmentUrl);
    map.put("attachmentName",this.attachmentName);
    return map;
  }

  public static Map<String, Object> buildMap(ArchiveDetail obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("attachmentUrl", obj.getAttachmentUrl());
    map.put("attachmentName", obj.getAttachmentName());
    return map;
  }

  public static Map<String, String> buildSerialMap(ArchiveDetail obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("attachmentUrl", JSONObject.toJSONString(obj.getAttachmentUrl()));
    map.put("attachmentName", JSONObject.toJSONString(obj.getAttachmentName()));
    return map;
  }

  public ArchiveDetail buildEntity() {
    ArchiveDetail obj = new ArchiveDetail();
    obj.setAttachmentUrl(this.attachmentUrl);
    obj.setAttachmentName(this.attachmentName);
    return obj;
  }

  public static ArchiveDetail parseEntity(Map<String, Object> map) {
    ArchiveDetail obj = new ArchiveDetail();
    if (map == null) return obj;
    obj.setAttachmentUrl((String) map.get("attachmentUrl"));
    obj.setAttachmentName((String) map.get("attachmentName"));
    return obj;
  }

  public static ArchiveDetail parseSerialEntity(Map<String, String> map) {
    ArchiveDetail obj = new ArchiveDetail();
    if (map == null) return obj;
    obj.setAttachmentUrl(JSONObject.parseObject(map.get("attachmentUrl"), String.class));
    obj.setAttachmentName(JSONObject.parseObject(map.get("attachmentName"), String.class));
    return obj;
  }
}

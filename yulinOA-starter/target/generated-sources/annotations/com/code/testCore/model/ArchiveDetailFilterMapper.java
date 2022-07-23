package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArchiveDetailFilterMapper {
  public String id;

  public String attachmentUrl;

  public String attachmentName;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public ArchiveDetailFilterMapper() {
  }

  public ArchiveDetailFilterMapper(String id, String attachmentUrl, String attachmentName) {
    this.id=id;
    this.attachmentUrl=attachmentUrl;
    this.attachmentName=attachmentName;
  }

  public static ArchiveDetailFilterMapper buildMapper(ArchiveDetail obj) {
    ArchiveDetailFilterMapper mapper = new ArchiveDetailFilterMapper();
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
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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

  public static Map<String, Object> buildMapExtra(ArchiveDetail obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(ArchiveDetail obj, Long page, Integer rows,
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

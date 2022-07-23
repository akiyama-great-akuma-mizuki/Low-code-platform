package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.ArchiveDetailTO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArchiveDetailDomain {
  public String id;

  public String attachmentUrl;

  public String attachmentName;

  public Date gmtUpdate;

  public Date gmtCreate;

  public ArchiveDetailDomain() {
  }

  public ArchiveDetailDomain(String id, String attachmentUrl, String attachmentName, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.attachmentUrl=attachmentUrl;
    this.attachmentName=attachmentName;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ArchiveDetailDomain buildMapper(ArchiveDetail obj) {
    ArchiveDetailDomain mapper = new ArchiveDetailDomain();
    mapper.id=obj.getId();
    mapper.attachmentUrl=obj.getAttachmentUrl();
    mapper.attachmentName=obj.getAttachmentName();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(ArchiveDetail obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("attachmentUrl", JSONObject.toJSONString(obj.getAttachmentUrl()));
    map.put("attachmentName", JSONObject.toJSONString(obj.getAttachmentName()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public ArchiveDetail buildEntity() {
    ArchiveDetail obj = new ArchiveDetail();
    obj.setId(this.id);
    obj.setAttachmentUrl(this.attachmentUrl);
    obj.setAttachmentName(this.attachmentName);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static ArchiveDetail parseEntity(Map<String, Object> map) {
    ArchiveDetail obj = new ArchiveDetail();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setAttachmentUrl((String) map.get("attachmentUrl"));
    obj.setAttachmentName((String) map.get("attachmentName"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static ArchiveDetail parseSerialEntity(Map<String, String> map) {
    ArchiveDetail obj = new ArchiveDetail();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setAttachmentUrl(JSONObject.parseObject(map.get("attachmentUrl"), String.class));
    obj.setAttachmentName(JSONObject.parseObject(map.get("attachmentName"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static ArchiveDetailTO convert(ArchiveDetail from, ArchiveDetailTO to) {
    if (from == null) return to;
    if (to == null) to = new ArchiveDetailTO();
    to.setId(from.getId());
    to.setAttachmentUrl(from.getAttachmentUrl());
    to.setAttachmentName(from.getAttachmentName());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static ArchiveDetail convert(ArchiveDetailTO from, ArchiveDetail to) {
    if (from == null) return to;
    if (to == null) to = new ArchiveDetail();
    to.setId(from.getId());
    to.setAttachmentUrl(from.getAttachmentUrl());
    to.setAttachmentName(from.getAttachmentName());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

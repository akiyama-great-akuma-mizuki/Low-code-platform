package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NoticeFilterMapper {
  public String id;

  public String noticeTitle;

  public String issuer;

  public String accessory;

  public String detail;

  public String noticeImg;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String noticeTitleLike = null;

  public String issuerLike = null;

  public String accessoryLike = null;

  public String detailLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public NoticeFilterMapper() {
  }

  public NoticeFilterMapper(String id, String noticeTitle, String issuer, String accessory,
      String detail, String noticeImg) {
    this.id=id;
    this.noticeTitle=noticeTitle;
    this.issuer=issuer;
    this.accessory=accessory;
    this.detail=detail;
    this.noticeImg=noticeImg;
  }

  public static NoticeFilterMapper buildMapper(Notice obj) {
    NoticeFilterMapper mapper = new NoticeFilterMapper();
    mapper.id=obj.getId();
    mapper.noticeTitle=obj.getNoticeTitle();
    mapper.issuer=obj.getIssuer();
    mapper.accessory=obj.getAccessory();
    mapper.detail=obj.getDetail();
    mapper.noticeImg=obj.getNoticeImg();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("noticeTitle",this.noticeTitle);
    map.put("issuer",this.issuer);
    map.put("accessory",this.accessory);
    map.put("detail",this.detail);
    map.put("noticeImg",this.noticeImg);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("noticeTitleLike",this.noticeTitleLike);
    map.put("issuerLike",this.issuerLike);
    map.put("accessoryLike",this.accessoryLike);
    map.put("detailLike",this.detailLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Notice obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("noticeTitle", obj.getNoticeTitle());
    map.put("issuer", obj.getIssuer());
    map.put("accessory", obj.getAccessory());
    map.put("detail", obj.getDetail());
    map.put("noticeImg", obj.getNoticeImg());
    return map;
  }

  public static Map<String, String> buildSerialMap(Notice obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("noticeTitle", JSONObject.toJSONString(obj.getNoticeTitle()));
    map.put("issuer", JSONObject.toJSONString(obj.getIssuer()));
    map.put("accessory", JSONObject.toJSONString(obj.getAccessory()));
    map.put("detail", JSONObject.toJSONString(obj.getDetail()));
    map.put("noticeImg", JSONObject.toJSONString(obj.getNoticeImg()));
    return map;
  }

  public Notice buildEntity() {
    Notice obj = new Notice();
    obj.setId(this.id);
    obj.setNoticeTitle(this.noticeTitle);
    obj.setIssuer(this.issuer);
    obj.setAccessory(this.accessory);
    obj.setDetail(this.detail);
    obj.setNoticeImg(this.noticeImg);
    return obj;
  }

  public static Notice parseEntity(Map<String, Object> map) {
    Notice obj = new Notice();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setNoticeTitle((String) map.get("noticeTitle"));
    obj.setIssuer((String) map.get("issuer"));
    obj.setAccessory((String) map.get("accessory"));
    obj.setDetail((String) map.get("detail"));
    obj.setNoticeImg((String) map.get("noticeImg"));
    return obj;
  }

  public static Notice parseSerialEntity(Map<String, String> map) {
    Notice obj = new Notice();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setNoticeTitle(JSONObject.parseObject(map.get("noticeTitle"), String.class));
    obj.setIssuer(JSONObject.parseObject(map.get("issuer"), String.class));
    obj.setAccessory(JSONObject.parseObject(map.get("accessory"), String.class));
    obj.setDetail(JSONObject.parseObject(map.get("detail"), String.class));
    obj.setNoticeImg(JSONObject.parseObject(map.get("noticeImg"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Notice obj, Long page, Integer rows,
      List<String> orderBy, String noticeTitleLike, String issuerLike, String accessoryLike,
      String detailLike, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("noticeTitleLike", noticeTitleLike);
    map.put("issuerLike", issuerLike);
    map.put("accessoryLike", accessoryLike);
    map.put("detailLike", detailLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Notice obj, Long page, Integer rows,
      List<String> orderBy, String noticeTitleLike, String issuerLike, String accessoryLike,
      String detailLike, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("noticeTitleLike", JSONObject.toJSONString(noticeTitleLike));
    map.put("issuerLike", JSONObject.toJSONString(issuerLike));
    map.put("accessoryLike", JSONObject.toJSONString(accessoryLike));
    map.put("detailLike", JSONObject.toJSONString(detailLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class NoticeDefaultMapper {
  public String id;

  public String noticeTitle;

  public String issuer;

  public Date issueTime;

  public String accessory;

  public String detail;

  public String noticeImg;

  public Date gmtUpdate;

  public Date gmtCreate;

  public NoticeDefaultMapper() {
  }

  public NoticeDefaultMapper(String id, String noticeTitle, String issuer, Date issueTime,
      String accessory, String detail, String noticeImg, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.noticeTitle=noticeTitle;
    this.issuer=issuer;
    this.issueTime=issueTime;
    this.accessory=accessory;
    this.detail=detail;
    this.noticeImg=noticeImg;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static NoticeDefaultMapper buildMapper(Notice obj) {
    NoticeDefaultMapper mapper = new NoticeDefaultMapper();
    mapper.id=obj.getId();
    mapper.noticeTitle=obj.getNoticeTitle();
    mapper.issuer=obj.getIssuer();
    mapper.issueTime=obj.getIssueTime();
    mapper.accessory=obj.getAccessory();
    mapper.detail=obj.getDetail();
    mapper.noticeImg=obj.getNoticeImg();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("noticeTitle",this.noticeTitle);
    map.put("issuer",this.issuer);
    map.put("issueTime",this.issueTime);
    map.put("accessory",this.accessory);
    map.put("detail",this.detail);
    map.put("noticeImg",this.noticeImg);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Notice obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("noticeTitle", obj.getNoticeTitle());
    map.put("issuer", obj.getIssuer());
    map.put("issueTime", obj.getIssueTime());
    map.put("accessory", obj.getAccessory());
    map.put("detail", obj.getDetail());
    map.put("noticeImg", obj.getNoticeImg());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(Notice obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("noticeTitle", JSONObject.toJSONString(obj.getNoticeTitle()));
    map.put("issuer", JSONObject.toJSONString(obj.getIssuer()));
    map.put("issueTime", JSONObject.toJSONString(obj.getIssueTime()));
    map.put("accessory", JSONObject.toJSONString(obj.getAccessory()));
    map.put("detail", JSONObject.toJSONString(obj.getDetail()));
    map.put("noticeImg", JSONObject.toJSONString(obj.getNoticeImg()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public Notice buildEntity() {
    Notice obj = new Notice();
    obj.setId(this.id);
    obj.setNoticeTitle(this.noticeTitle);
    obj.setIssuer(this.issuer);
    obj.setIssueTime(this.issueTime);
    obj.setAccessory(this.accessory);
    obj.setDetail(this.detail);
    obj.setNoticeImg(this.noticeImg);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static Notice parseEntity(Map<String, Object> map) {
    Notice obj = new Notice();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setNoticeTitle((String) map.get("noticeTitle"));
    obj.setIssuer((String) map.get("issuer"));
    obj.setIssueTime((Date) map.get("issueTime"));
    obj.setAccessory((String) map.get("accessory"));
    obj.setDetail((String) map.get("detail"));
    obj.setNoticeImg((String) map.get("noticeImg"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static Notice parseSerialEntity(Map<String, String> map) {
    Notice obj = new Notice();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setNoticeTitle(JSONObject.parseObject(map.get("noticeTitle"), String.class));
    obj.setIssuer(JSONObject.parseObject(map.get("issuer"), String.class));
    obj.setIssueTime(JSONObject.parseObject(map.get("issueTime"), Date.class));
    obj.setAccessory(JSONObject.parseObject(map.get("accessory"), String.class));
    obj.setDetail(JSONObject.parseObject(map.get("detail"), String.class));
    obj.setNoticeImg(JSONObject.parseObject(map.get("noticeImg"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.NoticeEnterpriseDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class NoticeEnterpriseData {
  public String id;

  public String noticeId;

  public String enterpriseId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public NoticeEnterpriseData() {
  }

  public NoticeEnterpriseData(String id, String noticeId, String enterpriseId, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.noticeId=noticeId;
    this.enterpriseId=enterpriseId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static NoticeEnterpriseData buildMapper(NoticeEnterprise obj) {
    NoticeEnterpriseData mapper = new NoticeEnterpriseData();
    mapper.id=obj.getId();
    mapper.noticeId=obj.getNoticeId();
    mapper.enterpriseId=obj.getEnterpriseId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("noticeId",this.noticeId);
    map.put("enterpriseId",this.enterpriseId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(NoticeEnterprise obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("noticeId", obj.getNoticeId());
    map.put("enterpriseId", obj.getEnterpriseId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(NoticeEnterprise obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("noticeId", JSONObject.toJSONString(obj.getNoticeId()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public NoticeEnterprise buildEntity() {
    NoticeEnterprise obj = new NoticeEnterprise();
    obj.setId(this.id);
    obj.setNoticeId(this.noticeId);
    obj.setEnterpriseId(this.enterpriseId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static NoticeEnterprise parseEntity(Map<String, Object> map) {
    NoticeEnterprise obj = new NoticeEnterprise();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setNoticeId((String) map.get("noticeId"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static NoticeEnterprise parseSerialEntity(Map<String, String> map) {
    NoticeEnterprise obj = new NoticeEnterprise();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setNoticeId(JSONObject.parseObject(map.get("noticeId"), String.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static NoticeEnterpriseDO convert(NoticeEnterprise from, NoticeEnterpriseDO to) {
    if (from == null) return to;
    if (to == null) to = new NoticeEnterpriseDO();
    to.setId(from.getId());
    to.setNoticeId(from.getNoticeId());
    to.setEnterpriseId(from.getEnterpriseId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static NoticeEnterprise convert(NoticeEnterpriseDO from, NoticeEnterprise to) {
    if (from == null) return to;
    if (to == null) to = new NoticeEnterprise();
    to.setId(from.getId());
    to.setNoticeId(from.getNoticeId());
    to.setEnterpriseId(from.getEnterpriseId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

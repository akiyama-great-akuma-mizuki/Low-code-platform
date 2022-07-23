package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class NoticeEnterpriseUpdateMapper {
  public String id;

  public String noticeId;

  public String enterpriseId;

  public NoticeEnterpriseUpdateMapper() {
  }

  public NoticeEnterpriseUpdateMapper(String id, String noticeId, String enterpriseId) {
    this.id=id;
    this.noticeId=noticeId;
    this.enterpriseId=enterpriseId;
  }

  public static NoticeEnterpriseUpdateMapper buildMapper(NoticeEnterprise obj) {
    NoticeEnterpriseUpdateMapper mapper = new NoticeEnterpriseUpdateMapper();
    mapper.id=obj.getId();
    mapper.noticeId=obj.getNoticeId();
    mapper.enterpriseId=obj.getEnterpriseId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("noticeId",this.noticeId);
    map.put("enterpriseId",this.enterpriseId);
    return map;
  }

  public static Map<String, Object> buildMap(NoticeEnterprise obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("noticeId", obj.getNoticeId());
    map.put("enterpriseId", obj.getEnterpriseId());
    return map;
  }

  public static Map<String, String> buildSerialMap(NoticeEnterprise obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("noticeId", JSONObject.toJSONString(obj.getNoticeId()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    return map;
  }

  public NoticeEnterprise buildEntity() {
    NoticeEnterprise obj = new NoticeEnterprise();
    obj.setId(this.id);
    obj.setNoticeId(this.noticeId);
    obj.setEnterpriseId(this.enterpriseId);
    return obj;
  }

  public static NoticeEnterprise parseEntity(Map<String, Object> map) {
    NoticeEnterprise obj = new NoticeEnterprise();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setNoticeId((String) map.get("noticeId"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    return obj;
  }

  public static NoticeEnterprise parseSerialEntity(Map<String, String> map) {
    NoticeEnterprise obj = new NoticeEnterprise();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setNoticeId(JSONObject.parseObject(map.get("noticeId"), String.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    return obj;
  }
}

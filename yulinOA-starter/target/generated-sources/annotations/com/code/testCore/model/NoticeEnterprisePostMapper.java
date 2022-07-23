package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class NoticeEnterprisePostMapper {
  public String noticeId;

  public String enterpriseId;

  public NoticeEnterprisePostMapper() {
  }

  public NoticeEnterprisePostMapper(String noticeId, String enterpriseId) {
    this.noticeId=noticeId;
    this.enterpriseId=enterpriseId;
  }

  public static NoticeEnterprisePostMapper buildMapper(NoticeEnterprise obj) {
    NoticeEnterprisePostMapper mapper = new NoticeEnterprisePostMapper();
    mapper.noticeId=obj.getNoticeId();
    mapper.enterpriseId=obj.getEnterpriseId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("noticeId",this.noticeId);
    map.put("enterpriseId",this.enterpriseId);
    return map;
  }

  public static Map<String, Object> buildMap(NoticeEnterprise obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("noticeId", obj.getNoticeId());
    map.put("enterpriseId", obj.getEnterpriseId());
    return map;
  }

  public static Map<String, String> buildSerialMap(NoticeEnterprise obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("noticeId", JSONObject.toJSONString(obj.getNoticeId()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    return map;
  }

  public NoticeEnterprise buildEntity() {
    NoticeEnterprise obj = new NoticeEnterprise();
    obj.setNoticeId(this.noticeId);
    obj.setEnterpriseId(this.enterpriseId);
    return obj;
  }

  public static NoticeEnterprise parseEntity(Map<String, Object> map) {
    NoticeEnterprise obj = new NoticeEnterprise();
    if (map == null) return obj;
    obj.setNoticeId((String) map.get("noticeId"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    return obj;
  }

  public static NoticeEnterprise parseSerialEntity(Map<String, String> map) {
    NoticeEnterprise obj = new NoticeEnterprise();
    if (map == null) return obj;
    obj.setNoticeId(JSONObject.parseObject(map.get("noticeId"), String.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    return obj;
  }
}

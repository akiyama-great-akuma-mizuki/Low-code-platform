package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NoticeEnterpriseFilterMapper {
  public String id;

  public String noticeId;

  public String enterpriseId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public NoticeEnterpriseFilterMapper() {
  }

  public NoticeEnterpriseFilterMapper(String id, String noticeId, String enterpriseId) {
    this.id=id;
    this.noticeId=noticeId;
    this.enterpriseId=enterpriseId;
  }

  public static NoticeEnterpriseFilterMapper buildMapper(NoticeEnterprise obj) {
    NoticeEnterpriseFilterMapper mapper = new NoticeEnterpriseFilterMapper();
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
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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

  public static Map<String, Object> buildMapExtra(NoticeEnterprise obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(NoticeEnterprise obj, Long page,
      Integer rows, List<String> orderBy, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
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

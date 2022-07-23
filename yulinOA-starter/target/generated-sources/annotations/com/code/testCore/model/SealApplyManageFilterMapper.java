package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SealApplyManageFilterMapper {
  public String id;

  public String applyUserId;

  public String sealId;

  public String applyFileUrl;

  public Integer limit;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public List<String> applyUserIdIn = null;

  public Long endTimeFrom = null;

  public Long endTimeTo = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public SealApplyManageFilterMapper() {
  }

  public SealApplyManageFilterMapper(String id, String applyUserId, String sealId,
      String applyFileUrl, Integer limit) {
    this.id=id;
    this.applyUserId=applyUserId;
    this.sealId=sealId;
    this.applyFileUrl=applyFileUrl;
    this.limit=limit;
  }

  public static SealApplyManageFilterMapper buildMapper(SealApplyManage obj) {
    SealApplyManageFilterMapper mapper = new SealApplyManageFilterMapper();
    mapper.id=obj.getId();
    mapper.applyUserId=obj.getApplyUserId();
    mapper.sealId=obj.getSealId();
    mapper.applyFileUrl=obj.getApplyFileUrl();
    mapper.limit=obj.getLimit();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("applyUserId",this.applyUserId);
    map.put("sealId",this.sealId);
    map.put("applyFileUrl",this.applyFileUrl);
    map.put("limit",this.limit);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("applyUserIdIn",this.applyUserIdIn);
    map.put("endTimeFrom",this.endTimeFrom);
    map.put("endTimeTo",this.endTimeTo);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(SealApplyManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("applyUserId", obj.getApplyUserId());
    map.put("sealId", obj.getSealId());
    map.put("applyFileUrl", obj.getApplyFileUrl());
    map.put("limit", obj.getLimit());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealApplyManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("applyUserId", JSONObject.toJSONString(obj.getApplyUserId()));
    map.put("sealId", JSONObject.toJSONString(obj.getSealId()));
    map.put("applyFileUrl", JSONObject.toJSONString(obj.getApplyFileUrl()));
    map.put("limit", JSONObject.toJSONString(obj.getLimit()));
    return map;
  }

  public SealApplyManage buildEntity() {
    SealApplyManage obj = new SealApplyManage();
    obj.setId(this.id);
    obj.setApplyUserId(this.applyUserId);
    obj.setSealId(this.sealId);
    obj.setApplyFileUrl(this.applyFileUrl);
    obj.setLimit(this.limit);
    return obj;
  }

  public static SealApplyManage parseEntity(Map<String, Object> map) {
    SealApplyManage obj = new SealApplyManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setApplyUserId((String) map.get("applyUserId"));
    obj.setSealId((String) map.get("sealId"));
    obj.setApplyFileUrl((String) map.get("applyFileUrl"));
    obj.setLimit((Integer) map.get("limit"));
    return obj;
  }

  public static SealApplyManage parseSerialEntity(Map<String, String> map) {
    SealApplyManage obj = new SealApplyManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setApplyUserId(JSONObject.parseObject(map.get("applyUserId"), String.class));
    obj.setSealId(JSONObject.parseObject(map.get("sealId"), String.class));
    obj.setApplyFileUrl(JSONObject.parseObject(map.get("applyFileUrl"), String.class));
    obj.setLimit(JSONObject.parseObject(map.get("limit"), Integer.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(SealApplyManage obj, Long page, Integer rows,
      List<String> orderBy, List<String> applyUserIdIn, Long endTimeFrom, Long endTimeTo,
      Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("applyUserIdIn", applyUserIdIn);
    map.put("endTimeFrom", endTimeFrom);
    map.put("endTimeTo", endTimeTo);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(SealApplyManage obj, Long page,
      Integer rows, List<String> orderBy, List<String> applyUserIdIn, Long endTimeFrom,
      Long endTimeTo, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("applyUserIdIn", JSONObject.toJSONString(applyUserIdIn));
    map.put("endTimeFrom", JSONObject.toJSONString(endTimeFrom));
    map.put("endTimeTo", JSONObject.toJSONString(endTimeTo));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

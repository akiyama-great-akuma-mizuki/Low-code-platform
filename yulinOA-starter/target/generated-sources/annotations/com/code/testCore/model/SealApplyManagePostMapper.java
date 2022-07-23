package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealApplyManagePostMapper {
  public String applyUserId;

  public String sealId;

  public Long endTime;

  public String applyFileUrl;

  public Integer limit;

  public SealApplyManagePostMapper() {
  }

  public SealApplyManagePostMapper(String applyUserId, String sealId, Long endTime,
      String applyFileUrl, Integer limit) {
    this.applyUserId=applyUserId;
    this.sealId=sealId;
    this.endTime=endTime;
    this.applyFileUrl=applyFileUrl;
    this.limit=limit;
  }

  public static SealApplyManagePostMapper buildMapper(SealApplyManage obj) {
    SealApplyManagePostMapper mapper = new SealApplyManagePostMapper();
    mapper.applyUserId=obj.getApplyUserId();
    mapper.sealId=obj.getSealId();
    mapper.endTime=obj.modifyTime(obj.getEndTime());
    mapper.applyFileUrl=obj.getApplyFileUrl();
    mapper.limit=obj.getLimit();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("applyUserId",this.applyUserId);
    map.put("sealId",this.sealId);
    map.put("endTime",this.endTime);
    map.put("applyFileUrl",this.applyFileUrl);
    map.put("limit",this.limit);
    return map;
  }

  public static Map<String, Object> buildMap(SealApplyManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("applyUserId", obj.getApplyUserId());
    map.put("sealId", obj.getSealId());
    map.put("endTime", obj.modifyTime(obj.getEndTime()));
    map.put("applyFileUrl", obj.getApplyFileUrl());
    map.put("limit", obj.getLimit());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealApplyManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("applyUserId", JSONObject.toJSONString(obj.getApplyUserId()));
    map.put("sealId", JSONObject.toJSONString(obj.getSealId()));
    map.put("endTime", JSONObject.toJSONString(obj.modifyTime(obj.getEndTime())));
    map.put("applyFileUrl", JSONObject.toJSONString(obj.getApplyFileUrl()));
    map.put("limit", JSONObject.toJSONString(obj.getLimit()));
    return map;
  }

  public SealApplyManage buildEntity() {
    SealApplyManage obj = new SealApplyManage();
    obj.setApplyUserId(this.applyUserId);
    obj.setSealId(this.sealId);
    obj.setEndTime(obj.recoverTime(this.endTime));
    obj.setApplyFileUrl(this.applyFileUrl);
    obj.setLimit(this.limit);
    return obj;
  }

  public static SealApplyManage parseEntity(Map<String, Object> map) {
    SealApplyManage obj = new SealApplyManage();
    if (map == null) return obj;
    obj.setApplyUserId((String) map.get("applyUserId"));
    obj.setSealId((String) map.get("sealId"));
    obj.setEndTime(obj.recoverTime((Long) map.get("endTime")));
    obj.setApplyFileUrl((String) map.get("applyFileUrl"));
    obj.setLimit((Integer) map.get("limit"));
    return obj;
  }

  public static SealApplyManage parseSerialEntity(Map<String, String> map) {
    SealApplyManage obj = new SealApplyManage();
    if (map == null) return obj;
    obj.setApplyUserId(JSONObject.parseObject(map.get("applyUserId"), String.class));
    obj.setSealId(JSONObject.parseObject(map.get("sealId"), String.class));
    obj.setEndTime(obj.recoverTime(JSONObject.parseObject(map.get("endTime"), Long.class)));
    obj.setApplyFileUrl(JSONObject.parseObject(map.get("applyFileUrl"), String.class));
    obj.setLimit(JSONObject.parseObject(map.get("limit"), Integer.class));
    return obj;
  }
}

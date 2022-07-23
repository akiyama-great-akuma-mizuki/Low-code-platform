package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealApplyManageDetailMapper {
  public String id;

  public String applyUserId;

  public String sealId;

  public Long endTime;

  public String applyFileUrl;

  public Integer limit;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map sealManage = null;

  public Map user = null;

  public SealApplyManageDetailMapper() {
  }

  public SealApplyManageDetailMapper(String id, String applyUserId, String sealId, Long endTime,
      String applyFileUrl, Integer limit, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.applyUserId=applyUserId;
    this.sealId=sealId;
    this.endTime=endTime;
    this.applyFileUrl=applyFileUrl;
    this.limit=limit;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static SealApplyManageDetailMapper buildMapper(SealApplyManage obj) {
    SealApplyManageDetailMapper mapper = new SealApplyManageDetailMapper();
    mapper.id=obj.getId();
    mapper.applyUserId=obj.getApplyUserId();
    mapper.sealId=obj.getSealId();
    mapper.endTime=obj.modifyTime(obj.getEndTime());
    mapper.applyFileUrl=obj.getApplyFileUrl();
    mapper.limit=obj.getLimit();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("applyUserId",this.applyUserId);
    map.put("sealId",this.sealId);
    map.put("endTime",this.endTime);
    map.put("applyFileUrl",this.applyFileUrl);
    map.put("limit",this.limit);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("sealManage",this.sealManage);
    map.put("user",this.user);
    return map;
  }

  public static Map<String, Object> buildMap(SealApplyManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("applyUserId", obj.getApplyUserId());
    map.put("sealId", obj.getSealId());
    map.put("endTime", obj.modifyTime(obj.getEndTime()));
    map.put("applyFileUrl", obj.getApplyFileUrl());
    map.put("limit", obj.getLimit());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(SealApplyManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("applyUserId", JSONObject.toJSONString(obj.getApplyUserId()));
    map.put("sealId", JSONObject.toJSONString(obj.getSealId()));
    map.put("endTime", JSONObject.toJSONString(obj.modifyTime(obj.getEndTime())));
    map.put("applyFileUrl", JSONObject.toJSONString(obj.getApplyFileUrl()));
    map.put("limit", JSONObject.toJSONString(obj.getLimit()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public SealApplyManage buildEntity() {
    SealApplyManage obj = new SealApplyManage();
    obj.setId(this.id);
    obj.setApplyUserId(this.applyUserId);
    obj.setSealId(this.sealId);
    obj.setEndTime(obj.recoverTime(this.endTime));
    obj.setApplyFileUrl(this.applyFileUrl);
    obj.setLimit(this.limit);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static SealApplyManage parseEntity(Map<String, Object> map) {
    SealApplyManage obj = new SealApplyManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setApplyUserId((String) map.get("applyUserId"));
    obj.setSealId((String) map.get("sealId"));
    obj.setEndTime(obj.recoverTime((Long) map.get("endTime")));
    obj.setApplyFileUrl((String) map.get("applyFileUrl"));
    obj.setLimit((Integer) map.get("limit"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static SealApplyManage parseSerialEntity(Map<String, String> map) {
    SealApplyManage obj = new SealApplyManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setApplyUserId(JSONObject.parseObject(map.get("applyUserId"), String.class));
    obj.setSealId(JSONObject.parseObject(map.get("sealId"), String.class));
    obj.setEndTime(obj.recoverTime(JSONObject.parseObject(map.get("endTime"), Long.class)));
    obj.setApplyFileUrl(JSONObject.parseObject(map.get("applyFileUrl"), String.class));
    obj.setLimit(JSONObject.parseObject(map.get("limit"), Integer.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(SealApplyManage obj,
      Map<String, Object> sealManage, Map<String, Object> user) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("sealManage", sealManage);
    map.put("user", user);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(SealApplyManage obj,
      Map<String, Object> sealManage, Map<String, Object> user) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("sealManage", JSONObject.toJSONString(sealManage));
    map.put("user", JSONObject.toJSONString(user));
    return map;
  }
}

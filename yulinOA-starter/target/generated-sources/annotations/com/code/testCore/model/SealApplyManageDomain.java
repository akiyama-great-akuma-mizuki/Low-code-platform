package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.SealApplyManageTO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealApplyManageDomain {
  public String id;

  public String applyUserId;

  public String sealId;

  public Date endTime;

  public String applyFileUrl;

  public Integer limit;

  public Date gmtUpdate;

  public Date gmtCreate;

  public SealApplyManageDomain() {
  }

  public SealApplyManageDomain(String id, String applyUserId, String sealId, Date endTime,
      String applyFileUrl, Integer limit, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.applyUserId=applyUserId;
    this.sealId=sealId;
    this.endTime=endTime;
    this.applyFileUrl=applyFileUrl;
    this.limit=limit;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static SealApplyManageDomain buildMapper(SealApplyManage obj) {
    SealApplyManageDomain mapper = new SealApplyManageDomain();
    mapper.id=obj.getId();
    mapper.applyUserId=obj.getApplyUserId();
    mapper.sealId=obj.getSealId();
    mapper.endTime=obj.getEndTime();
    mapper.applyFileUrl=obj.getApplyFileUrl();
    mapper.limit=obj.getLimit();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    return map;
  }

  public static Map<String, Object> buildMap(SealApplyManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("applyUserId", obj.getApplyUserId());
    map.put("sealId", obj.getSealId());
    map.put("endTime", obj.getEndTime());
    map.put("applyFileUrl", obj.getApplyFileUrl());
    map.put("limit", obj.getLimit());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealApplyManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("applyUserId", JSONObject.toJSONString(obj.getApplyUserId()));
    map.put("sealId", JSONObject.toJSONString(obj.getSealId()));
    map.put("endTime", JSONObject.toJSONString(obj.getEndTime()));
    map.put("applyFileUrl", JSONObject.toJSONString(obj.getApplyFileUrl()));
    map.put("limit", JSONObject.toJSONString(obj.getLimit()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public SealApplyManage buildEntity() {
    SealApplyManage obj = new SealApplyManage();
    obj.setId(this.id);
    obj.setApplyUserId(this.applyUserId);
    obj.setSealId(this.sealId);
    obj.setEndTime(this.endTime);
    obj.setApplyFileUrl(this.applyFileUrl);
    obj.setLimit(this.limit);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static SealApplyManage parseEntity(Map<String, Object> map) {
    SealApplyManage obj = new SealApplyManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setApplyUserId((String) map.get("applyUserId"));
    obj.setSealId((String) map.get("sealId"));
    obj.setEndTime((Date) map.get("endTime"));
    obj.setApplyFileUrl((String) map.get("applyFileUrl"));
    obj.setLimit((Integer) map.get("limit"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static SealApplyManage parseSerialEntity(Map<String, String> map) {
    SealApplyManage obj = new SealApplyManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setApplyUserId(JSONObject.parseObject(map.get("applyUserId"), String.class));
    obj.setSealId(JSONObject.parseObject(map.get("sealId"), String.class));
    obj.setEndTime(JSONObject.parseObject(map.get("endTime"), Date.class));
    obj.setApplyFileUrl(JSONObject.parseObject(map.get("applyFileUrl"), String.class));
    obj.setLimit(JSONObject.parseObject(map.get("limit"), Integer.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static SealApplyManageTO convert(SealApplyManage from, SealApplyManageTO to) {
    if (from == null) return to;
    if (to == null) to = new SealApplyManageTO();
    to.setId(from.getId());
    to.setApplyUserId(from.getApplyUserId());
    to.setSealId(from.getSealId());
    to.setEndTime(from.getEndTime());
    to.setApplyFileUrl(from.getApplyFileUrl());
    to.setLimit(from.getLimit());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static SealApplyManage convert(SealApplyManageTO from, SealApplyManage to) {
    if (from == null) return to;
    if (to == null) to = new SealApplyManage();
    to.setId(from.getId());
    to.setApplyUserId(from.getApplyUserId());
    to.setSealId(from.getSealId());
    to.setEndTime(from.getEndTime());
    to.setApplyFileUrl(from.getApplyFileUrl());
    to.setLimit(from.getLimit());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

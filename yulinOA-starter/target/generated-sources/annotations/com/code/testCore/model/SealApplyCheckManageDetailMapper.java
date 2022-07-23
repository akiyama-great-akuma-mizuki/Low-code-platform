package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealApplyCheckManageDetailMapper {
  public String id;

  public String sealApplyId;

  public String checkPersonId;

  public Integer checkStatus;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map sealApplyManage = null;

  public Map user = null;

  public SealApplyCheckManageDetailMapper() {
  }

  public SealApplyCheckManageDetailMapper(String id, String sealApplyId, String checkPersonId,
      Integer checkStatus, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.sealApplyId=sealApplyId;
    this.checkPersonId=checkPersonId;
    this.checkStatus=checkStatus;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static SealApplyCheckManageDetailMapper buildMapper(SealApplyCheckManage obj) {
    SealApplyCheckManageDetailMapper mapper = new SealApplyCheckManageDetailMapper();
    mapper.id=obj.getId();
    mapper.sealApplyId=obj.getSealApplyId();
    mapper.checkPersonId=obj.getCheckPersonId();
    mapper.checkStatus=obj.getCheckStatus();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("sealApplyId",this.sealApplyId);
    map.put("checkPersonId",this.checkPersonId);
    map.put("checkStatus",this.checkStatus);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("sealApplyManage",this.sealApplyManage);
    map.put("user",this.user);
    return map;
  }

  public static Map<String, Object> buildMap(SealApplyCheckManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("sealApplyId", obj.getSealApplyId());
    map.put("checkPersonId", obj.getCheckPersonId());
    map.put("checkStatus", obj.getCheckStatus());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(SealApplyCheckManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("sealApplyId", JSONObject.toJSONString(obj.getSealApplyId()));
    map.put("checkPersonId", JSONObject.toJSONString(obj.getCheckPersonId()));
    map.put("checkStatus", JSONObject.toJSONString(obj.getCheckStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public SealApplyCheckManage buildEntity() {
    SealApplyCheckManage obj = new SealApplyCheckManage();
    obj.setId(this.id);
    obj.setSealApplyId(this.sealApplyId);
    obj.setCheckPersonId(this.checkPersonId);
    obj.setCheckStatus(this.checkStatus);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static SealApplyCheckManage parseEntity(Map<String, Object> map) {
    SealApplyCheckManage obj = new SealApplyCheckManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setSealApplyId((String) map.get("sealApplyId"));
    obj.setCheckPersonId((String) map.get("checkPersonId"));
    obj.setCheckStatus((Integer) map.get("checkStatus"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static SealApplyCheckManage parseSerialEntity(Map<String, String> map) {
    SealApplyCheckManage obj = new SealApplyCheckManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setSealApplyId(JSONObject.parseObject(map.get("sealApplyId"), String.class));
    obj.setCheckPersonId(JSONObject.parseObject(map.get("checkPersonId"), String.class));
    obj.setCheckStatus(JSONObject.parseObject(map.get("checkStatus"), Integer.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(SealApplyCheckManage obj,
      Map<String, Object> sealApplyManage, Map<String, Object> user) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("sealApplyManage", sealApplyManage);
    map.put("user", user);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(SealApplyCheckManage obj,
      Map<String, Object> sealApplyManage, Map<String, Object> user) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("sealApplyManage", JSONObject.toJSONString(sealApplyManage));
    map.put("user", JSONObject.toJSONString(user));
    return map;
  }
}

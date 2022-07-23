package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealApplyCheckManagePostMapper {
  public String sealApplyId;

  public String checkPersonId;

  public Integer checkStatus;

  public SealApplyCheckManagePostMapper() {
  }

  public SealApplyCheckManagePostMapper(String sealApplyId, String checkPersonId,
      Integer checkStatus) {
    this.sealApplyId=sealApplyId;
    this.checkPersonId=checkPersonId;
    this.checkStatus=checkStatus;
  }

  public static SealApplyCheckManagePostMapper buildMapper(SealApplyCheckManage obj) {
    SealApplyCheckManagePostMapper mapper = new SealApplyCheckManagePostMapper();
    mapper.sealApplyId=obj.getSealApplyId();
    mapper.checkPersonId=obj.getCheckPersonId();
    mapper.checkStatus=obj.getCheckStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("sealApplyId",this.sealApplyId);
    map.put("checkPersonId",this.checkPersonId);
    map.put("checkStatus",this.checkStatus);
    return map;
  }

  public static Map<String, Object> buildMap(SealApplyCheckManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("sealApplyId", obj.getSealApplyId());
    map.put("checkPersonId", obj.getCheckPersonId());
    map.put("checkStatus", obj.getCheckStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealApplyCheckManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("sealApplyId", JSONObject.toJSONString(obj.getSealApplyId()));
    map.put("checkPersonId", JSONObject.toJSONString(obj.getCheckPersonId()));
    map.put("checkStatus", JSONObject.toJSONString(obj.getCheckStatus()));
    return map;
  }

  public SealApplyCheckManage buildEntity() {
    SealApplyCheckManage obj = new SealApplyCheckManage();
    obj.setSealApplyId(this.sealApplyId);
    obj.setCheckPersonId(this.checkPersonId);
    obj.setCheckStatus(this.checkStatus);
    return obj;
  }

  public static SealApplyCheckManage parseEntity(Map<String, Object> map) {
    SealApplyCheckManage obj = new SealApplyCheckManage();
    if (map == null) return obj;
    obj.setSealApplyId((String) map.get("sealApplyId"));
    obj.setCheckPersonId((String) map.get("checkPersonId"));
    obj.setCheckStatus((Integer) map.get("checkStatus"));
    return obj;
  }

  public static SealApplyCheckManage parseSerialEntity(Map<String, String> map) {
    SealApplyCheckManage obj = new SealApplyCheckManage();
    if (map == null) return obj;
    obj.setSealApplyId(JSONObject.parseObject(map.get("sealApplyId"), String.class));
    obj.setCheckPersonId(JSONObject.parseObject(map.get("checkPersonId"), String.class));
    obj.setCheckStatus(JSONObject.parseObject(map.get("checkStatus"), Integer.class));
    return obj;
  }
}

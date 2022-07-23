package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SealApplyCheckManageFilterMapper {
  public String id;

  public String sealApplyId;

  public String checkPersonId;

  public Integer checkStatus;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public SealApplyCheckManageFilterMapper() {
  }

  public SealApplyCheckManageFilterMapper(String id, String sealApplyId, String checkPersonId,
      Integer checkStatus) {
    this.id=id;
    this.sealApplyId=sealApplyId;
    this.checkPersonId=checkPersonId;
    this.checkStatus=checkStatus;
  }

  public static SealApplyCheckManageFilterMapper buildMapper(SealApplyCheckManage obj) {
    SealApplyCheckManageFilterMapper mapper = new SealApplyCheckManageFilterMapper();
    mapper.id=obj.getId();
    mapper.sealApplyId=obj.getSealApplyId();
    mapper.checkPersonId=obj.getCheckPersonId();
    mapper.checkStatus=obj.getCheckStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("sealApplyId",this.sealApplyId);
    map.put("checkPersonId",this.checkPersonId);
    map.put("checkStatus",this.checkStatus);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(SealApplyCheckManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("sealApplyId", obj.getSealApplyId());
    map.put("checkPersonId", obj.getCheckPersonId());
    map.put("checkStatus", obj.getCheckStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealApplyCheckManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("sealApplyId", JSONObject.toJSONString(obj.getSealApplyId()));
    map.put("checkPersonId", JSONObject.toJSONString(obj.getCheckPersonId()));
    map.put("checkStatus", JSONObject.toJSONString(obj.getCheckStatus()));
    return map;
  }

  public SealApplyCheckManage buildEntity() {
    SealApplyCheckManage obj = new SealApplyCheckManage();
    obj.setId(this.id);
    obj.setSealApplyId(this.sealApplyId);
    obj.setCheckPersonId(this.checkPersonId);
    obj.setCheckStatus(this.checkStatus);
    return obj;
  }

  public static SealApplyCheckManage parseEntity(Map<String, Object> map) {
    SealApplyCheckManage obj = new SealApplyCheckManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setSealApplyId((String) map.get("sealApplyId"));
    obj.setCheckPersonId((String) map.get("checkPersonId"));
    obj.setCheckStatus((Integer) map.get("checkStatus"));
    return obj;
  }

  public static SealApplyCheckManage parseSerialEntity(Map<String, String> map) {
    SealApplyCheckManage obj = new SealApplyCheckManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setSealApplyId(JSONObject.parseObject(map.get("sealApplyId"), String.class));
    obj.setCheckPersonId(JSONObject.parseObject(map.get("checkPersonId"), String.class));
    obj.setCheckStatus(JSONObject.parseObject(map.get("checkStatus"), Integer.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(SealApplyCheckManage obj, Long page, Integer rows,
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

  public static Map<String, String> buildSerialMapExtra(SealApplyCheckManage obj, Long page,
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

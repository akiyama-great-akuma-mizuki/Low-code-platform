package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.BusinessTripCheckTO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessTripCheckDomain {
  public String id;

  public String businessTripId;

  public String approverId;

  public Integer status;

  public Date gmtUpdate;

  public Date gmtCreate;

  public BusinessTripCheckDomain() {
  }

  public BusinessTripCheckDomain(String id, String businessTripId, String approverId,
      Integer status, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.businessTripId=businessTripId;
    this.approverId=approverId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static BusinessTripCheckDomain buildMapper(BusinessTripCheck obj) {
    BusinessTripCheckDomain mapper = new BusinessTripCheckDomain();
    mapper.id=obj.getId();
    mapper.businessTripId=obj.getBusinessTripId();
    mapper.approverId=obj.getApproverId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("businessTripId",this.businessTripId);
    map.put("approverId",this.approverId);
    map.put("status",this.status);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(BusinessTripCheck obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("businessTripId", obj.getBusinessTripId());
    map.put("approverId", obj.getApproverId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(BusinessTripCheck obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("businessTripId", JSONObject.toJSONString(obj.getBusinessTripId()));
    map.put("approverId", JSONObject.toJSONString(obj.getApproverId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public BusinessTripCheck buildEntity() {
    BusinessTripCheck obj = new BusinessTripCheck();
    obj.setId(this.id);
    obj.setBusinessTripId(this.businessTripId);
    obj.setApproverId(this.approverId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static BusinessTripCheck parseEntity(Map<String, Object> map) {
    BusinessTripCheck obj = new BusinessTripCheck();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setBusinessTripId((String) map.get("businessTripId"));
    obj.setApproverId((String) map.get("approverId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static BusinessTripCheck parseSerialEntity(Map<String, String> map) {
    BusinessTripCheck obj = new BusinessTripCheck();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setBusinessTripId(JSONObject.parseObject(map.get("businessTripId"), String.class));
    obj.setApproverId(JSONObject.parseObject(map.get("approverId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static BusinessTripCheckTO convert(BusinessTripCheck from, BusinessTripCheckTO to) {
    if (from == null) return to;
    if (to == null) to = new BusinessTripCheckTO();
    to.setId(from.getId());
    to.setBusinessTripId(from.getBusinessTripId());
    to.setApproverId(from.getApproverId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static BusinessTripCheck convert(BusinessTripCheckTO from, BusinessTripCheck to) {
    if (from == null) return to;
    if (to == null) to = new BusinessTripCheck();
    to.setId(from.getId());
    to.setBusinessTripId(from.getBusinessTripId());
    to.setApproverId(from.getApproverId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

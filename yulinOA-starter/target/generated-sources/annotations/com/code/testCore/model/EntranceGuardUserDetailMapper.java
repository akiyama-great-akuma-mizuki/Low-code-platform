package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntranceGuardUserDetailMapper {
  public String id;

  public Integer visitorType;

  public String belongCompany;

  public Long inParkTime;

  public String entranceUserName;

  public String entranceScope;

  public Long outParkTime;

  public String entranceManagementId;

  public String entrancePhone;

  public String entranceRemark;

  public String entranceRecord;

  public Integer applyState;

  public String qrCode;

  public String entranceCardId;

  public String examineRemark;

  public String enterpriseId;

  public String userId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map entranceManagement = null;

  public Map enterprise = null;

  public Map user = null;

  public EntranceGuardUserDetailMapper() {
  }

  public EntranceGuardUserDetailMapper(String id, Integer visitorType, String belongCompany,
      Long inParkTime, String entranceUserName, String entranceScope, Long outParkTime,
      String entranceManagementId, String entrancePhone, String entranceRemark,
      String entranceRecord, Integer applyState, String qrCode, String entranceCardId,
      String examineRemark, String enterpriseId, String userId, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.visitorType=visitorType;
    this.belongCompany=belongCompany;
    this.inParkTime=inParkTime;
    this.entranceUserName=entranceUserName;
    this.entranceScope=entranceScope;
    this.outParkTime=outParkTime;
    this.entranceManagementId=entranceManagementId;
    this.entrancePhone=entrancePhone;
    this.entranceRemark=entranceRemark;
    this.entranceRecord=entranceRecord;
    this.applyState=applyState;
    this.qrCode=qrCode;
    this.entranceCardId=entranceCardId;
    this.examineRemark=examineRemark;
    this.enterpriseId=enterpriseId;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static EntranceGuardUserDetailMapper buildMapper(EntranceGuardUser obj) {
    EntranceGuardUserDetailMapper mapper = new EntranceGuardUserDetailMapper();
    mapper.id=obj.getId();
    mapper.visitorType=obj.getVisitorType();
    mapper.belongCompany=obj.getBelongCompany();
    mapper.inParkTime=obj.modifyTime(obj.getInParkTime());
    mapper.entranceUserName=obj.getEntranceUserName();
    mapper.entranceScope=obj.getEntranceScope();
    mapper.outParkTime=obj.modifyTime(obj.getOutParkTime());
    mapper.entranceManagementId=obj.getEntranceManagementId();
    mapper.entrancePhone=obj.getEntrancePhone();
    mapper.entranceRemark=obj.getEntranceRemark();
    mapper.entranceRecord=obj.getEntranceRecord();
    mapper.applyState=obj.getApplyState();
    mapper.qrCode=obj.getQrCode();
    mapper.entranceCardId=obj.getEntranceCardId();
    mapper.examineRemark=obj.getExamineRemark();
    mapper.enterpriseId=obj.getEnterpriseId();
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("visitorType",this.visitorType);
    map.put("belongCompany",this.belongCompany);
    map.put("inParkTime",this.inParkTime);
    map.put("entranceUserName",this.entranceUserName);
    map.put("entranceScope",this.entranceScope);
    map.put("outParkTime",this.outParkTime);
    map.put("entranceManagementId",this.entranceManagementId);
    map.put("entrancePhone",this.entrancePhone);
    map.put("entranceRemark",this.entranceRemark);
    map.put("entranceRecord",this.entranceRecord);
    map.put("applyState",this.applyState);
    map.put("qrCode",this.qrCode);
    map.put("entranceCardId",this.entranceCardId);
    map.put("examineRemark",this.examineRemark);
    map.put("enterpriseId",this.enterpriseId);
    map.put("userId",this.userId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("entranceManagement",this.entranceManagement);
    map.put("enterprise",this.enterprise);
    map.put("user",this.user);
    return map;
  }

  public static Map<String, Object> buildMap(EntranceGuardUser obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("visitorType", obj.getVisitorType());
    map.put("belongCompany", obj.getBelongCompany());
    map.put("inParkTime", obj.modifyTime(obj.getInParkTime()));
    map.put("entranceUserName", obj.getEntranceUserName());
    map.put("entranceScope", obj.getEntranceScope());
    map.put("outParkTime", obj.modifyTime(obj.getOutParkTime()));
    map.put("entranceManagementId", obj.getEntranceManagementId());
    map.put("entrancePhone", obj.getEntrancePhone());
    map.put("entranceRemark", obj.getEntranceRemark());
    map.put("entranceRecord", obj.getEntranceRecord());
    map.put("applyState", obj.getApplyState());
    map.put("qrCode", obj.getQrCode());
    map.put("entranceCardId", obj.getEntranceCardId());
    map.put("examineRemark", obj.getExamineRemark());
    map.put("enterpriseId", obj.getEnterpriseId());
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(EntranceGuardUser obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("visitorType", JSONObject.toJSONString(obj.getVisitorType()));
    map.put("belongCompany", JSONObject.toJSONString(obj.getBelongCompany()));
    map.put("inParkTime", JSONObject.toJSONString(obj.modifyTime(obj.getInParkTime())));
    map.put("entranceUserName", JSONObject.toJSONString(obj.getEntranceUserName()));
    map.put("entranceScope", JSONObject.toJSONString(obj.getEntranceScope()));
    map.put("outParkTime", JSONObject.toJSONString(obj.modifyTime(obj.getOutParkTime())));
    map.put("entranceManagementId", JSONObject.toJSONString(obj.getEntranceManagementId()));
    map.put("entrancePhone", JSONObject.toJSONString(obj.getEntrancePhone()));
    map.put("entranceRemark", JSONObject.toJSONString(obj.getEntranceRemark()));
    map.put("entranceRecord", JSONObject.toJSONString(obj.getEntranceRecord()));
    map.put("applyState", JSONObject.toJSONString(obj.getApplyState()));
    map.put("qrCode", JSONObject.toJSONString(obj.getQrCode()));
    map.put("entranceCardId", JSONObject.toJSONString(obj.getEntranceCardId()));
    map.put("examineRemark", JSONObject.toJSONString(obj.getExamineRemark()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public EntranceGuardUser buildEntity() {
    EntranceGuardUser obj = new EntranceGuardUser();
    obj.setId(this.id);
    obj.setVisitorType(this.visitorType);
    obj.setBelongCompany(this.belongCompany);
    obj.setInParkTime(obj.recoverTime(this.inParkTime));
    obj.setEntranceUserName(this.entranceUserName);
    obj.setEntranceScope(this.entranceScope);
    obj.setOutParkTime(obj.recoverTime(this.outParkTime));
    obj.setEntranceManagementId(this.entranceManagementId);
    obj.setEntrancePhone(this.entrancePhone);
    obj.setEntranceRemark(this.entranceRemark);
    obj.setEntranceRecord(this.entranceRecord);
    obj.setApplyState(this.applyState);
    obj.setQrCode(this.qrCode);
    obj.setEntranceCardId(this.entranceCardId);
    obj.setExamineRemark(this.examineRemark);
    obj.setEnterpriseId(this.enterpriseId);
    obj.setUserId(this.userId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static EntranceGuardUser parseEntity(Map<String, Object> map) {
    EntranceGuardUser obj = new EntranceGuardUser();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setVisitorType((Integer) map.get("visitorType"));
    obj.setBelongCompany((String) map.get("belongCompany"));
    obj.setInParkTime(obj.recoverTime((Long) map.get("inParkTime")));
    obj.setEntranceUserName((String) map.get("entranceUserName"));
    obj.setEntranceScope((String) map.get("entranceScope"));
    obj.setOutParkTime(obj.recoverTime((Long) map.get("outParkTime")));
    obj.setEntranceManagementId((String) map.get("entranceManagementId"));
    obj.setEntrancePhone((String) map.get("entrancePhone"));
    obj.setEntranceRemark((String) map.get("entranceRemark"));
    obj.setEntranceRecord((String) map.get("entranceRecord"));
    obj.setApplyState((Integer) map.get("applyState"));
    obj.setQrCode((String) map.get("qrCode"));
    obj.setEntranceCardId((String) map.get("entranceCardId"));
    obj.setExamineRemark((String) map.get("examineRemark"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static EntranceGuardUser parseSerialEntity(Map<String, String> map) {
    EntranceGuardUser obj = new EntranceGuardUser();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setVisitorType(JSONObject.parseObject(map.get("visitorType"), Integer.class));
    obj.setBelongCompany(JSONObject.parseObject(map.get("belongCompany"), String.class));
    obj.setInParkTime(obj.recoverTime(JSONObject.parseObject(map.get("inParkTime"), Long.class)));
    obj.setEntranceUserName(JSONObject.parseObject(map.get("entranceUserName"), String.class));
    obj.setEntranceScope(JSONObject.parseObject(map.get("entranceScope"), String.class));
    obj.setOutParkTime(obj.recoverTime(JSONObject.parseObject(map.get("outParkTime"), Long.class)));
    obj.setEntranceManagementId(JSONObject.parseObject(map.get("entranceManagementId"), String.class));
    obj.setEntrancePhone(JSONObject.parseObject(map.get("entrancePhone"), String.class));
    obj.setEntranceRemark(JSONObject.parseObject(map.get("entranceRemark"), String.class));
    obj.setEntranceRecord(JSONObject.parseObject(map.get("entranceRecord"), String.class));
    obj.setApplyState(JSONObject.parseObject(map.get("applyState"), Integer.class));
    obj.setQrCode(JSONObject.parseObject(map.get("qrCode"), String.class));
    obj.setEntranceCardId(JSONObject.parseObject(map.get("entranceCardId"), String.class));
    obj.setExamineRemark(JSONObject.parseObject(map.get("examineRemark"), String.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(EntranceGuardUser obj,
      Map<String, Object> entranceManagement, Map<String, Object> enterprise,
      Map<String, Object> user) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("entranceManagement", entranceManagement);
    map.put("enterprise", enterprise);
    map.put("user", user);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(EntranceGuardUser obj,
      Map<String, Object> entranceManagement, Map<String, Object> enterprise,
      Map<String, Object> user) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("entranceManagement", JSONObject.toJSONString(entranceManagement));
    map.put("enterprise", JSONObject.toJSONString(enterprise));
    map.put("user", JSONObject.toJSONString(user));
    return map;
  }
}

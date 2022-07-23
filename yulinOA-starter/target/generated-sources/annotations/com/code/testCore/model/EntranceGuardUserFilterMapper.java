package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EntranceGuardUserFilterMapper {
  public String id;

  public Integer visitorType;

  public String belongCompany;

  public String entranceUserName;

  public String entranceScope;

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

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String belongCompanyLike = null;

  public Long inParkTimeFrom = null;

  public Long inParkTimeTo = null;

  public String entranceUserNameLike = null;

  public String entranceScopeLike = null;

  public Long outParkTimeFrom = null;

  public Long outParkTimeTo = null;

  public String entrancePhoneLike = null;

  public String entranceRemarkLike = null;

  public String entranceRecordLike = null;

  public String qrCodeLike = null;

  public String entranceCardIdLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public EntranceGuardUserFilterMapper() {
  }

  public EntranceGuardUserFilterMapper(String id, Integer visitorType, String belongCompany,
      String entranceUserName, String entranceScope, String entranceManagementId,
      String entrancePhone, String entranceRemark, String entranceRecord, Integer applyState,
      String qrCode, String entranceCardId, String examineRemark, String enterpriseId,
      String userId) {
    this.id=id;
    this.visitorType=visitorType;
    this.belongCompany=belongCompany;
    this.entranceUserName=entranceUserName;
    this.entranceScope=entranceScope;
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
  }

  public static EntranceGuardUserFilterMapper buildMapper(EntranceGuardUser obj) {
    EntranceGuardUserFilterMapper mapper = new EntranceGuardUserFilterMapper();
    mapper.id=obj.getId();
    mapper.visitorType=obj.getVisitorType();
    mapper.belongCompany=obj.getBelongCompany();
    mapper.entranceUserName=obj.getEntranceUserName();
    mapper.entranceScope=obj.getEntranceScope();
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
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("visitorType",this.visitorType);
    map.put("belongCompany",this.belongCompany);
    map.put("entranceUserName",this.entranceUserName);
    map.put("entranceScope",this.entranceScope);
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
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("belongCompanyLike",this.belongCompanyLike);
    map.put("inParkTimeFrom",this.inParkTimeFrom);
    map.put("inParkTimeTo",this.inParkTimeTo);
    map.put("entranceUserNameLike",this.entranceUserNameLike);
    map.put("entranceScopeLike",this.entranceScopeLike);
    map.put("outParkTimeFrom",this.outParkTimeFrom);
    map.put("outParkTimeTo",this.outParkTimeTo);
    map.put("entrancePhoneLike",this.entrancePhoneLike);
    map.put("entranceRemarkLike",this.entranceRemarkLike);
    map.put("entranceRecordLike",this.entranceRecordLike);
    map.put("qrCodeLike",this.qrCodeLike);
    map.put("entranceCardIdLike",this.entranceCardIdLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(EntranceGuardUser obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("visitorType", obj.getVisitorType());
    map.put("belongCompany", obj.getBelongCompany());
    map.put("entranceUserName", obj.getEntranceUserName());
    map.put("entranceScope", obj.getEntranceScope());
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
    return map;
  }

  public static Map<String, String> buildSerialMap(EntranceGuardUser obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("visitorType", JSONObject.toJSONString(obj.getVisitorType()));
    map.put("belongCompany", JSONObject.toJSONString(obj.getBelongCompany()));
    map.put("entranceUserName", JSONObject.toJSONString(obj.getEntranceUserName()));
    map.put("entranceScope", JSONObject.toJSONString(obj.getEntranceScope()));
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
    return map;
  }

  public EntranceGuardUser buildEntity() {
    EntranceGuardUser obj = new EntranceGuardUser();
    obj.setId(this.id);
    obj.setVisitorType(this.visitorType);
    obj.setBelongCompany(this.belongCompany);
    obj.setEntranceUserName(this.entranceUserName);
    obj.setEntranceScope(this.entranceScope);
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
    return obj;
  }

  public static EntranceGuardUser parseEntity(Map<String, Object> map) {
    EntranceGuardUser obj = new EntranceGuardUser();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setVisitorType((Integer) map.get("visitorType"));
    obj.setBelongCompany((String) map.get("belongCompany"));
    obj.setEntranceUserName((String) map.get("entranceUserName"));
    obj.setEntranceScope((String) map.get("entranceScope"));
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
    return obj;
  }

  public static EntranceGuardUser parseSerialEntity(Map<String, String> map) {
    EntranceGuardUser obj = new EntranceGuardUser();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setVisitorType(JSONObject.parseObject(map.get("visitorType"), Integer.class));
    obj.setBelongCompany(JSONObject.parseObject(map.get("belongCompany"), String.class));
    obj.setEntranceUserName(JSONObject.parseObject(map.get("entranceUserName"), String.class));
    obj.setEntranceScope(JSONObject.parseObject(map.get("entranceScope"), String.class));
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
    return obj;
  }

  public static Map<String, Object> buildMapExtra(EntranceGuardUser obj, Long page, Integer rows,
      List<String> orderBy, String belongCompanyLike, Long inParkTimeFrom, Long inParkTimeTo,
      String entranceUserNameLike, String entranceScopeLike, Long outParkTimeFrom,
      Long outParkTimeTo, String entrancePhoneLike, String entranceRemarkLike,
      String entranceRecordLike, String qrCodeLike, String entranceCardIdLike, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("belongCompanyLike", belongCompanyLike);
    map.put("inParkTimeFrom", inParkTimeFrom);
    map.put("inParkTimeTo", inParkTimeTo);
    map.put("entranceUserNameLike", entranceUserNameLike);
    map.put("entranceScopeLike", entranceScopeLike);
    map.put("outParkTimeFrom", outParkTimeFrom);
    map.put("outParkTimeTo", outParkTimeTo);
    map.put("entrancePhoneLike", entrancePhoneLike);
    map.put("entranceRemarkLike", entranceRemarkLike);
    map.put("entranceRecordLike", entranceRecordLike);
    map.put("qrCodeLike", qrCodeLike);
    map.put("entranceCardIdLike", entranceCardIdLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(EntranceGuardUser obj, Long page,
      Integer rows, List<String> orderBy, String belongCompanyLike, Long inParkTimeFrom,
      Long inParkTimeTo, String entranceUserNameLike, String entranceScopeLike,
      Long outParkTimeFrom, Long outParkTimeTo, String entrancePhoneLike, String entranceRemarkLike,
      String entranceRecordLike, String qrCodeLike, String entranceCardIdLike, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("belongCompanyLike", JSONObject.toJSONString(belongCompanyLike));
    map.put("inParkTimeFrom", JSONObject.toJSONString(inParkTimeFrom));
    map.put("inParkTimeTo", JSONObject.toJSONString(inParkTimeTo));
    map.put("entranceUserNameLike", JSONObject.toJSONString(entranceUserNameLike));
    map.put("entranceScopeLike", JSONObject.toJSONString(entranceScopeLike));
    map.put("outParkTimeFrom", JSONObject.toJSONString(outParkTimeFrom));
    map.put("outParkTimeTo", JSONObject.toJSONString(outParkTimeTo));
    map.put("entrancePhoneLike", JSONObject.toJSONString(entrancePhoneLike));
    map.put("entranceRemarkLike", JSONObject.toJSONString(entranceRemarkLike));
    map.put("entranceRecordLike", JSONObject.toJSONString(entranceRecordLike));
    map.put("qrCodeLike", JSONObject.toJSONString(qrCodeLike));
    map.put("entranceCardIdLike", JSONObject.toJSONString(entranceCardIdLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

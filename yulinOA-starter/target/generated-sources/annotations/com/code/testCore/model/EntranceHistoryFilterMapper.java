package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EntranceHistoryFilterMapper {
  public String id;

  public String entranceGuardId;

  public String staffName;

  public String tellPhone;

  public Integer inOrOut;

  public String entranceName;

  public String photo;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String staffNameLike = null;

  public String tellPhoneLike = null;

  public Long useDateFrom = null;

  public Long useDateTo = null;

  public String entranceNameLike = null;

  public String photoLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public EntranceHistoryFilterMapper() {
  }

  public EntranceHistoryFilterMapper(String id, String entranceGuardId, String staffName,
      String tellPhone, Integer inOrOut, String entranceName, String photo) {
    this.id=id;
    this.entranceGuardId=entranceGuardId;
    this.staffName=staffName;
    this.tellPhone=tellPhone;
    this.inOrOut=inOrOut;
    this.entranceName=entranceName;
    this.photo=photo;
  }

  public static EntranceHistoryFilterMapper buildMapper(EntranceHistory obj) {
    EntranceHistoryFilterMapper mapper = new EntranceHistoryFilterMapper();
    mapper.id=obj.getId();
    mapper.entranceGuardId=obj.getEntranceGuardId();
    mapper.staffName=obj.getStaffName();
    mapper.tellPhone=obj.getTellPhone();
    mapper.inOrOut=obj.getInOrOut();
    mapper.entranceName=obj.getEntranceName();
    mapper.photo=obj.getPhoto();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("entranceGuardId",this.entranceGuardId);
    map.put("staffName",this.staffName);
    map.put("tellPhone",this.tellPhone);
    map.put("inOrOut",this.inOrOut);
    map.put("entranceName",this.entranceName);
    map.put("photo",this.photo);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("staffNameLike",this.staffNameLike);
    map.put("tellPhoneLike",this.tellPhoneLike);
    map.put("useDateFrom",this.useDateFrom);
    map.put("useDateTo",this.useDateTo);
    map.put("entranceNameLike",this.entranceNameLike);
    map.put("photoLike",this.photoLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(EntranceHistory obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("entranceGuardId", obj.getEntranceGuardId());
    map.put("staffName", obj.getStaffName());
    map.put("tellPhone", obj.getTellPhone());
    map.put("inOrOut", obj.getInOrOut());
    map.put("entranceName", obj.getEntranceName());
    map.put("photo", obj.getPhoto());
    return map;
  }

  public static Map<String, String> buildSerialMap(EntranceHistory obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("entranceGuardId", JSONObject.toJSONString(obj.getEntranceGuardId()));
    map.put("staffName", JSONObject.toJSONString(obj.getStaffName()));
    map.put("tellPhone", JSONObject.toJSONString(obj.getTellPhone()));
    map.put("inOrOut", JSONObject.toJSONString(obj.getInOrOut()));
    map.put("entranceName", JSONObject.toJSONString(obj.getEntranceName()));
    map.put("photo", JSONObject.toJSONString(obj.getPhoto()));
    return map;
  }

  public EntranceHistory buildEntity() {
    EntranceHistory obj = new EntranceHistory();
    obj.setId(this.id);
    obj.setEntranceGuardId(this.entranceGuardId);
    obj.setStaffName(this.staffName);
    obj.setTellPhone(this.tellPhone);
    obj.setInOrOut(this.inOrOut);
    obj.setEntranceName(this.entranceName);
    obj.setPhoto(this.photo);
    return obj;
  }

  public static EntranceHistory parseEntity(Map<String, Object> map) {
    EntranceHistory obj = new EntranceHistory();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setEntranceGuardId((String) map.get("entranceGuardId"));
    obj.setStaffName((String) map.get("staffName"));
    obj.setTellPhone((String) map.get("tellPhone"));
    obj.setInOrOut((Integer) map.get("inOrOut"));
    obj.setEntranceName((String) map.get("entranceName"));
    obj.setPhoto((String) map.get("photo"));
    return obj;
  }

  public static EntranceHistory parseSerialEntity(Map<String, String> map) {
    EntranceHistory obj = new EntranceHistory();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setEntranceGuardId(JSONObject.parseObject(map.get("entranceGuardId"), String.class));
    obj.setStaffName(JSONObject.parseObject(map.get("staffName"), String.class));
    obj.setTellPhone(JSONObject.parseObject(map.get("tellPhone"), String.class));
    obj.setInOrOut(JSONObject.parseObject(map.get("inOrOut"), Integer.class));
    obj.setEntranceName(JSONObject.parseObject(map.get("entranceName"), String.class));
    obj.setPhoto(JSONObject.parseObject(map.get("photo"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(EntranceHistory obj, Long page, Integer rows,
      List<String> orderBy, String staffNameLike, String tellPhoneLike, Long useDateFrom,
      Long useDateTo, String entranceNameLike, String photoLike, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("staffNameLike", staffNameLike);
    map.put("tellPhoneLike", tellPhoneLike);
    map.put("useDateFrom", useDateFrom);
    map.put("useDateTo", useDateTo);
    map.put("entranceNameLike", entranceNameLike);
    map.put("photoLike", photoLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(EntranceHistory obj, Long page,
      Integer rows, List<String> orderBy, String staffNameLike, String tellPhoneLike,
      Long useDateFrom, Long useDateTo, String entranceNameLike, String photoLike,
      Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("staffNameLike", JSONObject.toJSONString(staffNameLike));
    map.put("tellPhoneLike", JSONObject.toJSONString(tellPhoneLike));
    map.put("useDateFrom", JSONObject.toJSONString(useDateFrom));
    map.put("useDateTo", JSONObject.toJSONString(useDateTo));
    map.put("entranceNameLike", JSONObject.toJSONString(entranceNameLike));
    map.put("photoLike", JSONObject.toJSONString(photoLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

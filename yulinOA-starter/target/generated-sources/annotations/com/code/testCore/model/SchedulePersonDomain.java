package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.SchedulePersonTO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class SchedulePersonDomain {
  public String id;

  public String scheduleId;

  public String userId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public SchedulePersonDomain() {
  }

  public SchedulePersonDomain(String id, String scheduleId, String userId, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.scheduleId=scheduleId;
    this.userId=userId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static SchedulePersonDomain buildMapper(SchedulePerson obj) {
    SchedulePersonDomain mapper = new SchedulePersonDomain();
    mapper.id=obj.getId();
    mapper.scheduleId=obj.getScheduleId();
    mapper.userId=obj.getUserId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("scheduleId",this.scheduleId);
    map.put("userId",this.userId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(SchedulePerson obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("scheduleId", obj.getScheduleId());
    map.put("userId", obj.getUserId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(SchedulePerson obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("scheduleId", JSONObject.toJSONString(obj.getScheduleId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public SchedulePerson buildEntity() {
    SchedulePerson obj = new SchedulePerson();
    obj.setId(this.id);
    obj.setScheduleId(this.scheduleId);
    obj.setUserId(this.userId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static SchedulePerson parseEntity(Map<String, Object> map) {
    SchedulePerson obj = new SchedulePerson();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setScheduleId((String) map.get("scheduleId"));
    obj.setUserId((String) map.get("userId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static SchedulePerson parseSerialEntity(Map<String, String> map) {
    SchedulePerson obj = new SchedulePerson();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setScheduleId(JSONObject.parseObject(map.get("scheduleId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static SchedulePersonTO convert(SchedulePerson from, SchedulePersonTO to) {
    if (from == null) return to;
    if (to == null) to = new SchedulePersonTO();
    to.setId(from.getId());
    to.setScheduleId(from.getScheduleId());
    to.setUserId(from.getUserId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static SchedulePerson convert(SchedulePersonTO from, SchedulePerson to) {
    if (from == null) return to;
    if (to == null) to = new SchedulePerson();
    to.setId(from.getId());
    to.setScheduleId(from.getScheduleId());
    to.setUserId(from.getUserId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

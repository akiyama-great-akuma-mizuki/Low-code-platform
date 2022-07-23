package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckDetailMapper {
  public String id;

  public String eventId;

  public Integer status;

  public Integer type;

  public Long gmtUpdate;

  public Long gmtCreate;

  public List<Map> checkPersonList = null;

  public CheckDetailMapper() {
  }

  public CheckDetailMapper(String id, String eventId, Integer status, Integer type, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.eventId=eventId;
    this.status=status;
    this.type=type;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static CheckDetailMapper buildMapper(Check obj) {
    CheckDetailMapper mapper = new CheckDetailMapper();
    mapper.id=obj.getId();
    mapper.eventId=obj.getEventId();
    mapper.status=obj.getStatus();
    mapper.type=obj.getType();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("eventId",this.eventId);
    map.put("status",this.status);
    map.put("type",this.type);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("checkPersonList",this.checkPersonList);
    return map;
  }

  public static Map<String, Object> buildMap(Check obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("eventId", obj.getEventId());
    map.put("status", obj.getStatus());
    map.put("type", obj.getType());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Check obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("eventId", JSONObject.toJSONString(obj.getEventId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Check buildEntity() {
    Check obj = new Check();
    obj.setId(this.id);
    obj.setEventId(this.eventId);
    obj.setStatus(this.status);
    obj.setType(this.type);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Check parseEntity(Map<String, Object> map) {
    Check obj = new Check();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setEventId((String) map.get("eventId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setType((Integer) map.get("type"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Check parseSerialEntity(Map<String, String> map) {
    Check obj = new Check();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setEventId(JSONObject.parseObject(map.get("eventId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setType(JSONObject.parseObject(map.get("type"), Integer.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Check obj,
      List<Map<String, Object>> checkPersonList) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("checkPersonList", checkPersonList);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Check obj,
      List<Map<String, Object>> checkPersonList) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("checkPersonList", JSONObject.toJSONString(checkPersonList));
    return map;
  }
}

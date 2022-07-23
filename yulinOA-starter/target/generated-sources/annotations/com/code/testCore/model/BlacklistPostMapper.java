package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlacklistPostMapper {
  public String operator;

  public Long operateTime;

  public String reason;

  public BlacklistPostMapper() {
  }

  public BlacklistPostMapper(String operator, Long operateTime, String reason) {
    this.operator=operator;
    this.operateTime=operateTime;
    this.reason=reason;
  }

  public static BlacklistPostMapper buildMapper(Blacklist obj) {
    BlacklistPostMapper mapper = new BlacklistPostMapper();
    mapper.operator=obj.getOperator();
    mapper.operateTime=obj.modifyTime(obj.getOperateTime());
    mapper.reason=obj.getReason();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("operator",this.operator);
    map.put("operateTime",this.operateTime);
    map.put("reason",this.reason);
    return map;
  }

  public static Map<String, Object> buildMap(Blacklist obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("operator", obj.getOperator());
    map.put("operateTime", obj.modifyTime(obj.getOperateTime()));
    map.put("reason", obj.getReason());
    return map;
  }

  public static Map<String, String> buildSerialMap(Blacklist obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("operator", JSONObject.toJSONString(obj.getOperator()));
    map.put("operateTime", JSONObject.toJSONString(obj.modifyTime(obj.getOperateTime())));
    map.put("reason", JSONObject.toJSONString(obj.getReason()));
    return map;
  }

  public Blacklist buildEntity() {
    Blacklist obj = new Blacklist();
    obj.setOperator(this.operator);
    obj.setOperateTime(obj.recoverTime(this.operateTime));
    obj.setReason(this.reason);
    return obj;
  }

  public static Blacklist parseEntity(Map<String, Object> map) {
    Blacklist obj = new Blacklist();
    if (map == null) return obj;
    obj.setOperator((String) map.get("operator"));
    obj.setOperateTime(obj.recoverTime((Long) map.get("operateTime")));
    obj.setReason((String) map.get("reason"));
    return obj;
  }

  public static Blacklist parseSerialEntity(Map<String, String> map) {
    Blacklist obj = new Blacklist();
    if (map == null) return obj;
    obj.setOperator(JSONObject.parseObject(map.get("operator"), String.class));
    obj.setOperateTime(obj.recoverTime(JSONObject.parseObject(map.get("operateTime"), Long.class)));
    obj.setReason(JSONObject.parseObject(map.get("reason"), String.class));
    return obj;
  }
}

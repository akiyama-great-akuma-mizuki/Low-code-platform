package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlacklistDetailMapper {
  public String id;

  public String operator;

  public Long operateTime;

  public String carId;

  public String reason;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map car = null;

  public BlacklistDetailMapper() {
  }

  public BlacklistDetailMapper(String id, String operator, Long operateTime, String carId,
      String reason, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.operator=operator;
    this.operateTime=operateTime;
    this.carId=carId;
    this.reason=reason;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static BlacklistDetailMapper buildMapper(Blacklist obj) {
    BlacklistDetailMapper mapper = new BlacklistDetailMapper();
    mapper.id=obj.getId();
    mapper.operator=obj.getOperator();
    mapper.operateTime=obj.modifyTime(obj.getOperateTime());
    mapper.carId=obj.getCarId();
    mapper.reason=obj.getReason();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("operator",this.operator);
    map.put("operateTime",this.operateTime);
    map.put("carId",this.carId);
    map.put("reason",this.reason);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("car",this.car);
    return map;
  }

  public static Map<String, Object> buildMap(Blacklist obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("operator", obj.getOperator());
    map.put("operateTime", obj.modifyTime(obj.getOperateTime()));
    map.put("carId", obj.getCarId());
    map.put("reason", obj.getReason());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Blacklist obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("operator", JSONObject.toJSONString(obj.getOperator()));
    map.put("operateTime", JSONObject.toJSONString(obj.modifyTime(obj.getOperateTime())));
    map.put("carId", JSONObject.toJSONString(obj.getCarId()));
    map.put("reason", JSONObject.toJSONString(obj.getReason()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Blacklist buildEntity() {
    Blacklist obj = new Blacklist();
    obj.setId(this.id);
    obj.setOperator(this.operator);
    obj.setOperateTime(obj.recoverTime(this.operateTime));
    obj.setCarId(this.carId);
    obj.setReason(this.reason);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Blacklist parseEntity(Map<String, Object> map) {
    Blacklist obj = new Blacklist();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setOperator((String) map.get("operator"));
    obj.setOperateTime(obj.recoverTime((Long) map.get("operateTime")));
    obj.setCarId((String) map.get("carId"));
    obj.setReason((String) map.get("reason"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Blacklist parseSerialEntity(Map<String, String> map) {
    Blacklist obj = new Blacklist();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setOperator(JSONObject.parseObject(map.get("operator"), String.class));
    obj.setOperateTime(obj.recoverTime(JSONObject.parseObject(map.get("operateTime"), Long.class)));
    obj.setCarId(JSONObject.parseObject(map.get("carId"), String.class));
    obj.setReason(JSONObject.parseObject(map.get("reason"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Blacklist obj, Map<String, Object> car) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("car", car);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Blacklist obj, Map<String, Object> car) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("car", JSONObject.toJSONString(car));
    return map;
  }
}

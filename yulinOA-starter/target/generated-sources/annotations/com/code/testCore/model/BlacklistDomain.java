package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.BlacklistTO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlacklistDomain {
  public String id;

  public String operator;

  public Date operateTime;

  public String carId;

  public String reason;

  public Date gmtUpdate;

  public Date gmtCreate;

  public BlacklistDomain() {
  }

  public BlacklistDomain(String id, String operator, Date operateTime, String carId, String reason,
      Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.operator=operator;
    this.operateTime=operateTime;
    this.carId=carId;
    this.reason=reason;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static BlacklistDomain buildMapper(Blacklist obj) {
    BlacklistDomain mapper = new BlacklistDomain();
    mapper.id=obj.getId();
    mapper.operator=obj.getOperator();
    mapper.operateTime=obj.getOperateTime();
    mapper.carId=obj.getCarId();
    mapper.reason=obj.getReason();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    return map;
  }

  public static Map<String, Object> buildMap(Blacklist obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("operator", obj.getOperator());
    map.put("operateTime", obj.getOperateTime());
    map.put("carId", obj.getCarId());
    map.put("reason", obj.getReason());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(Blacklist obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("operator", JSONObject.toJSONString(obj.getOperator()));
    map.put("operateTime", JSONObject.toJSONString(obj.getOperateTime()));
    map.put("carId", JSONObject.toJSONString(obj.getCarId()));
    map.put("reason", JSONObject.toJSONString(obj.getReason()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public Blacklist buildEntity() {
    Blacklist obj = new Blacklist();
    obj.setId(this.id);
    obj.setOperator(this.operator);
    obj.setOperateTime(this.operateTime);
    obj.setCarId(this.carId);
    obj.setReason(this.reason);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static Blacklist parseEntity(Map<String, Object> map) {
    Blacklist obj = new Blacklist();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setOperator((String) map.get("operator"));
    obj.setOperateTime((Date) map.get("operateTime"));
    obj.setCarId((String) map.get("carId"));
    obj.setReason((String) map.get("reason"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static Blacklist parseSerialEntity(Map<String, String> map) {
    Blacklist obj = new Blacklist();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setOperator(JSONObject.parseObject(map.get("operator"), String.class));
    obj.setOperateTime(JSONObject.parseObject(map.get("operateTime"), Date.class));
    obj.setCarId(JSONObject.parseObject(map.get("carId"), String.class));
    obj.setReason(JSONObject.parseObject(map.get("reason"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static BlacklistTO convert(Blacklist from, BlacklistTO to) {
    if (from == null) return to;
    if (to == null) to = new BlacklistTO();
    to.setId(from.getId());
    to.setOperator(from.getOperator());
    to.setOperateTime(from.getOperateTime());
    to.setCarId(from.getCarId());
    to.setReason(from.getReason());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static Blacklist convert(BlacklistTO from, Blacklist to) {
    if (from == null) return to;
    if (to == null) to = new Blacklist();
    to.setId(from.getId());
    to.setOperator(from.getOperator());
    to.setOperateTime(from.getOperateTime());
    to.setCarId(from.getCarId());
    to.setReason(from.getReason());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class PropertyRecordSimpleMapper {
  public String id;

  public String payPeople;

  public String payPhone;

  public Integer payNum;

  public String payTime;

  public String payWay;

  public String propertyId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public PropertyRecordSimpleMapper() {
  }

  public PropertyRecordSimpleMapper(String id, String payPeople, String payPhone, Integer payNum,
      String payTime, String payWay, String propertyId, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.payPeople=payPeople;
    this.payPhone=payPhone;
    this.payNum=payNum;
    this.payTime=payTime;
    this.payWay=payWay;
    this.propertyId=propertyId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static PropertyRecordSimpleMapper buildMapper(PropertyRecord obj) {
    PropertyRecordSimpleMapper mapper = new PropertyRecordSimpleMapper();
    mapper.id=obj.getId();
    mapper.payPeople=obj.getPayPeople();
    mapper.payPhone=obj.getPayPhone();
    mapper.payNum=obj.getPayNum();
    mapper.payTime=obj.getPayTime();
    mapper.payWay=obj.getPayWay();
    mapper.propertyId=obj.getPropertyId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("payPeople",this.payPeople);
    map.put("payPhone",this.payPhone);
    map.put("payNum",this.payNum);
    map.put("payTime",this.payTime);
    map.put("payWay",this.payWay);
    map.put("propertyId",this.propertyId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(PropertyRecord obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("payPeople", obj.getPayPeople());
    map.put("payPhone", obj.getPayPhone());
    map.put("payNum", obj.getPayNum());
    map.put("payTime", obj.getPayTime());
    map.put("payWay", obj.getPayWay());
    map.put("propertyId", obj.getPropertyId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(PropertyRecord obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("payPeople", JSONObject.toJSONString(obj.getPayPeople()));
    map.put("payPhone", JSONObject.toJSONString(obj.getPayPhone()));
    map.put("payNum", JSONObject.toJSONString(obj.getPayNum()));
    map.put("payTime", JSONObject.toJSONString(obj.getPayTime()));
    map.put("payWay", JSONObject.toJSONString(obj.getPayWay()));
    map.put("propertyId", JSONObject.toJSONString(obj.getPropertyId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public PropertyRecord buildEntity() {
    PropertyRecord obj = new PropertyRecord();
    obj.setId(this.id);
    obj.setPayPeople(this.payPeople);
    obj.setPayPhone(this.payPhone);
    obj.setPayNum(this.payNum);
    obj.setPayTime(this.payTime);
    obj.setPayWay(this.payWay);
    obj.setPropertyId(this.propertyId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static PropertyRecord parseEntity(Map<String, Object> map) {
    PropertyRecord obj = new PropertyRecord();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setPayPeople((String) map.get("payPeople"));
    obj.setPayPhone((String) map.get("payPhone"));
    obj.setPayNum((Integer) map.get("payNum"));
    obj.setPayTime((String) map.get("payTime"));
    obj.setPayWay((String) map.get("payWay"));
    obj.setPropertyId((String) map.get("propertyId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static PropertyRecord parseSerialEntity(Map<String, String> map) {
    PropertyRecord obj = new PropertyRecord();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setPayPeople(JSONObject.parseObject(map.get("payPeople"), String.class));
    obj.setPayPhone(JSONObject.parseObject(map.get("payPhone"), String.class));
    obj.setPayNum(JSONObject.parseObject(map.get("payNum"), Integer.class));
    obj.setPayTime(JSONObject.parseObject(map.get("payTime"), String.class));
    obj.setPayWay(JSONObject.parseObject(map.get("payWay"), String.class));
    obj.setPropertyId(JSONObject.parseObject(map.get("propertyId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

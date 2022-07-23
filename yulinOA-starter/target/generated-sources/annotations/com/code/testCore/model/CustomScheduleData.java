package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.CustomScheduleDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomScheduleData {
  public String id;

  public String title;

  public Date time;

  public String address;

  public String remark;

  public Date gmtUpdate;

  public Date gmtCreate;

  public CustomScheduleData() {
  }

  public CustomScheduleData(String id, String title, Date time, String address, String remark,
      Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.title=title;
    this.time=time;
    this.address=address;
    this.remark=remark;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static CustomScheduleData buildMapper(CustomSchedule obj) {
    CustomScheduleData mapper = new CustomScheduleData();
    mapper.id=obj.getId();
    mapper.title=obj.getTitle();
    mapper.time=obj.getTime();
    mapper.address=obj.getAddress();
    mapper.remark=obj.getRemark();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("title",this.title);
    map.put("time",this.time);
    map.put("address",this.address);
    map.put("remark",this.remark);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(CustomSchedule obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("title", obj.getTitle());
    map.put("time", obj.getTime());
    map.put("address", obj.getAddress());
    map.put("remark", obj.getRemark());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(CustomSchedule obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("title", JSONObject.toJSONString(obj.getTitle()));
    map.put("time", JSONObject.toJSONString(obj.getTime()));
    map.put("address", JSONObject.toJSONString(obj.getAddress()));
    map.put("remark", JSONObject.toJSONString(obj.getRemark()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public CustomSchedule buildEntity() {
    CustomSchedule obj = new CustomSchedule();
    obj.setId(this.id);
    obj.setTitle(this.title);
    obj.setTime(this.time);
    obj.setAddress(this.address);
    obj.setRemark(this.remark);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static CustomSchedule parseEntity(Map<String, Object> map) {
    CustomSchedule obj = new CustomSchedule();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setTitle((String) map.get("title"));
    obj.setTime((Date) map.get("time"));
    obj.setAddress((String) map.get("address"));
    obj.setRemark((String) map.get("remark"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static CustomSchedule parseSerialEntity(Map<String, String> map) {
    CustomSchedule obj = new CustomSchedule();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setTitle(JSONObject.parseObject(map.get("title"), String.class));
    obj.setTime(JSONObject.parseObject(map.get("time"), Date.class));
    obj.setAddress(JSONObject.parseObject(map.get("address"), String.class));
    obj.setRemark(JSONObject.parseObject(map.get("remark"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static CustomScheduleDO convert(CustomSchedule from, CustomScheduleDO to) {
    if (from == null) return to;
    if (to == null) to = new CustomScheduleDO();
    to.setId(from.getId());
    to.setTitle(from.getTitle());
    to.setTime(from.getTime());
    to.setAddress(from.getAddress());
    to.setRemark(from.getRemark());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static CustomSchedule convert(CustomScheduleDO from, CustomSchedule to) {
    if (from == null) return to;
    if (to == null) to = new CustomSchedule();
    to.setId(from.getId());
    to.setTitle(from.getTitle());
    to.setTime(from.getTime());
    to.setAddress(from.getAddress());
    to.setRemark(from.getRemark());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

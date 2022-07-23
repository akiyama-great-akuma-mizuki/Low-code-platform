package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomScheduleUpdateMapper {
  public String id;

  public String title;

  public Long time;

  public String address;

  public String remark;

  public CustomScheduleUpdateMapper() {
  }

  public CustomScheduleUpdateMapper(String id, String title, Long time, String address,
      String remark) {
    this.id=id;
    this.title=title;
    this.time=time;
    this.address=address;
    this.remark=remark;
  }

  public static CustomScheduleUpdateMapper buildMapper(CustomSchedule obj) {
    CustomScheduleUpdateMapper mapper = new CustomScheduleUpdateMapper();
    mapper.id=obj.getId();
    mapper.title=obj.getTitle();
    mapper.time=obj.modifyTime(obj.getTime());
    mapper.address=obj.getAddress();
    mapper.remark=obj.getRemark();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("title",this.title);
    map.put("time",this.time);
    map.put("address",this.address);
    map.put("remark",this.remark);
    return map;
  }

  public static Map<String, Object> buildMap(CustomSchedule obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("title", obj.getTitle());
    map.put("time", obj.modifyTime(obj.getTime()));
    map.put("address", obj.getAddress());
    map.put("remark", obj.getRemark());
    return map;
  }

  public static Map<String, String> buildSerialMap(CustomSchedule obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("title", JSONObject.toJSONString(obj.getTitle()));
    map.put("time", JSONObject.toJSONString(obj.modifyTime(obj.getTime())));
    map.put("address", JSONObject.toJSONString(obj.getAddress()));
    map.put("remark", JSONObject.toJSONString(obj.getRemark()));
    return map;
  }

  public CustomSchedule buildEntity() {
    CustomSchedule obj = new CustomSchedule();
    obj.setId(this.id);
    obj.setTitle(this.title);
    obj.setTime(obj.recoverTime(this.time));
    obj.setAddress(this.address);
    obj.setRemark(this.remark);
    return obj;
  }

  public static CustomSchedule parseEntity(Map<String, Object> map) {
    CustomSchedule obj = new CustomSchedule();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setTitle((String) map.get("title"));
    obj.setTime(obj.recoverTime((Long) map.get("time")));
    obj.setAddress((String) map.get("address"));
    obj.setRemark((String) map.get("remark"));
    return obj;
  }

  public static CustomSchedule parseSerialEntity(Map<String, String> map) {
    CustomSchedule obj = new CustomSchedule();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setTitle(JSONObject.parseObject(map.get("title"), String.class));
    obj.setTime(obj.recoverTime(JSONObject.parseObject(map.get("time"), Long.class)));
    obj.setAddress(JSONObject.parseObject(map.get("address"), String.class));
    obj.setRemark(JSONObject.parseObject(map.get("remark"), String.class));
    return obj;
  }
}

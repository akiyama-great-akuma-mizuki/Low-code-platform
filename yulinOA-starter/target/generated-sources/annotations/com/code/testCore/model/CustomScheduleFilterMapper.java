package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomScheduleFilterMapper {
  public String id;

  public String title;

  public String address;

  public String remark;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String titleLike = null;

  public Long timeFrom = null;

  public Long timeTo = null;

  public String addressLike = null;

  public String remarkLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public CustomScheduleFilterMapper() {
  }

  public CustomScheduleFilterMapper(String id, String title, String address, String remark) {
    this.id=id;
    this.title=title;
    this.address=address;
    this.remark=remark;
  }

  public static CustomScheduleFilterMapper buildMapper(CustomSchedule obj) {
    CustomScheduleFilterMapper mapper = new CustomScheduleFilterMapper();
    mapper.id=obj.getId();
    mapper.title=obj.getTitle();
    mapper.address=obj.getAddress();
    mapper.remark=obj.getRemark();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("title",this.title);
    map.put("address",this.address);
    map.put("remark",this.remark);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("titleLike",this.titleLike);
    map.put("timeFrom",this.timeFrom);
    map.put("timeTo",this.timeTo);
    map.put("addressLike",this.addressLike);
    map.put("remarkLike",this.remarkLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(CustomSchedule obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("title", obj.getTitle());
    map.put("address", obj.getAddress());
    map.put("remark", obj.getRemark());
    return map;
  }

  public static Map<String, String> buildSerialMap(CustomSchedule obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("title", JSONObject.toJSONString(obj.getTitle()));
    map.put("address", JSONObject.toJSONString(obj.getAddress()));
    map.put("remark", JSONObject.toJSONString(obj.getRemark()));
    return map;
  }

  public CustomSchedule buildEntity() {
    CustomSchedule obj = new CustomSchedule();
    obj.setId(this.id);
    obj.setTitle(this.title);
    obj.setAddress(this.address);
    obj.setRemark(this.remark);
    return obj;
  }

  public static CustomSchedule parseEntity(Map<String, Object> map) {
    CustomSchedule obj = new CustomSchedule();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setTitle((String) map.get("title"));
    obj.setAddress((String) map.get("address"));
    obj.setRemark((String) map.get("remark"));
    return obj;
  }

  public static CustomSchedule parseSerialEntity(Map<String, String> map) {
    CustomSchedule obj = new CustomSchedule();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setTitle(JSONObject.parseObject(map.get("title"), String.class));
    obj.setAddress(JSONObject.parseObject(map.get("address"), String.class));
    obj.setRemark(JSONObject.parseObject(map.get("remark"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(CustomSchedule obj, Long page, Integer rows,
      List<String> orderBy, String titleLike, Long timeFrom, Long timeTo, String addressLike,
      String remarkLike, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("titleLike", titleLike);
    map.put("timeFrom", timeFrom);
    map.put("timeTo", timeTo);
    map.put("addressLike", addressLike);
    map.put("remarkLike", remarkLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(CustomSchedule obj, Long page, Integer rows,
      List<String> orderBy, String titleLike, Long timeFrom, Long timeTo, String addressLike,
      String remarkLike, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("titleLike", JSONObject.toJSONString(titleLike));
    map.put("timeFrom", JSONObject.toJSONString(timeFrom));
    map.put("timeTo", JSONObject.toJSONString(timeTo));
    map.put("addressLike", JSONObject.toJSONString(addressLike));
    map.put("remarkLike", JSONObject.toJSONString(remarkLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

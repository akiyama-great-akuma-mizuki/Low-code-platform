package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SealManageFilterMapper {
  public String id;

  public String name;

  public String number;

  public String pictureUrl;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String nameLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public SealManageFilterMapper() {
  }

  public SealManageFilterMapper(String id, String name, String number, String pictureUrl) {
    this.id=id;
    this.name=name;
    this.number=number;
    this.pictureUrl=pictureUrl;
  }

  public static SealManageFilterMapper buildMapper(SealManage obj) {
    SealManageFilterMapper mapper = new SealManageFilterMapper();
    mapper.id=obj.getId();
    mapper.name=obj.getName();
    mapper.number=obj.getNumber();
    mapper.pictureUrl=obj.getPictureUrl();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("name",this.name);
    map.put("number",this.number);
    map.put("pictureUrl",this.pictureUrl);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("nameLike",this.nameLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(SealManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("name", obj.getName());
    map.put("number", obj.getNumber());
    map.put("pictureUrl", obj.getPictureUrl());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("number", JSONObject.toJSONString(obj.getNumber()));
    map.put("pictureUrl", JSONObject.toJSONString(obj.getPictureUrl()));
    return map;
  }

  public SealManage buildEntity() {
    SealManage obj = new SealManage();
    obj.setId(this.id);
    obj.setName(this.name);
    obj.setNumber(this.number);
    obj.setPictureUrl(this.pictureUrl);
    return obj;
  }

  public static SealManage parseEntity(Map<String, Object> map) {
    SealManage obj = new SealManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setName((String) map.get("name"));
    obj.setNumber((String) map.get("number"));
    obj.setPictureUrl((String) map.get("pictureUrl"));
    return obj;
  }

  public static SealManage parseSerialEntity(Map<String, String> map) {
    SealManage obj = new SealManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setNumber(JSONObject.parseObject(map.get("number"), String.class));
    obj.setPictureUrl(JSONObject.parseObject(map.get("pictureUrl"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(SealManage obj, Long page, Integer rows,
      List<String> orderBy, String nameLike, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("nameLike", nameLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(SealManage obj, Long page, Integer rows,
      List<String> orderBy, String nameLike, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("nameLike", JSONObject.toJSONString(nameLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

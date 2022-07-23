package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealManageUpdateMapper {
  public String id;

  public String name;

  public String number;

  public String pictureUrl;

  public SealManageUpdateMapper() {
  }

  public SealManageUpdateMapper(String id, String name, String number, String pictureUrl) {
    this.id=id;
    this.name=name;
    this.number=number;
    this.pictureUrl=pictureUrl;
  }

  public static SealManageUpdateMapper buildMapper(SealManage obj) {
    SealManageUpdateMapper mapper = new SealManageUpdateMapper();
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
}

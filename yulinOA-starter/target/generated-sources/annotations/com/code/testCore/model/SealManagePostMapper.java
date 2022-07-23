package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealManagePostMapper {
  public String name;

  public String number;

  public String pictureUrl;

  public SealManagePostMapper() {
  }

  public SealManagePostMapper(String name, String number, String pictureUrl) {
    this.name=name;
    this.number=number;
    this.pictureUrl=pictureUrl;
  }

  public static SealManagePostMapper buildMapper(SealManage obj) {
    SealManagePostMapper mapper = new SealManagePostMapper();
    mapper.name=obj.getName();
    mapper.number=obj.getNumber();
    mapper.pictureUrl=obj.getPictureUrl();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("name",this.name);
    map.put("number",this.number);
    map.put("pictureUrl",this.pictureUrl);
    return map;
  }

  public static Map<String, Object> buildMap(SealManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("name", obj.getName());
    map.put("number", obj.getNumber());
    map.put("pictureUrl", obj.getPictureUrl());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("number", JSONObject.toJSONString(obj.getNumber()));
    map.put("pictureUrl", JSONObject.toJSONString(obj.getPictureUrl()));
    return map;
  }

  public SealManage buildEntity() {
    SealManage obj = new SealManage();
    obj.setName(this.name);
    obj.setNumber(this.number);
    obj.setPictureUrl(this.pictureUrl);
    return obj;
  }

  public static SealManage parseEntity(Map<String, Object> map) {
    SealManage obj = new SealManage();
    if (map == null) return obj;
    obj.setName((String) map.get("name"));
    obj.setNumber((String) map.get("number"));
    obj.setPictureUrl((String) map.get("pictureUrl"));
    return obj;
  }

  public static SealManage parseSerialEntity(Map<String, String> map) {
    SealManage obj = new SealManage();
    if (map == null) return obj;
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setNumber(JSONObject.parseObject(map.get("number"), String.class));
    obj.setPictureUrl(JSONObject.parseObject(map.get("pictureUrl"), String.class));
    return obj;
  }
}

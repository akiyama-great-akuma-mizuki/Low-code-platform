package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealManageDetailMapper {
  public String id;

  public String name;

  public String number;

  public String pictureUrl;

  public Long gmtUpdate;

  public Long gmtCreate;

  public SealManageDetailMapper() {
  }

  public SealManageDetailMapper(String id, String name, String number, String pictureUrl,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.name=name;
    this.number=number;
    this.pictureUrl=pictureUrl;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static SealManageDetailMapper buildMapper(SealManage obj) {
    SealManageDetailMapper mapper = new SealManageDetailMapper();
    mapper.id=obj.getId();
    mapper.name=obj.getName();
    mapper.number=obj.getNumber();
    mapper.pictureUrl=obj.getPictureUrl();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("name",this.name);
    map.put("number",this.number);
    map.put("pictureUrl",this.pictureUrl);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(SealManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("name", obj.getName());
    map.put("number", obj.getNumber());
    map.put("pictureUrl", obj.getPictureUrl());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(SealManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("number", JSONObject.toJSONString(obj.getNumber()));
    map.put("pictureUrl", JSONObject.toJSONString(obj.getPictureUrl()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public SealManage buildEntity() {
    SealManage obj = new SealManage();
    obj.setId(this.id);
    obj.setName(this.name);
    obj.setNumber(this.number);
    obj.setPictureUrl(this.pictureUrl);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static SealManage parseEntity(Map<String, Object> map) {
    SealManage obj = new SealManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setName((String) map.get("name"));
    obj.setNumber((String) map.get("number"));
    obj.setPictureUrl((String) map.get("pictureUrl"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static SealManage parseSerialEntity(Map<String, String> map) {
    SealManage obj = new SealManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setNumber(JSONObject.parseObject(map.get("number"), String.class));
    obj.setPictureUrl(JSONObject.parseObject(map.get("pictureUrl"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

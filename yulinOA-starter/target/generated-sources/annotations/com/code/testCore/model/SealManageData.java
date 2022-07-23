package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.SealManageDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealManageData {
  public String id;

  public String name;

  public String number;

  public String pictureUrl;

  public Date gmtUpdate;

  public Date gmtCreate;

  public SealManageData() {
  }

  public SealManageData(String id, String name, String number, String pictureUrl, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.name=name;
    this.number=number;
    this.pictureUrl=pictureUrl;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static SealManageData buildMapper(SealManage obj) {
    SealManageData mapper = new SealManageData();
    mapper.id=obj.getId();
    mapper.name=obj.getName();
    mapper.number=obj.getNumber();
    mapper.pictureUrl=obj.getPictureUrl();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("number", JSONObject.toJSONString(obj.getNumber()));
    map.put("pictureUrl", JSONObject.toJSONString(obj.getPictureUrl()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public SealManage buildEntity() {
    SealManage obj = new SealManage();
    obj.setId(this.id);
    obj.setName(this.name);
    obj.setNumber(this.number);
    obj.setPictureUrl(this.pictureUrl);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static SealManage parseEntity(Map<String, Object> map) {
    SealManage obj = new SealManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setName((String) map.get("name"));
    obj.setNumber((String) map.get("number"));
    obj.setPictureUrl((String) map.get("pictureUrl"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static SealManage parseSerialEntity(Map<String, String> map) {
    SealManage obj = new SealManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setNumber(JSONObject.parseObject(map.get("number"), String.class));
    obj.setPictureUrl(JSONObject.parseObject(map.get("pictureUrl"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static SealManageDO convert(SealManage from, SealManageDO to) {
    if (from == null) return to;
    if (to == null) to = new SealManageDO();
    to.setId(from.getId());
    to.setName(from.getName());
    to.setNumber(from.getNumber());
    to.setPictureUrl(from.getPictureUrl());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static SealManage convert(SealManageDO from, SealManage to) {
    if (from == null) return to;
    if (to == null) to = new SealManage();
    to.setId(from.getId());
    to.setName(from.getName());
    to.setNumber(from.getNumber());
    to.setPictureUrl(from.getPictureUrl());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

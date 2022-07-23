package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class NewsSimpleMapper {
  public String id;

  public String newsTitle;

  public String publisher;

  public Long releaseTime;

  public String releaseDepartment;

  public String file;

  public String detailContent;

  public String newsImg;

  public Long gmtUpdate;

  public Long gmtCreate;

  public NewsSimpleMapper() {
  }

  public NewsSimpleMapper(String id, String newsTitle, String publisher, Long releaseTime,
      String releaseDepartment, String file, String detailContent, String newsImg, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.newsTitle=newsTitle;
    this.publisher=publisher;
    this.releaseTime=releaseTime;
    this.releaseDepartment=releaseDepartment;
    this.file=file;
    this.detailContent=detailContent;
    this.newsImg=newsImg;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static NewsSimpleMapper buildMapper(News obj) {
    NewsSimpleMapper mapper = new NewsSimpleMapper();
    mapper.id=obj.getId();
    mapper.newsTitle=obj.getNewsTitle();
    mapper.publisher=obj.getPublisher();
    mapper.releaseTime=obj.modifyTime(obj.getReleaseTime());
    mapper.releaseDepartment=obj.getReleaseDepartment();
    mapper.file=obj.getFile();
    mapper.detailContent=obj.getDetailContent();
    mapper.newsImg=obj.getNewsImg();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("newsTitle",this.newsTitle);
    map.put("publisher",this.publisher);
    map.put("releaseTime",this.releaseTime);
    map.put("releaseDepartment",this.releaseDepartment);
    map.put("file",this.file);
    map.put("detailContent",this.detailContent);
    map.put("newsImg",this.newsImg);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(News obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("newsTitle", obj.getNewsTitle());
    map.put("publisher", obj.getPublisher());
    map.put("releaseTime", obj.modifyTime(obj.getReleaseTime()));
    map.put("releaseDepartment", obj.getReleaseDepartment());
    map.put("file", obj.getFile());
    map.put("detailContent", obj.getDetailContent());
    map.put("newsImg", obj.getNewsImg());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(News obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("newsTitle", JSONObject.toJSONString(obj.getNewsTitle()));
    map.put("publisher", JSONObject.toJSONString(obj.getPublisher()));
    map.put("releaseTime", JSONObject.toJSONString(obj.modifyTime(obj.getReleaseTime())));
    map.put("releaseDepartment", JSONObject.toJSONString(obj.getReleaseDepartment()));
    map.put("file", JSONObject.toJSONString(obj.getFile()));
    map.put("detailContent", JSONObject.toJSONString(obj.getDetailContent()));
    map.put("newsImg", JSONObject.toJSONString(obj.getNewsImg()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public News buildEntity() {
    News obj = new News();
    obj.setId(this.id);
    obj.setNewsTitle(this.newsTitle);
    obj.setPublisher(this.publisher);
    obj.setReleaseTime(obj.recoverTime(this.releaseTime));
    obj.setReleaseDepartment(this.releaseDepartment);
    obj.setFile(this.file);
    obj.setDetailContent(this.detailContent);
    obj.setNewsImg(this.newsImg);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static News parseEntity(Map<String, Object> map) {
    News obj = new News();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setNewsTitle((String) map.get("newsTitle"));
    obj.setPublisher((String) map.get("publisher"));
    obj.setReleaseTime(obj.recoverTime((Long) map.get("releaseTime")));
    obj.setReleaseDepartment((String) map.get("releaseDepartment"));
    obj.setFile((String) map.get("file"));
    obj.setDetailContent((String) map.get("detailContent"));
    obj.setNewsImg((String) map.get("newsImg"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static News parseSerialEntity(Map<String, String> map) {
    News obj = new News();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setNewsTitle(JSONObject.parseObject(map.get("newsTitle"), String.class));
    obj.setPublisher(JSONObject.parseObject(map.get("publisher"), String.class));
    obj.setReleaseTime(obj.recoverTime(JSONObject.parseObject(map.get("releaseTime"), Long.class)));
    obj.setReleaseDepartment(JSONObject.parseObject(map.get("releaseDepartment"), String.class));
    obj.setFile(JSONObject.parseObject(map.get("file"), String.class));
    obj.setDetailContent(JSONObject.parseObject(map.get("detailContent"), String.class));
    obj.setNewsImg(JSONObject.parseObject(map.get("newsImg"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

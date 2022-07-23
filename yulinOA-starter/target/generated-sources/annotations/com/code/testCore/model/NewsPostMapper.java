package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class NewsPostMapper {
  public String newsTitle;

  public String publisher;

  public Long releaseTime;

  public String releaseDepartment;

  public String file;

  public String detailContent;

  public String newsImg;

  public NewsPostMapper() {
  }

  public NewsPostMapper(String newsTitle, String publisher, Long releaseTime,
      String releaseDepartment, String file, String detailContent, String newsImg) {
    this.newsTitle=newsTitle;
    this.publisher=publisher;
    this.releaseTime=releaseTime;
    this.releaseDepartment=releaseDepartment;
    this.file=file;
    this.detailContent=detailContent;
    this.newsImg=newsImg;
  }

  public static NewsPostMapper buildMapper(News obj) {
    NewsPostMapper mapper = new NewsPostMapper();
    mapper.newsTitle=obj.getNewsTitle();
    mapper.publisher=obj.getPublisher();
    mapper.releaseTime=obj.modifyTime(obj.getReleaseTime());
    mapper.releaseDepartment=obj.getReleaseDepartment();
    mapper.file=obj.getFile();
    mapper.detailContent=obj.getDetailContent();
    mapper.newsImg=obj.getNewsImg();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("newsTitle",this.newsTitle);
    map.put("publisher",this.publisher);
    map.put("releaseTime",this.releaseTime);
    map.put("releaseDepartment",this.releaseDepartment);
    map.put("file",this.file);
    map.put("detailContent",this.detailContent);
    map.put("newsImg",this.newsImg);
    return map;
  }

  public static Map<String, Object> buildMap(News obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("newsTitle", obj.getNewsTitle());
    map.put("publisher", obj.getPublisher());
    map.put("releaseTime", obj.modifyTime(obj.getReleaseTime()));
    map.put("releaseDepartment", obj.getReleaseDepartment());
    map.put("file", obj.getFile());
    map.put("detailContent", obj.getDetailContent());
    map.put("newsImg", obj.getNewsImg());
    return map;
  }

  public static Map<String, String> buildSerialMap(News obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("newsTitle", JSONObject.toJSONString(obj.getNewsTitle()));
    map.put("publisher", JSONObject.toJSONString(obj.getPublisher()));
    map.put("releaseTime", JSONObject.toJSONString(obj.modifyTime(obj.getReleaseTime())));
    map.put("releaseDepartment", JSONObject.toJSONString(obj.getReleaseDepartment()));
    map.put("file", JSONObject.toJSONString(obj.getFile()));
    map.put("detailContent", JSONObject.toJSONString(obj.getDetailContent()));
    map.put("newsImg", JSONObject.toJSONString(obj.getNewsImg()));
    return map;
  }

  public News buildEntity() {
    News obj = new News();
    obj.setNewsTitle(this.newsTitle);
    obj.setPublisher(this.publisher);
    obj.setReleaseTime(obj.recoverTime(this.releaseTime));
    obj.setReleaseDepartment(this.releaseDepartment);
    obj.setFile(this.file);
    obj.setDetailContent(this.detailContent);
    obj.setNewsImg(this.newsImg);
    return obj;
  }

  public static News parseEntity(Map<String, Object> map) {
    News obj = new News();
    if (map == null) return obj;
    obj.setNewsTitle((String) map.get("newsTitle"));
    obj.setPublisher((String) map.get("publisher"));
    obj.setReleaseTime(obj.recoverTime((Long) map.get("releaseTime")));
    obj.setReleaseDepartment((String) map.get("releaseDepartment"));
    obj.setFile((String) map.get("file"));
    obj.setDetailContent((String) map.get("detailContent"));
    obj.setNewsImg((String) map.get("newsImg"));
    return obj;
  }

  public static News parseSerialEntity(Map<String, String> map) {
    News obj = new News();
    if (map == null) return obj;
    obj.setNewsTitle(JSONObject.parseObject(map.get("newsTitle"), String.class));
    obj.setPublisher(JSONObject.parseObject(map.get("publisher"), String.class));
    obj.setReleaseTime(obj.recoverTime(JSONObject.parseObject(map.get("releaseTime"), Long.class)));
    obj.setReleaseDepartment(JSONObject.parseObject(map.get("releaseDepartment"), String.class));
    obj.setFile(JSONObject.parseObject(map.get("file"), String.class));
    obj.setDetailContent(JSONObject.parseObject(map.get("detailContent"), String.class));
    obj.setNewsImg(JSONObject.parseObject(map.get("newsImg"), String.class));
    return obj;
  }
}

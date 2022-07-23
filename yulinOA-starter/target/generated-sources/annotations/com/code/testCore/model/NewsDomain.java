package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.NewsTO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class NewsDomain {
  public String id;

  public String newsTitle;

  public String publisher;

  public Date releaseTime;

  public String releaseDepartment;

  public String file;

  public String detailContent;

  public String newsImg;

  public Date gmtUpdate;

  public Date gmtCreate;

  public NewsDomain() {
  }

  public NewsDomain(String id, String newsTitle, String publisher, Date releaseTime,
      String releaseDepartment, String file, String detailContent, String newsImg, Date gmtUpdate,
      Date gmtCreate) {
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

  public static NewsDomain buildMapper(News obj) {
    NewsDomain mapper = new NewsDomain();
    mapper.id=obj.getId();
    mapper.newsTitle=obj.getNewsTitle();
    mapper.publisher=obj.getPublisher();
    mapper.releaseTime=obj.getReleaseTime();
    mapper.releaseDepartment=obj.getReleaseDepartment();
    mapper.file=obj.getFile();
    mapper.detailContent=obj.getDetailContent();
    mapper.newsImg=obj.getNewsImg();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("releaseTime", obj.getReleaseTime());
    map.put("releaseDepartment", obj.getReleaseDepartment());
    map.put("file", obj.getFile());
    map.put("detailContent", obj.getDetailContent());
    map.put("newsImg", obj.getNewsImg());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(News obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("newsTitle", JSONObject.toJSONString(obj.getNewsTitle()));
    map.put("publisher", JSONObject.toJSONString(obj.getPublisher()));
    map.put("releaseTime", JSONObject.toJSONString(obj.getReleaseTime()));
    map.put("releaseDepartment", JSONObject.toJSONString(obj.getReleaseDepartment()));
    map.put("file", JSONObject.toJSONString(obj.getFile()));
    map.put("detailContent", JSONObject.toJSONString(obj.getDetailContent()));
    map.put("newsImg", JSONObject.toJSONString(obj.getNewsImg()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public News buildEntity() {
    News obj = new News();
    obj.setId(this.id);
    obj.setNewsTitle(this.newsTitle);
    obj.setPublisher(this.publisher);
    obj.setReleaseTime(this.releaseTime);
    obj.setReleaseDepartment(this.releaseDepartment);
    obj.setFile(this.file);
    obj.setDetailContent(this.detailContent);
    obj.setNewsImg(this.newsImg);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static News parseEntity(Map<String, Object> map) {
    News obj = new News();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setNewsTitle((String) map.get("newsTitle"));
    obj.setPublisher((String) map.get("publisher"));
    obj.setReleaseTime((Date) map.get("releaseTime"));
    obj.setReleaseDepartment((String) map.get("releaseDepartment"));
    obj.setFile((String) map.get("file"));
    obj.setDetailContent((String) map.get("detailContent"));
    obj.setNewsImg((String) map.get("newsImg"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static News parseSerialEntity(Map<String, String> map) {
    News obj = new News();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setNewsTitle(JSONObject.parseObject(map.get("newsTitle"), String.class));
    obj.setPublisher(JSONObject.parseObject(map.get("publisher"), String.class));
    obj.setReleaseTime(JSONObject.parseObject(map.get("releaseTime"), Date.class));
    obj.setReleaseDepartment(JSONObject.parseObject(map.get("releaseDepartment"), String.class));
    obj.setFile(JSONObject.parseObject(map.get("file"), String.class));
    obj.setDetailContent(JSONObject.parseObject(map.get("detailContent"), String.class));
    obj.setNewsImg(JSONObject.parseObject(map.get("newsImg"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static NewsTO convert(News from, NewsTO to) {
    if (from == null) return to;
    if (to == null) to = new NewsTO();
    to.setId(from.getId());
    to.setNewsTitle(from.getNewsTitle());
    to.setPublisher(from.getPublisher());
    to.setReleaseTime(from.getReleaseTime());
    to.setReleaseDepartment(from.getReleaseDepartment());
    to.setFile(from.getFile());
    to.setDetailContent(from.getDetailContent());
    to.setNewsImg(from.getNewsImg());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static News convert(NewsTO from, News to) {
    if (from == null) return to;
    if (to == null) to = new News();
    to.setId(from.getId());
    to.setNewsTitle(from.getNewsTitle());
    to.setPublisher(from.getPublisher());
    to.setReleaseTime(from.getReleaseTime());
    to.setReleaseDepartment(from.getReleaseDepartment());
    to.setFile(from.getFile());
    to.setDetailContent(from.getDetailContent());
    to.setNewsImg(from.getNewsImg());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

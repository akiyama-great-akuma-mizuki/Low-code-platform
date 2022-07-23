package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NewsFilterMapper {
  public String id;

  public String newsTitle;

  public String publisher;

  public String releaseDepartment;

  public String file;

  public String detailContent;

  public String newsImg;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String newsTitleLike = null;

  public List<String> newsTitleIn = null;

  public String publisherLike = null;

  public List<String> publisherIn = null;

  public String releaseDepartmentLike = null;

  public List<String> releaseDepartmentIn = null;

  public String detailContentLike = null;

  public String newsImgLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public NewsFilterMapper() {
  }

  public NewsFilterMapper(String id, String newsTitle, String publisher, String releaseDepartment,
      String file, String detailContent, String newsImg) {
    this.id=id;
    this.newsTitle=newsTitle;
    this.publisher=publisher;
    this.releaseDepartment=releaseDepartment;
    this.file=file;
    this.detailContent=detailContent;
    this.newsImg=newsImg;
  }

  public static NewsFilterMapper buildMapper(News obj) {
    NewsFilterMapper mapper = new NewsFilterMapper();
    mapper.id=obj.getId();
    mapper.newsTitle=obj.getNewsTitle();
    mapper.publisher=obj.getPublisher();
    mapper.releaseDepartment=obj.getReleaseDepartment();
    mapper.file=obj.getFile();
    mapper.detailContent=obj.getDetailContent();
    mapper.newsImg=obj.getNewsImg();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("newsTitle",this.newsTitle);
    map.put("publisher",this.publisher);
    map.put("releaseDepartment",this.releaseDepartment);
    map.put("file",this.file);
    map.put("detailContent",this.detailContent);
    map.put("newsImg",this.newsImg);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("newsTitleLike",this.newsTitleLike);
    map.put("newsTitleIn",this.newsTitleIn);
    map.put("publisherLike",this.publisherLike);
    map.put("publisherIn",this.publisherIn);
    map.put("releaseDepartmentLike",this.releaseDepartmentLike);
    map.put("releaseDepartmentIn",this.releaseDepartmentIn);
    map.put("detailContentLike",this.detailContentLike);
    map.put("newsImgLike",this.newsImgLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(News obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("newsTitle", obj.getNewsTitle());
    map.put("publisher", obj.getPublisher());
    map.put("releaseDepartment", obj.getReleaseDepartment());
    map.put("file", obj.getFile());
    map.put("detailContent", obj.getDetailContent());
    map.put("newsImg", obj.getNewsImg());
    return map;
  }

  public static Map<String, String> buildSerialMap(News obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("newsTitle", JSONObject.toJSONString(obj.getNewsTitle()));
    map.put("publisher", JSONObject.toJSONString(obj.getPublisher()));
    map.put("releaseDepartment", JSONObject.toJSONString(obj.getReleaseDepartment()));
    map.put("file", JSONObject.toJSONString(obj.getFile()));
    map.put("detailContent", JSONObject.toJSONString(obj.getDetailContent()));
    map.put("newsImg", JSONObject.toJSONString(obj.getNewsImg()));
    return map;
  }

  public News buildEntity() {
    News obj = new News();
    obj.setId(this.id);
    obj.setNewsTitle(this.newsTitle);
    obj.setPublisher(this.publisher);
    obj.setReleaseDepartment(this.releaseDepartment);
    obj.setFile(this.file);
    obj.setDetailContent(this.detailContent);
    obj.setNewsImg(this.newsImg);
    return obj;
  }

  public static News parseEntity(Map<String, Object> map) {
    News obj = new News();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setNewsTitle((String) map.get("newsTitle"));
    obj.setPublisher((String) map.get("publisher"));
    obj.setReleaseDepartment((String) map.get("releaseDepartment"));
    obj.setFile((String) map.get("file"));
    obj.setDetailContent((String) map.get("detailContent"));
    obj.setNewsImg((String) map.get("newsImg"));
    return obj;
  }

  public static News parseSerialEntity(Map<String, String> map) {
    News obj = new News();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setNewsTitle(JSONObject.parseObject(map.get("newsTitle"), String.class));
    obj.setPublisher(JSONObject.parseObject(map.get("publisher"), String.class));
    obj.setReleaseDepartment(JSONObject.parseObject(map.get("releaseDepartment"), String.class));
    obj.setFile(JSONObject.parseObject(map.get("file"), String.class));
    obj.setDetailContent(JSONObject.parseObject(map.get("detailContent"), String.class));
    obj.setNewsImg(JSONObject.parseObject(map.get("newsImg"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(News obj, Long page, Integer rows,
      List<String> orderBy, String newsTitleLike, List<String> newsTitleIn, String publisherLike,
      List<String> publisherIn, String releaseDepartmentLike, List<String> releaseDepartmentIn,
      String detailContentLike, String newsImgLike, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("newsTitleLike", newsTitleLike);
    map.put("newsTitleIn", newsTitleIn);
    map.put("publisherLike", publisherLike);
    map.put("publisherIn", publisherIn);
    map.put("releaseDepartmentLike", releaseDepartmentLike);
    map.put("releaseDepartmentIn", releaseDepartmentIn);
    map.put("detailContentLike", detailContentLike);
    map.put("newsImgLike", newsImgLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(News obj, Long page, Integer rows,
      List<String> orderBy, String newsTitleLike, List<String> newsTitleIn, String publisherLike,
      List<String> publisherIn, String releaseDepartmentLike, List<String> releaseDepartmentIn,
      String detailContentLike, String newsImgLike, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("newsTitleLike", JSONObject.toJSONString(newsTitleLike));
    map.put("newsTitleIn", JSONObject.toJSONString(newsTitleIn));
    map.put("publisherLike", JSONObject.toJSONString(publisherLike));
    map.put("publisherIn", JSONObject.toJSONString(publisherIn));
    map.put("releaseDepartmentLike", JSONObject.toJSONString(releaseDepartmentLike));
    map.put("releaseDepartmentIn", JSONObject.toJSONString(releaseDepartmentIn));
    map.put("detailContentLike", JSONObject.toJSONString(detailContentLike));
    map.put("newsImgLike", JSONObject.toJSONString(newsImgLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KnowledgeFilterMapper {
  public String id;

  public String knowledgeName;

  public String upload;

  public String lookUp;

  public String describe;

  public String contentDetail;

  public Integer browse;

  public String accessory;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String knowledgeNameLike = null;

  public List<String> knowledgeNameIn = null;

  public String uploadLike = null;

  public List<String> uploadIn = null;

  public String lookUpLike = null;

  public List<String> lookUpIn = null;

  public String describeLike = null;

  public List<String> describeIn = null;

  public String contentDetailLike = null;

  public List<Integer> browseIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public KnowledgeFilterMapper() {
  }

  public KnowledgeFilterMapper(String id, String knowledgeName, String upload, String lookUp,
      String describe, String contentDetail, Integer browse, String accessory) {
    this.id=id;
    this.knowledgeName=knowledgeName;
    this.upload=upload;
    this.lookUp=lookUp;
    this.describe=describe;
    this.contentDetail=contentDetail;
    this.browse=browse;
    this.accessory=accessory;
  }

  public static KnowledgeFilterMapper buildMapper(Knowledge obj) {
    KnowledgeFilterMapper mapper = new KnowledgeFilterMapper();
    mapper.id=obj.getId();
    mapper.knowledgeName=obj.getKnowledgeName();
    mapper.upload=obj.getUpload();
    mapper.lookUp=obj.getLookUp();
    mapper.describe=obj.getDescribe();
    mapper.contentDetail=obj.getContentDetail();
    mapper.browse=obj.getBrowse();
    mapper.accessory=obj.getAccessory();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("knowledgeName",this.knowledgeName);
    map.put("upload",this.upload);
    map.put("lookUp",this.lookUp);
    map.put("describe",this.describe);
    map.put("contentDetail",this.contentDetail);
    map.put("browse",this.browse);
    map.put("accessory",this.accessory);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("knowledgeNameLike",this.knowledgeNameLike);
    map.put("knowledgeNameIn",this.knowledgeNameIn);
    map.put("uploadLike",this.uploadLike);
    map.put("uploadIn",this.uploadIn);
    map.put("lookUpLike",this.lookUpLike);
    map.put("lookUpIn",this.lookUpIn);
    map.put("describeLike",this.describeLike);
    map.put("describeIn",this.describeIn);
    map.put("contentDetailLike",this.contentDetailLike);
    map.put("browseIn",this.browseIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Knowledge obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("knowledgeName", obj.getKnowledgeName());
    map.put("upload", obj.getUpload());
    map.put("lookUp", obj.getLookUp());
    map.put("describe", obj.getDescribe());
    map.put("contentDetail", obj.getContentDetail());
    map.put("browse", obj.getBrowse());
    map.put("accessory", obj.getAccessory());
    return map;
  }

  public static Map<String, String> buildSerialMap(Knowledge obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("knowledgeName", JSONObject.toJSONString(obj.getKnowledgeName()));
    map.put("upload", JSONObject.toJSONString(obj.getUpload()));
    map.put("lookUp", JSONObject.toJSONString(obj.getLookUp()));
    map.put("describe", JSONObject.toJSONString(obj.getDescribe()));
    map.put("contentDetail", JSONObject.toJSONString(obj.getContentDetail()));
    map.put("browse", JSONObject.toJSONString(obj.getBrowse()));
    map.put("accessory", JSONObject.toJSONString(obj.getAccessory()));
    return map;
  }

  public Knowledge buildEntity() {
    Knowledge obj = new Knowledge();
    obj.setId(this.id);
    obj.setKnowledgeName(this.knowledgeName);
    obj.setUpload(this.upload);
    obj.setLookUp(this.lookUp);
    obj.setDescribe(this.describe);
    obj.setContentDetail(this.contentDetail);
    obj.setBrowse(this.browse);
    obj.setAccessory(this.accessory);
    return obj;
  }

  public static Knowledge parseEntity(Map<String, Object> map) {
    Knowledge obj = new Knowledge();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setKnowledgeName((String) map.get("knowledgeName"));
    obj.setUpload((String) map.get("upload"));
    obj.setLookUp((String) map.get("lookUp"));
    obj.setDescribe((String) map.get("describe"));
    obj.setContentDetail((String) map.get("contentDetail"));
    obj.setBrowse((Integer) map.get("browse"));
    obj.setAccessory((String) map.get("accessory"));
    return obj;
  }

  public static Knowledge parseSerialEntity(Map<String, String> map) {
    Knowledge obj = new Knowledge();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setKnowledgeName(JSONObject.parseObject(map.get("knowledgeName"), String.class));
    obj.setUpload(JSONObject.parseObject(map.get("upload"), String.class));
    obj.setLookUp(JSONObject.parseObject(map.get("lookUp"), String.class));
    obj.setDescribe(JSONObject.parseObject(map.get("describe"), String.class));
    obj.setContentDetail(JSONObject.parseObject(map.get("contentDetail"), String.class));
    obj.setBrowse(JSONObject.parseObject(map.get("browse"), Integer.class));
    obj.setAccessory(JSONObject.parseObject(map.get("accessory"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Knowledge obj, Long page, Integer rows,
      List<String> orderBy, String knowledgeNameLike, List<String> knowledgeNameIn,
      String uploadLike, List<String> uploadIn, String lookUpLike, List<String> lookUpIn,
      String describeLike, List<String> describeIn, String contentDetailLike,
      List<Integer> browseIn, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("knowledgeNameLike", knowledgeNameLike);
    map.put("knowledgeNameIn", knowledgeNameIn);
    map.put("uploadLike", uploadLike);
    map.put("uploadIn", uploadIn);
    map.put("lookUpLike", lookUpLike);
    map.put("lookUpIn", lookUpIn);
    map.put("describeLike", describeLike);
    map.put("describeIn", describeIn);
    map.put("contentDetailLike", contentDetailLike);
    map.put("browseIn", browseIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Knowledge obj, Long page, Integer rows,
      List<String> orderBy, String knowledgeNameLike, List<String> knowledgeNameIn,
      String uploadLike, List<String> uploadIn, String lookUpLike, List<String> lookUpIn,
      String describeLike, List<String> describeIn, String contentDetailLike,
      List<Integer> browseIn, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("knowledgeNameLike", JSONObject.toJSONString(knowledgeNameLike));
    map.put("knowledgeNameIn", JSONObject.toJSONString(knowledgeNameIn));
    map.put("uploadLike", JSONObject.toJSONString(uploadLike));
    map.put("uploadIn", JSONObject.toJSONString(uploadIn));
    map.put("lookUpLike", JSONObject.toJSONString(lookUpLike));
    map.put("lookUpIn", JSONObject.toJSONString(lookUpIn));
    map.put("describeLike", JSONObject.toJSONString(describeLike));
    map.put("describeIn", JSONObject.toJSONString(describeIn));
    map.put("contentDetailLike", JSONObject.toJSONString(contentDetailLike));
    map.put("browseIn", JSONObject.toJSONString(browseIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

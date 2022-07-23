package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.ArchiveManageDO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArchiveManageData {
  public String id;

  public String name;

  public String department;

  public String description;

  public Integer browseTimes;

  public String contentUrl;

  public String uploadUserId;

  public Date uploadTime;

  public String archiveDetailId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public ArchiveManageData() {
  }

  public ArchiveManageData(String id, String name, String department, String description,
      Integer browseTimes, String contentUrl, String uploadUserId, Date uploadTime,
      String archiveDetailId, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.name=name;
    this.department=department;
    this.description=description;
    this.browseTimes=browseTimes;
    this.contentUrl=contentUrl;
    this.uploadUserId=uploadUserId;
    this.uploadTime=uploadTime;
    this.archiveDetailId=archiveDetailId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static ArchiveManageData buildMapper(ArchiveManage obj) {
    ArchiveManageData mapper = new ArchiveManageData();
    mapper.id=obj.getId();
    mapper.name=obj.getName();
    mapper.department=obj.getDepartment();
    mapper.description=obj.getDescription();
    mapper.browseTimes=obj.getBrowseTimes();
    mapper.contentUrl=obj.getContentUrl();
    mapper.uploadUserId=obj.getUploadUserId();
    mapper.uploadTime=obj.getUploadTime();
    mapper.archiveDetailId=obj.getArchiveDetailId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("name",this.name);
    map.put("department",this.department);
    map.put("description",this.description);
    map.put("browseTimes",this.browseTimes);
    map.put("contentUrl",this.contentUrl);
    map.put("uploadUserId",this.uploadUserId);
    map.put("uploadTime",this.uploadTime);
    map.put("archiveDetailId",this.archiveDetailId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(ArchiveManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("name", obj.getName());
    map.put("department", obj.getDepartment());
    map.put("description", obj.getDescription());
    map.put("browseTimes", obj.getBrowseTimes());
    map.put("contentUrl", obj.getContentUrl());
    map.put("uploadUserId", obj.getUploadUserId());
    map.put("uploadTime", obj.getUploadTime());
    map.put("archiveDetailId", obj.getArchiveDetailId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(ArchiveManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("department", JSONObject.toJSONString(obj.getDepartment()));
    map.put("description", JSONObject.toJSONString(obj.getDescription()));
    map.put("browseTimes", JSONObject.toJSONString(obj.getBrowseTimes()));
    map.put("contentUrl", JSONObject.toJSONString(obj.getContentUrl()));
    map.put("uploadUserId", JSONObject.toJSONString(obj.getUploadUserId()));
    map.put("uploadTime", JSONObject.toJSONString(obj.getUploadTime()));
    map.put("archiveDetailId", JSONObject.toJSONString(obj.getArchiveDetailId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public ArchiveManage buildEntity() {
    ArchiveManage obj = new ArchiveManage();
    obj.setId(this.id);
    obj.setName(this.name);
    obj.setDepartment(this.department);
    obj.setDescription(this.description);
    obj.setBrowseTimes(this.browseTimes);
    obj.setContentUrl(this.contentUrl);
    obj.setUploadUserId(this.uploadUserId);
    obj.setUploadTime(this.uploadTime);
    obj.setArchiveDetailId(this.archiveDetailId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static ArchiveManage parseEntity(Map<String, Object> map) {
    ArchiveManage obj = new ArchiveManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setName((String) map.get("name"));
    obj.setDepartment((String) map.get("department"));
    obj.setDescription((String) map.get("description"));
    obj.setBrowseTimes((Integer) map.get("browseTimes"));
    obj.setContentUrl((String) map.get("contentUrl"));
    obj.setUploadUserId((String) map.get("uploadUserId"));
    obj.setUploadTime((Date) map.get("uploadTime"));
    obj.setArchiveDetailId((String) map.get("archiveDetailId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static ArchiveManage parseSerialEntity(Map<String, String> map) {
    ArchiveManage obj = new ArchiveManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setDepartment(JSONObject.parseObject(map.get("department"), String.class));
    obj.setDescription(JSONObject.parseObject(map.get("description"), String.class));
    obj.setBrowseTimes(JSONObject.parseObject(map.get("browseTimes"), Integer.class));
    obj.setContentUrl(JSONObject.parseObject(map.get("contentUrl"), String.class));
    obj.setUploadUserId(JSONObject.parseObject(map.get("uploadUserId"), String.class));
    obj.setUploadTime(JSONObject.parseObject(map.get("uploadTime"), Date.class));
    obj.setArchiveDetailId(JSONObject.parseObject(map.get("archiveDetailId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static ArchiveManageDO convert(ArchiveManage from, ArchiveManageDO to) {
    if (from == null) return to;
    if (to == null) to = new ArchiveManageDO();
    to.setId(from.getId());
    to.setName(from.getName());
    to.setDepartment(from.getDepartment());
    to.setDescription(from.getDescription());
    to.setBrowseTimes(from.getBrowseTimes());
    to.setContentUrl(from.getContentUrl());
    to.setUploadUserId(from.getUploadUserId());
    to.setUploadTime(from.getUploadTime());
    to.setArchiveDetailId(from.getArchiveDetailId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static ArchiveManage convert(ArchiveManageDO from, ArchiveManage to) {
    if (from == null) return to;
    if (to == null) to = new ArchiveManage();
    to.setId(from.getId());
    to.setName(from.getName());
    to.setDepartment(from.getDepartment());
    to.setDescription(from.getDescription());
    to.setBrowseTimes(from.getBrowseTimes());
    to.setContentUrl(from.getContentUrl());
    to.setUploadUserId(from.getUploadUserId());
    to.setUploadTime(from.getUploadTime());
    to.setArchiveDetailId(from.getArchiveDetailId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

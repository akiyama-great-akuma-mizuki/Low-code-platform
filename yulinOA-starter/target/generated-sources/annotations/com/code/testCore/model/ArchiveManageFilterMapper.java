package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ArchiveManageFilterMapper {
  public String id;

  public String name;

  public String department;

  public String description;

  public Integer browseTimes;

  public String contentUrl;

  public String uploadUserId;

  public String archiveDetailId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public List<String> departmentIn = null;

  public Integer browseTimesFrom = null;

  public Integer browseTimesTo = null;

  public Long uploadTimeFrom = null;

  public Long uploadTimeTo = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public ArchiveManageFilterMapper() {
  }

  public ArchiveManageFilterMapper(String id, String name, String department, String description,
      Integer browseTimes, String contentUrl, String uploadUserId, String archiveDetailId) {
    this.id=id;
    this.name=name;
    this.department=department;
    this.description=description;
    this.browseTimes=browseTimes;
    this.contentUrl=contentUrl;
    this.uploadUserId=uploadUserId;
    this.archiveDetailId=archiveDetailId;
  }

  public static ArchiveManageFilterMapper buildMapper(ArchiveManage obj) {
    ArchiveManageFilterMapper mapper = new ArchiveManageFilterMapper();
    mapper.id=obj.getId();
    mapper.name=obj.getName();
    mapper.department=obj.getDepartment();
    mapper.description=obj.getDescription();
    mapper.browseTimes=obj.getBrowseTimes();
    mapper.contentUrl=obj.getContentUrl();
    mapper.uploadUserId=obj.getUploadUserId();
    mapper.archiveDetailId=obj.getArchiveDetailId();
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
    map.put("archiveDetailId",this.archiveDetailId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("departmentIn",this.departmentIn);
    map.put("browseTimesFrom",this.browseTimesFrom);
    map.put("browseTimesTo",this.browseTimesTo);
    map.put("uploadTimeFrom",this.uploadTimeFrom);
    map.put("uploadTimeTo",this.uploadTimeTo);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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
    map.put("archiveDetailId", obj.getArchiveDetailId());
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
    map.put("archiveDetailId", JSONObject.toJSONString(obj.getArchiveDetailId()));
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
    obj.setArchiveDetailId(this.archiveDetailId);
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
    obj.setArchiveDetailId((String) map.get("archiveDetailId"));
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
    obj.setArchiveDetailId(JSONObject.parseObject(map.get("archiveDetailId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(ArchiveManage obj, Long page, Integer rows,
      List<String> orderBy, List<String> departmentIn, Integer browseTimesFrom,
      Integer browseTimesTo, Long uploadTimeFrom, Long uploadTimeTo, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("departmentIn", departmentIn);
    map.put("browseTimesFrom", browseTimesFrom);
    map.put("browseTimesTo", browseTimesTo);
    map.put("uploadTimeFrom", uploadTimeFrom);
    map.put("uploadTimeTo", uploadTimeTo);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(ArchiveManage obj, Long page, Integer rows,
      List<String> orderBy, List<String> departmentIn, Integer browseTimesFrom,
      Integer browseTimesTo, Long uploadTimeFrom, Long uploadTimeTo, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("departmentIn", JSONObject.toJSONString(departmentIn));
    map.put("browseTimesFrom", JSONObject.toJSONString(browseTimesFrom));
    map.put("browseTimesTo", JSONObject.toJSONString(browseTimesTo));
    map.put("uploadTimeFrom", JSONObject.toJSONString(uploadTimeFrom));
    map.put("uploadTimeTo", JSONObject.toJSONString(uploadTimeTo));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

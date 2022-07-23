package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrganizeArchiveFilterMapper {
  public String id;

  public String archiveId;

  public String organizeId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public List<String> archiveIdIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public OrganizeArchiveFilterMapper() {
  }

  public OrganizeArchiveFilterMapper(String id, String archiveId, String organizeId) {
    this.id=id;
    this.archiveId=archiveId;
    this.organizeId=organizeId;
  }

  public static OrganizeArchiveFilterMapper buildMapper(OrganizeArchive obj) {
    OrganizeArchiveFilterMapper mapper = new OrganizeArchiveFilterMapper();
    mapper.id=obj.getId();
    mapper.archiveId=obj.getArchiveId();
    mapper.organizeId=obj.getOrganizeId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("archiveId",this.archiveId);
    map.put("organizeId",this.organizeId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("archiveIdIn",this.archiveIdIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(OrganizeArchive obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("archiveId", obj.getArchiveId());
    map.put("organizeId", obj.getOrganizeId());
    return map;
  }

  public static Map<String, String> buildSerialMap(OrganizeArchive obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("archiveId", JSONObject.toJSONString(obj.getArchiveId()));
    map.put("organizeId", JSONObject.toJSONString(obj.getOrganizeId()));
    return map;
  }

  public OrganizeArchive buildEntity() {
    OrganizeArchive obj = new OrganizeArchive();
    obj.setId(this.id);
    obj.setArchiveId(this.archiveId);
    obj.setOrganizeId(this.organizeId);
    return obj;
  }

  public static OrganizeArchive parseEntity(Map<String, Object> map) {
    OrganizeArchive obj = new OrganizeArchive();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setArchiveId((String) map.get("archiveId"));
    obj.setOrganizeId((String) map.get("organizeId"));
    return obj;
  }

  public static OrganizeArchive parseSerialEntity(Map<String, String> map) {
    OrganizeArchive obj = new OrganizeArchive();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setArchiveId(JSONObject.parseObject(map.get("archiveId"), String.class));
    obj.setOrganizeId(JSONObject.parseObject(map.get("organizeId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(OrganizeArchive obj, Long page, Integer rows,
      List<String> orderBy, List<String> archiveIdIn, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("archiveIdIn", archiveIdIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(OrganizeArchive obj, Long page,
      Integer rows, List<String> orderBy, List<String> archiveIdIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("archiveIdIn", JSONObject.toJSONString(archiveIdIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrganizeArchiveUpdateMapper {
  public String id;

  public String archiveId;

  public String organizeId;

  public OrganizeArchiveUpdateMapper() {
  }

  public OrganizeArchiveUpdateMapper(String id, String archiveId, String organizeId) {
    this.id=id;
    this.archiveId=archiveId;
    this.organizeId=organizeId;
  }

  public static OrganizeArchiveUpdateMapper buildMapper(OrganizeArchive obj) {
    OrganizeArchiveUpdateMapper mapper = new OrganizeArchiveUpdateMapper();
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
}

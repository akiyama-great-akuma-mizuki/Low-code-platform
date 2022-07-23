package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrganizeArchivePostMapper {
  public String archiveId;

  public String organizeId;

  public OrganizeArchivePostMapper() {
  }

  public OrganizeArchivePostMapper(String archiveId, String organizeId) {
    this.archiveId=archiveId;
    this.organizeId=organizeId;
  }

  public static OrganizeArchivePostMapper buildMapper(OrganizeArchive obj) {
    OrganizeArchivePostMapper mapper = new OrganizeArchivePostMapper();
    mapper.archiveId=obj.getArchiveId();
    mapper.organizeId=obj.getOrganizeId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("archiveId",this.archiveId);
    map.put("organizeId",this.organizeId);
    return map;
  }

  public static Map<String, Object> buildMap(OrganizeArchive obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("archiveId", obj.getArchiveId());
    map.put("organizeId", obj.getOrganizeId());
    return map;
  }

  public static Map<String, String> buildSerialMap(OrganizeArchive obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("archiveId", JSONObject.toJSONString(obj.getArchiveId()));
    map.put("organizeId", JSONObject.toJSONString(obj.getOrganizeId()));
    return map;
  }

  public OrganizeArchive buildEntity() {
    OrganizeArchive obj = new OrganizeArchive();
    obj.setArchiveId(this.archiveId);
    obj.setOrganizeId(this.organizeId);
    return obj;
  }

  public static OrganizeArchive parseEntity(Map<String, Object> map) {
    OrganizeArchive obj = new OrganizeArchive();
    if (map == null) return obj;
    obj.setArchiveId((String) map.get("archiveId"));
    obj.setOrganizeId((String) map.get("organizeId"));
    return obj;
  }

  public static OrganizeArchive parseSerialEntity(Map<String, String> map) {
    OrganizeArchive obj = new OrganizeArchive();
    if (map == null) return obj;
    obj.setArchiveId(JSONObject.parseObject(map.get("archiveId"), String.class));
    obj.setOrganizeId(JSONObject.parseObject(map.get("organizeId"), String.class));
    return obj;
  }
}

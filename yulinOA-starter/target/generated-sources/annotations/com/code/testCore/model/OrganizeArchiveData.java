package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.OrganizeArchiveDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrganizeArchiveData {
  public String id;

  public String archiveId;

  public String organizeId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public OrganizeArchiveData() {
  }

  public OrganizeArchiveData(String id, String archiveId, String organizeId, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.archiveId=archiveId;
    this.organizeId=organizeId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static OrganizeArchiveData buildMapper(OrganizeArchive obj) {
    OrganizeArchiveData mapper = new OrganizeArchiveData();
    mapper.id=obj.getId();
    mapper.archiveId=obj.getArchiveId();
    mapper.organizeId=obj.getOrganizeId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("archiveId",this.archiveId);
    map.put("organizeId",this.organizeId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(OrganizeArchive obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("archiveId", obj.getArchiveId());
    map.put("organizeId", obj.getOrganizeId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(OrganizeArchive obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("archiveId", JSONObject.toJSONString(obj.getArchiveId()));
    map.put("organizeId", JSONObject.toJSONString(obj.getOrganizeId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public OrganizeArchive buildEntity() {
    OrganizeArchive obj = new OrganizeArchive();
    obj.setId(this.id);
    obj.setArchiveId(this.archiveId);
    obj.setOrganizeId(this.organizeId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static OrganizeArchive parseEntity(Map<String, Object> map) {
    OrganizeArchive obj = new OrganizeArchive();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setArchiveId((String) map.get("archiveId"));
    obj.setOrganizeId((String) map.get("organizeId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static OrganizeArchive parseSerialEntity(Map<String, String> map) {
    OrganizeArchive obj = new OrganizeArchive();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setArchiveId(JSONObject.parseObject(map.get("archiveId"), String.class));
    obj.setOrganizeId(JSONObject.parseObject(map.get("organizeId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static OrganizeArchiveDO convert(OrganizeArchive from, OrganizeArchiveDO to) {
    if (from == null) return to;
    if (to == null) to = new OrganizeArchiveDO();
    to.setId(from.getId());
    to.setArchiveId(from.getArchiveId());
    to.setOrganizeId(from.getOrganizeId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static OrganizeArchive convert(OrganizeArchiveDO from, OrganizeArchive to) {
    if (from == null) return to;
    if (to == null) to = new OrganizeArchive();
    to.setId(from.getId());
    to.setArchiveId(from.getArchiveId());
    to.setOrganizeId(from.getOrganizeId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

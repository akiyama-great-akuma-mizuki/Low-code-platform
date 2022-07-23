package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class OrganizeArchiveDetailMapper {
  public String id;

  public String archiveId;

  public String organizeId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map archiveManage = null;

  public Map organize = null;

  public OrganizeArchiveDetailMapper() {
  }

  public OrganizeArchiveDetailMapper(String id, String archiveId, String organizeId, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.archiveId=archiveId;
    this.organizeId=organizeId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static OrganizeArchiveDetailMapper buildMapper(OrganizeArchive obj) {
    OrganizeArchiveDetailMapper mapper = new OrganizeArchiveDetailMapper();
    mapper.id=obj.getId();
    mapper.archiveId=obj.getArchiveId();
    mapper.organizeId=obj.getOrganizeId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("archiveId",this.archiveId);
    map.put("organizeId",this.organizeId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("archiveManage",this.archiveManage);
    map.put("organize",this.organize);
    return map;
  }

  public static Map<String, Object> buildMap(OrganizeArchive obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("archiveId", obj.getArchiveId());
    map.put("organizeId", obj.getOrganizeId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(OrganizeArchive obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("archiveId", JSONObject.toJSONString(obj.getArchiveId()));
    map.put("organizeId", JSONObject.toJSONString(obj.getOrganizeId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public OrganizeArchive buildEntity() {
    OrganizeArchive obj = new OrganizeArchive();
    obj.setId(this.id);
    obj.setArchiveId(this.archiveId);
    obj.setOrganizeId(this.organizeId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static OrganizeArchive parseEntity(Map<String, Object> map) {
    OrganizeArchive obj = new OrganizeArchive();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setArchiveId((String) map.get("archiveId"));
    obj.setOrganizeId((String) map.get("organizeId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static OrganizeArchive parseSerialEntity(Map<String, String> map) {
    OrganizeArchive obj = new OrganizeArchive();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setArchiveId(JSONObject.parseObject(map.get("archiveId"), String.class));
    obj.setOrganizeId(JSONObject.parseObject(map.get("organizeId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(OrganizeArchive obj,
      Map<String, Object> archiveManage, Map<String, Object> organize) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("archiveManage", archiveManage);
    map.put("organize", organize);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(OrganizeArchive obj,
      Map<String, Object> archiveManage, Map<String, Object> organize) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("archiveManage", JSONObject.toJSONString(archiveManage));
    map.put("organize", JSONObject.toJSONString(organize));
    return map;
  }
}

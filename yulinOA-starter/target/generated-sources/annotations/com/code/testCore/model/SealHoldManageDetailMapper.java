package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealHoldManageDetailMapper {
  public String id;

  public String holderId;

  public String archiveId;

  public Long limitEndTime;

  public Integer holdLimit;

  public Integer state;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map sealManage = null;

  public Map user = null;

  public SealHoldManageDetailMapper() {
  }

  public SealHoldManageDetailMapper(String id, String holderId, String archiveId, Long limitEndTime,
      Integer holdLimit, Integer state, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.holderId=holderId;
    this.archiveId=archiveId;
    this.limitEndTime=limitEndTime;
    this.holdLimit=holdLimit;
    this.state=state;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static SealHoldManageDetailMapper buildMapper(SealHoldManage obj) {
    SealHoldManageDetailMapper mapper = new SealHoldManageDetailMapper();
    mapper.id=obj.getId();
    mapper.holderId=obj.getHolderId();
    mapper.archiveId=obj.getArchiveId();
    mapper.limitEndTime=obj.modifyTime(obj.getLimitEndTime());
    mapper.holdLimit=obj.getHoldLimit();
    mapper.state=obj.getState();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("holderId",this.holderId);
    map.put("archiveId",this.archiveId);
    map.put("limitEndTime",this.limitEndTime);
    map.put("holdLimit",this.holdLimit);
    map.put("state",this.state);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("sealManage",this.sealManage);
    map.put("user",this.user);
    return map;
  }

  public static Map<String, Object> buildMap(SealHoldManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("holderId", obj.getHolderId());
    map.put("archiveId", obj.getArchiveId());
    map.put("limitEndTime", obj.modifyTime(obj.getLimitEndTime()));
    map.put("holdLimit", obj.getHoldLimit());
    map.put("state", obj.getState());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(SealHoldManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("holderId", JSONObject.toJSONString(obj.getHolderId()));
    map.put("archiveId", JSONObject.toJSONString(obj.getArchiveId()));
    map.put("limitEndTime", JSONObject.toJSONString(obj.modifyTime(obj.getLimitEndTime())));
    map.put("holdLimit", JSONObject.toJSONString(obj.getHoldLimit()));
    map.put("state", JSONObject.toJSONString(obj.getState()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public SealHoldManage buildEntity() {
    SealHoldManage obj = new SealHoldManage();
    obj.setId(this.id);
    obj.setHolderId(this.holderId);
    obj.setArchiveId(this.archiveId);
    obj.setLimitEndTime(obj.recoverTime(this.limitEndTime));
    obj.setHoldLimit(this.holdLimit);
    obj.setState(this.state);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static SealHoldManage parseEntity(Map<String, Object> map) {
    SealHoldManage obj = new SealHoldManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHolderId((String) map.get("holderId"));
    obj.setArchiveId((String) map.get("archiveId"));
    obj.setLimitEndTime(obj.recoverTime((Long) map.get("limitEndTime")));
    obj.setHoldLimit((Integer) map.get("holdLimit"));
    obj.setState((Integer) map.get("state"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static SealHoldManage parseSerialEntity(Map<String, String> map) {
    SealHoldManage obj = new SealHoldManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHolderId(JSONObject.parseObject(map.get("holderId"), String.class));
    obj.setArchiveId(JSONObject.parseObject(map.get("archiveId"), String.class));
    obj.setLimitEndTime(obj.recoverTime(JSONObject.parseObject(map.get("limitEndTime"), Long.class)));
    obj.setHoldLimit(JSONObject.parseObject(map.get("holdLimit"), Integer.class));
    obj.setState(JSONObject.parseObject(map.get("state"), Integer.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(SealHoldManage obj,
      Map<String, Object> sealManage, Map<String, Object> user) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("sealManage", sealManage);
    map.put("user", user);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(SealHoldManage obj,
      Map<String, Object> sealManage, Map<String, Object> user) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("sealManage", JSONObject.toJSONString(sealManage));
    map.put("user", JSONObject.toJSONString(user));
    return map;
  }
}

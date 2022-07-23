package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealHoldManageDefaultMapper {
  public String id;

  public String holderId;

  public String archiveId;

  public Date limitEndTime;

  public Integer holdLimit;

  public Integer state;

  public Date gmtUpdate;

  public Date gmtCreate;

  public SealHoldManageDefaultMapper() {
  }

  public SealHoldManageDefaultMapper(String id, String holderId, String archiveId,
      Date limitEndTime, Integer holdLimit, Integer state, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.holderId=holderId;
    this.archiveId=archiveId;
    this.limitEndTime=limitEndTime;
    this.holdLimit=holdLimit;
    this.state=state;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static SealHoldManageDefaultMapper buildMapper(SealHoldManage obj) {
    SealHoldManageDefaultMapper mapper = new SealHoldManageDefaultMapper();
    mapper.id=obj.getId();
    mapper.holderId=obj.getHolderId();
    mapper.archiveId=obj.getArchiveId();
    mapper.limitEndTime=obj.getLimitEndTime();
    mapper.holdLimit=obj.getHoldLimit();
    mapper.state=obj.getState();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    return map;
  }

  public static Map<String, Object> buildMap(SealHoldManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("holderId", obj.getHolderId());
    map.put("archiveId", obj.getArchiveId());
    map.put("limitEndTime", obj.getLimitEndTime());
    map.put("holdLimit", obj.getHoldLimit());
    map.put("state", obj.getState());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealHoldManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("holderId", JSONObject.toJSONString(obj.getHolderId()));
    map.put("archiveId", JSONObject.toJSONString(obj.getArchiveId()));
    map.put("limitEndTime", JSONObject.toJSONString(obj.getLimitEndTime()));
    map.put("holdLimit", JSONObject.toJSONString(obj.getHoldLimit()));
    map.put("state", JSONObject.toJSONString(obj.getState()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public SealHoldManage buildEntity() {
    SealHoldManage obj = new SealHoldManage();
    obj.setId(this.id);
    obj.setHolderId(this.holderId);
    obj.setArchiveId(this.archiveId);
    obj.setLimitEndTime(this.limitEndTime);
    obj.setHoldLimit(this.holdLimit);
    obj.setState(this.state);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static SealHoldManage parseEntity(Map<String, Object> map) {
    SealHoldManage obj = new SealHoldManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHolderId((String) map.get("holderId"));
    obj.setArchiveId((String) map.get("archiveId"));
    obj.setLimitEndTime((Date) map.get("limitEndTime"));
    obj.setHoldLimit((Integer) map.get("holdLimit"));
    obj.setState((Integer) map.get("state"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static SealHoldManage parseSerialEntity(Map<String, String> map) {
    SealHoldManage obj = new SealHoldManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHolderId(JSONObject.parseObject(map.get("holderId"), String.class));
    obj.setArchiveId(JSONObject.parseObject(map.get("archiveId"), String.class));
    obj.setLimitEndTime(JSONObject.parseObject(map.get("limitEndTime"), Date.class));
    obj.setHoldLimit(JSONObject.parseObject(map.get("holdLimit"), Integer.class));
    obj.setState(JSONObject.parseObject(map.get("state"), Integer.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class SealHoldManagePostMapper {
  public String holderId;

  public String archiveId;

  public Long limitEndTime;

  public Integer holdLimit;

  public Integer state;

  public SealHoldManagePostMapper() {
  }

  public SealHoldManagePostMapper(String holderId, String archiveId, Long limitEndTime,
      Integer holdLimit, Integer state) {
    this.holderId=holderId;
    this.archiveId=archiveId;
    this.limitEndTime=limitEndTime;
    this.holdLimit=holdLimit;
    this.state=state;
  }

  public static SealHoldManagePostMapper buildMapper(SealHoldManage obj) {
    SealHoldManagePostMapper mapper = new SealHoldManagePostMapper();
    mapper.holderId=obj.getHolderId();
    mapper.archiveId=obj.getArchiveId();
    mapper.limitEndTime=obj.modifyTime(obj.getLimitEndTime());
    mapper.holdLimit=obj.getHoldLimit();
    mapper.state=obj.getState();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("holderId",this.holderId);
    map.put("archiveId",this.archiveId);
    map.put("limitEndTime",this.limitEndTime);
    map.put("holdLimit",this.holdLimit);
    map.put("state",this.state);
    return map;
  }

  public static Map<String, Object> buildMap(SealHoldManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("holderId", obj.getHolderId());
    map.put("archiveId", obj.getArchiveId());
    map.put("limitEndTime", obj.modifyTime(obj.getLimitEndTime()));
    map.put("holdLimit", obj.getHoldLimit());
    map.put("state", obj.getState());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealHoldManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("holderId", JSONObject.toJSONString(obj.getHolderId()));
    map.put("archiveId", JSONObject.toJSONString(obj.getArchiveId()));
    map.put("limitEndTime", JSONObject.toJSONString(obj.modifyTime(obj.getLimitEndTime())));
    map.put("holdLimit", JSONObject.toJSONString(obj.getHoldLimit()));
    map.put("state", JSONObject.toJSONString(obj.getState()));
    return map;
  }

  public SealHoldManage buildEntity() {
    SealHoldManage obj = new SealHoldManage();
    obj.setHolderId(this.holderId);
    obj.setArchiveId(this.archiveId);
    obj.setLimitEndTime(obj.recoverTime(this.limitEndTime));
    obj.setHoldLimit(this.holdLimit);
    obj.setState(this.state);
    return obj;
  }

  public static SealHoldManage parseEntity(Map<String, Object> map) {
    SealHoldManage obj = new SealHoldManage();
    if (map == null) return obj;
    obj.setHolderId((String) map.get("holderId"));
    obj.setArchiveId((String) map.get("archiveId"));
    obj.setLimitEndTime(obj.recoverTime((Long) map.get("limitEndTime")));
    obj.setHoldLimit((Integer) map.get("holdLimit"));
    obj.setState((Integer) map.get("state"));
    return obj;
  }

  public static SealHoldManage parseSerialEntity(Map<String, String> map) {
    SealHoldManage obj = new SealHoldManage();
    if (map == null) return obj;
    obj.setHolderId(JSONObject.parseObject(map.get("holderId"), String.class));
    obj.setArchiveId(JSONObject.parseObject(map.get("archiveId"), String.class));
    obj.setLimitEndTime(obj.recoverTime(JSONObject.parseObject(map.get("limitEndTime"), Long.class)));
    obj.setHoldLimit(JSONObject.parseObject(map.get("holdLimit"), Integer.class));
    obj.setState(JSONObject.parseObject(map.get("state"), Integer.class));
    return obj;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SealHoldManageFilterMapper {
  public String id;

  public String holderId;

  public String archiveId;

  public Integer holdLimit;

  public Integer state;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public List<String> holderIdIn = null;

  public List<String> archiveIdIn = null;

  public Long limitEndTimeFrom = null;

  public Long limitEndTimeTo = null;

  public List<Integer> holdLimitIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public SealHoldManageFilterMapper() {
  }

  public SealHoldManageFilterMapper(String id, String holderId, String archiveId, Integer holdLimit,
      Integer state) {
    this.id=id;
    this.holderId=holderId;
    this.archiveId=archiveId;
    this.holdLimit=holdLimit;
    this.state=state;
  }

  public static SealHoldManageFilterMapper buildMapper(SealHoldManage obj) {
    SealHoldManageFilterMapper mapper = new SealHoldManageFilterMapper();
    mapper.id=obj.getId();
    mapper.holderId=obj.getHolderId();
    mapper.archiveId=obj.getArchiveId();
    mapper.holdLimit=obj.getHoldLimit();
    mapper.state=obj.getState();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("holderId",this.holderId);
    map.put("archiveId",this.archiveId);
    map.put("holdLimit",this.holdLimit);
    map.put("state",this.state);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("holderIdIn",this.holderIdIn);
    map.put("archiveIdIn",this.archiveIdIn);
    map.put("limitEndTimeFrom",this.limitEndTimeFrom);
    map.put("limitEndTimeTo",this.limitEndTimeTo);
    map.put("holdLimitIn",this.holdLimitIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(SealHoldManage obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("holderId", obj.getHolderId());
    map.put("archiveId", obj.getArchiveId());
    map.put("holdLimit", obj.getHoldLimit());
    map.put("state", obj.getState());
    return map;
  }

  public static Map<String, String> buildSerialMap(SealHoldManage obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("holderId", JSONObject.toJSONString(obj.getHolderId()));
    map.put("archiveId", JSONObject.toJSONString(obj.getArchiveId()));
    map.put("holdLimit", JSONObject.toJSONString(obj.getHoldLimit()));
    map.put("state", JSONObject.toJSONString(obj.getState()));
    return map;
  }

  public SealHoldManage buildEntity() {
    SealHoldManage obj = new SealHoldManage();
    obj.setId(this.id);
    obj.setHolderId(this.holderId);
    obj.setArchiveId(this.archiveId);
    obj.setHoldLimit(this.holdLimit);
    obj.setState(this.state);
    return obj;
  }

  public static SealHoldManage parseEntity(Map<String, Object> map) {
    SealHoldManage obj = new SealHoldManage();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHolderId((String) map.get("holderId"));
    obj.setArchiveId((String) map.get("archiveId"));
    obj.setHoldLimit((Integer) map.get("holdLimit"));
    obj.setState((Integer) map.get("state"));
    return obj;
  }

  public static SealHoldManage parseSerialEntity(Map<String, String> map) {
    SealHoldManage obj = new SealHoldManage();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHolderId(JSONObject.parseObject(map.get("holderId"), String.class));
    obj.setArchiveId(JSONObject.parseObject(map.get("archiveId"), String.class));
    obj.setHoldLimit(JSONObject.parseObject(map.get("holdLimit"), Integer.class));
    obj.setState(JSONObject.parseObject(map.get("state"), Integer.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(SealHoldManage obj, Long page, Integer rows,
      List<String> orderBy, List<String> holderIdIn, List<String> archiveIdIn,
      Long limitEndTimeFrom, Long limitEndTimeTo, List<Integer> holdLimitIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("holderIdIn", holderIdIn);
    map.put("archiveIdIn", archiveIdIn);
    map.put("limitEndTimeFrom", limitEndTimeFrom);
    map.put("limitEndTimeTo", limitEndTimeTo);
    map.put("holdLimitIn", holdLimitIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(SealHoldManage obj, Long page, Integer rows,
      List<String> orderBy, List<String> holderIdIn, List<String> archiveIdIn,
      Long limitEndTimeFrom, Long limitEndTimeTo, List<Integer> holdLimitIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("holderIdIn", JSONObject.toJSONString(holderIdIn));
    map.put("archiveIdIn", JSONObject.toJSONString(archiveIdIn));
    map.put("limitEndTimeFrom", JSONObject.toJSONString(limitEndTimeFrom));
    map.put("limitEndTimeTo", JSONObject.toJSONString(limitEndTimeTo));
    map.put("holdLimitIn", JSONObject.toJSONString(holdLimitIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

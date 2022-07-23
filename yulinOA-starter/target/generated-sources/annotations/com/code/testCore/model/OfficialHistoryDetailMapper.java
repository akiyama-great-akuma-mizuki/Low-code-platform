package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class OfficialHistoryDetailMapper {
  public String id;

  public String operateClass;

  public String operatePeople;

  public Integer result;

  public String remark;

  public String officialId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map official = null;

  public OfficialHistoryDetailMapper() {
  }

  public OfficialHistoryDetailMapper(String id, String operateClass, String operatePeople,
      Integer result, String remark, String officialId, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.operateClass=operateClass;
    this.operatePeople=operatePeople;
    this.result=result;
    this.remark=remark;
    this.officialId=officialId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static OfficialHistoryDetailMapper buildMapper(OfficialHistory obj) {
    OfficialHistoryDetailMapper mapper = new OfficialHistoryDetailMapper();
    mapper.id=obj.getId();
    mapper.operateClass=obj.getOperateClass();
    mapper.operatePeople=obj.getOperatePeople();
    mapper.result=obj.getResult();
    mapper.remark=obj.getRemark();
    mapper.officialId=obj.getOfficialId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("operateClass",this.operateClass);
    map.put("operatePeople",this.operatePeople);
    map.put("result",this.result);
    map.put("remark",this.remark);
    map.put("officialId",this.officialId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("official",this.official);
    return map;
  }

  public static Map<String, Object> buildMap(OfficialHistory obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("operateClass", obj.getOperateClass());
    map.put("operatePeople", obj.getOperatePeople());
    map.put("result", obj.getResult());
    map.put("remark", obj.getRemark());
    map.put("officialId", obj.getOfficialId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(OfficialHistory obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("operateClass", JSONObject.toJSONString(obj.getOperateClass()));
    map.put("operatePeople", JSONObject.toJSONString(obj.getOperatePeople()));
    map.put("result", JSONObject.toJSONString(obj.getResult()));
    map.put("remark", JSONObject.toJSONString(obj.getRemark()));
    map.put("officialId", JSONObject.toJSONString(obj.getOfficialId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public OfficialHistory buildEntity() {
    OfficialHistory obj = new OfficialHistory();
    obj.setId(this.id);
    obj.setOperateClass(this.operateClass);
    obj.setOperatePeople(this.operatePeople);
    obj.setResult(this.result);
    obj.setRemark(this.remark);
    obj.setOfficialId(this.officialId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static OfficialHistory parseEntity(Map<String, Object> map) {
    OfficialHistory obj = new OfficialHistory();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setOperateClass((String) map.get("operateClass"));
    obj.setOperatePeople((String) map.get("operatePeople"));
    obj.setResult((Integer) map.get("result"));
    obj.setRemark((String) map.get("remark"));
    obj.setOfficialId((String) map.get("officialId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static OfficialHistory parseSerialEntity(Map<String, String> map) {
    OfficialHistory obj = new OfficialHistory();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setOperateClass(JSONObject.parseObject(map.get("operateClass"), String.class));
    obj.setOperatePeople(JSONObject.parseObject(map.get("operatePeople"), String.class));
    obj.setResult(JSONObject.parseObject(map.get("result"), Integer.class));
    obj.setRemark(JSONObject.parseObject(map.get("remark"), String.class));
    obj.setOfficialId(JSONObject.parseObject(map.get("officialId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(OfficialHistory obj,
      Map<String, Object> official) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("official", official);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(OfficialHistory obj,
      Map<String, Object> official) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("official", JSONObject.toJSONString(official));
    return map;
  }
}

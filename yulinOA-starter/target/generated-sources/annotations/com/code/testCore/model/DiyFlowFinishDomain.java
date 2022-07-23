package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.DiyFlowFinishTO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiyFlowFinishDomain {
  public String id;

  public String diyFlowId;

  public Integer status;

  public Date gmtUpdate;

  public Date gmtCreate;

  public DiyFlowFinishDomain() {
  }

  public DiyFlowFinishDomain(String id, String diyFlowId, Integer status, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.diyFlowId=diyFlowId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static DiyFlowFinishDomain buildMapper(DiyFlowFinish obj) {
    DiyFlowFinishDomain mapper = new DiyFlowFinishDomain();
    mapper.id=obj.getId();
    mapper.diyFlowId=obj.getDiyFlowId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("diyFlowId",this.diyFlowId);
    map.put("status",this.status);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(DiyFlowFinish obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("diyFlowId", obj.getDiyFlowId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(DiyFlowFinish obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("diyFlowId", JSONObject.toJSONString(obj.getDiyFlowId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public DiyFlowFinish buildEntity() {
    DiyFlowFinish obj = new DiyFlowFinish();
    obj.setId(this.id);
    obj.setDiyFlowId(this.diyFlowId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static DiyFlowFinish parseEntity(Map<String, Object> map) {
    DiyFlowFinish obj = new DiyFlowFinish();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setDiyFlowId((String) map.get("diyFlowId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static DiyFlowFinish parseSerialEntity(Map<String, String> map) {
    DiyFlowFinish obj = new DiyFlowFinish();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setDiyFlowId(JSONObject.parseObject(map.get("diyFlowId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static DiyFlowFinishTO convert(DiyFlowFinish from, DiyFlowFinishTO to) {
    if (from == null) return to;
    if (to == null) to = new DiyFlowFinishTO();
    to.setId(from.getId());
    to.setDiyFlowId(from.getDiyFlowId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static DiyFlowFinish convert(DiyFlowFinishTO from, DiyFlowFinish to) {
    if (from == null) return to;
    if (to == null) to = new DiyFlowFinish();
    to.setId(from.getId());
    to.setDiyFlowId(from.getDiyFlowId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

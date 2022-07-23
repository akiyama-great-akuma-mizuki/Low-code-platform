package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.TaskTO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskDomain {
  public String id;

  public String type;

  public String name;

  public String flowId;

  public String status;

  public Date gmtUpdate;

  public Date gmtCreate;

  public TaskDomain() {
  }

  public TaskDomain(String id, String type, String name, String flowId, String status,
      Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.type=type;
    this.name=name;
    this.flowId=flowId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static TaskDomain buildMapper(Task obj) {
    TaskDomain mapper = new TaskDomain();
    mapper.id=obj.getId();
    mapper.type=obj.getType();
    mapper.name=obj.getName();
    mapper.flowId=obj.getFlowId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("type",this.type);
    map.put("name",this.name);
    map.put("flowId",this.flowId);
    map.put("status",this.status);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Task obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("type", obj.getType());
    map.put("name", obj.getName());
    map.put("flowId", obj.getFlowId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(Task obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("flowId", JSONObject.toJSONString(obj.getFlowId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public Task buildEntity() {
    Task obj = new Task();
    obj.setId(this.id);
    obj.setType(this.type);
    obj.setName(this.name);
    obj.setFlowId(this.flowId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static Task parseEntity(Map<String, Object> map) {
    Task obj = new Task();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setType((String) map.get("type"));
    obj.setName((String) map.get("name"));
    obj.setFlowId((String) map.get("flowId"));
    obj.setStatus((String) map.get("status"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static Task parseSerialEntity(Map<String, String> map) {
    Task obj = new Task();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setType(JSONObject.parseObject(map.get("type"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setFlowId(JSONObject.parseObject(map.get("flowId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static TaskTO convert(Task from, TaskTO to) {
    if (from == null) return to;
    if (to == null) to = new TaskTO();
    to.setId(from.getId());
    to.setType(from.getType());
    to.setName(from.getName());
    to.setFlowId(from.getFlowId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static Task convert(TaskTO from, Task to) {
    if (from == null) return to;
    if (to == null) to = new Task();
    to.setId(from.getId());
    to.setType(from.getType());
    to.setName(from.getName());
    to.setFlowId(from.getFlowId());
    to.setStatus(from.getStatus());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

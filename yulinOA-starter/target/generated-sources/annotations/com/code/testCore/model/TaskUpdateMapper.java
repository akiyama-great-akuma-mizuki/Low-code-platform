package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class TaskUpdateMapper {
  public String id;

  public String type;

  public String name;

  public String flowId;

  public String status;

  public TaskUpdateMapper() {
  }

  public TaskUpdateMapper(String id, String type, String name, String flowId, String status) {
    this.id=id;
    this.type=type;
    this.name=name;
    this.flowId=flowId;
    this.status=status;
  }

  public static TaskUpdateMapper buildMapper(Task obj) {
    TaskUpdateMapper mapper = new TaskUpdateMapper();
    mapper.id=obj.getId();
    mapper.type=obj.getType();
    mapper.name=obj.getName();
    mapper.flowId=obj.getFlowId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("type",this.type);
    map.put("name",this.name);
    map.put("flowId",this.flowId);
    map.put("status",this.status);
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
    return map;
  }

  public static Map<String, String> buildSerialMap(Task obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("flowId", JSONObject.toJSONString(obj.getFlowId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public Task buildEntity() {
    Task obj = new Task();
    obj.setId(this.id);
    obj.setType(this.type);
    obj.setName(this.name);
    obj.setFlowId(this.flowId);
    obj.setStatus(this.status);
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
    return obj;
  }
}

package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroupPostMapper {
  public String headImg;

  public String groupName;

  public String groupPeople;

  public GroupPostMapper() {
  }

  public GroupPostMapper(String headImg, String groupName, String groupPeople) {
    this.headImg=headImg;
    this.groupName=groupName;
    this.groupPeople=groupPeople;
  }

  public static GroupPostMapper buildMapper(Group obj) {
    GroupPostMapper mapper = new GroupPostMapper();
    mapper.headImg=obj.getHeadImg();
    mapper.groupName=obj.getGroupName();
    mapper.groupPeople=obj.getGroupPeople();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("headImg",this.headImg);
    map.put("groupName",this.groupName);
    map.put("groupPeople",this.groupPeople);
    return map;
  }

  public static Map<String, Object> buildMap(Group obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("headImg", obj.getHeadImg());
    map.put("groupName", obj.getGroupName());
    map.put("groupPeople", obj.getGroupPeople());
    return map;
  }

  public static Map<String, String> buildSerialMap(Group obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("headImg", JSONObject.toJSONString(obj.getHeadImg()));
    map.put("groupName", JSONObject.toJSONString(obj.getGroupName()));
    map.put("groupPeople", JSONObject.toJSONString(obj.getGroupPeople()));
    return map;
  }

  public Group buildEntity() {
    Group obj = new Group();
    obj.setHeadImg(this.headImg);
    obj.setGroupName(this.groupName);
    obj.setGroupPeople(this.groupPeople);
    return obj;
  }

  public static Group parseEntity(Map<String, Object> map) {
    Group obj = new Group();
    if (map == null) return obj;
    obj.setHeadImg((String) map.get("headImg"));
    obj.setGroupName((String) map.get("groupName"));
    obj.setGroupPeople((String) map.get("groupPeople"));
    return obj;
  }

  public static Group parseSerialEntity(Map<String, String> map) {
    Group obj = new Group();
    if (map == null) return obj;
    obj.setHeadImg(JSONObject.parseObject(map.get("headImg"), String.class));
    obj.setGroupName(JSONObject.parseObject(map.get("groupName"), String.class));
    obj.setGroupPeople(JSONObject.parseObject(map.get("groupPeople"), String.class));
    return obj;
  }
}

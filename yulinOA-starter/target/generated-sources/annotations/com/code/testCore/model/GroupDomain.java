package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.domain.GroupTO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class GroupDomain {
  public String id;

  public String headImg;

  public String groupName;

  public String groupPeople;

  public Date gmtUpdate;

  public Date gmtCreate;

  public GroupDomain() {
  }

  public GroupDomain(String id, String headImg, String groupName, String groupPeople,
      Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.headImg=headImg;
    this.groupName=groupName;
    this.groupPeople=groupPeople;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static GroupDomain buildMapper(Group obj) {
    GroupDomain mapper = new GroupDomain();
    mapper.id=obj.getId();
    mapper.headImg=obj.getHeadImg();
    mapper.groupName=obj.getGroupName();
    mapper.groupPeople=obj.getGroupPeople();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("headImg",this.headImg);
    map.put("groupName",this.groupName);
    map.put("groupPeople",this.groupPeople);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Group obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("headImg", obj.getHeadImg());
    map.put("groupName", obj.getGroupName());
    map.put("groupPeople", obj.getGroupPeople());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(Group obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("headImg", JSONObject.toJSONString(obj.getHeadImg()));
    map.put("groupName", JSONObject.toJSONString(obj.getGroupName()));
    map.put("groupPeople", JSONObject.toJSONString(obj.getGroupPeople()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public Group buildEntity() {
    Group obj = new Group();
    obj.setId(this.id);
    obj.setHeadImg(this.headImg);
    obj.setGroupName(this.groupName);
    obj.setGroupPeople(this.groupPeople);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static Group parseEntity(Map<String, Object> map) {
    Group obj = new Group();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHeadImg((String) map.get("headImg"));
    obj.setGroupName((String) map.get("groupName"));
    obj.setGroupPeople((String) map.get("groupPeople"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static Group parseSerialEntity(Map<String, String> map) {
    Group obj = new Group();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHeadImg(JSONObject.parseObject(map.get("headImg"), String.class));
    obj.setGroupName(JSONObject.parseObject(map.get("groupName"), String.class));
    obj.setGroupPeople(JSONObject.parseObject(map.get("groupPeople"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static GroupTO convert(Group from, GroupTO to) {
    if (from == null) return to;
    if (to == null) to = new GroupTO();
    to.setId(from.getId());
    to.setHeadImg(from.getHeadImg());
    to.setGroupName(from.getGroupName());
    to.setGroupPeople(from.getGroupPeople());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static Group convert(GroupTO from, Group to) {
    if (from == null) return to;
    if (to == null) to = new Group();
    to.setId(from.getId());
    to.setHeadImg(from.getHeadImg());
    to.setGroupName(from.getGroupName());
    to.setGroupPeople(from.getGroupPeople());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

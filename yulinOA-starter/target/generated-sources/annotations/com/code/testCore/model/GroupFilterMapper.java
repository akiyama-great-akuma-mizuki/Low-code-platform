package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GroupFilterMapper {
  public String id;

  public String headImg;

  public String groupName;

  public String groupPeople;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String headImgLike = null;

  public List<String> headImgIn = null;

  public String groupNameLike = null;

  public List<String> groupNameIn = null;

  public String groupPeopleLike = null;

  public List<String> groupPeopleIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public GroupFilterMapper() {
  }

  public GroupFilterMapper(String id, String headImg, String groupName, String groupPeople) {
    this.id=id;
    this.headImg=headImg;
    this.groupName=groupName;
    this.groupPeople=groupPeople;
  }

  public static GroupFilterMapper buildMapper(Group obj) {
    GroupFilterMapper mapper = new GroupFilterMapper();
    mapper.id=obj.getId();
    mapper.headImg=obj.getHeadImg();
    mapper.groupName=obj.getGroupName();
    mapper.groupPeople=obj.getGroupPeople();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("headImg",this.headImg);
    map.put("groupName",this.groupName);
    map.put("groupPeople",this.groupPeople);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("headImgLike",this.headImgLike);
    map.put("headImgIn",this.headImgIn);
    map.put("groupNameLike",this.groupNameLike);
    map.put("groupNameIn",this.groupNameIn);
    map.put("groupPeopleLike",this.groupPeopleLike);
    map.put("groupPeopleIn",this.groupPeopleIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Group obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("headImg", obj.getHeadImg());
    map.put("groupName", obj.getGroupName());
    map.put("groupPeople", obj.getGroupPeople());
    return map;
  }

  public static Map<String, String> buildSerialMap(Group obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("headImg", JSONObject.toJSONString(obj.getHeadImg()));
    map.put("groupName", JSONObject.toJSONString(obj.getGroupName()));
    map.put("groupPeople", JSONObject.toJSONString(obj.getGroupPeople()));
    return map;
  }

  public Group buildEntity() {
    Group obj = new Group();
    obj.setId(this.id);
    obj.setHeadImg(this.headImg);
    obj.setGroupName(this.groupName);
    obj.setGroupPeople(this.groupPeople);
    return obj;
  }

  public static Group parseEntity(Map<String, Object> map) {
    Group obj = new Group();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setHeadImg((String) map.get("headImg"));
    obj.setGroupName((String) map.get("groupName"));
    obj.setGroupPeople((String) map.get("groupPeople"));
    return obj;
  }

  public static Group parseSerialEntity(Map<String, String> map) {
    Group obj = new Group();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setHeadImg(JSONObject.parseObject(map.get("headImg"), String.class));
    obj.setGroupName(JSONObject.parseObject(map.get("groupName"), String.class));
    obj.setGroupPeople(JSONObject.parseObject(map.get("groupPeople"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Group obj, Long page, Integer rows,
      List<String> orderBy, String headImgLike, List<String> headImgIn, String groupNameLike,
      List<String> groupNameIn, String groupPeopleLike, List<String> groupPeopleIn,
      Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("headImgLike", headImgLike);
    map.put("headImgIn", headImgIn);
    map.put("groupNameLike", groupNameLike);
    map.put("groupNameIn", groupNameIn);
    map.put("groupPeopleLike", groupPeopleLike);
    map.put("groupPeopleIn", groupPeopleIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Group obj, Long page, Integer rows,
      List<String> orderBy, String headImgLike, List<String> headImgIn, String groupNameLike,
      List<String> groupNameIn, String groupPeopleLike, List<String> groupPeopleIn,
      Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("headImgLike", JSONObject.toJSONString(headImgLike));
    map.put("headImgIn", JSONObject.toJSONString(headImgIn));
    map.put("groupNameLike", JSONObject.toJSONString(groupNameLike));
    map.put("groupNameIn", JSONObject.toJSONString(groupNameIn));
    map.put("groupPeopleLike", JSONObject.toJSONString(groupPeopleLike));
    map.put("groupPeopleIn", JSONObject.toJSONString(groupPeopleIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

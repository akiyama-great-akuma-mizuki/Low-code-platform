package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeetingRoomDefaultMapper {
  public String id;

  public String roomName;

  public String roomFacility;

  public Integer roomState;

  public Integer roomCapacity;

  public String roomFloor;

  public String roomExplain;

  public Date gmtUpdate;

  public Date gmtCreate;

  public MeetingRoomDefaultMapper() {
  }

  public MeetingRoomDefaultMapper(String id, String roomName, String roomFacility,
      Integer roomState, Integer roomCapacity, String roomFloor, String roomExplain, Date gmtUpdate,
      Date gmtCreate) {
    this.id=id;
    this.roomName=roomName;
    this.roomFacility=roomFacility;
    this.roomState=roomState;
    this.roomCapacity=roomCapacity;
    this.roomFloor=roomFloor;
    this.roomExplain=roomExplain;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static MeetingRoomDefaultMapper buildMapper(MeetingRoom obj) {
    MeetingRoomDefaultMapper mapper = new MeetingRoomDefaultMapper();
    mapper.id=obj.getId();
    mapper.roomName=obj.getRoomName();
    mapper.roomFacility=obj.getRoomFacility();
    mapper.roomState=obj.getRoomState();
    mapper.roomCapacity=obj.getRoomCapacity();
    mapper.roomFloor=obj.getRoomFloor();
    mapper.roomExplain=obj.getRoomExplain();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("roomName",this.roomName);
    map.put("roomFacility",this.roomFacility);
    map.put("roomState",this.roomState);
    map.put("roomCapacity",this.roomCapacity);
    map.put("roomFloor",this.roomFloor);
    map.put("roomExplain",this.roomExplain);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(MeetingRoom obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("roomName", obj.getRoomName());
    map.put("roomFacility", obj.getRoomFacility());
    map.put("roomState", obj.getRoomState());
    map.put("roomCapacity", obj.getRoomCapacity());
    map.put("roomFloor", obj.getRoomFloor());
    map.put("roomExplain", obj.getRoomExplain());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(MeetingRoom obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("roomName", JSONObject.toJSONString(obj.getRoomName()));
    map.put("roomFacility", JSONObject.toJSONString(obj.getRoomFacility()));
    map.put("roomState", JSONObject.toJSONString(obj.getRoomState()));
    map.put("roomCapacity", JSONObject.toJSONString(obj.getRoomCapacity()));
    map.put("roomFloor", JSONObject.toJSONString(obj.getRoomFloor()));
    map.put("roomExplain", JSONObject.toJSONString(obj.getRoomExplain()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public MeetingRoom buildEntity() {
    MeetingRoom obj = new MeetingRoom();
    obj.setId(this.id);
    obj.setRoomName(this.roomName);
    obj.setRoomFacility(this.roomFacility);
    obj.setRoomState(this.roomState);
    obj.setRoomCapacity(this.roomCapacity);
    obj.setRoomFloor(this.roomFloor);
    obj.setRoomExplain(this.roomExplain);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static MeetingRoom parseEntity(Map<String, Object> map) {
    MeetingRoom obj = new MeetingRoom();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setRoomName((String) map.get("roomName"));
    obj.setRoomFacility((String) map.get("roomFacility"));
    obj.setRoomState((Integer) map.get("roomState"));
    obj.setRoomCapacity((Integer) map.get("roomCapacity"));
    obj.setRoomFloor((String) map.get("roomFloor"));
    obj.setRoomExplain((String) map.get("roomExplain"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static MeetingRoom parseSerialEntity(Map<String, String> map) {
    MeetingRoom obj = new MeetingRoom();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setRoomName(JSONObject.parseObject(map.get("roomName"), String.class));
    obj.setRoomFacility(JSONObject.parseObject(map.get("roomFacility"), String.class));
    obj.setRoomState(JSONObject.parseObject(map.get("roomState"), Integer.class));
    obj.setRoomCapacity(JSONObject.parseObject(map.get("roomCapacity"), Integer.class));
    obj.setRoomFloor(JSONObject.parseObject(map.get("roomFloor"), String.class));
    obj.setRoomExplain(JSONObject.parseObject(map.get("roomExplain"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }
}

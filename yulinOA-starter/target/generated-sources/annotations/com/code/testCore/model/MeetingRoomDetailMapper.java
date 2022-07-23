package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomDetailMapper {
  public String id;

  public String roomName;

  public String roomFacility;

  public Integer roomState;

  public Integer roomCapacity;

  public String roomFloor;

  public String roomExplain;

  public Long gmtUpdate;

  public Long gmtCreate;

  public List<Map> meetingList = null;

  public MeetingRoomDetailMapper() {
  }

  public MeetingRoomDetailMapper(String id, String roomName, String roomFacility, Integer roomState,
      Integer roomCapacity, String roomFloor, String roomExplain, Long gmtUpdate, Long gmtCreate) {
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

  public static MeetingRoomDetailMapper buildMapper(MeetingRoom obj) {
    MeetingRoomDetailMapper mapper = new MeetingRoomDetailMapper();
    mapper.id=obj.getId();
    mapper.roomName=obj.getRoomName();
    mapper.roomFacility=obj.getRoomFacility();
    mapper.roomState=obj.getRoomState();
    mapper.roomCapacity=obj.getRoomCapacity();
    mapper.roomFloor=obj.getRoomFloor();
    mapper.roomExplain=obj.getRoomExplain();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
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
    map.put("meetingList",this.meetingList);
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
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
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
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
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
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
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
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
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
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(MeetingRoom obj,
      List<Map<String, Object>> meetingList) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("meetingList", meetingList);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(MeetingRoom obj,
      List<Map<String, Object>> meetingList) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("meetingList", JSONObject.toJSONString(meetingList));
    return map;
  }
}

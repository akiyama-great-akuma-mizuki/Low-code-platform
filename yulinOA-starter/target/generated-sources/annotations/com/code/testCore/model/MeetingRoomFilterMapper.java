package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomFilterMapper {
  public String id;

  public String roomName;

  public String roomFacility;

  public Integer roomState;

  public Integer roomCapacity;

  public String roomFloor;

  public String roomExplain;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String roomNameLike = null;

  public String roomFacilityLike = null;

  public Integer roomCapacityFrom = null;

  public Integer roomCapacityTo = null;

  public String roomFloorLike = null;

  public String roomExplainLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public MeetingRoomFilterMapper() {
  }

  public MeetingRoomFilterMapper(String id, String roomName, String roomFacility, Integer roomState,
      Integer roomCapacity, String roomFloor, String roomExplain) {
    this.id=id;
    this.roomName=roomName;
    this.roomFacility=roomFacility;
    this.roomState=roomState;
    this.roomCapacity=roomCapacity;
    this.roomFloor=roomFloor;
    this.roomExplain=roomExplain;
  }

  public static MeetingRoomFilterMapper buildMapper(MeetingRoom obj) {
    MeetingRoomFilterMapper mapper = new MeetingRoomFilterMapper();
    mapper.id=obj.getId();
    mapper.roomName=obj.getRoomName();
    mapper.roomFacility=obj.getRoomFacility();
    mapper.roomState=obj.getRoomState();
    mapper.roomCapacity=obj.getRoomCapacity();
    mapper.roomFloor=obj.getRoomFloor();
    mapper.roomExplain=obj.getRoomExplain();
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
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("roomNameLike",this.roomNameLike);
    map.put("roomFacilityLike",this.roomFacilityLike);
    map.put("roomCapacityFrom",this.roomCapacityFrom);
    map.put("roomCapacityTo",this.roomCapacityTo);
    map.put("roomFloorLike",this.roomFloorLike);
    map.put("roomExplainLike",this.roomExplainLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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
    return obj;
  }

  public static Map<String, Object> buildMapExtra(MeetingRoom obj, Long page, Integer rows,
      List<String> orderBy, String roomNameLike, String roomFacilityLike, Integer roomCapacityFrom,
      Integer roomCapacityTo, String roomFloorLike, String roomExplainLike, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("roomNameLike", roomNameLike);
    map.put("roomFacilityLike", roomFacilityLike);
    map.put("roomCapacityFrom", roomCapacityFrom);
    map.put("roomCapacityTo", roomCapacityTo);
    map.put("roomFloorLike", roomFloorLike);
    map.put("roomExplainLike", roomExplainLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(MeetingRoom obj, Long page, Integer rows,
      List<String> orderBy, String roomNameLike, String roomFacilityLike, Integer roomCapacityFrom,
      Integer roomCapacityTo, String roomFloorLike, String roomExplainLike, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("roomNameLike", JSONObject.toJSONString(roomNameLike));
    map.put("roomFacilityLike", JSONObject.toJSONString(roomFacilityLike));
    map.put("roomCapacityFrom", JSONObject.toJSONString(roomCapacityFrom));
    map.put("roomCapacityTo", JSONObject.toJSONString(roomCapacityTo));
    map.put("roomFloorLike", JSONObject.toJSONString(roomFloorLike));
    map.put("roomExplainLike", JSONObject.toJSONString(roomExplainLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

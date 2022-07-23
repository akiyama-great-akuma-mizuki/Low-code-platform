package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeetingParticipantDetailMapper {
  public String id;

  public String meetingId;

  public String userId;

  public Integer status;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map meeting = null;

  public Map user = null;

  public MeetingParticipantDetailMapper() {
  }

  public MeetingParticipantDetailMapper(String id, String meetingId, String userId, Integer status,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.meetingId=meetingId;
    this.userId=userId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static MeetingParticipantDetailMapper buildMapper(MeetingParticipant obj) {
    MeetingParticipantDetailMapper mapper = new MeetingParticipantDetailMapper();
    mapper.id=obj.getId();
    mapper.meetingId=obj.getMeetingId();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("meetingId",this.meetingId);
    map.put("userId",this.userId);
    map.put("status",this.status);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("meeting",this.meeting);
    map.put("user",this.user);
    return map;
  }

  public static Map<String, Object> buildMap(MeetingParticipant obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("meetingId", obj.getMeetingId());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(MeetingParticipant obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("meetingId", JSONObject.toJSONString(obj.getMeetingId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public MeetingParticipant buildEntity() {
    MeetingParticipant obj = new MeetingParticipant();
    obj.setId(this.id);
    obj.setMeetingId(this.meetingId);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static MeetingParticipant parseEntity(Map<String, Object> map) {
    MeetingParticipant obj = new MeetingParticipant();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setMeetingId((String) map.get("meetingId"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static MeetingParticipant parseSerialEntity(Map<String, String> map) {
    MeetingParticipant obj = new MeetingParticipant();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setMeetingId(JSONObject.parseObject(map.get("meetingId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(MeetingParticipant obj,
      Map<String, Object> meeting, Map<String, Object> user) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("meeting", meeting);
    map.put("user", user);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(MeetingParticipant obj,
      Map<String, Object> meeting, Map<String, Object> user) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("meeting", JSONObject.toJSONString(meeting));
    map.put("user", JSONObject.toJSONString(user));
    return map;
  }
}

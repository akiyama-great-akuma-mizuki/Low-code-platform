package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeetingParticipantUpdateMapper {
  public String id;

  public String meetingId;

  public String userId;

  public Integer status;

  public MeetingParticipantUpdateMapper() {
  }

  public MeetingParticipantUpdateMapper(String id, String meetingId, String userId,
      Integer status) {
    this.id=id;
    this.meetingId=meetingId;
    this.userId=userId;
    this.status=status;
  }

  public static MeetingParticipantUpdateMapper buildMapper(MeetingParticipant obj) {
    MeetingParticipantUpdateMapper mapper = new MeetingParticipantUpdateMapper();
    mapper.id=obj.getId();
    mapper.meetingId=obj.getMeetingId();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("meetingId",this.meetingId);
    map.put("userId",this.userId);
    map.put("status",this.status);
    return map;
  }

  public static Map<String, Object> buildMap(MeetingParticipant obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("meetingId", obj.getMeetingId());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(MeetingParticipant obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("meetingId", JSONObject.toJSONString(obj.getMeetingId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public MeetingParticipant buildEntity() {
    MeetingParticipant obj = new MeetingParticipant();
    obj.setId(this.id);
    obj.setMeetingId(this.meetingId);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    return obj;
  }

  public static MeetingParticipant parseEntity(Map<String, Object> map) {
    MeetingParticipant obj = new MeetingParticipant();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setMeetingId((String) map.get("meetingId"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static MeetingParticipant parseSerialEntity(Map<String, String> map) {
    MeetingParticipant obj = new MeetingParticipant();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setMeetingId(JSONObject.parseObject(map.get("meetingId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }
}

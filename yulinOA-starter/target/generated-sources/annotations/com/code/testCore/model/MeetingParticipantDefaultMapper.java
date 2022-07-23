package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeetingParticipantDefaultMapper {
  public String id;

  public String meetingId;

  public String userId;

  public Integer status;

  public Date gmtUpdate;

  public Date gmtCreate;

  public MeetingParticipantDefaultMapper() {
  }

  public MeetingParticipantDefaultMapper(String id, String meetingId, String userId, Integer status,
      Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.meetingId=meetingId;
    this.userId=userId;
    this.status=status;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static MeetingParticipantDefaultMapper buildMapper(MeetingParticipant obj) {
    MeetingParticipantDefaultMapper mapper = new MeetingParticipantDefaultMapper();
    mapper.id=obj.getId();
    mapper.meetingId=obj.getMeetingId();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    return map;
  }

  public static Map<String, Object> buildMap(MeetingParticipant obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("meetingId", obj.getMeetingId());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(MeetingParticipant obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("meetingId", JSONObject.toJSONString(obj.getMeetingId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public MeetingParticipant buildEntity() {
    MeetingParticipant obj = new MeetingParticipant();
    obj.setId(this.id);
    obj.setMeetingId(this.meetingId);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static MeetingParticipant parseEntity(Map<String, Object> map) {
    MeetingParticipant obj = new MeetingParticipant();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setMeetingId((String) map.get("meetingId"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((Integer) map.get("status"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static MeetingParticipant parseSerialEntity(Map<String, String> map) {
    MeetingParticipant obj = new MeetingParticipant();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setMeetingId(JSONObject.parseObject(map.get("meetingId"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }
}

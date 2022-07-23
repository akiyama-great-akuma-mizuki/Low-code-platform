package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MeetingParticipantFilterMapper {
  public String id;

  public String meetingId;

  public String userId;

  public Integer status;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public List<Integer> statusIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public MeetingParticipantFilterMapper() {
  }

  public MeetingParticipantFilterMapper(String id, String meetingId, String userId,
      Integer status) {
    this.id=id;
    this.meetingId=meetingId;
    this.userId=userId;
    this.status=status;
  }

  public static MeetingParticipantFilterMapper buildMapper(MeetingParticipant obj) {
    MeetingParticipantFilterMapper mapper = new MeetingParticipantFilterMapper();
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
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("statusIn",this.statusIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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

  public static Map<String, Object> buildMapExtra(MeetingParticipant obj, Long page, Integer rows,
      List<String> orderBy, List<Integer> statusIn, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("statusIn", statusIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(MeetingParticipant obj, Long page,
      Integer rows, List<String> orderBy, List<Integer> statusIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("statusIn", JSONObject.toJSONString(statusIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

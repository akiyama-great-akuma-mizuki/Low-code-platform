package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MeetingDetailMapper {
  public String id;

  public String applyPeople;

  public String enterpriseId;

  public String meetingRoomId;

  public String meetingTitle;

  public Integer joinMeetingNum;

  public Long meetingTime;

  public String meetingAddress;

  public String meetingExplain;

  public Integer audiState;

  public String audiRemark;

  public Long gmtUpdate;

  public Long gmtCreate;

  public Map meetingRoom = null;

  public List<Map> meetingParticipantList = null;

  public Map enterprise = null;

  public MeetingDetailMapper() {
  }

  public MeetingDetailMapper(String id, String applyPeople, String enterpriseId,
      String meetingRoomId, String meetingTitle, Integer joinMeetingNum, Long meetingTime,
      String meetingAddress, String meetingExplain, Integer audiState, String audiRemark,
      Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.applyPeople=applyPeople;
    this.enterpriseId=enterpriseId;
    this.meetingRoomId=meetingRoomId;
    this.meetingTitle=meetingTitle;
    this.joinMeetingNum=joinMeetingNum;
    this.meetingTime=meetingTime;
    this.meetingAddress=meetingAddress;
    this.meetingExplain=meetingExplain;
    this.audiState=audiState;
    this.audiRemark=audiRemark;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static MeetingDetailMapper buildMapper(Meeting obj) {
    MeetingDetailMapper mapper = new MeetingDetailMapper();
    mapper.id=obj.getId();
    mapper.applyPeople=obj.getApplyPeople();
    mapper.enterpriseId=obj.getEnterpriseId();
    mapper.meetingRoomId=obj.getMeetingRoomId();
    mapper.meetingTitle=obj.getMeetingTitle();
    mapper.joinMeetingNum=obj.getJoinMeetingNum();
    mapper.meetingTime=obj.modifyTime(obj.getMeetingTime());
    mapper.meetingAddress=obj.getMeetingAddress();
    mapper.meetingExplain=obj.getMeetingExplain();
    mapper.audiState=obj.getAudiState();
    mapper.audiRemark=obj.getAudiRemark();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("applyPeople",this.applyPeople);
    map.put("enterpriseId",this.enterpriseId);
    map.put("meetingRoomId",this.meetingRoomId);
    map.put("meetingTitle",this.meetingTitle);
    map.put("joinMeetingNum",this.joinMeetingNum);
    map.put("meetingTime",this.meetingTime);
    map.put("meetingAddress",this.meetingAddress);
    map.put("meetingExplain",this.meetingExplain);
    map.put("audiState",this.audiState);
    map.put("audiRemark",this.audiRemark);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    map.put("meetingRoom",this.meetingRoom);
    map.put("meetingParticipantList",this.meetingParticipantList);
    map.put("enterprise",this.enterprise);
    return map;
  }

  public static Map<String, Object> buildMap(Meeting obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("applyPeople", obj.getApplyPeople());
    map.put("enterpriseId", obj.getEnterpriseId());
    map.put("meetingRoomId", obj.getMeetingRoomId());
    map.put("meetingTitle", obj.getMeetingTitle());
    map.put("joinMeetingNum", obj.getJoinMeetingNum());
    map.put("meetingTime", obj.modifyTime(obj.getMeetingTime()));
    map.put("meetingAddress", obj.getMeetingAddress());
    map.put("meetingExplain", obj.getMeetingExplain());
    map.put("audiState", obj.getAudiState());
    map.put("audiRemark", obj.getAudiRemark());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Meeting obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("applyPeople", JSONObject.toJSONString(obj.getApplyPeople()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    map.put("meetingRoomId", JSONObject.toJSONString(obj.getMeetingRoomId()));
    map.put("meetingTitle", JSONObject.toJSONString(obj.getMeetingTitle()));
    map.put("joinMeetingNum", JSONObject.toJSONString(obj.getJoinMeetingNum()));
    map.put("meetingTime", JSONObject.toJSONString(obj.modifyTime(obj.getMeetingTime())));
    map.put("meetingAddress", JSONObject.toJSONString(obj.getMeetingAddress()));
    map.put("meetingExplain", JSONObject.toJSONString(obj.getMeetingExplain()));
    map.put("audiState", JSONObject.toJSONString(obj.getAudiState()));
    map.put("audiRemark", JSONObject.toJSONString(obj.getAudiRemark()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Meeting buildEntity() {
    Meeting obj = new Meeting();
    obj.setId(this.id);
    obj.setApplyPeople(this.applyPeople);
    obj.setEnterpriseId(this.enterpriseId);
    obj.setMeetingRoomId(this.meetingRoomId);
    obj.setMeetingTitle(this.meetingTitle);
    obj.setJoinMeetingNum(this.joinMeetingNum);
    obj.setMeetingTime(obj.recoverTime(this.meetingTime));
    obj.setMeetingAddress(this.meetingAddress);
    obj.setMeetingExplain(this.meetingExplain);
    obj.setAudiState(this.audiState);
    obj.setAudiRemark(this.audiRemark);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Meeting parseEntity(Map<String, Object> map) {
    Meeting obj = new Meeting();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setApplyPeople((String) map.get("applyPeople"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    obj.setMeetingRoomId((String) map.get("meetingRoomId"));
    obj.setMeetingTitle((String) map.get("meetingTitle"));
    obj.setJoinMeetingNum((Integer) map.get("joinMeetingNum"));
    obj.setMeetingTime(obj.recoverTime((Long) map.get("meetingTime")));
    obj.setMeetingAddress((String) map.get("meetingAddress"));
    obj.setMeetingExplain((String) map.get("meetingExplain"));
    obj.setAudiState((Integer) map.get("audiState"));
    obj.setAudiRemark((String) map.get("audiRemark"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Meeting parseSerialEntity(Map<String, String> map) {
    Meeting obj = new Meeting();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setApplyPeople(JSONObject.parseObject(map.get("applyPeople"), String.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    obj.setMeetingRoomId(JSONObject.parseObject(map.get("meetingRoomId"), String.class));
    obj.setMeetingTitle(JSONObject.parseObject(map.get("meetingTitle"), String.class));
    obj.setJoinMeetingNum(JSONObject.parseObject(map.get("joinMeetingNum"), Integer.class));
    obj.setMeetingTime(obj.recoverTime(JSONObject.parseObject(map.get("meetingTime"), Long.class)));
    obj.setMeetingAddress(JSONObject.parseObject(map.get("meetingAddress"), String.class));
    obj.setMeetingExplain(JSONObject.parseObject(map.get("meetingExplain"), String.class));
    obj.setAudiState(JSONObject.parseObject(map.get("audiState"), Integer.class));
    obj.setAudiRemark(JSONObject.parseObject(map.get("audiRemark"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Meeting obj, Map<String, Object> meetingRoom,
      List<Map<String, Object>> meetingParticipantList, Map<String, Object> enterprise) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("meetingRoom", meetingRoom);
    map.put("meetingParticipantList", meetingParticipantList);
    map.put("enterprise", enterprise);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Meeting obj,
      Map<String, Object> meetingRoom, List<Map<String, Object>> meetingParticipantList,
      Map<String, Object> enterprise) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("meetingRoom", JSONObject.toJSONString(meetingRoom));
    map.put("meetingParticipantList", JSONObject.toJSONString(meetingParticipantList));
    map.put("enterprise", JSONObject.toJSONString(enterprise));
    return map;
  }
}

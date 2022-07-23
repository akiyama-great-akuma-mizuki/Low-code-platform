package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeetingUpdateMapper {
  public String id;

  public String applyPeople;

  public String enterpriseId;

  public String meetingTitle;

  public Integer joinMeetingNum;

  public Long meetingTime;

  public String meetingAddress;

  public String meetingExplain;

  public Integer audiState;

  public String audiRemark;

  public MeetingUpdateMapper() {
  }

  public MeetingUpdateMapper(String id, String applyPeople, String enterpriseId,
      String meetingTitle, Integer joinMeetingNum, Long meetingTime, String meetingAddress,
      String meetingExplain, Integer audiState, String audiRemark) {
    this.id=id;
    this.applyPeople=applyPeople;
    this.enterpriseId=enterpriseId;
    this.meetingTitle=meetingTitle;
    this.joinMeetingNum=joinMeetingNum;
    this.meetingTime=meetingTime;
    this.meetingAddress=meetingAddress;
    this.meetingExplain=meetingExplain;
    this.audiState=audiState;
    this.audiRemark=audiRemark;
  }

  public static MeetingUpdateMapper buildMapper(Meeting obj) {
    MeetingUpdateMapper mapper = new MeetingUpdateMapper();
    mapper.id=obj.getId();
    mapper.applyPeople=obj.getApplyPeople();
    mapper.enterpriseId=obj.getEnterpriseId();
    mapper.meetingTitle=obj.getMeetingTitle();
    mapper.joinMeetingNum=obj.getJoinMeetingNum();
    mapper.meetingTime=obj.modifyTime(obj.getMeetingTime());
    mapper.meetingAddress=obj.getMeetingAddress();
    mapper.meetingExplain=obj.getMeetingExplain();
    mapper.audiState=obj.getAudiState();
    mapper.audiRemark=obj.getAudiRemark();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("applyPeople",this.applyPeople);
    map.put("enterpriseId",this.enterpriseId);
    map.put("meetingTitle",this.meetingTitle);
    map.put("joinMeetingNum",this.joinMeetingNum);
    map.put("meetingTime",this.meetingTime);
    map.put("meetingAddress",this.meetingAddress);
    map.put("meetingExplain",this.meetingExplain);
    map.put("audiState",this.audiState);
    map.put("audiRemark",this.audiRemark);
    return map;
  }

  public static Map<String, Object> buildMap(Meeting obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("applyPeople", obj.getApplyPeople());
    map.put("enterpriseId", obj.getEnterpriseId());
    map.put("meetingTitle", obj.getMeetingTitle());
    map.put("joinMeetingNum", obj.getJoinMeetingNum());
    map.put("meetingTime", obj.modifyTime(obj.getMeetingTime()));
    map.put("meetingAddress", obj.getMeetingAddress());
    map.put("meetingExplain", obj.getMeetingExplain());
    map.put("audiState", obj.getAudiState());
    map.put("audiRemark", obj.getAudiRemark());
    return map;
  }

  public static Map<String, String> buildSerialMap(Meeting obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("applyPeople", JSONObject.toJSONString(obj.getApplyPeople()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    map.put("meetingTitle", JSONObject.toJSONString(obj.getMeetingTitle()));
    map.put("joinMeetingNum", JSONObject.toJSONString(obj.getJoinMeetingNum()));
    map.put("meetingTime", JSONObject.toJSONString(obj.modifyTime(obj.getMeetingTime())));
    map.put("meetingAddress", JSONObject.toJSONString(obj.getMeetingAddress()));
    map.put("meetingExplain", JSONObject.toJSONString(obj.getMeetingExplain()));
    map.put("audiState", JSONObject.toJSONString(obj.getAudiState()));
    map.put("audiRemark", JSONObject.toJSONString(obj.getAudiRemark()));
    return map;
  }

  public Meeting buildEntity() {
    Meeting obj = new Meeting();
    obj.setId(this.id);
    obj.setApplyPeople(this.applyPeople);
    obj.setEnterpriseId(this.enterpriseId);
    obj.setMeetingTitle(this.meetingTitle);
    obj.setJoinMeetingNum(this.joinMeetingNum);
    obj.setMeetingTime(obj.recoverTime(this.meetingTime));
    obj.setMeetingAddress(this.meetingAddress);
    obj.setMeetingExplain(this.meetingExplain);
    obj.setAudiState(this.audiState);
    obj.setAudiRemark(this.audiRemark);
    return obj;
  }

  public static Meeting parseEntity(Map<String, Object> map) {
    Meeting obj = new Meeting();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setApplyPeople((String) map.get("applyPeople"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    obj.setMeetingTitle((String) map.get("meetingTitle"));
    obj.setJoinMeetingNum((Integer) map.get("joinMeetingNum"));
    obj.setMeetingTime(obj.recoverTime((Long) map.get("meetingTime")));
    obj.setMeetingAddress((String) map.get("meetingAddress"));
    obj.setMeetingExplain((String) map.get("meetingExplain"));
    obj.setAudiState((Integer) map.get("audiState"));
    obj.setAudiRemark((String) map.get("audiRemark"));
    return obj;
  }

  public static Meeting parseSerialEntity(Map<String, String> map) {
    Meeting obj = new Meeting();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setApplyPeople(JSONObject.parseObject(map.get("applyPeople"), String.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    obj.setMeetingTitle(JSONObject.parseObject(map.get("meetingTitle"), String.class));
    obj.setJoinMeetingNum(JSONObject.parseObject(map.get("joinMeetingNum"), Integer.class));
    obj.setMeetingTime(obj.recoverTime(JSONObject.parseObject(map.get("meetingTime"), Long.class)));
    obj.setMeetingAddress(JSONObject.parseObject(map.get("meetingAddress"), String.class));
    obj.setMeetingExplain(JSONObject.parseObject(map.get("meetingExplain"), String.class));
    obj.setAudiState(JSONObject.parseObject(map.get("audiState"), Integer.class));
    obj.setAudiRemark(JSONObject.parseObject(map.get("audiRemark"), String.class));
    return obj;
  }
}

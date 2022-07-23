package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.MeetingDO;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class MeetingData {
  public String id;

  public String applyPeople;

  public String enterpriseId;

  public String meetingRoomId;

  public String meetingTitle;

  public Integer joinMeetingNum;

  public Date meetingTime;

  public String meetingAddress;

  public String meetingExplain;

  public Integer audiState;

  public String audiRemark;

  public Date gmtUpdate;

  public Date gmtCreate;

  public MeetingData() {
  }

  public MeetingData(String id, String applyPeople, String enterpriseId, String meetingRoomId,
      String meetingTitle, Integer joinMeetingNum, Date meetingTime, String meetingAddress,
      String meetingExplain, Integer audiState, String audiRemark, Date gmtUpdate, Date gmtCreate) {
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

  public static MeetingData buildMapper(Meeting obj) {
    MeetingData mapper = new MeetingData();
    mapper.id=obj.getId();
    mapper.applyPeople=obj.getApplyPeople();
    mapper.enterpriseId=obj.getEnterpriseId();
    mapper.meetingRoomId=obj.getMeetingRoomId();
    mapper.meetingTitle=obj.getMeetingTitle();
    mapper.joinMeetingNum=obj.getJoinMeetingNum();
    mapper.meetingTime=obj.getMeetingTime();
    mapper.meetingAddress=obj.getMeetingAddress();
    mapper.meetingExplain=obj.getMeetingExplain();
    mapper.audiState=obj.getAudiState();
    mapper.audiRemark=obj.getAudiRemark();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("meetingTime", obj.getMeetingTime());
    map.put("meetingAddress", obj.getMeetingAddress());
    map.put("meetingExplain", obj.getMeetingExplain());
    map.put("audiState", obj.getAudiState());
    map.put("audiRemark", obj.getAudiRemark());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
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
    map.put("meetingTime", JSONObject.toJSONString(obj.getMeetingTime()));
    map.put("meetingAddress", JSONObject.toJSONString(obj.getMeetingAddress()));
    map.put("meetingExplain", JSONObject.toJSONString(obj.getMeetingExplain()));
    map.put("audiState", JSONObject.toJSONString(obj.getAudiState()));
    map.put("audiRemark", JSONObject.toJSONString(obj.getAudiRemark()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
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
    obj.setMeetingTime(this.meetingTime);
    obj.setMeetingAddress(this.meetingAddress);
    obj.setMeetingExplain(this.meetingExplain);
    obj.setAudiState(this.audiState);
    obj.setAudiRemark(this.audiRemark);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
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
    obj.setMeetingTime((Date) map.get("meetingTime"));
    obj.setMeetingAddress((String) map.get("meetingAddress"));
    obj.setMeetingExplain((String) map.get("meetingExplain"));
    obj.setAudiState((Integer) map.get("audiState"));
    obj.setAudiRemark((String) map.get("audiRemark"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
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
    obj.setMeetingTime(JSONObject.parseObject(map.get("meetingTime"), Date.class));
    obj.setMeetingAddress(JSONObject.parseObject(map.get("meetingAddress"), String.class));
    obj.setMeetingExplain(JSONObject.parseObject(map.get("meetingExplain"), String.class));
    obj.setAudiState(JSONObject.parseObject(map.get("audiState"), Integer.class));
    obj.setAudiRemark(JSONObject.parseObject(map.get("audiRemark"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static MeetingDO convert(Meeting from, MeetingDO to) {
    if (from == null) return to;
    if (to == null) to = new MeetingDO();
    to.setId(from.getId());
    to.setApplyPeople(from.getApplyPeople());
    to.setEnterpriseId(from.getEnterpriseId());
    to.setMeetingRoomId(from.getMeetingRoomId());
    to.setMeetingTitle(from.getMeetingTitle());
    to.setJoinMeetingNum(from.getJoinMeetingNum());
    to.setMeetingTime(from.getMeetingTime());
    to.setMeetingAddress(from.getMeetingAddress());
    to.setMeetingExplain(from.getMeetingExplain());
    to.setAudiState(from.getAudiState());
    to.setAudiRemark(from.getAudiRemark());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static Meeting convert(MeetingDO from, Meeting to) {
    if (from == null) return to;
    if (to == null) to = new Meeting();
    to.setId(from.getId());
    to.setApplyPeople(from.getApplyPeople());
    to.setEnterpriseId(from.getEnterpriseId());
    to.setMeetingRoomId(from.getMeetingRoomId());
    to.setMeetingTitle(from.getMeetingTitle());
    to.setJoinMeetingNum(from.getJoinMeetingNum());
    to.setMeetingTime(from.getMeetingTime());
    to.setMeetingAddress(from.getMeetingAddress());
    to.setMeetingExplain(from.getMeetingExplain());
    to.setAudiState(from.getAudiState());
    to.setAudiRemark(from.getAudiRemark());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

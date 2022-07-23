package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MeetingFilterMapper {
  public String id;

  public String applyPeople;

  public String enterpriseId;

  public String meetingRoomId;

  public String meetingTitle;

  public Integer joinMeetingNum;

  public String meetingAddress;

  public String meetingExplain;

  public Integer audiState;

  public String audiRemark;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String meetingTitleLike = null;

  public List<Integer> joinMeetingNumIn = null;

  public List<Long> meetingTimeIn = null;

  public String meetingAddressLike = null;

  public String meetingExplainLike = null;

  public String audiRemarkLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public MeetingFilterMapper() {
  }

  public MeetingFilterMapper(String id, String applyPeople, String enterpriseId,
      String meetingRoomId, String meetingTitle, Integer joinMeetingNum, String meetingAddress,
      String meetingExplain, Integer audiState, String audiRemark) {
    this.id=id;
    this.applyPeople=applyPeople;
    this.enterpriseId=enterpriseId;
    this.meetingRoomId=meetingRoomId;
    this.meetingTitle=meetingTitle;
    this.joinMeetingNum=joinMeetingNum;
    this.meetingAddress=meetingAddress;
    this.meetingExplain=meetingExplain;
    this.audiState=audiState;
    this.audiRemark=audiRemark;
  }

  public static MeetingFilterMapper buildMapper(Meeting obj) {
    MeetingFilterMapper mapper = new MeetingFilterMapper();
    mapper.id=obj.getId();
    mapper.applyPeople=obj.getApplyPeople();
    mapper.enterpriseId=obj.getEnterpriseId();
    mapper.meetingRoomId=obj.getMeetingRoomId();
    mapper.meetingTitle=obj.getMeetingTitle();
    mapper.joinMeetingNum=obj.getJoinMeetingNum();
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
    map.put("meetingRoomId",this.meetingRoomId);
    map.put("meetingTitle",this.meetingTitle);
    map.put("joinMeetingNum",this.joinMeetingNum);
    map.put("meetingAddress",this.meetingAddress);
    map.put("meetingExplain",this.meetingExplain);
    map.put("audiState",this.audiState);
    map.put("audiRemark",this.audiRemark);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("meetingTitleLike",this.meetingTitleLike);
    map.put("joinMeetingNumIn",this.joinMeetingNumIn);
    map.put("meetingTimeIn",this.meetingTimeIn);
    map.put("meetingAddressLike",this.meetingAddressLike);
    map.put("meetingExplainLike",this.meetingExplainLike);
    map.put("audiRemarkLike",this.audiRemarkLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
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
    map.put("meetingRoomId", JSONObject.toJSONString(obj.getMeetingRoomId()));
    map.put("meetingTitle", JSONObject.toJSONString(obj.getMeetingTitle()));
    map.put("joinMeetingNum", JSONObject.toJSONString(obj.getJoinMeetingNum()));
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
    obj.setMeetingRoomId(this.meetingRoomId);
    obj.setMeetingTitle(this.meetingTitle);
    obj.setJoinMeetingNum(this.joinMeetingNum);
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
    obj.setMeetingRoomId((String) map.get("meetingRoomId"));
    obj.setMeetingTitle((String) map.get("meetingTitle"));
    obj.setJoinMeetingNum((Integer) map.get("joinMeetingNum"));
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
    obj.setMeetingRoomId(JSONObject.parseObject(map.get("meetingRoomId"), String.class));
    obj.setMeetingTitle(JSONObject.parseObject(map.get("meetingTitle"), String.class));
    obj.setJoinMeetingNum(JSONObject.parseObject(map.get("joinMeetingNum"), Integer.class));
    obj.setMeetingAddress(JSONObject.parseObject(map.get("meetingAddress"), String.class));
    obj.setMeetingExplain(JSONObject.parseObject(map.get("meetingExplain"), String.class));
    obj.setAudiState(JSONObject.parseObject(map.get("audiState"), Integer.class));
    obj.setAudiRemark(JSONObject.parseObject(map.get("audiRemark"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Meeting obj, Long page, Integer rows,
      List<String> orderBy, String meetingTitleLike, List<Integer> joinMeetingNumIn,
      List<Long> meetingTimeIn, String meetingAddressLike, String meetingExplainLike,
      String audiRemarkLike, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("meetingTitleLike", meetingTitleLike);
    map.put("joinMeetingNumIn", joinMeetingNumIn);
    map.put("meetingTimeIn", meetingTimeIn);
    map.put("meetingAddressLike", meetingAddressLike);
    map.put("meetingExplainLike", meetingExplainLike);
    map.put("audiRemarkLike", audiRemarkLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Meeting obj, Long page, Integer rows,
      List<String> orderBy, String meetingTitleLike, List<Integer> joinMeetingNumIn,
      List<Long> meetingTimeIn, String meetingAddressLike, String meetingExplainLike,
      String audiRemarkLike, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("meetingTitleLike", JSONObject.toJSONString(meetingTitleLike));
    map.put("joinMeetingNumIn", JSONObject.toJSONString(joinMeetingNumIn));
    map.put("meetingTimeIn", JSONObject.toJSONString(meetingTimeIn));
    map.put("meetingAddressLike", JSONObject.toJSONString(meetingAddressLike));
    map.put("meetingExplainLike", JSONObject.toJSONString(meetingExplainLike));
    map.put("audiRemarkLike", JSONObject.toJSONString(audiRemarkLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

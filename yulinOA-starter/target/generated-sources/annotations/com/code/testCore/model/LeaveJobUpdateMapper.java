package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeaveJobUpdateMapper {
  public String id;

  public String userId;

  public String position;

  public Long applyLeaveTime;

  public String leaveReason;

  public String leaveRemark;

  public Integer status;

  public LeaveJobUpdateMapper() {
  }

  public LeaveJobUpdateMapper(String id, String userId, String position, Long applyLeaveTime,
      String leaveReason, String leaveRemark, Integer status) {
    this.id=id;
    this.userId=userId;
    this.position=position;
    this.applyLeaveTime=applyLeaveTime;
    this.leaveReason=leaveReason;
    this.leaveRemark=leaveRemark;
    this.status=status;
  }

  public static LeaveJobUpdateMapper buildMapper(LeaveJob obj) {
    LeaveJobUpdateMapper mapper = new LeaveJobUpdateMapper();
    mapper.id=obj.getId();
    mapper.userId=obj.getUserId();
    mapper.position=obj.getPosition();
    mapper.applyLeaveTime=obj.modifyTime(obj.getApplyLeaveTime());
    mapper.leaveReason=obj.getLeaveReason();
    mapper.leaveRemark=obj.getLeaveRemark();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("userId",this.userId);
    map.put("position",this.position);
    map.put("applyLeaveTime",this.applyLeaveTime);
    map.put("leaveReason",this.leaveReason);
    map.put("leaveRemark",this.leaveRemark);
    map.put("status",this.status);
    return map;
  }

  public static Map<String, Object> buildMap(LeaveJob obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("userId", obj.getUserId());
    map.put("position", obj.getPosition());
    map.put("applyLeaveTime", obj.modifyTime(obj.getApplyLeaveTime()));
    map.put("leaveReason", obj.getLeaveReason());
    map.put("leaveRemark", obj.getLeaveRemark());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(LeaveJob obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("position", JSONObject.toJSONString(obj.getPosition()));
    map.put("applyLeaveTime", JSONObject.toJSONString(obj.modifyTime(obj.getApplyLeaveTime())));
    map.put("leaveReason", JSONObject.toJSONString(obj.getLeaveReason()));
    map.put("leaveRemark", JSONObject.toJSONString(obj.getLeaveRemark()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public LeaveJob buildEntity() {
    LeaveJob obj = new LeaveJob();
    obj.setId(this.id);
    obj.setUserId(this.userId);
    obj.setPosition(this.position);
    obj.setApplyLeaveTime(obj.recoverTime(this.applyLeaveTime));
    obj.setLeaveReason(this.leaveReason);
    obj.setLeaveRemark(this.leaveRemark);
    obj.setStatus(this.status);
    return obj;
  }

  public static LeaveJob parseEntity(Map<String, Object> map) {
    LeaveJob obj = new LeaveJob();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setUserId((String) map.get("userId"));
    obj.setPosition((String) map.get("position"));
    obj.setApplyLeaveTime(obj.recoverTime((Long) map.get("applyLeaveTime")));
    obj.setLeaveReason((String) map.get("leaveReason"));
    obj.setLeaveRemark((String) map.get("leaveRemark"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static LeaveJob parseSerialEntity(Map<String, String> map) {
    LeaveJob obj = new LeaveJob();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setPosition(JSONObject.parseObject(map.get("position"), String.class));
    obj.setApplyLeaveTime(obj.recoverTime(JSONObject.parseObject(map.get("applyLeaveTime"), Long.class)));
    obj.setLeaveReason(JSONObject.parseObject(map.get("leaveReason"), String.class));
    obj.setLeaveRemark(JSONObject.parseObject(map.get("leaveRemark"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }
}

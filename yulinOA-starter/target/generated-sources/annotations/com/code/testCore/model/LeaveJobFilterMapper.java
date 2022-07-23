package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LeaveJobFilterMapper {
  public String id;

  public String userId;

  public String position;

  public String leaveReason;

  public String leaveRemark;

  public Integer status;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String positionLike = null;

  public List<String> positionIn = null;

  public Long applyLeaveTimeLike = null;

  public String leaveReasonLike = null;

  public List<String> leaveReasonIn = null;

  public String leaveRemarkLike = null;

  public List<String> leaveRemarkIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public LeaveJobFilterMapper() {
  }

  public LeaveJobFilterMapper(String id, String userId, String position, String leaveReason,
      String leaveRemark, Integer status) {
    this.id=id;
    this.userId=userId;
    this.position=position;
    this.leaveReason=leaveReason;
    this.leaveRemark=leaveRemark;
    this.status=status;
  }

  public static LeaveJobFilterMapper buildMapper(LeaveJob obj) {
    LeaveJobFilterMapper mapper = new LeaveJobFilterMapper();
    mapper.id=obj.getId();
    mapper.userId=obj.getUserId();
    mapper.position=obj.getPosition();
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
    map.put("leaveReason",this.leaveReason);
    map.put("leaveRemark",this.leaveRemark);
    map.put("status",this.status);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("positionLike",this.positionLike);
    map.put("positionIn",this.positionIn);
    map.put("applyLeaveTimeLike",this.applyLeaveTimeLike);
    map.put("leaveReasonLike",this.leaveReasonLike);
    map.put("leaveReasonIn",this.leaveReasonIn);
    map.put("leaveRemarkLike",this.leaveRemarkLike);
    map.put("leaveRemarkIn",this.leaveRemarkIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(LeaveJob obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("userId", obj.getUserId());
    map.put("position", obj.getPosition());
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
    obj.setLeaveReason(JSONObject.parseObject(map.get("leaveReason"), String.class));
    obj.setLeaveRemark(JSONObject.parseObject(map.get("leaveRemark"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(LeaveJob obj, Long page, Integer rows,
      List<String> orderBy, String positionLike, List<String> positionIn, Long applyLeaveTimeLike,
      String leaveReasonLike, List<String> leaveReasonIn, String leaveRemarkLike,
      List<String> leaveRemarkIn, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("positionLike", positionLike);
    map.put("positionIn", positionIn);
    map.put("applyLeaveTimeLike", applyLeaveTimeLike);
    map.put("leaveReasonLike", leaveReasonLike);
    map.put("leaveReasonIn", leaveReasonIn);
    map.put("leaveRemarkLike", leaveRemarkLike);
    map.put("leaveRemarkIn", leaveRemarkIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(LeaveJob obj, Long page, Integer rows,
      List<String> orderBy, String positionLike, List<String> positionIn, Long applyLeaveTimeLike,
      String leaveReasonLike, List<String> leaveReasonIn, String leaveRemarkLike,
      List<String> leaveRemarkIn, Long gmtUpdateFrom, Long gmtUpdateTo, Long gmtCreateFrom,
      Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("positionLike", JSONObject.toJSONString(positionLike));
    map.put("positionIn", JSONObject.toJSONString(positionIn));
    map.put("applyLeaveTimeLike", JSONObject.toJSONString(applyLeaveTimeLike));
    map.put("leaveReasonLike", JSONObject.toJSONString(leaveReasonLike));
    map.put("leaveReasonIn", JSONObject.toJSONString(leaveReasonIn));
    map.put("leaveRemarkLike", JSONObject.toJSONString(leaveRemarkLike));
    map.put("leaveRemarkIn", JSONObject.toJSONString(leaveRemarkIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

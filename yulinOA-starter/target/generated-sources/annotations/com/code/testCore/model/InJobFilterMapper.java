package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InJobFilterMapper {
  public String id;

  public String userId;

  public String phone;

  public String idCard;

  public String department;

  public String position;

  public String email;

  public String inJobRemark;

  public String approver;

  public Integer status;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String phoneLike = null;

  public List<String> phoneIn = null;

  public String idCardLike = null;

  public List<String> idCardIn = null;

  public String departmentLike = null;

  public List<String> departmentIn = null;

  public String positionLike = null;

  public List<String> positionIn = null;

  public String emailLike = null;

  public List<String> emailIn = null;

  public String inJobRemarkLike = null;

  public List<String> inJobRemarkIn = null;

  public String approverLike = null;

  public List<String> approverIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public InJobFilterMapper() {
  }

  public InJobFilterMapper(String id, String userId, String phone, String idCard, String department,
      String position, String email, String inJobRemark, String approver, Integer status) {
    this.id=id;
    this.userId=userId;
    this.phone=phone;
    this.idCard=idCard;
    this.department=department;
    this.position=position;
    this.email=email;
    this.inJobRemark=inJobRemark;
    this.approver=approver;
    this.status=status;
  }

  public static InJobFilterMapper buildMapper(InJob obj) {
    InJobFilterMapper mapper = new InJobFilterMapper();
    mapper.id=obj.getId();
    mapper.userId=obj.getUserId();
    mapper.phone=obj.getPhone();
    mapper.idCard=obj.getIdCard();
    mapper.department=obj.getDepartment();
    mapper.position=obj.getPosition();
    mapper.email=obj.getEmail();
    mapper.inJobRemark=obj.getInJobRemark();
    mapper.approver=obj.getApprover();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("userId",this.userId);
    map.put("phone",this.phone);
    map.put("idCard",this.idCard);
    map.put("department",this.department);
    map.put("position",this.position);
    map.put("email",this.email);
    map.put("inJobRemark",this.inJobRemark);
    map.put("approver",this.approver);
    map.put("status",this.status);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("phoneLike",this.phoneLike);
    map.put("phoneIn",this.phoneIn);
    map.put("idCardLike",this.idCardLike);
    map.put("idCardIn",this.idCardIn);
    map.put("departmentLike",this.departmentLike);
    map.put("departmentIn",this.departmentIn);
    map.put("positionLike",this.positionLike);
    map.put("positionIn",this.positionIn);
    map.put("emailLike",this.emailLike);
    map.put("emailIn",this.emailIn);
    map.put("inJobRemarkLike",this.inJobRemarkLike);
    map.put("inJobRemarkIn",this.inJobRemarkIn);
    map.put("approverLike",this.approverLike);
    map.put("approverIn",this.approverIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(InJob obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("userId", obj.getUserId());
    map.put("phone", obj.getPhone());
    map.put("idCard", obj.getIdCard());
    map.put("department", obj.getDepartment());
    map.put("position", obj.getPosition());
    map.put("email", obj.getEmail());
    map.put("inJobRemark", obj.getInJobRemark());
    map.put("approver", obj.getApprover());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(InJob obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("phone", JSONObject.toJSONString(obj.getPhone()));
    map.put("idCard", JSONObject.toJSONString(obj.getIdCard()));
    map.put("department", JSONObject.toJSONString(obj.getDepartment()));
    map.put("position", JSONObject.toJSONString(obj.getPosition()));
    map.put("email", JSONObject.toJSONString(obj.getEmail()));
    map.put("inJobRemark", JSONObject.toJSONString(obj.getInJobRemark()));
    map.put("approver", JSONObject.toJSONString(obj.getApprover()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public InJob buildEntity() {
    InJob obj = new InJob();
    obj.setId(this.id);
    obj.setUserId(this.userId);
    obj.setPhone(this.phone);
    obj.setIdCard(this.idCard);
    obj.setDepartment(this.department);
    obj.setPosition(this.position);
    obj.setEmail(this.email);
    obj.setInJobRemark(this.inJobRemark);
    obj.setApprover(this.approver);
    obj.setStatus(this.status);
    return obj;
  }

  public static InJob parseEntity(Map<String, Object> map) {
    InJob obj = new InJob();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setUserId((String) map.get("userId"));
    obj.setPhone((String) map.get("phone"));
    obj.setIdCard((String) map.get("idCard"));
    obj.setDepartment((String) map.get("department"));
    obj.setPosition((String) map.get("position"));
    obj.setEmail((String) map.get("email"));
    obj.setInJobRemark((String) map.get("inJobRemark"));
    obj.setApprover((String) map.get("approver"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static InJob parseSerialEntity(Map<String, String> map) {
    InJob obj = new InJob();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setPhone(JSONObject.parseObject(map.get("phone"), String.class));
    obj.setIdCard(JSONObject.parseObject(map.get("idCard"), String.class));
    obj.setDepartment(JSONObject.parseObject(map.get("department"), String.class));
    obj.setPosition(JSONObject.parseObject(map.get("position"), String.class));
    obj.setEmail(JSONObject.parseObject(map.get("email"), String.class));
    obj.setInJobRemark(JSONObject.parseObject(map.get("inJobRemark"), String.class));
    obj.setApprover(JSONObject.parseObject(map.get("approver"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(InJob obj, Long page, Integer rows,
      List<String> orderBy, String phoneLike, List<String> phoneIn, String idCardLike,
      List<String> idCardIn, String departmentLike, List<String> departmentIn, String positionLike,
      List<String> positionIn, String emailLike, List<String> emailIn, String inJobRemarkLike,
      List<String> inJobRemarkIn, String approverLike, List<String> approverIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("phoneLike", phoneLike);
    map.put("phoneIn", phoneIn);
    map.put("idCardLike", idCardLike);
    map.put("idCardIn", idCardIn);
    map.put("departmentLike", departmentLike);
    map.put("departmentIn", departmentIn);
    map.put("positionLike", positionLike);
    map.put("positionIn", positionIn);
    map.put("emailLike", emailLike);
    map.put("emailIn", emailIn);
    map.put("inJobRemarkLike", inJobRemarkLike);
    map.put("inJobRemarkIn", inJobRemarkIn);
    map.put("approverLike", approverLike);
    map.put("approverIn", approverIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(InJob obj, Long page, Integer rows,
      List<String> orderBy, String phoneLike, List<String> phoneIn, String idCardLike,
      List<String> idCardIn, String departmentLike, List<String> departmentIn, String positionLike,
      List<String> positionIn, String emailLike, List<String> emailIn, String inJobRemarkLike,
      List<String> inJobRemarkIn, String approverLike, List<String> approverIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("phoneLike", JSONObject.toJSONString(phoneLike));
    map.put("phoneIn", JSONObject.toJSONString(phoneIn));
    map.put("idCardLike", JSONObject.toJSONString(idCardLike));
    map.put("idCardIn", JSONObject.toJSONString(idCardIn));
    map.put("departmentLike", JSONObject.toJSONString(departmentLike));
    map.put("departmentIn", JSONObject.toJSONString(departmentIn));
    map.put("positionLike", JSONObject.toJSONString(positionLike));
    map.put("positionIn", JSONObject.toJSONString(positionIn));
    map.put("emailLike", JSONObject.toJSONString(emailLike));
    map.put("emailIn", JSONObject.toJSONString(emailIn));
    map.put("inJobRemarkLike", JSONObject.toJSONString(inJobRemarkLike));
    map.put("inJobRemarkIn", JSONObject.toJSONString(inJobRemarkIn));
    map.put("approverLike", JSONObject.toJSONString(approverLike));
    map.put("approverIn", JSONObject.toJSONString(approverIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

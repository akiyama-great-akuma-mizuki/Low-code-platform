package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OfficialHistoryFilterMapper {
  public String id;

  public String operateClass;

  public String operatePeople;

  public Integer result;

  public String remark;

  public String officialId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String operateClassLike = null;

  public List<String> operateClassIn = null;

  public String operatePeopleLike = null;

  public String remarkLike = null;

  public List<String> remarkIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public OfficialHistoryFilterMapper() {
  }

  public OfficialHistoryFilterMapper(String id, String operateClass, String operatePeople,
      Integer result, String remark, String officialId) {
    this.id=id;
    this.operateClass=operateClass;
    this.operatePeople=operatePeople;
    this.result=result;
    this.remark=remark;
    this.officialId=officialId;
  }

  public static OfficialHistoryFilterMapper buildMapper(OfficialHistory obj) {
    OfficialHistoryFilterMapper mapper = new OfficialHistoryFilterMapper();
    mapper.id=obj.getId();
    mapper.operateClass=obj.getOperateClass();
    mapper.operatePeople=obj.getOperatePeople();
    mapper.result=obj.getResult();
    mapper.remark=obj.getRemark();
    mapper.officialId=obj.getOfficialId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("operateClass",this.operateClass);
    map.put("operatePeople",this.operatePeople);
    map.put("result",this.result);
    map.put("remark",this.remark);
    map.put("officialId",this.officialId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("operateClassLike",this.operateClassLike);
    map.put("operateClassIn",this.operateClassIn);
    map.put("operatePeopleLike",this.operatePeopleLike);
    map.put("remarkLike",this.remarkLike);
    map.put("remarkIn",this.remarkIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(OfficialHistory obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("operateClass", obj.getOperateClass());
    map.put("operatePeople", obj.getOperatePeople());
    map.put("result", obj.getResult());
    map.put("remark", obj.getRemark());
    map.put("officialId", obj.getOfficialId());
    return map;
  }

  public static Map<String, String> buildSerialMap(OfficialHistory obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("operateClass", JSONObject.toJSONString(obj.getOperateClass()));
    map.put("operatePeople", JSONObject.toJSONString(obj.getOperatePeople()));
    map.put("result", JSONObject.toJSONString(obj.getResult()));
    map.put("remark", JSONObject.toJSONString(obj.getRemark()));
    map.put("officialId", JSONObject.toJSONString(obj.getOfficialId()));
    return map;
  }

  public OfficialHistory buildEntity() {
    OfficialHistory obj = new OfficialHistory();
    obj.setId(this.id);
    obj.setOperateClass(this.operateClass);
    obj.setOperatePeople(this.operatePeople);
    obj.setResult(this.result);
    obj.setRemark(this.remark);
    obj.setOfficialId(this.officialId);
    return obj;
  }

  public static OfficialHistory parseEntity(Map<String, Object> map) {
    OfficialHistory obj = new OfficialHistory();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setOperateClass((String) map.get("operateClass"));
    obj.setOperatePeople((String) map.get("operatePeople"));
    obj.setResult((Integer) map.get("result"));
    obj.setRemark((String) map.get("remark"));
    obj.setOfficialId((String) map.get("officialId"));
    return obj;
  }

  public static OfficialHistory parseSerialEntity(Map<String, String> map) {
    OfficialHistory obj = new OfficialHistory();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setOperateClass(JSONObject.parseObject(map.get("operateClass"), String.class));
    obj.setOperatePeople(JSONObject.parseObject(map.get("operatePeople"), String.class));
    obj.setResult(JSONObject.parseObject(map.get("result"), Integer.class));
    obj.setRemark(JSONObject.parseObject(map.get("remark"), String.class));
    obj.setOfficialId(JSONObject.parseObject(map.get("officialId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(OfficialHistory obj, Long page, Integer rows,
      List<String> orderBy, String operateClassLike, List<String> operateClassIn,
      String operatePeopleLike, String remarkLike, List<String> remarkIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("operateClassLike", operateClassLike);
    map.put("operateClassIn", operateClassIn);
    map.put("operatePeopleLike", operatePeopleLike);
    map.put("remarkLike", remarkLike);
    map.put("remarkIn", remarkIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(OfficialHistory obj, Long page,
      Integer rows, List<String> orderBy, String operateClassLike, List<String> operateClassIn,
      String operatePeopleLike, String remarkLike, List<String> remarkIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("operateClassLike", JSONObject.toJSONString(operateClassLike));
    map.put("operateClassIn", JSONObject.toJSONString(operateClassIn));
    map.put("operatePeopleLike", JSONObject.toJSONString(operatePeopleLike));
    map.put("remarkLike", JSONObject.toJSONString(remarkLike));
    map.put("remarkIn", JSONObject.toJSONString(remarkIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

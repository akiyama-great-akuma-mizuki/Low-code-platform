package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class OfficialHistoryPostMapper {
  public String operateClass;

  public String operatePeople;

  public Integer result;

  public String remark;

  public OfficialHistoryPostMapper() {
  }

  public OfficialHistoryPostMapper(String operateClass, String operatePeople, Integer result,
      String remark) {
    this.operateClass=operateClass;
    this.operatePeople=operatePeople;
    this.result=result;
    this.remark=remark;
  }

  public static OfficialHistoryPostMapper buildMapper(OfficialHistory obj) {
    OfficialHistoryPostMapper mapper = new OfficialHistoryPostMapper();
    mapper.operateClass=obj.getOperateClass();
    mapper.operatePeople=obj.getOperatePeople();
    mapper.result=obj.getResult();
    mapper.remark=obj.getRemark();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("operateClass",this.operateClass);
    map.put("operatePeople",this.operatePeople);
    map.put("result",this.result);
    map.put("remark",this.remark);
    return map;
  }

  public static Map<String, Object> buildMap(OfficialHistory obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("operateClass", obj.getOperateClass());
    map.put("operatePeople", obj.getOperatePeople());
    map.put("result", obj.getResult());
    map.put("remark", obj.getRemark());
    return map;
  }

  public static Map<String, String> buildSerialMap(OfficialHistory obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("operateClass", JSONObject.toJSONString(obj.getOperateClass()));
    map.put("operatePeople", JSONObject.toJSONString(obj.getOperatePeople()));
    map.put("result", JSONObject.toJSONString(obj.getResult()));
    map.put("remark", JSONObject.toJSONString(obj.getRemark()));
    return map;
  }

  public OfficialHistory buildEntity() {
    OfficialHistory obj = new OfficialHistory();
    obj.setOperateClass(this.operateClass);
    obj.setOperatePeople(this.operatePeople);
    obj.setResult(this.result);
    obj.setRemark(this.remark);
    return obj;
  }

  public static OfficialHistory parseEntity(Map<String, Object> map) {
    OfficialHistory obj = new OfficialHistory();
    if (map == null) return obj;
    obj.setOperateClass((String) map.get("operateClass"));
    obj.setOperatePeople((String) map.get("operatePeople"));
    obj.setResult((Integer) map.get("result"));
    obj.setRemark((String) map.get("remark"));
    return obj;
  }

  public static OfficialHistory parseSerialEntity(Map<String, String> map) {
    OfficialHistory obj = new OfficialHistory();
    if (map == null) return obj;
    obj.setOperateClass(JSONObject.parseObject(map.get("operateClass"), String.class));
    obj.setOperatePeople(JSONObject.parseObject(map.get("operatePeople"), String.class));
    obj.setResult(JSONObject.parseObject(map.get("result"), Integer.class));
    obj.setRemark(JSONObject.parseObject(map.get("remark"), String.class));
    return obj;
  }
}

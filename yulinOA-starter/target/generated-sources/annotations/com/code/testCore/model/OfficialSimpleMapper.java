package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class OfficialSimpleMapper {
  public String id;

  public String officialTitle;

  public Long sendTime;

  public String sentObj;

  public String whetherRed;

  public String signature;

  public String audit;

  public String content;

  public Long gmtUpdate;

  public Long gmtCreate;

  public OfficialSimpleMapper() {
  }

  public OfficialSimpleMapper(String id, String officialTitle, Long sendTime, String sentObj,
      String whetherRed, String signature, String audit, String content, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.officialTitle=officialTitle;
    this.sendTime=sendTime;
    this.sentObj=sentObj;
    this.whetherRed=whetherRed;
    this.signature=signature;
    this.audit=audit;
    this.content=content;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static OfficialSimpleMapper buildMapper(Official obj) {
    OfficialSimpleMapper mapper = new OfficialSimpleMapper();
    mapper.id=obj.getId();
    mapper.officialTitle=obj.getOfficialTitle();
    mapper.sendTime=obj.modifyTime(obj.getSendTime());
    mapper.sentObj=obj.getSentObj();
    mapper.whetherRed=obj.getWhetherRed();
    mapper.signature=obj.getSignature();
    mapper.audit=obj.getAudit();
    mapper.content=obj.getContent();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("officialTitle",this.officialTitle);
    map.put("sendTime",this.sendTime);
    map.put("sentObj",this.sentObj);
    map.put("whetherRed",this.whetherRed);
    map.put("signature",this.signature);
    map.put("audit",this.audit);
    map.put("content",this.content);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Official obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("officialTitle", obj.getOfficialTitle());
    map.put("sendTime", obj.modifyTime(obj.getSendTime()));
    map.put("sentObj", obj.getSentObj());
    map.put("whetherRed", obj.getWhetherRed());
    map.put("signature", obj.getSignature());
    map.put("audit", obj.getAudit());
    map.put("content", obj.getContent());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Official obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("officialTitle", JSONObject.toJSONString(obj.getOfficialTitle()));
    map.put("sendTime", JSONObject.toJSONString(obj.modifyTime(obj.getSendTime())));
    map.put("sentObj", JSONObject.toJSONString(obj.getSentObj()));
    map.put("whetherRed", JSONObject.toJSONString(obj.getWhetherRed()));
    map.put("signature", JSONObject.toJSONString(obj.getSignature()));
    map.put("audit", JSONObject.toJSONString(obj.getAudit()));
    map.put("content", JSONObject.toJSONString(obj.getContent()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Official buildEntity() {
    Official obj = new Official();
    obj.setId(this.id);
    obj.setOfficialTitle(this.officialTitle);
    obj.setSendTime(obj.recoverTime(this.sendTime));
    obj.setSentObj(this.sentObj);
    obj.setWhetherRed(this.whetherRed);
    obj.setSignature(this.signature);
    obj.setAudit(this.audit);
    obj.setContent(this.content);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Official parseEntity(Map<String, Object> map) {
    Official obj = new Official();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setOfficialTitle((String) map.get("officialTitle"));
    obj.setSendTime(obj.recoverTime((Long) map.get("sendTime")));
    obj.setSentObj((String) map.get("sentObj"));
    obj.setWhetherRed((String) map.get("whetherRed"));
    obj.setSignature((String) map.get("signature"));
    obj.setAudit((String) map.get("audit"));
    obj.setContent((String) map.get("content"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Official parseSerialEntity(Map<String, String> map) {
    Official obj = new Official();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setOfficialTitle(JSONObject.parseObject(map.get("officialTitle"), String.class));
    obj.setSendTime(obj.recoverTime(JSONObject.parseObject(map.get("sendTime"), Long.class)));
    obj.setSentObj(JSONObject.parseObject(map.get("sentObj"), String.class));
    obj.setWhetherRed(JSONObject.parseObject(map.get("whetherRed"), String.class));
    obj.setSignature(JSONObject.parseObject(map.get("signature"), String.class));
    obj.setAudit(JSONObject.parseObject(map.get("audit"), String.class));
    obj.setContent(JSONObject.parseObject(map.get("content"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}

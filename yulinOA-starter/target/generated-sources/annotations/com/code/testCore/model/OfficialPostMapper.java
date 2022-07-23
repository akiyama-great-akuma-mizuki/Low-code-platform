package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class OfficialPostMapper {
  public String officialTitle;

  public Long sendTime;

  public String sentObj;

  public String whetherRed;

  public String signature;

  public String audit;

  public String content;

  public OfficialPostMapper() {
  }

  public OfficialPostMapper(String officialTitle, Long sendTime, String sentObj, String whetherRed,
      String signature, String audit, String content) {
    this.officialTitle=officialTitle;
    this.sendTime=sendTime;
    this.sentObj=sentObj;
    this.whetherRed=whetherRed;
    this.signature=signature;
    this.audit=audit;
    this.content=content;
  }

  public static OfficialPostMapper buildMapper(Official obj) {
    OfficialPostMapper mapper = new OfficialPostMapper();
    mapper.officialTitle=obj.getOfficialTitle();
    mapper.sendTime=obj.modifyTime(obj.getSendTime());
    mapper.sentObj=obj.getSentObj();
    mapper.whetherRed=obj.getWhetherRed();
    mapper.signature=obj.getSignature();
    mapper.audit=obj.getAudit();
    mapper.content=obj.getContent();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("officialTitle",this.officialTitle);
    map.put("sendTime",this.sendTime);
    map.put("sentObj",this.sentObj);
    map.put("whetherRed",this.whetherRed);
    map.put("signature",this.signature);
    map.put("audit",this.audit);
    map.put("content",this.content);
    return map;
  }

  public static Map<String, Object> buildMap(Official obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("officialTitle", obj.getOfficialTitle());
    map.put("sendTime", obj.modifyTime(obj.getSendTime()));
    map.put("sentObj", obj.getSentObj());
    map.put("whetherRed", obj.getWhetherRed());
    map.put("signature", obj.getSignature());
    map.put("audit", obj.getAudit());
    map.put("content", obj.getContent());
    return map;
  }

  public static Map<String, String> buildSerialMap(Official obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("officialTitle", JSONObject.toJSONString(obj.getOfficialTitle()));
    map.put("sendTime", JSONObject.toJSONString(obj.modifyTime(obj.getSendTime())));
    map.put("sentObj", JSONObject.toJSONString(obj.getSentObj()));
    map.put("whetherRed", JSONObject.toJSONString(obj.getWhetherRed()));
    map.put("signature", JSONObject.toJSONString(obj.getSignature()));
    map.put("audit", JSONObject.toJSONString(obj.getAudit()));
    map.put("content", JSONObject.toJSONString(obj.getContent()));
    return map;
  }

  public Official buildEntity() {
    Official obj = new Official();
    obj.setOfficialTitle(this.officialTitle);
    obj.setSendTime(obj.recoverTime(this.sendTime));
    obj.setSentObj(this.sentObj);
    obj.setWhetherRed(this.whetherRed);
    obj.setSignature(this.signature);
    obj.setAudit(this.audit);
    obj.setContent(this.content);
    return obj;
  }

  public static Official parseEntity(Map<String, Object> map) {
    Official obj = new Official();
    if (map == null) return obj;
    obj.setOfficialTitle((String) map.get("officialTitle"));
    obj.setSendTime(obj.recoverTime((Long) map.get("sendTime")));
    obj.setSentObj((String) map.get("sentObj"));
    obj.setWhetherRed((String) map.get("whetherRed"));
    obj.setSignature((String) map.get("signature"));
    obj.setAudit((String) map.get("audit"));
    obj.setContent((String) map.get("content"));
    return obj;
  }

  public static Official parseSerialEntity(Map<String, String> map) {
    Official obj = new Official();
    if (map == null) return obj;
    obj.setOfficialTitle(JSONObject.parseObject(map.get("officialTitle"), String.class));
    obj.setSendTime(obj.recoverTime(JSONObject.parseObject(map.get("sendTime"), Long.class)));
    obj.setSentObj(JSONObject.parseObject(map.get("sentObj"), String.class));
    obj.setWhetherRed(JSONObject.parseObject(map.get("whetherRed"), String.class));
    obj.setSignature(JSONObject.parseObject(map.get("signature"), String.class));
    obj.setAudit(JSONObject.parseObject(map.get("audit"), String.class));
    obj.setContent(JSONObject.parseObject(map.get("content"), String.class));
    return obj;
  }
}

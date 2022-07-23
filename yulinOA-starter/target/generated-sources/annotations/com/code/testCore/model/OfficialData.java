package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.OfficialDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class OfficialData {
  public String id;

  public String officialTitle;

  public Date sendTime;

  public String sentObj;

  public String whetherRed;

  public String signature;

  public String audit;

  public String content;

  public Date gmtUpdate;

  public Date gmtCreate;

  public OfficialData() {
  }

  public OfficialData(String id, String officialTitle, Date sendTime, String sentObj,
      String whetherRed, String signature, String audit, String content, Date gmtUpdate,
      Date gmtCreate) {
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

  public static OfficialData buildMapper(Official obj) {
    OfficialData mapper = new OfficialData();
    mapper.id=obj.getId();
    mapper.officialTitle=obj.getOfficialTitle();
    mapper.sendTime=obj.getSendTime();
    mapper.sentObj=obj.getSentObj();
    mapper.whetherRed=obj.getWhetherRed();
    mapper.signature=obj.getSignature();
    mapper.audit=obj.getAudit();
    mapper.content=obj.getContent();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
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
    map.put("sendTime", obj.getSendTime());
    map.put("sentObj", obj.getSentObj());
    map.put("whetherRed", obj.getWhetherRed());
    map.put("signature", obj.getSignature());
    map.put("audit", obj.getAudit());
    map.put("content", obj.getContent());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(Official obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("officialTitle", JSONObject.toJSONString(obj.getOfficialTitle()));
    map.put("sendTime", JSONObject.toJSONString(obj.getSendTime()));
    map.put("sentObj", JSONObject.toJSONString(obj.getSentObj()));
    map.put("whetherRed", JSONObject.toJSONString(obj.getWhetherRed()));
    map.put("signature", JSONObject.toJSONString(obj.getSignature()));
    map.put("audit", JSONObject.toJSONString(obj.getAudit()));
    map.put("content", JSONObject.toJSONString(obj.getContent()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public Official buildEntity() {
    Official obj = new Official();
    obj.setId(this.id);
    obj.setOfficialTitle(this.officialTitle);
    obj.setSendTime(this.sendTime);
    obj.setSentObj(this.sentObj);
    obj.setWhetherRed(this.whetherRed);
    obj.setSignature(this.signature);
    obj.setAudit(this.audit);
    obj.setContent(this.content);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static Official parseEntity(Map<String, Object> map) {
    Official obj = new Official();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setOfficialTitle((String) map.get("officialTitle"));
    obj.setSendTime((Date) map.get("sendTime"));
    obj.setSentObj((String) map.get("sentObj"));
    obj.setWhetherRed((String) map.get("whetherRed"));
    obj.setSignature((String) map.get("signature"));
    obj.setAudit((String) map.get("audit"));
    obj.setContent((String) map.get("content"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static Official parseSerialEntity(Map<String, String> map) {
    Official obj = new Official();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setOfficialTitle(JSONObject.parseObject(map.get("officialTitle"), String.class));
    obj.setSendTime(JSONObject.parseObject(map.get("sendTime"), Date.class));
    obj.setSentObj(JSONObject.parseObject(map.get("sentObj"), String.class));
    obj.setWhetherRed(JSONObject.parseObject(map.get("whetherRed"), String.class));
    obj.setSignature(JSONObject.parseObject(map.get("signature"), String.class));
    obj.setAudit(JSONObject.parseObject(map.get("audit"), String.class));
    obj.setContent(JSONObject.parseObject(map.get("content"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static OfficialDO convert(Official from, OfficialDO to) {
    if (from == null) return to;
    if (to == null) to = new OfficialDO();
    to.setId(from.getId());
    to.setOfficialTitle(from.getOfficialTitle());
    to.setSendTime(from.getSendTime());
    to.setSentObj(from.getSentObj());
    to.setWhetherRed(from.getWhetherRed());
    to.setSignature(from.getSignature());
    to.setAudit(from.getAudit());
    to.setContent(from.getContent());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static Official convert(OfficialDO from, Official to) {
    if (from == null) return to;
    if (to == null) to = new Official();
    to.setId(from.getId());
    to.setOfficialTitle(from.getOfficialTitle());
    to.setSendTime(from.getSendTime());
    to.setSentObj(from.getSentObj());
    to.setWhetherRed(from.getWhetherRed());
    to.setSignature(from.getSignature());
    to.setAudit(from.getAudit());
    to.setContent(from.getContent());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}

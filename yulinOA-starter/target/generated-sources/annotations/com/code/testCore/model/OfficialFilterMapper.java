package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OfficialFilterMapper {
  public String id;

  public String officialTitle;

  public String sentObj;

  public String whetherRed;

  public String signature;

  public String audit;

  public String content;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String officialTitleLike = null;

  public String sentObjLike = null;

  public List<String> sentObjIn = null;

  public String signatureLike = null;

  public String auditLike = null;

  public List<String> contentIn = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public OfficialFilterMapper() {
  }

  public OfficialFilterMapper(String id, String officialTitle, String sentObj, String whetherRed,
      String signature, String audit, String content) {
    this.id=id;
    this.officialTitle=officialTitle;
    this.sentObj=sentObj;
    this.whetherRed=whetherRed;
    this.signature=signature;
    this.audit=audit;
    this.content=content;
  }

  public static OfficialFilterMapper buildMapper(Official obj) {
    OfficialFilterMapper mapper = new OfficialFilterMapper();
    mapper.id=obj.getId();
    mapper.officialTitle=obj.getOfficialTitle();
    mapper.sentObj=obj.getSentObj();
    mapper.whetherRed=obj.getWhetherRed();
    mapper.signature=obj.getSignature();
    mapper.audit=obj.getAudit();
    mapper.content=obj.getContent();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("officialTitle",this.officialTitle);
    map.put("sentObj",this.sentObj);
    map.put("whetherRed",this.whetherRed);
    map.put("signature",this.signature);
    map.put("audit",this.audit);
    map.put("content",this.content);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("officialTitleLike",this.officialTitleLike);
    map.put("sentObjLike",this.sentObjLike);
    map.put("sentObjIn",this.sentObjIn);
    map.put("signatureLike",this.signatureLike);
    map.put("auditLike",this.auditLike);
    map.put("contentIn",this.contentIn);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Official obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("officialTitle", obj.getOfficialTitle());
    map.put("sentObj", obj.getSentObj());
    map.put("whetherRed", obj.getWhetherRed());
    map.put("signature", obj.getSignature());
    map.put("audit", obj.getAudit());
    map.put("content", obj.getContent());
    return map;
  }

  public static Map<String, String> buildSerialMap(Official obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("officialTitle", JSONObject.toJSONString(obj.getOfficialTitle()));
    map.put("sentObj", JSONObject.toJSONString(obj.getSentObj()));
    map.put("whetherRed", JSONObject.toJSONString(obj.getWhetherRed()));
    map.put("signature", JSONObject.toJSONString(obj.getSignature()));
    map.put("audit", JSONObject.toJSONString(obj.getAudit()));
    map.put("content", JSONObject.toJSONString(obj.getContent()));
    return map;
  }

  public Official buildEntity() {
    Official obj = new Official();
    obj.setId(this.id);
    obj.setOfficialTitle(this.officialTitle);
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
    obj.setId((String) map.get("id"));
    obj.setOfficialTitle((String) map.get("officialTitle"));
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
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setOfficialTitle(JSONObject.parseObject(map.get("officialTitle"), String.class));
    obj.setSentObj(JSONObject.parseObject(map.get("sentObj"), String.class));
    obj.setWhetherRed(JSONObject.parseObject(map.get("whetherRed"), String.class));
    obj.setSignature(JSONObject.parseObject(map.get("signature"), String.class));
    obj.setAudit(JSONObject.parseObject(map.get("audit"), String.class));
    obj.setContent(JSONObject.parseObject(map.get("content"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Official obj, Long page, Integer rows,
      List<String> orderBy, String officialTitleLike, String sentObjLike, List<String> sentObjIn,
      String signatureLike, String auditLike, List<String> contentIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("officialTitleLike", officialTitleLike);
    map.put("sentObjLike", sentObjLike);
    map.put("sentObjIn", sentObjIn);
    map.put("signatureLike", signatureLike);
    map.put("auditLike", auditLike);
    map.put("contentIn", contentIn);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Official obj, Long page, Integer rows,
      List<String> orderBy, String officialTitleLike, String sentObjLike, List<String> sentObjIn,
      String signatureLike, String auditLike, List<String> contentIn, Long gmtUpdateFrom,
      Long gmtUpdateTo, Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("officialTitleLike", JSONObject.toJSONString(officialTitleLike));
    map.put("sentObjLike", JSONObject.toJSONString(sentObjLike));
    map.put("sentObjIn", JSONObject.toJSONString(sentObjIn));
    map.put("signatureLike", JSONObject.toJSONString(signatureLike));
    map.put("auditLike", JSONObject.toJSONString(auditLike));
    map.put("contentIn", JSONObject.toJSONString(contentIn));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

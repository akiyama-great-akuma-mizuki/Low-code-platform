package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PropertyFilterMapper {
  public String id;

  public String firmName;

  public String rentPlace;

  public String linkman;

  public String linkPhone;

  public String costType;

  public String costState;

  public Integer waitPayNum;

  public String enterpriseId;

  public Long page = null;

  public Integer rows = null;

  public List<String> orderBy = null;

  public String rentPlaceLike = null;

  public String linkmanLike = null;

  public String linkPhoneLike = null;

  public String costTypeLike = null;

  public String costStateLike = null;

  public Long gmtUpdateFrom = null;

  public Long gmtUpdateTo = null;

  public Long gmtCreateFrom = null;

  public Long gmtCreateTo = null;

  public PropertyFilterMapper() {
  }

  public PropertyFilterMapper(String id, String firmName, String rentPlace, String linkman,
      String linkPhone, String costType, String costState, Integer waitPayNum,
      String enterpriseId) {
    this.id=id;
    this.firmName=firmName;
    this.rentPlace=rentPlace;
    this.linkman=linkman;
    this.linkPhone=linkPhone;
    this.costType=costType;
    this.costState=costState;
    this.waitPayNum=waitPayNum;
    this.enterpriseId=enterpriseId;
  }

  public static PropertyFilterMapper buildMapper(Property obj) {
    PropertyFilterMapper mapper = new PropertyFilterMapper();
    mapper.id=obj.getId();
    mapper.firmName=obj.getFirmName();
    mapper.rentPlace=obj.getRentPlace();
    mapper.linkman=obj.getLinkman();
    mapper.linkPhone=obj.getLinkPhone();
    mapper.costType=obj.getCostType();
    mapper.costState=obj.getCostState();
    mapper.waitPayNum=obj.getWaitPayNum();
    mapper.enterpriseId=obj.getEnterpriseId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("firmName",this.firmName);
    map.put("rentPlace",this.rentPlace);
    map.put("linkman",this.linkman);
    map.put("linkPhone",this.linkPhone);
    map.put("costType",this.costType);
    map.put("costState",this.costState);
    map.put("waitPayNum",this.waitPayNum);
    map.put("enterpriseId",this.enterpriseId);
    map.put("page",this.page);
    map.put("rows",this.rows);
    map.put("orderBy",this.orderBy);
    map.put("rentPlaceLike",this.rentPlaceLike);
    map.put("linkmanLike",this.linkmanLike);
    map.put("linkPhoneLike",this.linkPhoneLike);
    map.put("costTypeLike",this.costTypeLike);
    map.put("costStateLike",this.costStateLike);
    map.put("gmtUpdateFrom",this.gmtUpdateFrom);
    map.put("gmtUpdateTo",this.gmtUpdateTo);
    map.put("gmtCreateFrom",this.gmtCreateFrom);
    map.put("gmtCreateTo",this.gmtCreateTo);
    return map;
  }

  public static Map<String, Object> buildMap(Property obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("firmName", obj.getFirmName());
    map.put("rentPlace", obj.getRentPlace());
    map.put("linkman", obj.getLinkman());
    map.put("linkPhone", obj.getLinkPhone());
    map.put("costType", obj.getCostType());
    map.put("costState", obj.getCostState());
    map.put("waitPayNum", obj.getWaitPayNum());
    map.put("enterpriseId", obj.getEnterpriseId());
    return map;
  }

  public static Map<String, String> buildSerialMap(Property obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("firmName", JSONObject.toJSONString(obj.getFirmName()));
    map.put("rentPlace", JSONObject.toJSONString(obj.getRentPlace()));
    map.put("linkman", JSONObject.toJSONString(obj.getLinkman()));
    map.put("linkPhone", JSONObject.toJSONString(obj.getLinkPhone()));
    map.put("costType", JSONObject.toJSONString(obj.getCostType()));
    map.put("costState", JSONObject.toJSONString(obj.getCostState()));
    map.put("waitPayNum", JSONObject.toJSONString(obj.getWaitPayNum()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    return map;
  }

  public Property buildEntity() {
    Property obj = new Property();
    obj.setId(this.id);
    obj.setFirmName(this.firmName);
    obj.setRentPlace(this.rentPlace);
    obj.setLinkman(this.linkman);
    obj.setLinkPhone(this.linkPhone);
    obj.setCostType(this.costType);
    obj.setCostState(this.costState);
    obj.setWaitPayNum(this.waitPayNum);
    obj.setEnterpriseId(this.enterpriseId);
    return obj;
  }

  public static Property parseEntity(Map<String, Object> map) {
    Property obj = new Property();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setFirmName((String) map.get("firmName"));
    obj.setRentPlace((String) map.get("rentPlace"));
    obj.setLinkman((String) map.get("linkman"));
    obj.setLinkPhone((String) map.get("linkPhone"));
    obj.setCostType((String) map.get("costType"));
    obj.setCostState((String) map.get("costState"));
    obj.setWaitPayNum((Integer) map.get("waitPayNum"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    return obj;
  }

  public static Property parseSerialEntity(Map<String, String> map) {
    Property obj = new Property();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setFirmName(JSONObject.parseObject(map.get("firmName"), String.class));
    obj.setRentPlace(JSONObject.parseObject(map.get("rentPlace"), String.class));
    obj.setLinkman(JSONObject.parseObject(map.get("linkman"), String.class));
    obj.setLinkPhone(JSONObject.parseObject(map.get("linkPhone"), String.class));
    obj.setCostType(JSONObject.parseObject(map.get("costType"), String.class));
    obj.setCostState(JSONObject.parseObject(map.get("costState"), String.class));
    obj.setWaitPayNum(JSONObject.parseObject(map.get("waitPayNum"), Integer.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    return obj;
  }

  public static Map<String, Object> buildMapExtra(Property obj, Long page, Integer rows,
      List<String> orderBy, String rentPlaceLike, String linkmanLike, String linkPhoneLike,
      String costTypeLike, String costStateLike, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, Object> map = buildMap(obj);
    if (obj == null) return map;
    map.put("page", page);
    map.put("rows", rows);
    map.put("orderBy", orderBy);
    map.put("rentPlaceLike", rentPlaceLike);
    map.put("linkmanLike", linkmanLike);
    map.put("linkPhoneLike", linkPhoneLike);
    map.put("costTypeLike", costTypeLike);
    map.put("costStateLike", costStateLike);
    map.put("gmtUpdateFrom", gmtUpdateFrom);
    map.put("gmtUpdateTo", gmtUpdateTo);
    map.put("gmtCreateFrom", gmtCreateFrom);
    map.put("gmtCreateTo", gmtCreateTo);
    return map;
  }

  public static Map<String, String> buildSerialMapExtra(Property obj, Long page, Integer rows,
      List<String> orderBy, String rentPlaceLike, String linkmanLike, String linkPhoneLike,
      String costTypeLike, String costStateLike, Long gmtUpdateFrom, Long gmtUpdateTo,
      Long gmtCreateFrom, Long gmtCreateTo) {
    Map<String, String> map = buildSerialMap(obj);
    if (obj == null) return map;
    map.put("page", JSONObject.toJSONString(page));
    map.put("rows", JSONObject.toJSONString(rows));
    map.put("orderBy", JSONObject.toJSONString(orderBy));
    map.put("rentPlaceLike", JSONObject.toJSONString(rentPlaceLike));
    map.put("linkmanLike", JSONObject.toJSONString(linkmanLike));
    map.put("linkPhoneLike", JSONObject.toJSONString(linkPhoneLike));
    map.put("costTypeLike", JSONObject.toJSONString(costTypeLike));
    map.put("costStateLike", JSONObject.toJSONString(costStateLike));
    map.put("gmtUpdateFrom", JSONObject.toJSONString(gmtUpdateFrom));
    map.put("gmtUpdateTo", JSONObject.toJSONString(gmtUpdateTo));
    map.put("gmtCreateFrom", JSONObject.toJSONString(gmtCreateFrom));
    map.put("gmtCreateTo", JSONObject.toJSONString(gmtCreateTo));
    return map;
  }
}

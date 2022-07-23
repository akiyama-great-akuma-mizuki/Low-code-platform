package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.PropertyRecordDO;
import com.horsecoder.yulinOA.sys.domain.PropertyRecordTO;
import lombok.*;

import java.util.Date;
import java.util.Map;

/**
 * Author: horsecoder
 * Email: eamon@horsecoder.com
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Mapper(
    value = {"data","domain","filter","post","update","simple","detail",},
    name = {"PropertyRecordData","PropertyRecordDomain","PropertyRecordFilterMapper","PropertyRecordPostMapper","PropertyRecordUpdateMapper","PropertyRecordSimpleMapper","PropertyRecordDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","property",},
    type = {Long.class,Integer.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {PropertyRecordDO.class,PropertyRecordTO.class,}
)
@TestModel
public class PropertyRecord {
  /**
   * 物业缴费记录ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 缴费人
   */
  private String payPeople;

  /**
   * 手机号
   */
  private String payPhone;

  /**
   * 缴费金额
   */
  private Integer payNum;

  /**
   * 缴费时间
   */
  private String payTime;

  /**
   * 缴费方式
   */
  private String payWay;

  /**
   * 物业服务ID
   */
  @MapperIgnore({"post", "update",})
  private String propertyId;

  /**
   * 更新时间
   */
  @MapperIgnore({"post", "update","filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date gmtUpdate;

  /**
   * 创建时间
   */
  @MapperIgnore({"post", "update","filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date gmtCreate;

  Long modifyTime(Date date) {
    if (date == null) return null;
    return date.getTime();
  }

  Date recoverTime(Long time) {
    if (time == null) return null;
    return new Date(time);
  }
}

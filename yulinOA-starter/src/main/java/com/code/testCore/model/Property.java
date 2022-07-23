package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.PropertyDO;
import com.horsecoder.yulinOA.sys.domain.PropertyTO;
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
    name = {"PropertyData","PropertyDomain","PropertyFilterMapper","PropertyPostMapper","PropertyUpdateMapper","PropertySimpleMapper","PropertyDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail","detail",},
    name = {"page","rows","orderBy","rentPlaceLike","linkmanLike","linkPhoneLike","costTypeLike","costStateLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","propertyRecordList","enterprise",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","String, Object","String, Object",},
    list = {false,false,true,false,false,false,false,false,false,false,false,false,true,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {PropertyDO.class,PropertyTO.class,}
)
@TestModel
public class Property {
  /**
   * 物业服务ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 企业名称
   */
  private String firmName;

  /**
   * 租用地址
   */
  private String rentPlace;

  /**
   * 联系人
   */
  private String linkman;

  /**
   * 手机号
   */
  private String linkPhone;

  /**
   * 入驻时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date enterTime;

  /**
   * 费用类型
   */
  private String costType;

  /**
   * 费用状态
   */
  private String costState;

  /**
   * 待缴金额
   */
  private Integer waitPayNum;

  /**
   * 企业ID
   */
  private String enterpriseId;

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

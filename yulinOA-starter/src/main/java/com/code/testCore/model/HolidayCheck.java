package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.HolidayCheckDO;
import com.horsecoder.yulinOA.sys.domain.HolidayCheckTO;
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
    name = {"HolidayCheckData","HolidayCheckDomain","HolidayCheckFilterMapper","HolidayCheckPostMapper","HolidayCheckUpdateMapper","HolidayCheckSimpleMapper","HolidayCheckDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","detail","detail",},
    name = {"page","rows","orderBy","statusIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","holiday","user",},
    type = {Long.class,Integer.class,String.class,Integer.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","String, Object","String, Object",},
    list = {false,false,true,true,false,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {HolidayCheckDO.class,HolidayCheckTO.class,}
)
@TestModel
public class HolidayCheck {
  /**
   * 请假审批ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 请假ID
   */
  private String holidayId;

  /**
   * 审批人ID
   */
  private String approverId;

  /**
   * 状态
   */
  private Integer status;

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

package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.HolidayDO;
import com.horsecoder.yulinOA.sys.domain.HolidayTO;
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
    name = {"HolidayData","HolidayDomain","HolidayFilterMapper","HolidayPostMapper","HolidayUpdateMapper","HolidaySimpleMapper","HolidayDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail","detail",},
    name = {"page","rows","orderBy","holidayClassLike","holidayEndTimeFrom","holidayEndTimeTo","holidayReasonLike","holidayReasonIn","statusIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","user","holidayCheckList",},
    type = {Long.class,Integer.class,String.class,String.class,Long.class,Long.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","String, Object","String, Object",},
    list = {false,false,true,false,false,false,false,true,true,false,false,false,false,false,true,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {HolidayDO.class,HolidayTO.class,}
)
@TestModel
public class Holiday {
  /**
   * 请假ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 请假类型
   */
  private String holidayClass;

  /**
   * 开始时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date hilidayStartTime;

  /**
   * 结束时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date holidayEndTime;

  /**
   * 请假事由
   */
  private String holidayReason;

  /**
   * 请假人ID
   */
  private String userId;

  /**
   * 状态
   */
  private String status;

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

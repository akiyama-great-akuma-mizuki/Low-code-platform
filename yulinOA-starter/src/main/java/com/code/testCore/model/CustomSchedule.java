package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.CustomScheduleDO;
import com.horsecoder.yulinOA.sys.domain.CustomScheduleTO;
import lombok.*;

import java.util.Date;

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
    name = {"CustomScheduleData","CustomScheduleDomain","CustomScheduleFilterMapper","CustomSchedulePostMapper","CustomScheduleUpdateMapper","CustomScheduleSimpleMapper","CustomScheduleDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter",},
    name = {"page","rows","orderBy","titleLike","timeFrom","timeTo","addressLike","remarkLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo",},
    type = {Long.class,Integer.class,String.class,String.class,Long.class,Long.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null",},
    list = {false,false,true,false,false,false,false,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {CustomScheduleDO.class,CustomScheduleTO.class,}
)
@TestModel
public class CustomSchedule {
  /**
   * 自定义日程ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 标题
   */
  private String title;

  /**
   * 时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date time;

  /**
   * 地址
   */
  private String address;

  /**
   * 备注
   */
  private String remark;

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

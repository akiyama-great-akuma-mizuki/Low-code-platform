package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.CheckDO;
import com.horsecoder.yulinOA.sys.domain.CheckTO;
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
    name = {"CheckData","CheckDomain","CheckFilterMapper","CheckPostMapper","CheckUpdateMapper","CheckSimpleMapper","CheckDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","typeIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","checkPersonList",},
    type = {Long.class,Integer.class,String.class,Integer.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,true,false,false,false,false,true,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {CheckDO.class,CheckTO.class,}
)
@TestModel
public class Check {
  /**
   * 审批ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 关联事件ID
   */
  private String eventId;

  /**
   * 状态
   */
  private Integer status;

  /**
   * 事件类型
   */
  private Integer type;

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

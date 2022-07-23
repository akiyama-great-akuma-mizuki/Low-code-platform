package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.EntranceHistoryDO;
import com.horsecoder.yulinOA.sys.domain.EntranceHistoryTO;
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
    name = {"EntranceHistoryData","EntranceHistoryDomain","EntranceHistoryFilterMapper","EntranceHistoryPostMapper","EntranceHistoryUpdateMapper","EntranceHistorySimpleMapper","EntranceHistoryDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","staffNameLike","tellPhoneLike","useDateFrom","useDateTo","entranceNameLike","photoLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","entranceManagement",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,Long.class,Long.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,false,false,false,false,false,false,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {EntranceHistoryDO.class,EntranceHistoryTO.class,}
)
@TestModel
public class EntranceHistory {
  /**
   * 门禁历史记录ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 门禁ID
   */
  private String entranceGuardId;

  /**
   * 员工姓名
   */
  private String staffName;

  /**
   * 联系方式
   */
  private String tellPhone;

  /**
   * 使用日期
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date useDate;

  /**
   * 进出类型
   */
  private Integer inOrOut;

  /**
   * 门禁名称
   */
  private String entranceName;

  /**
   * 拍照
   */
  private String photo;

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

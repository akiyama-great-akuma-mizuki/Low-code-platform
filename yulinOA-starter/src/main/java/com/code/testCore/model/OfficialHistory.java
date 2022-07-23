package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.OfficialHistoryDO;
import com.horsecoder.yulinOA.sys.domain.OfficialHistoryTO;
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
    name = {"OfficialHistoryData","OfficialHistoryDomain","OfficialHistoryFilterMapper","OfficialHistoryPostMapper","OfficialHistoryUpdateMapper","OfficialHistorySimpleMapper","OfficialHistoryDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","operateClassLike","operateClassIn","operatePeopleLike","remarkLike","remarkIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","official",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,false,true,false,false,true,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {OfficialHistoryDO.class,OfficialHistoryTO.class,}
)
@TestModel
public class OfficialHistory {
  /**
   * 公文历史记录ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 操作类型
   */
  private String operateClass;

  /**
   * 操作人
   */
  private String operatePeople;

  /**
   * 执行结果
   */
  private Integer result;

  /**
   * 备注
   */
  private String remark;

  /**
   * 公文ID
   */
  @MapperIgnore({"post", "update",})
  private String officialId;

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

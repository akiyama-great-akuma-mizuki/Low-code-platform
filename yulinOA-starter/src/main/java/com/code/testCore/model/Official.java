package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.OfficialDO;
import com.horsecoder.yulinOA.sys.domain.OfficialTO;
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
    name = {"OfficialData","OfficialDomain","OfficialFilterMapper","OfficialPostMapper","OfficialUpdateMapper","OfficialSimpleMapper","OfficialDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","officialTitleLike","sentObjLike","sentObjIn","signatureLike","auditLike","contentIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","sealManage",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,false,false,true,false,false,true,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {OfficialDO.class,OfficialTO.class,}
)
@TestModel
public class Official {
  /**
   * 公文ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 标题
   */
  private String officialTitle;

  /**
   * 发送时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date sendTime;

  /**
   * 送达对象
   */
  private String sentObj;

  /**
   * 是否套红
   */
  private String whetherRed;

  /**
   * 电子签章
   */
  private String signature;

  /**
   * 审核人
   */
  private String audit;

  /**
   * 详细内容
   */
  private String content;

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

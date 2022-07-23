package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.ArchiveDetailDO;
import com.horsecoder.yulinOA.sys.domain.ArchiveDetailTO;
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
    name = {"ArchiveDetailData","ArchiveDetailDomain","ArchiveDetailFilterMapper","ArchiveDetailPostMapper","ArchiveDetailUpdateMapper","ArchiveDetailSimpleMapper","ArchiveDetailDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter",},
    name = {"page","rows","orderBy","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo",},
    type = {Long.class,Integer.class,String.class,Long.class,Long.class,Long.class,Long.class,},
    typeArgs = {"null","null","null","null","null","null","null",},
    list = {false,false,true,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {ArchiveDetailDO.class,ArchiveDetailTO.class,}
)
@TestModel
public class ArchiveDetail {
  /**
   * 档案详细ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 附件文件
   */
  private String attachmentUrl;

  /**
   * 附件名字
   */
  private String attachmentName;

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

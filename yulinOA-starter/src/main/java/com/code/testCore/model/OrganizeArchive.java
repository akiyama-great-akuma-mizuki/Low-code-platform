package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.OrganizeArchiveDO;
import com.horsecoder.yulinOA.sys.domain.OrganizeArchiveTO;
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
    name = {"OrganizeArchiveData","OrganizeArchiveDomain","OrganizeArchiveFilterMapper","OrganizeArchivePostMapper","OrganizeArchiveUpdateMapper","OrganizeArchiveSimpleMapper","OrganizeArchiveDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","detail","detail",},
    name = {"page","rows","orderBy","archiveIdIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","archiveManage","organize",},
    type = {Long.class,Integer.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","String, Object","String, Object",},
    list = {false,false,true,true,false,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {OrganizeArchiveDO.class,OrganizeArchiveTO.class,}
)
@TestModel
public class OrganizeArchive {
  /**
   * 组织查阅档案ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 档案ID
   */
  private String archiveId;

  /**
   * 组织ID
   */
  private String organizeId;

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

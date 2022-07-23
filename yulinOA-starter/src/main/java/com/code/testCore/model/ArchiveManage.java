package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.ArchiveManageDO;
import com.horsecoder.yulinOA.sys.domain.ArchiveManageTO;
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
    name = {"ArchiveManageData","ArchiveManageDomain","ArchiveManageFilterMapper","ArchiveManagePostMapper","ArchiveManageUpdateMapper","ArchiveManageSimpleMapper","ArchiveManageDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail","detail",},
    name = {"page","rows","orderBy","departmentIn","browseTimesFrom","browseTimesTo","uploadTimeFrom","uploadTimeTo","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","user","archiveDetail",},
    type = {Long.class,Integer.class,String.class,String.class,Integer.class,Integer.class,Long.class,Long.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","String, Object","String, Object",},
    list = {false,false,true,true,false,false,false,false,false,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {ArchiveManageDO.class,ArchiveManageTO.class,}
)@TestModel

public class ArchiveManage {
  /**
   * 档案ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 档案名称
   */
  private String name;

  /**
   * 查阅组织
   */
  private String department;

  /**
   * 内容描述
   */
  private String description;

  /**
   * 浏览次数
   */
  private Integer browseTimes;

  /**
   * 内容富文本
   */
  private String contentUrl;

  /**
   * 上传人id
   */
  private String uploadUserId;

  /**
   * 上传时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date uploadTime;

  /**
   * 档案详细ID
   */
  @MapperIgnore({"post", "update",})
  private String archiveDetailId;

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

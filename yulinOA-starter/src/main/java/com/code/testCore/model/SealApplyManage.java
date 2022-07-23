package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.SealApplyManageDO;
import com.horsecoder.yulinOA.sys.domain.SealApplyManageTO;
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
    name = {"SealApplyManageData","SealApplyManageDomain","SealApplyManageFilterMapper","SealApplyManagePostMapper","SealApplyManageUpdateMapper","SealApplyManageSimpleMapper","SealApplyManageDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail","detail",},
    name = {"page","rows","orderBy","applyUserIdIn","endTimeFrom","endTimeTo","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","sealManage","user",},
    type = {Long.class,Integer.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","String, Object","String, Object",},
    list = {false,false,true,true,false,false,false,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {SealApplyManageDO.class,SealApplyManageTO.class,}
)
@TestModel
public class SealApplyManage {
  /**
   * 印章申请ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 申请人ID
   */
  private String applyUserId;

  /**
   * 印章Id
   */
  private String sealId;

  /**
   * 到期时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date endTime;

  /**
   * 授权书
   */
  private String applyFileUrl;

  /**
   * 申请期限
   */
  private Integer limit;

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

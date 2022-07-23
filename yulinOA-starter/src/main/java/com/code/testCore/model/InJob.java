package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.InJobDO;
import com.horsecoder.yulinOA.sys.domain.InJobTO;
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
    name = {"InJobData","InJobDomain","InJobFilterMapper","InJobPostMapper","InJobUpdateMapper","InJobSimpleMapper","InJobDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","phoneLike","phoneIn","idCardLike","idCardIn","departmentLike","departmentIn","positionLike","positionIn","emailLike","emailIn","inJobRemarkLike","inJobRemarkIn","approverLike","approverIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","user",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,true,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {InJobDO.class,InJobTO.class,}
)
@TestModel
public class InJob {
  /**
   * 入职流程ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 发起人ID
   */
  private String userId;

  /**
   * 手机号
   */
  private String phone;

  /**
   * 身份证号
   */
  private String idCard;

  /**
   * 部门
   */
  private String department;

  /**
   * 岗位
   */
  private String position;

  /**
   * 企业邮箱
   */
  private String email;

  /**
   * 备注
   */
  private String inJobRemark;

  /**
   * 审批人
   */
  private String approver;

  /**
   * 状态
   */
  private Integer status;

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

package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.EntranceGuardUserDO;
import com.horsecoder.yulinOA.sys.domain.EntranceGuardUserTO;
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
    name = {"EntranceGuardUserData","EntranceGuardUserDomain","EntranceGuardUserFilterMapper","EntranceGuardUserPostMapper","EntranceGuardUserUpdateMapper","EntranceGuardUserSimpleMapper","EntranceGuardUserDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail","detail","detail",},
    name = {"page","rows","orderBy","belongCompanyLike","inParkTimeFrom","inParkTimeTo","entranceUserNameLike","entranceScopeLike","outParkTimeFrom","outParkTimeTo","entrancePhoneLike","entranceRemarkLike","entranceRecordLike","qrCodeLike","entranceCardIdLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","entranceManagement","enterprise","user",},
    type = {Long.class,Integer.class,String.class,String.class,Long.class,Long.class,String.class,String.class,Long.class,Long.class,String.class,String.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","String, Object","String, Object","String, Object",},
    list = {false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {EntranceGuardUserDO.class,EntranceGuardUserTO.class,}
)
@TestModel
public class EntranceGuardUser {
  /**
   * 用户门禁ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 类型
   */
  private Integer visitorType;

  /**
   * 所属公司
   */
  private String belongCompany;

  /**
   * 入园开始时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date inParkTime;

  /**
   * 门禁用户名称
   */
  private String entranceUserName;

  /**
   * 门禁范围
   */
  private String entranceScope;

  /**
   * 入园结束时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date outParkTime;

  /**
   * 门禁ID
   */
  @MapperIgnore({"post", "update",})
  private String entranceManagementId;

  /**
   * 联系方式
   */
  private String entrancePhone;

  /**
   * 备注
   */
  private String entranceRemark;

  /**
   * 门禁卡使用记录
   */
  private String entranceRecord;

  /**
   * 申请状态
   */
  private Integer applyState;

  /**
   * 二维码
   */
  private String qrCode;

  /**
   * 门禁卡号
   */
  private String entranceCardId;

  /**
   * 审批备注
   */
  private String examineRemark;

  /**
   * 企业ID
   */
  @MapperIgnore({"post", "update",})
  private String enterpriseId;

  /**
   * 用户ID
   */
  private String userId;

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

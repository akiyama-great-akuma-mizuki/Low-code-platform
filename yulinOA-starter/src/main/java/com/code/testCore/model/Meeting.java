package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.MeetingDO;
import com.horsecoder.yulinOA.sys.domain.MeetingTO;
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
    name = {"MeetingData","MeetingDomain","MeetingFilterMapper","MeetingPostMapper","MeetingUpdateMapper","MeetingSimpleMapper","MeetingDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail","detail","detail",},
    name = {"page","rows","orderBy","meetingTitleLike","joinMeetingNumIn","meetingTimeIn","meetingAddressLike","meetingExplainLike","audiRemarkLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","meetingRoom","meetingParticipantList","enterprise",},
    type = {Long.class,Integer.class,String.class,String.class,Integer.class,Long.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","String, Object","String, Object","String, Object",},
    list = {false,false,true,false,true,true,false,false,false,false,false,false,false,false,true,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {MeetingDO.class,MeetingTO.class,}
)
@TestModel
public class Meeting {
  /**
   * 会议ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 申请人姓名
   */
  private String applyPeople;

  /**
   * 企业ID
   */
  private String enterpriseId;

  /**
   * 会议室ID
   */
  @MapperIgnore({"post", "update",})
  private String meetingRoomId;

  /**
   * 会议标题
   */
  private String meetingTitle;

  /**
   * 参会人数
   */
  private Integer joinMeetingNum;

  /**
   * 会议时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date meetingTime;

  /**
   * 会议地址
   */
  private String meetingAddress;

  /**
   * 说明
   */
  private String meetingExplain;

  /**
   * 审批状态
   */
  private Integer audiState;

  /**
   * 审批备注
   */
  private String audiRemark;

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

package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.MeetingRoomDO;
import com.horsecoder.yulinOA.sys.domain.MeetingRoomTO;
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
    name = {"MeetingRoomData","MeetingRoomDomain","MeetingRoomFilterMapper","MeetingRoomPostMapper","MeetingRoomUpdateMapper","MeetingRoomSimpleMapper","MeetingRoomDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","roomNameLike","roomFacilityLike","roomCapacityFrom","roomCapacityTo","roomFloorLike","roomExplainLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","meetingList",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,Integer.class,Integer.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,false,false,false,false,false,false,false,false,false,false,true,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {MeetingRoomDO.class,MeetingRoomTO.class,}
)
@TestModel
public class MeetingRoom {
  /**
   * 会议室ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 会议室名称
   */
  private String roomName;

  /**
   * 设施信息
   */
  private String roomFacility;

  /**
   * 状态
   */
  private Integer roomState;

  /**
   * 容量
   */
  private Integer roomCapacity;

  /**
   * 楼层
   */
  private String roomFloor;

  /**
   * 说明
   */
  private String roomExplain;

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

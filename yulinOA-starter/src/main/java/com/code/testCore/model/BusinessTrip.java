package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.BusinessTripDO;
import com.horsecoder.yulinOA.sys.domain.BusinessTripTO;
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
    name = {"BusinessTripData","BusinessTripDomain","BusinessTripFilterMapper","BusinessTripPostMapper","BusinessTripUpdateMapper","BusinessTripSimpleMapper","BusinessTripDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail","detail","detail",},
    name = {"page","rows","orderBy","tripStartTimeFrom","tripStartTimeTo","tripEndTimeFrom","tripEndTimeTo","tripStartPlaceLike","tripStartPlaceIn","tripEndPlaceLike","tripEndPlaceIn","trafficToolLike","trafficToolIn","tripBackLike","tripBackIn","tripRemarkLike","tripRemarkIn","statusIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","businessTripPeopleList","user","businessTripCheckList",},
    type = {Long.class,Integer.class,String.class,Long.class,Long.class,Long.class,Long.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,Integer.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","String, Object","String, Object","String, Object",},
    list = {false,false,true,false,false,false,false,false,true,false,true,false,true,false,true,false,true,true,false,false,false,false,true,false,true,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {BusinessTripDO.class,BusinessTripTO.class,}
)
@TestModel
public class BusinessTrip {
  /**
   * 出差ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 开始时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date tripStartTime;

  /**
   * 结束时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date tripEndTime;

  /**
   * 出发地
   */
  private String tripStartPlace;

  /**
   * 目的地
   */
  private String tripEndPlace;

  /**
   * 交通工具
   */
  private String trafficTool;

  /**
   * 单程/往返
   */
  private String tripBack;

  /**
   * 备注
   */
  private String tripRemark;

  /**
   * 出差用户Id
   */
  private String userId;

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

package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.ParkParkDO;
import com.horsecoder.yulinOA.sys.domain.ParkParkTO;
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
    name = {"ParkParkData","ParkParkDomain","ParkParkFilterMapper","ParkParkPostMapper","ParkParkUpdateMapper","ParkParkSimpleMapper","ParkParkDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","parkNameLike","placeLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","parkPlaceList",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,false,false,false,false,false,false,true,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {ParkParkDO.class,ParkParkTO.class,}
)
@TestModel
public class ParkPark {
  /**
   * 园区停车场ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 停车场名称
   */
  private String parkName;

  /**
   * 总车位
   */
  private Integer allStall;

  /**
   * 位置
   */
  private String place;

  /**
   * 剩余停车位
   */
  private Integer residueStall;

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

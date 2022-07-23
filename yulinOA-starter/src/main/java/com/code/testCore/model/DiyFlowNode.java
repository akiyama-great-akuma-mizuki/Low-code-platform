package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.DiyFlowNodeDO;
import com.horsecoder.yulinOA.sys.domain.DiyFlowNodeTO;
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
    name = {"DiyFlowNodeData","DiyFlowNodeDomain","DiyFlowNodeFilterMapper","DiyFlowNodePostMapper","DiyFlowNodeUpdateMapper","DiyFlowNodeSimpleMapper","DiyFlowNodeDetailMapper",}
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
    type = {DiyFlowNodeDO.class,DiyFlowNodeTO.class,}
)
@TestModel
public class DiyFlowNode {
  /**
   * 自定义流程节点ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 节点类型
   */
  private Integer type;

  /**
   * 节点标题
   */
  private String title;

  /**
   * 自定义流程ID
   */
  private String diyFlowId;

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

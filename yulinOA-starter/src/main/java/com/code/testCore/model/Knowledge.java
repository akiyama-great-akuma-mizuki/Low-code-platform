package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.KnowledgeDO;
import com.horsecoder.yulinOA.sys.domain.KnowledgeTO;
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
    name = {"KnowledgeData","KnowledgeDomain","KnowledgeFilterMapper","KnowledgePostMapper","KnowledgeUpdateMapper","KnowledgeSimpleMapper","KnowledgeDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter",},
    name = {"page","rows","orderBy","knowledgeNameLike","knowledgeNameIn","uploadLike","uploadIn","lookUpLike","lookUpIn","describeLike","describeIn","contentDetailLike","browseIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,Integer.class,Long.class,Long.class,Long.class,Long.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",},
    list = {false,false,true,false,true,false,true,false,true,false,true,false,true,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {KnowledgeDO.class,KnowledgeTO.class,}
)
@TestModel
public class Knowledge {
  /**
   * 知识ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 文档名称
   */
  private String knowledgeName;

  /**
   * 上传人
   */
  private String upload;

  /**
   * 查阅部门
   */
  private String lookUp;

  /**
   * 描述
   */
  private String describe;

  /**
   * 详细内容
   */
  private String contentDetail;

  /**
   * 浏览次数
   */
  @MapperIgnore({"post", "update",})
  private Integer browse;

  /**
   * 附件
   */
  private String accessory;

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

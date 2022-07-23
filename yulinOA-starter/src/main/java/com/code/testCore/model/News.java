package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.NewsDO;
import com.horsecoder.yulinOA.sys.domain.NewsTO;
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
    name = {"NewsData","NewsDomain","NewsFilterMapper","NewsPostMapper","NewsUpdateMapper","NewsSimpleMapper","NewsDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter",},
    name = {"page","rows","orderBy","newsTitleLike","newsTitleIn","publisherLike","publisherIn","releaseDepartmentLike","releaseDepartmentIn","detailContentLike","newsImgLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null","null","null",},
    list = {false,false,true,false,true,false,true,false,true,false,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {NewsDO.class,NewsTO.class,}
)
@TestModel
public class News {
  /**
   * 新闻ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 标题
   */
  private String newsTitle;

  /**
   * 发布人
   */
  private String publisher;

  /**
   * 发布时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date releaseTime;

  /**
   * 发布部门
   */
  private String releaseDepartment;

  /**
   * 附件
   */
  private String file;

  /**
   * 详细内容
   */
  private String detailContent;

  /**
   * 图片
   */
  private String newsImg;

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

package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.NoticeDO;
import com.horsecoder.yulinOA.sys.domain.NoticeTO;
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
    name = {"NoticeData","NoticeDomain","NoticeFilterMapper","NoticePostMapper","NoticeUpdateMapper","NoticeSimpleMapper","NoticeDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","noticeTitleLike","issuerLike","accessoryLike","detailLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","noticeEnterpriseList",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,false,false,false,false,false,false,false,false,true,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {NoticeDO.class,NoticeTO.class,}
)
@TestModel
public class Notice {
  /**
   * 公告ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 公告标题
   */
  private String noticeTitle;

  /**
   * 发布人
   */
  private String issuer;

  /**
   * 发布时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date issueTime;

  /**
   * 附件
   */
  private String accessory;

  /**
   * 详细内容
   */
  private String detail;

  /**
   * 图片
   */
  private String noticeImg;

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

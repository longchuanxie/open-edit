package com.xielc1.group.open.edit.dao.domain;

import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("blog")
public class Blog {
  @Id
  private String id;
  /*标题*/
  private String title;
  /*作者ID*/
  private String authorId;
  /*标签*/
  private String tag;
  /*概要*/
  private String abstractContext;
  /*正文*/
  private String context;
  /*点赞数*/
  private String follow;
  /*建议改善数*/
  private String unLike;
  /*创建人*/
  private String createBy;
  /*创建时间*/
  private Date createDate;
  /*更新时间*/
  private Date  updateDate;




}

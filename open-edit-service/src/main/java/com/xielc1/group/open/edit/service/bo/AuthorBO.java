package com.xielc1.group.open.edit.service.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * author传输实体
 */
@Data
public class AuthorBO implements Serializable {

  private static final long serialVersionUID = 1227303539939902196L;
  private String id ;
  private String firstName;
  private String lastName;
  private String name;
  private String birthDate;
  private String descript;

}

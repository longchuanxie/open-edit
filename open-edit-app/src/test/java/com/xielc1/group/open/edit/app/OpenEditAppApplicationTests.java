package com.xielc1.group.open.edit.app;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.xielc1.group.edit.common.util.PageUtil;
import com.xielc1.group.edit.log.EditLog;
import com.xielc1.group.open.edit.dao.domain.Author;
import com.xielc1.group.open.edit.dao.impl.AuthorDao;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public  class OpenEditAppApplicationTests {
  @Autowired
  private AuthorDao authorDao;
  @Test
  @EditLog
  public  void contextLoads() {
    Author author = new Author();
    author.setFirstName("xie");
//    authorDao.save(author);
    PageUtil<Author> pageUtil = new PageUtil<>();
    pageUtil.setQueryCond(author);
    List<Author> authors =authorDao.findAll(pageUtil);
    System.out.println("");

  }

}

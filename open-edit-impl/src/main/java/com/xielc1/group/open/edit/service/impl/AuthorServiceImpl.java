package com.xielc1.group.open.edit.service.impl;

import com.xielc1.group.edit.common.exception.EditException;
import com.xielc1.group.edit.common.exception.EditException.ErrorCode;
import com.xielc1.group.edit.common.util.EditBeanCopier;
import com.xielc1.group.edit.common.util.PageUtil;
import com.xielc1.group.edit.log.EditLog;
import com.xielc1.group.open.edit.dao.domain.Author;
import com.xielc1.group.open.edit.dao.impl.AuthorDao;
import com.xielc1.group.open.edit.service.AuthorService;
import com.xielc1.group.open.edit.service.bo.AuthorBO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class AuthorServiceImpl implements AuthorService {
  private static  final Integer batchSize = 1000;
  private AuthorDao authorDao;

  @Override
  @EditLog
  public void saveAuthor(AuthorBO authorBO) {
    authorBO = Optional.ofNullable(authorBO)
        .orElseThrow(() -> new EditException(ErrorCode.REQUEST_PARAM_ERROR, "参数不能为空"));

    Author author = new Author();
    EditBeanCopier.copy(authorBO, author);
    authorDao.save(author);
  }

  @Override
  public void deleteAuthorById(String id) {
    authorDao.deleteById(id);
  }

  @Override
  public void updateAuthorById(AuthorBO authorBO) {

  }

  @Override
  public List<AuthorBO> queryAuthor(AuthorBO authorBO) {

    return null;
  }

  @Override
  @EditLog
  public void saveListAuthor(List<AuthorBO> authorBOS) {
    authorBOS = Optional.ofNullable(authorBOS)
        .orElseThrow(() -> new EditException(ErrorCode.REQUEST_PARAM_ERROR, "参数不能为空"));
    List<Author> authors = new ArrayList<>(authorBOS.size());
    authorBOS.forEach(authorBO -> {
      Author author = new Author();
      EditBeanCopier.copy(authorBO, new Author());
      authors.add(author);
    });
    int size = authors.size();
    int batch = size / batchSize;
    int reminder = size % batchSize;
    if (size <= batchSize) {
      authorDao.saveAll(authors);
    } else {
       for(int i=0;i<=batch;i++ ){
         if(i==batch && reminder != 0){
           authorDao.saveAll(authors.subList(i*batchSize,((i+1)*batchSize)+reminder)) ;
         }else {
           authors.subList(i*batchSize,((i+1)*batchSize));
         }
       }

    }

  }

  @Override
  @EditLog
  public AuthorBO queryAuthorById(String id) {
    if(StringUtils.isBlank(id)){

      throw new EditException(ErrorCode.REQUEST_PARAM_ERROR,"id 不能为空");
    }
    Author author = authorDao.findById(id);
    return  Optional.ofNullable(author).map(author1 -> {
      AuthorBO authorBO = new AuthorBO();
      EditBeanCopier.copy(author,authorBO);
      return authorBO;
    }).orElse(null);
  }

  @Override
  public PageUtil<AuthorBO> queryAuthorByPage(PageUtil<AuthorBO> pageUtil) {
    PageUtil<Author> queryPage = new PageUtil<>();
    Author author = new Author();
    EditBeanCopier.copy(pageUtil.getQueryCond(),author);
    queryPage.setQueryCond(author);
    queryPage.setPageNo(pageUtil.getPageNo());
    queryPage.setPageSize(pageUtil.getPageSize());
    List<Author> authors =authorDao.findAll(queryPage);
    List<AuthorBO> authorBOS = new ArrayList<>();
    if(CollectionUtils.isEmpty(authors)){
      return pageUtil;
    }
    authors.forEach(author1 -> {
      AuthorBO tempAuthor = new AuthorBO();
      EditBeanCopier.copy(author1,tempAuthor);
      authorBOS.add(tempAuthor);
    });
    pageUtil.setData(authorBOS);


    return pageUtil;
  }

  @Override
  public Integer queryAuthorCount(AuthorBO authorBO) {

    return null;
  }

  @Autowired
  private void setAuthorDao(final AuthorDao authorDao) {
    this.authorDao = authorDao;
  }

  public  static void main(String ...sa){
    AuthorBO authorBO = new AuthorBO();
    Author author = new Author();
    author.setId("12432443");
    EditBeanCopier.copy(author,authorBO);
    System.out.println(authorBO);
  }
}

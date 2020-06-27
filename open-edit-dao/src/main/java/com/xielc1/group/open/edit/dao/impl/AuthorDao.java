package com.xielc1.group.open.edit.dao.impl;

import com.xielc1.group.edit.common.util.PageUtil;
import com.xielc1.group.edit.log.EditLog;
import com.xielc1.group.open.edit.dao.domain.Author;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component("authorDao")
public class AuthorDao {

  @Autowired
  private MongoTemplate mongoTemplate;


  public List<Author> saveAll(final Iterable<Author> iterable) {
    return null;
  }


  public List<Author> findAll() {
    return null;
  }


  public List<Author> findAll(final Sort sort) {
    return null;
  }


  public Author insert(final Author s) {
    return null;
  }


  public <S extends Author> List<S> insert(final Iterable<S> iterable) {
    return null;
  }


  public List<Author> findAll(final PageUtil<Author> pageUtil) {
    Query query = null;

    Author queryCond = pageUtil.getQueryCond();
    Pattern nameQuery = Pattern.compile("^.*"+queryCond.getName()+".*$", Pattern.CASE_INSENSITIVE);
    Pattern descriptQuery = Pattern.compile("^.*"+queryCond.getName()+".*$", Pattern.CASE_INSENSITIVE);
    query = new Query(new Criteria().orOperator(Criteria.where("name").regex(nameQuery),
        Criteria.where("descript").regex(descriptQuery)));
    query.skip((long) (pageUtil.getPageNo() * pageUtil.getPageSize()));
    query.limit(pageUtil.getPageSize());

    String s = "1";

//
    return mongoTemplate.find(query, Author.class);
  }



  public <S extends Author> List<S> findAll(final Example<S> example, final Sort sort) {
    return null;
  }


  public Page<Author> findAll(final Pageable pageable) {
    return null;
  }

  @EditLog
  public <S extends Author> S save(final S s) {
    return mongoTemplate.save(s);
  }


  public Author findById(final String s) {

    return mongoTemplate.findById(s, Author.class);
  }


  public boolean existsById(final String s) {
    return false;
  }


  public Iterable<Author> findAllById(final Iterable<String> iterable) {
    return null;
  }


  public long count() {
    return 0;
  }


  public void deleteById(final String s) {

  }


  public void delete(final Author author) {

  }


  public void deleteAll(final Iterable<? extends Author> iterable) {

  }


  public void deleteAll() {

  }


  public <S extends Author> Optional<S> findOne(final Example<S> example) {
    return Optional.empty();
  }


  public <S extends Author> Page<S> findAll(final Example<S> example, final Pageable pageable) {
    return null;
  }


  public <S extends Author> long count(final Example<S> example) {
    return 0;
  }


  public <S extends Author> boolean exists(final Example<S> example) {
    return false;
  }
}




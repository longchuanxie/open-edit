package com.xielc1.group.open.edit.service;

import com.xielc1.group.edit.common.util.PageUtil;
import com.xielc1.group.open.edit.service.bo.AuthorBO;
import java.util.List;

/**
 * Author操作接口定义
 */
public interface AuthorService {

    /**
     * 保存传入数据
     * @param authorBO  待保存数据
     * @return
     */
    void saveAuthor(AuthorBO authorBO);

    /**
     * <descripte>根据传入主键删除对应数据</descripte>

     */
    void deleteAuthorById(String id);

    /**
     * 根据主键更新数据
     * @param authorBO 待更新数据，主键id不能为空
     * @return
     */
    void updateAuthorById(AuthorBO authorBO);

    /**
     * 根据查询条件返回对应读者信息</descripte>
     * @param authorBO 筛选条件
     * @return 不存在满足筛选条件时返回null
     */
    List<AuthorBO> queryAuthor(AuthorBO authorBO);

    /**
     * 批量保存插入数据，存在时做更新处理
     * @param authorBOS
     * @return 影响的数据条数
     */
    void saveListAuthor(List<AuthorBO> authorBOS);

    /**
     * 根据主键查询数据
     * @param id
     * @return
     */
   AuthorBO queryAuthorById(String id);


    /**
     * <descripte>分页获取满足条件的数据</descripte>
     * @param pageUtil
     * @return
     */
    PageUtil<AuthorBO> queryAuthorByPage(PageUtil<AuthorBO> pageUtil);

    /**
     * 获取满足条件的记录条数
     * @param authorBO
     * @return 不存在时返回0
     */
    Integer queryAuthorCount(AuthorBO authorBO);

}

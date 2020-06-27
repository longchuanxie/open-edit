package com.xielc1.group.open.edit.web;

import com.alibaba.fastjson.JSONObject;
import com.xielc1.group.edit.common.constant.EditConstant.ReturnCode;
import com.xielc1.group.edit.common.util.BaseReturnBO;
import com.xielc1.group.edit.common.util.PageUtil;
import com.xielc1.group.open.edit.constant.EnumManager;
import com.xielc1.group.open.edit.service.AuthorService;
import com.xielc1.group.open.edit.service.bo.AuthorBO;
import com.xielc1.group.open.edit.web.vo.SearchReturnVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/author")
@Slf4j
public class AuthorController {
  private AuthorService authorService;
   @RequestMapping("/index")
   public ModelAndView index(){
     ModelAndView modelAndView = new ModelAndView();
     modelAndView.setViewName("author/author_index");
     return modelAndView;
   }

  @PostMapping(value = "/search.do")
  @ResponseBody
  public String search(String cond){
    BaseReturnBO<PageUtil<SearchReturnVO>> baseReturnBO = new BaseReturnBO<>();
    baseReturnBO.setReturnCode(ReturnCode.SUCCESS.toString());
   try {
     AuthorBO queryCond = new AuthorBO();
     queryCond.setName(cond);
     queryCond.setDescript(cond);
     PageUtil<AuthorBO> pageUtil = new PageUtil<>();
     pageUtil.setQueryCond(queryCond);
     PageUtil<AuthorBO> result =authorService.queryAuthorByPage(pageUtil);

     PageUtil<SearchReturnVO> searchReturnVOPageUtil= new PageUtil<>();
       List<SearchReturnVO> searchReturnVOS = new ArrayList<>();
     if(result!=null && !CollectionUtils.isEmpty(result.getData())){
         for(AuthorBO author:result.getData()){
             SearchReturnVO searchReturnVO = new SearchReturnVO();
             searchReturnVO.setId(author.getId());
             searchReturnVO.setAbstractContext(author.getName());
             searchReturnVO.setModule(EnumManager.ModuleEnum.AUTHOR);
             searchReturnVOS.add(searchReturnVO);
         }
     }
       searchReturnVOPageUtil.setData(searchReturnVOS);
       searchReturnVOPageUtil.setPageNo(pageUtil.getPageNo());
       searchReturnVOPageUtil.setPageSize(pageUtil.getPageSize());
       searchReturnVOPageUtil.setTotal(pageUtil.getTotal());
     baseReturnBO.setData(searchReturnVOPageUtil);

   }catch (Exception e){
       baseReturnBO.setReturnCode(ReturnCode.FAIL.toString());
       log.error("查询异常",e);
       baseReturnBO.setReturnMessage("系统异常，请联系管理员");

   }
   log.info("JSON{}",JSONObject.toJSONString(baseReturnBO));
    return JSONObject.toJSONString(baseReturnBO);
  }
  @Autowired
  public void setAuthorService(final AuthorService authorService) {
    this.authorService = authorService;
  }
}

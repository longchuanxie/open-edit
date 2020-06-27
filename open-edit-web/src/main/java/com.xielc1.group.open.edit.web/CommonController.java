package com.xielc1.group.open.edit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CommonController {
  @RequestMapping("/")
  public ModelAndView index(){
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("common_index");
    return modelAndView;
  }
}

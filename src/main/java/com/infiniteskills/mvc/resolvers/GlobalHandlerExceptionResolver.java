package com.infiniteskills.mvc.resolvers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

// COMENTADO PARA DESACTIVALO E VER AS EXCEPCIÓNS
//@Component
public class GlobalHandlerExceptionResolver
    implements HandlerExceptionResolver {

  @Override
  public ModelAndView resolveException(HttpServletRequest request,
      HttpServletResponse response, Object handler, Exception exception) {

    final ModelAndView mav = new ModelAndView();
    mav.setViewName("global_error");
    return mav;
  }

}

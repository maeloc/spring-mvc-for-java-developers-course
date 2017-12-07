package com.infiniteskills.mvc.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = Controller.class)
public class GlobalControllerAdvice {

  @ModelAttribute("currentDate")
  public Date getCurrentDate() {
    return new Date();
  }

}

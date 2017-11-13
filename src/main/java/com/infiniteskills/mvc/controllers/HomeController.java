package com.infiniteskills.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.entities.Sponsor;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String goHome(Model model) {

    final Project project = new Project();
    project.setName("First Project");
    project.setSponsor(new Sponsor("NASA", "661.098.105", "nasa@nasa.gob.us"));
    project.setDescription("This is a simple project sponsored by NASA");
    model.addAttribute("currentProject", project);

    return "home";
  }
}

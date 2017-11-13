package com.infiniteskills.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.infiniteskills.mvc.data.entities.Project;
import com.infiniteskills.mvc.data.services.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @RequestMapping(value = "/{projectId}")
  public String findProject(Model model,
      @PathVariable("projectId") Long projectId) {
    model.addAttribute("project", this.projectService.find(projectId));
    return "project";
  }

  @RequestMapping(value = "/find")
  public String findAll(Model model) {
    model.addAttribute("projects", projectService.findAll());
    return "projects";
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  public String addProject(Model model) {
    final List<String> types = new LinkedList<>(Arrays.asList(new String[] {
        "", "Single Year", "Multi Year" }));

    model.addAttribute("types", types);
    model.addAttribute("project", new Project());

    System.out.println("invoking addProject");
    return "project_add";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String saveProject(@ModelAttribute Project project) {
    System.out.println("invoking saveProject");
    System.out.println(project);
    return "project_add";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST, params = { "type=multi" })
  public String saveMultiYearProject() {
    System.out.println("invoking saveMultiYearProject");
    return "project_add";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST, params = {
      "type=multi", "special" })
  public String saveSpecialProject() {
    System.out.println("invoking saveSpecialProject");
    return "project_add";
  }

}

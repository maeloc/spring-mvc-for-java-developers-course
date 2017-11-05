package com.infiniteskills.mvc.data.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.infiniteskills.mvc.data.entities.Project;

public class ProjectService {

  private final List<Project> projects = new LinkedList<>();

  public ProjectService() {
    final Project javaProject = this.create("Java Project",
        "This is a Java Project");
    final Project jsProject = this.create("Javascript Project",
        "This is a Javascript Project");
    final Project htmlProject = this.create("HTML Project",
        "This is a HTML Project");

    this.projects.addAll(Arrays.asList(new Project[] { javaProject, jsProject,
        htmlProject }));
  }

  public List<Project> findAll() {
    return projects;
  }

  public Project find(Long projectId) {
    return this.projects.stream().filter(p -> {
      return p.getProjectId().equals(projectId);
    }).collect(Collectors.toList()).get(0);
  }

  private Project create(String title, String description) {
    final Project project = new Project();

    project.setName(title);
    project.setAuthorizedFunds(new BigDecimal("100000"));
    project.setAuthorizedHours(new BigDecimal("1000"));
    project.setProjectId(1L);
    project.setSpecial(false);
    project.setType("multi");
    project.setYear("2015");
    project.setDescription(description);

    return project;
  }

}

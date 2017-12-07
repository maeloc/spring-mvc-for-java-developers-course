package com.infiniteskills.mvc.data.services;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.infiniteskills.mvc.data.entities.Resource;

public class ResourceService {

  private final List<Resource> resources = new LinkedList<>();

  public ResourceService() {
    this.resources.add(
        new Resource(1L, "Coder", "Staff", new BigDecimal("100.00"), "Hours"));
    this.resources.add(
        new Resource(2L, "Analyst", "Staff", new BigDecimal("50.00"), "Hours"));
    this.resources.add(
        new Resource(3L, "Tester", "Staff", new BigDecimal("70.00"), "Hours"));
  }

  public List<Resource> findAll() {
    return this.resources;
  }

  public Resource find(Long resourceId) {
    return this.resources.stream().filter(r -> {
      return r.getResourceId().equals(resourceId);
    }).collect(Collectors.toList()).get(0);
  }

}

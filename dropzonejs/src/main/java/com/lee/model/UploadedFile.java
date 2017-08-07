package com.lee.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class UploadedFile {

  private Long id;
  private String name;
  private String location;
  private Long size;
  private String type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "UploadedFile{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", location='" + location + '\'' +
            ", size=" + size +
            ", type='" + type + '\'' +
            '}';
  }
}

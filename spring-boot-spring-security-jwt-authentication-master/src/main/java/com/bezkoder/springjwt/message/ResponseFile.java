package com.bezkoder.springjwt.message;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseFile {
  private String name;
  private String url;
  private String type;
  private long size;
  private LocalDateTime dateEnvoie;

  public LocalDateTime getDateEnvoie() {
    return dateEnvoie;
  }

  public void setDateEnvoie(LocalDateTime dateEnvoie) {
    this.dateEnvoie = dateEnvoie;
  }

  public ResponseFile(String name, String url, String type, long size,LocalDateTime dateEnvoie) {
    this.name = name;
    this.url = url;
    this.type = type;
    this.size = size;
    this.dateEnvoie=dateEnvoie;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

}

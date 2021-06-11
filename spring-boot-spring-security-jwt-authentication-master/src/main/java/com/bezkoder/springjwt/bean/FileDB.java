package com.bezkoder.springjwt.bean;

import com.bezkoder.springjwt.models.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "files")
public class FileDB {
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String id;

  private String name;

  private String type;

  @Lob
  private byte[] data;

  public LocalDateTime getDateEnvoie() {
    return dateEnvoie;
  }

  public void setDateEnvoie(LocalDateTime dateEnvoie) {
    this.dateEnvoie = dateEnvoie;
  }

  private LocalDateTime dateEnvoie;

@ManyToOne
private User user;

  public void setId(String id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public FileDB() {
  }

  public FileDB(String name, String type, byte[] data,User user) {
    this.name = name;
    this.type = type;
    this.data = data;
    this.setUser(user);
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

}

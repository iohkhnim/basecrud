package com.khoi.basecrud.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.lang.Nullable;

@MappedSuperclass
public class baseDTO implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;

  @Column(name = "created_at", columnDefinition = "DATETIME", updatable = false)
  @Nullable
  @Temporal(TemporalType.TIMESTAMP)
  private java.util.Date createdTime;

  @Column(name = "updated_at", columnDefinition = "DATETIME")
  @Nullable
  @Temporal(TemporalType.TIMESTAMP)
  private java.util.Date updatedTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}

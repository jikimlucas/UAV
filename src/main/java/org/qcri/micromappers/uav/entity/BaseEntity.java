package org.qcri.micromappers.uav.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable
{
  private static final long serialVersionUID = 5714436358953848715L;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  public Long getId()
  {
    return this.id;
  }
  
  public void setId(Long id)
  {
    this.id = id;
  }
}

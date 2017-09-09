package org.qcri.micromappers.uav.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;

@MappedSuperclass
public class ExtendedBaseEntity extends BaseEntity
{
  private static final long serialVersionUID = 9219571511424036980L;
  
  @Column(updatable=false, nullable=false, name="created_at")
  private Timestamp createdAt;
  
  @Column(nullable=false, name="updated_at")
  private Timestamp updatedAt;
  
  @PrePersist
  private void prePersist()
  {
    Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
    setCreatedAt(currentTimestamp);
    setUpdatedAt(currentTimestamp);
  }
  
  @PreUpdate
  private void preUpdate()
  {
    setUpdatedAt(new Timestamp(System.currentTimeMillis()));
  }
  
  public Timestamp getCreatedAt()
  {
    return this.createdAt;
  }
  
  public void setCreatedAt(Timestamp createdAt)
  {
    this.createdAt = createdAt;
  }
  
  public Timestamp getUpdatedAt()
  {
    return this.updatedAt;
  }
  
  public void setUpdatedAt(Timestamp updatedAt)
  {
    this.updatedAt = updatedAt;
  }
}

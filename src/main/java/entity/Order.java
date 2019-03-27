package entity;

import java.io.Serializable;

public class Order implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -1737859893948370664L;

  private long id;

  private String name;

  private String messageId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", name=" + name + ", messageId=" + messageId + "]";
  }

}

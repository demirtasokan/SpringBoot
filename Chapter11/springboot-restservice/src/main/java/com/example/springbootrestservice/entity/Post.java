package com.example.springbootrestservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Siva
 *
 */
@Entity
@Table(name = "POSTS")
public class Post
{

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "title", nullable = false, length = 150)
  private String title;

  @Lob
  @Column(name = "content", nullable = false, columnDefinition="TEXT")
  private String content;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="created_on")
  private Date createdOn = new Date();

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="updated_on")
  private Date updatedOn;

  @JsonManagedReference
  @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
  private List<Comment> comments;


  @Override
  public String toString() {
    return "Post [id=" + id + ", title=" + title + ", content=" + content + ", createdOn=" + createdOn
        + ", updatedOn=" + updatedOn + "]";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Date getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(Date updatedOn) {
    this.updatedOn = updatedOn;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }


}
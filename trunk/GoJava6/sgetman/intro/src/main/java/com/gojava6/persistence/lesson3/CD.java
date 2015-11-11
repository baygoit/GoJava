package com.gojava6.persistence.lesson3;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

import org.hibernate.annotations.*;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
/*@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)*/
public class CD extends Item {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Column(name = "total_duration")
  private Float totalDuration;

  private String genre;

  @OneToMany
  private Set<Musician> musicians = new HashSet<>();

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD() {
  }

  public CD(String title) {
    this.title = title;
  }

  public CD(String title, String genre) {
    this.title = title;
    this.genre = genre;
  }

  public CD(String title, String description, Float unitCost, Float totalDuration, String genre) {
    this.title = title;
    this.description = description;
    this.unitCost = unitCost;
    this.totalDuration = totalDuration;
    this.genre = genre;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Float getUnitCost() {
    return unitCost;
  }

  public void setUnitCost(Float unitCost) {
    this.unitCost = unitCost;
  }

  public Float getTotalDuration() {
    return totalDuration;
  }

  public void setTotalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public Set<Musician> getMusicians() {
    return musicians;
  }

  public void setMusicians(Set<Musician> musicians) {
    this.musicians = musicians;
  }

  // ======================================
  // =    hashcode, equals & toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CD{");
    sb.append("id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", genre='").append(genre).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
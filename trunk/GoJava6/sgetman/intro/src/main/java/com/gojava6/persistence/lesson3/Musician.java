package com.gojava6.persistence.lesson3;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
/*@Entity*/
public class Musician {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "first_name", length = 50)
  protected String firstName;

  @Column(name = "last_name", length = 50)
  protected String lastName;

  @Column(length = 5000)
  protected String bio;

  @Column(name = "date_of_birth")
  @Temporal(TemporalType.DATE)
  protected Date dateOfBirth;

  @Transient
  protected Integer age;

  @Column(name = "preferred_instrument")
  private String preferredInstrument;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Musician() {
  }

  public Musician(String firstName, String lastName, String bio, Date dateOfBirth, Integer age, String preferredInstrument) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.bio = bio;
    this.dateOfBirth = dateOfBirth;
    this.age = age;
    this.preferredInstrument = preferredInstrument;
  }

  public Musician(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getPreferredInstrument() {
    return preferredInstrument;
  }

  public void setPreferredInstrument(String preferredInstrument) {
    this.preferredInstrument = preferredInstrument;
  }

  // ======================================
  // =    hashcode, equals & toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Musician{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
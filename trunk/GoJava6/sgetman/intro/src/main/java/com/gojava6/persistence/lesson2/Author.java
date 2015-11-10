package com.gojava6.persistence.lesson2;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Author {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "first_name", length = 50)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(length = 5000)
  private String bio;

  @Column(name = "date_of_birth")
  @Temporal(TemporalType.DATE)
  private Date dateOfBirth;

  @Transient
  private Integer age;

  private Language language;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Author() {
  }

  public Author(String firstName, String lastName, String bio, Date dateOfBirth, Integer age, Language language) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.bio = bio;
    this.dateOfBirth = dateOfBirth;
    this.age = age;
    this.language = language;
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

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  // ======================================
  // =    hashcode, equals & toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Author{");
    sb.append("id=").append(id);
    sb.append(", firstName='").append(firstName).append('\'');
    sb.append(", lastName='").append(lastName).append('\'');
    sb.append(", bio='").append(bio).append('\'');
    sb.append(", dateOfBirth=").append(dateOfBirth);
    sb.append(", age=").append(age);
    sb.append(", language=").append(language);
    sb.append('}');
    return sb.toString();
  }
}
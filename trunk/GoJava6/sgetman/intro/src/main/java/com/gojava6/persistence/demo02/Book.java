package com.gojava6.persistence.demo02;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Book {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  private Long id;
  private String title;
  private String description;
  private Float unitCost;
  private String isbn;
  private Integer nbOfPage;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book() {
  }

  public Book(Long id) {
    this.id = id;
  }

  public Book(Long id, String title, String description, Float unitCost, String isbn, Integer nbOfPage) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.unitCost = unitCost;
    this.isbn = isbn;
    this.nbOfPage = nbOfPage;
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

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Integer getNbOfPage() {
    return nbOfPage;
  }

  public void setNbOfPage(Integer nbOfPage) {
    this.nbOfPage = nbOfPage;
  }

  // ======================================
  // =    hashcode, equals & toString     =
  // ======================================

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (description != null ? !description.equals(book.description) : book.description != null) return false;
    if (id != null ? !id.equals(book.id) : book.id != null) return false;
    if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
    if (nbOfPage != null ? !nbOfPage.equals(book.nbOfPage) : book.nbOfPage != null) return false;
    if (title != null ? !title.equals(book.title) : book.title != null) return false;
    if (unitCost != null ? !unitCost.equals(book.unitCost) : book.unitCost != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (unitCost != null ? unitCost.hashCode() : 0);
    result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
    result = 31 * result + (nbOfPage != null ? nbOfPage.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Book{");
    sb.append("id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", description='").append(description).append('\'');
    sb.append(", unitCost=").append(unitCost);
    sb.append(", isbn='").append(isbn).append('\'');
    sb.append(", nbOfPage=").append(nbOfPage);
    sb.append('}');
    return sb.toString();
  }
}
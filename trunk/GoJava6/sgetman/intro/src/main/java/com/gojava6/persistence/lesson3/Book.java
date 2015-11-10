package com.gojava6.persistence.lesson3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Book extends Item {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Column(length = 15)
  private String isbn;

  @Column(name = "nb_of_pages")
  private Integer nbOfPage;

  @Column(name = "publication_date")
  @Temporal(TemporalType.DATE)
  private Date publicationDate;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book() {
  }

  public Book(String title) {
    this.title = title;
  }

  public Book(String title, String isbn) {
    this.title = title;
    this.isbn = isbn;
  }

  public Book(String title, String description, Float unitCost, String isbn, Integer nbOfPage, Date publicationDate) {
    this.title = title;
    this.description = description;
    this.unitCost = unitCost;
    this.isbn = isbn;
    this.nbOfPage = nbOfPage;
    this.publicationDate = publicationDate;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

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

  public Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  // ======================================
  // =    hashcode, equals & toString     =
  // ======================================

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    if (!super.equals(o)) return false;

    Book book = (Book) o;

    if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
    if (nbOfPage != null ? !nbOfPage.equals(book.nbOfPage) : book.nbOfPage != null) return false;
    if (publicationDate != null ? !publicationDate.equals(book.publicationDate) : book.publicationDate != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
    result = 31 * result + (nbOfPage != null ? nbOfPage.hashCode() : 0);
    result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Book{");
    sb.append("id=").append(id);
    sb.append(", title='").append(title).append('\'');
    sb.append(", isbn='").append(isbn).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
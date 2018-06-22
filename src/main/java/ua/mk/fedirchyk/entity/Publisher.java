package ua.mk.fedirchyk.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", columnDefinition = "serial")
    private Long publisherId;
    @Column
    private String namePublisher;
    @Column
    private String description;
    @Column
    private String country;

    @ManyToMany(mappedBy = "publishers")
    private Set<Book> books;

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setNamePublisher(String namePublisher) {
        this.namePublisher = namePublisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(publisherId, publisher.publisherId) &&
                Objects.equals(namePublisher, publisher.namePublisher) &&
                Objects.equals(description, publisher.description) &&
                Objects.equals(country, publisher.country) &&
                Objects.equals(books, publisher.books);
    }

    @Override
    public int hashCode() {

        return Objects.hash(publisherId, namePublisher, description, country, books);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", namePublisher='" + namePublisher + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", books=" + books +
                '}';
    }
}

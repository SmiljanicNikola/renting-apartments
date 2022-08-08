package com.example.RentingApartments.model;

import javax.persistence.*;

@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="review_id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="apartment_id", referencedColumnName = "apartment_id")
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name="client_id", referencedColumnName = "client_id")
    private Client reviewAuthor;

    @Column(name="grade", unique=false, nullable=false)
    private Integer grade;

    @Column(name="comment", unique=false, nullable=false)
    private String comment;

    public Review() {
    }

    public Review(Integer id, Apartment apartment, Client reviewAuthor, Integer grade, String comment) {
        this.id = id;
        this.apartment = apartment;
        this.reviewAuthor = reviewAuthor;
        this.grade = grade;
        this.comment = comment;
    }

    public Review(Apartment apartment, Client reviewAuthor, Integer grade, String comment) {
        this.apartment = apartment;
        this.reviewAuthor = reviewAuthor;
        this.grade = grade;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Client getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(Client reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", apartment=" + apartment +
                ", reviewAuthor=" + reviewAuthor +
                ", grade=" + grade +
                ", comment='" + comment + '\'' +
                '}';
    }
}

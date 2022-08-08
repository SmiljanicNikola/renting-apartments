package com.example.RentingApartments.DTO;

import com.example.RentingApartments.model.Review;

public class ReviewDTO {

    private Integer id;

    private ApartmentDTO apartment;

    private ClientDTO reviewAuthor;

    private Integer grade;

    private String comment;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review){
        this(review.getId(), new ApartmentDTO(review.getApartment()), new ClientDTO(review.getReviewAuthor()), review.getGrade(), review.getComment());
    }

    public ReviewDTO(Integer id, ApartmentDTO apartment, ClientDTO reviewAuthor, Integer grade, String comment) {
        this.id = id;
        this.apartment = apartment;
        this.reviewAuthor = reviewAuthor;
        this.grade = grade;
        this.comment = comment;
    }

    public ReviewDTO(ApartmentDTO apartment, ClientDTO reviewAuthor, Integer grade, String comment) {
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

    public ApartmentDTO getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentDTO apartment) {
        this.apartment = apartment;
    }

    public ClientDTO getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(ClientDTO reviewAuthor) {
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
}

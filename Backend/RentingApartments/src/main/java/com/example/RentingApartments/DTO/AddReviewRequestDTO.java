package com.example.RentingApartments.DTO;

import com.example.RentingApartments.model.Apartment;
import com.example.RentingApartments.model.Client;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AddReviewRequestDTO {

    private Integer id;

    private Integer apartmentId;

    private Integer reviewAuthorId;

    private Integer grade;

    private String comment;

    public AddReviewRequestDTO(Integer apartmentId, Integer reviewAuthorId, Integer grade, String comment) {
        this.apartmentId = apartmentId;
        this.reviewAuthorId = reviewAuthorId;
        this.grade = grade;
        this.comment = comment;
    }

    public AddReviewRequestDTO(Integer id, Integer apartmentId, Integer reviewAuthorId, Integer grade, String comment) {
        this.id = id;
        this.apartmentId = apartmentId;
        this.reviewAuthorId = reviewAuthorId;
        this.grade = grade;
        this.comment = comment;
    }

    public AddReviewRequestDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Integer getReviewAuthorId() {
        return reviewAuthorId;
    }

    public void setReviewAuthorId(Integer reviewAuthorId) {
        this.reviewAuthorId = reviewAuthorId;
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

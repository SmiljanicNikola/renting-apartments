package com.example.RentingApartments.DTO;

import java.time.LocalDate;

public class RentRequestFormDTO {

    private Integer id;

    private Integer clientId;

    private Integer advertisementId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String additionalMessage;

    public RentRequestFormDTO(Integer clientId, Integer advertisementId, LocalDate startDate, LocalDate endDate, String additionalMessage) {
        this.clientId = clientId;
        this.advertisementId = advertisementId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.additionalMessage = additionalMessage;
    }

    public RentRequestFormDTO() {
    }

    public RentRequestFormDTO(Integer id, Integer clientId, Integer advertisementId, LocalDate startDate, LocalDate endDate, String additionalMessage) {
        this.id = id;
        this.clientId = clientId;
        this.advertisementId = advertisementId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.additionalMessage = additionalMessage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getAdditionalMessage() {
        return additionalMessage;
    }

    public void setAdditionalMessage(String additionalMessage) {
        this.additionalMessage = additionalMessage;
    }
}

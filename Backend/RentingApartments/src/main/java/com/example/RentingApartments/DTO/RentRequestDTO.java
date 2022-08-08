package com.example.RentingApartments.DTO;

import com.example.RentingApartments.model.Advertisement;
import com.example.RentingApartments.model.Client;
import com.example.RentingApartments.model.RentRequest;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class RentRequestDTO {

    private Integer id;

    private ClientDTO client;

    private AdvertisementDTO advertisement;

    private LocalDate startDate;

    private LocalDate endDate;

    private String additionalMessage;

    private Boolean accepted;

    public RentRequestDTO() {
    }

    public RentRequestDTO(RentRequest rentRequest){
        this(rentRequest.getId(), new ClientDTO(rentRequest.getClient()), new AdvertisementDTO(rentRequest.getAdvertisement()), rentRequest.getStartDate(), rentRequest.getEndDate(), rentRequest.getAdditionalMessage(), rentRequest.getAccepted());
    }

    public RentRequestDTO(ClientDTO client, AdvertisementDTO advertisement, LocalDate startDate, LocalDate endDate, String additionalMessage, Boolean accepted) {
        this.client = client;
        this.advertisement = advertisement;
        this.startDate = startDate;
        this.endDate = endDate;
        this.additionalMessage = additionalMessage;
        this.accepted = accepted;
    }

    public RentRequestDTO(Integer id, ClientDTO client, AdvertisementDTO advertisement, LocalDate startDate, LocalDate endDate, String additionalMessage, Boolean accepted) {
        this.id = id;
        this.client = client;
        this.advertisement = advertisement;
        this.startDate = startDate;
        this.endDate = endDate;
        this.additionalMessage = additionalMessage;
        this.accepted = accepted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public AdvertisementDTO getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(AdvertisementDTO advertisement) {
        this.advertisement = advertisement;
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

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
}

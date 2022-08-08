package com.example.RentingApartments.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rent_requests")
public class RentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rent_request_id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="client_id", referencedColumnName = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="advertisement_id", referencedColumnName = "advertisement_id")
    private Advertisement advertisement;

    @Column(name="start_date", unique=false, nullable=false)
    private LocalDate startDate;

    @Column(name="end_date", unique=false, nullable=false)
    private LocalDate endDate;

    @Column(name="additional_message", unique=false, nullable=false)
    private String additionalMessage;

    @Column(name="accepted", unique=false, nullable=false)
    private Boolean accepted;

    public RentRequest() {
    }

    public RentRequest(Integer id, Client client, Advertisement advertisement, LocalDate startDate, LocalDate endDate, String additionalMessage, Boolean accepted) {
        this.id = id;
        this.client = client;
        this.advertisement = advertisement;
        this.startDate = startDate;
        this.endDate = endDate;
        this.additionalMessage = additionalMessage;
        this.accepted = accepted;
    }

    public RentRequest(Client client, Advertisement advertisement, LocalDate startDate, LocalDate endDate, String additionalMessage, Boolean accepted) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Advertisement getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(Advertisement advertisement) {
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

    @Override
    public String toString() {
        return "RentRequest{" +
                "id=" + id +
                ", client=" + client +
                ", advertisement=" + advertisement +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", additionalMessage='" + additionalMessage + '\'' +
                ", accepted=" + accepted +
                '}';
    }
}

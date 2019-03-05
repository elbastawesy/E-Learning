package com.three2one.assessment.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "request_log")
public class RequestLog extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "requestURI can't by empty")
    @Valid
    private String requestURI;

    @Column(name = "request_method")
    private String requestMethod;

    @Column(name = "request_body")
    private String requestBody;



    @Column(name = "request_date")
    private LocalDateTime requestDate;

    public RequestLog() {
    }


    public RequestLog(@NotNull(message = "requestURI can't by empty") @Valid String requestURI, String requestMethod, String requestBody, LocalDateTime requestDate) {
        this.requestURI = requestURI;
        this.requestMethod = requestMethod;
        this.requestBody = requestBody;
        this.requestDate = requestDate;
    }

    @PrePersist
    public void validatePrePersist() {
        super.validatePrePersist();
    }

    @PreUpdate
    public void validatePreUpdate() {
        super.validatePreUpdate();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }
}

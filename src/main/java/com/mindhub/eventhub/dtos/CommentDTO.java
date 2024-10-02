package com.mindhub.eventhub.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.*;

public class CommentDTO {
    private String comment;
    private String createdAt;
    private CustomerCommentDTO customer;

    public CommentDTO(String comment, LocalDateTime  createdAt, CustomerCommentDTO customer) {
        this.comment = comment;
        this.createdAt = createdAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.customer = customer;
    }

    public String getComment() {
        return comment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public CustomerCommentDTO getCustomer() {
        return customer;
    }
}

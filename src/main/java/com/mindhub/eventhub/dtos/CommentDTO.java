package com.mindhub.eventhub.dtos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.*;

public class CommentDTO {
    private String comment;
    private String createdAt;
    private CustomerCommentDTO customerCommentDTO;

    public CommentDTO(String comment, LocalDateTime  createdAt, CustomerCommentDTO customerCommentDTO) {
        this.comment = comment;
        this.createdAt = createdAt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.customerCommentDTO = customerCommentDTO;
    }

    public String getComment() {
        return comment;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public CustomerCommentDTO getCustomerCommentDTO() {
        return customerCommentDTO;
    }
}

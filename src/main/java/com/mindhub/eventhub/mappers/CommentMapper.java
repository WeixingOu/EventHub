package com.mindhub.eventhub.mappers;

import com.mindhub.eventhub.dtos.CommentDTO;
import com.mindhub.eventhub.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerCommentMapper.class})
public interface CommentMapper {
    @Mapping(source = "customer", target = "customer")
    CommentDTO toCommentDTO(Comment comment);
}

package com.mindhub.eventhub.services;

import com.mindhub.eventhub.dtos.CommentCreateDTO;
import com.mindhub.eventhub.dtos.CommentDTO;

public interface CommentService {
    CommentDTO createComment(String eventId, CommentCreateDTO commentCreateDTO);
}

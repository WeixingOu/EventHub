package com.mindhub.eventhub.services.impls;

import com.mindhub.eventhub.dtos.records.CommentCreateDTO;
import com.mindhub.eventhub.dtos.CommentDTO;
import com.mindhub.eventhub.mappers.CommentMapper;
import com.mindhub.eventhub.models.Comment;
import com.mindhub.eventhub.models.Customer;
import com.mindhub.eventhub.models.Event;
import com.mindhub.eventhub.repositories.CommentRepository;
import com.mindhub.eventhub.repositories.CustomerRepository;
import com.mindhub.eventhub.repositories.EventRepository;
import com.mindhub.eventhub.services.AuthenticationFacade;
import com.mindhub.eventhub.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public CommentDTO createComment(String eventId, CommentCreateDTO commentCreateDTO) {
        Customer customer = customerRepository.findByEmail(authenticationFacade.getAuthentication().getName()).orElseThrow(() -> new RuntimeException("Customer not found woth email: " + authenticationFacade.getAuthentication().getName()));

        Event event = eventRepository.findById(UUID.fromString(eventId)).orElseThrow(() -> new RuntimeException("Event not found woth id: " + eventId));

        Comment comment = new Comment(commentCreateDTO.comment());

        customer.addComment(comment);
        event.addComment(comment);
        return commentMapper.toCommentDTO(commentRepository.save(comment));
    }
}

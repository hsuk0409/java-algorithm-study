package com.mongod.study;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
    private final MongoTemplate mongoTemplate;

    public EventDoc saveEvent(EventDoc body) {
        return mongoTemplate.insert(body);
    }

    public EventDoc getEvent(String eventId) {
        EventDoc event = mongoTemplate.findById(eventId, EventDoc.class);

        return Optional.ofNullable(event).orElseThrow(() -> new RestClientException("Not found events"));
    }
}

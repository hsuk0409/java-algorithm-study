package com.mongod.study;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("events")
@Getter
public class EventDoc {
    @Id
    private String _id;

    private String title;

    private String message;

    @Builder
    public EventDoc(String title, String message) {
        this.title = title;
        this.message = message;
    }
}

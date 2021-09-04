package com.mongod.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EventServiceTest {

    @Autowired
    EventService eventService;

    @DisplayName("MongoDB를 사용한 테스트 개체 생성")
    @Test
    void insertTest() {
        EventDoc resultObj = getEventDoc();

        assertNotNull(resultObj);
    }

    @DisplayName("MongoDB를 사용한 테스트 개체 조회")
    @Test
    void findTest() {
        EventDoc event = getEventDoc();

        EventDoc result = eventService.getEvent(event.get_id());

        assertNotNull(result);
    }

    private EventDoc getEventDoc() {
        EventDoc body = EventDoc.builder()
                .title("Spring MongoDB")
                .message("Hello!!")
                .build();

        EventDoc resultObj = eventService.saveEvent(body);
        return resultObj;
    }
}
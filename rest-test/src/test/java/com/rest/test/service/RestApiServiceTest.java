package com.rest.test.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiServiceTest {
    @Autowired
    private RestApiService restApiService;

    @DisplayName("RestTemplate을 사용한 API 호출 테스트")
    @Test
    void test() {
        String data = restApiService.getData();

        assert (data != null);
    }
}
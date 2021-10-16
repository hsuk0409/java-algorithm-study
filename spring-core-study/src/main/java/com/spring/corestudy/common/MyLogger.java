package com.spring.corestudy.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

/**
 * 스프링 컨테이너에 요청(request)하는 시점에 빈이 생성된다.
 * HTTP 요청 당 하나씩 생성된다.
 *
 * ScopedProxyMode.TARGET_CLASS 설정하므로
 * 웹 애플리케이션 실행 시점에 프록시를 생성해서 빈 주입 해준다.
 * -> ObjectProvider 또는 위 기능 사용하지 않으면 빈 주입 불가능
 * 실제 요청이 오면 그때 내부에 실제 빈을 요청하는 위임 로직이 들어있다.
 *
 * ******** 핵심은 Provider, Proxy 둘다 실제 개체를 사용하기 전까지 지연처리를 해주는 것이다!! ********
 *
 * 애노케이션 설정 변경만으로 원본 개체를 조작할 수 있는 것이 다형성과 DI 컨테이너의 가장 큰 힘이다.
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestUrl;

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestUrl + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);
    }
}
